package MingesoTingeso.demo.Controllers;
import java.net.SocketOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import MingesoTingeso.demo.Models.*;
import MingesoTingeso.demo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.remoting.soap.SoapFaultException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    ResHabRepository resHabRepository;

    @Autowired
    HabitacionRepository habitacionRepository;

    @RequestMapping(value="", method = RequestMethod.GET)
    @ResponseBody
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Reserva getReservaByIdReserva(@PathVariable Long id) {
        return reservaRepository.findReservaByIdReserva(id);
    }

    @RequestMapping(value = "/codigoReserva/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Reserva getReservaByCodigoReserva(@PathVariable int codigoReserva) {
        return reservaRepository.findReservaByCodigoReserva(codigoReserva);
    }

    @RequestMapping(value = "/tipoHabitacion/{idHabitacion}", method = RequestMethod.GET)
    @ResponseBody
    public List<Habitacion> getHabitacionByTipo(@PathVariable String tipo) {
        return habitacionRepository.findHabitacionByTipo(tipo);
    }

    @RequestMapping(value = "/{idCliente}", method = RequestMethod.GET)
    @ResponseBody
    public Cliente getClienteById(@PathVariable Long idCliente) {
        return clienteRepository.findClienteByIdCliente(idCliente);
    }

    @PostMapping("/create")
    @ResponseBody
    public List<HashMap<String, String>> create(@RequestBody Map<String, Object> jsonData) throws ParseException {
        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Cliente cliente = clienteRepository.findClienteByRut(Integer.parseInt(jsonData.get("rut").toString()));
        Usuario usuario = usuarioRepository.findUsuarioByRutUsuario(Integer.parseInt(jsonData.get("rutUsuario").toString()));
        Long idUsuario = usuario.getIdUsuario();
        Usuario usuario2= usuarioRepository.findUsuarioByIdUser(idUsuario);
        if (cliente == null){
            cliente = clienteRepository.save(new Cliente(Integer.parseInt(jsonData.get("rut").toString()),
                    jsonData.get("nombre").toString(),
                    jsonData.get("correo").toString(),
                    Integer.parseInt(jsonData.get("telefono").toString()),
                    formatter.parse(jsonData.get("fechaNacimiento").toString())));
        }
        Reserva reserva =reservaRepository.save(new Reserva(Integer.parseInt(jsonData.get("estado").toString()),
                Integer.parseInt(jsonData.get("descuento").toString()),
                Integer.parseInt(jsonData.get("codigoReserva").toString()),
                usuario2,
                cliente));

        //Habitacion habitacion = habitacionRepository.findHabitacionByTipo(jsonData.get("tipo").toString());

        List <Habitacion> habitaciones = new ArrayList<>();
        habitaciones = getHabitacionByTipo(jsonData.get("tipo").toString());

        Date DeseaInicio= formatter.parse(jsonData.get("fechaInicio").toString());
        Date DeseaTermino= formatter.parse(jsonData.get("fechaTermino").toString());
        Date fechaInicio;
        Date fechaTermino;
        Boolean noestaocupado;
        for( Habitacion habita : habitaciones) {
            noestaocupado =true;
                List<ReservaHabitacion> listreshab = resHabRepository.findReservaHabitacionByHabitacion(habita);
                for (ReservaHabitacion reshabi : listreshab){
                    fechaInicio = reshabi.getFechaInicioRH();
                    fechaTermino = reshabi.getFechaTerminoRH();
                    //(date1.before(date2)) si date1 es anterior a date2,verdadero
                    if(!(fechaTermino.before(DeseaInicio)&&(DeseaInicio.before(fechaTermino)))){
                        noestaocupado=false;
                        break;
                    }
                }
                if(noestaocupado == true){
                    ReservaHabitacion reservaHabitacion = resHabRepository.save(new ReservaHabitacion(formatter.parse(jsonData.get("fechaInicio").toString()),
                                            formatter.parse(jsonData.get("fechaTermino").toString()),
                                            reserva,
                                            habita));
                    map.put("status", "201");
                    map.put("message", "OK");
                    result.add(map);
                    return result;
                }
        }
        map.put("status", "201");
        map.put("message", "No se a podido crear");
        result.add(map);
        return result;

    }

    @PostMapping("/update")
    @ResponseBody
    public List<HashMap<String, String>> update(@RequestBody Map<String, Object> jsonData) throws ParseException {
        System.out.println(jsonData);
        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Reserva reserva = reservaRepository.findReservaByCodigoReserva(Integer.parseInt(jsonData.get("codigoReserva").toString()));

        List<Habitacion> habitaciones = getHabitacionByTipo(jsonData.get("tipo").toString());
        Date DeseaInicio = formatter.parse(jsonData.get("fechaInicio").toString());
        Date DeseaTermino = formatter.parse(jsonData.get("fechaTermino").toString());
        Date fechaInicio;
        Date fechaTermino;
        Boolean noestaocupado;
        for (Habitacion habitaci : habitaciones) {
            noestaocupado = true;
            List<ReservaHabitacion> listreshab = resHabRepository.findReservaHabitacionByHabitacion(habitaci);
            for (ReservaHabitacion reshabi : listreshab) {
                fechaInicio = reshabi.getFechaInicioRH();
                fechaTermino = reshabi.getFechaTerminoRH();
                if (!(fechaTermino.before(DeseaInicio) && (fechaInicio.before(DeseaTermino)))) {
                    noestaocupado = false;
                    break;
                }
            }
            if (noestaocupado) {
                ReservaHabitacion reservaHabitacion = resHabRepository.findReservaHabitacionByReserva(reserva.getIdReserva());
                reservaHabitacion.setHabitacion(habitaci);
                reservaHabitacion.setFechaInicioRH(DeseaInicio);
                reservaHabitacion.setFechaTerminoRH(DeseaTermino);
                resHabRepository.save(reservaHabitacion);
                map.put("status", "201");
                map.put("message", "OK");
                result.add(map);
                return result;
            }
        }
        map.put("status", "201");
        map.put("message", "OK");
        result.add(map);
        return result;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/delete/{id}")
    @ResponseBody
    public List<HashMap<String, String>> update(@PathVariable Long id) throws ParseException {
        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>();
        Reserva reserva = reservaRepository.findReservaByIdReserva(id);
        if(reserva == null) {
            map.put("status", "404");
            map.put("message", "Reserva does not exist!.");
            map.put("item", "");
            result.add(map);
            return result;
        }
        else {
            reservaRepository.deleteById(id);
            map.put("status", "200");
            map.put("message", "OK, reserva erased!.");
            result.add(map);
            return result;
        }
    }

}
