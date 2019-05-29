package MingesoTingeso.demo.Controllers;
import java.net.SocketOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
        List<ReservaHabitacion> reservahabitaciones = resHabRepository.findAll();
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

        LocalDate localDate = LocalDate.now();
        Date actual = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fechaInicio = new Date(),fechaTermino = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        try {
            /** actual = formato.parse(actual.toString());*/
            fechaInicio = formato.parse(jsonData.get("fechaInicio").toString());
            fechaTermino = formato.parse(jsonData.get("fechaTermino").toString());
        }
        catch (ParseException ex)
        {
            map.put("status", "401");
            map.put("message", "Error al convertir date.");
            result.add(map);
            return result;
        }
        if(fechaInicio.before(actual)){
            map.put("status", "401");
            map.put("message", "Error: La fecha de inicio debe ser mayor a la actual.");
            result.add(map);
            return result;
        }
        else if(fechaInicio.after(fechaTermino)){
            map.put("status", "401");
            map.put("message", "La fecha de inicio no puede estar después de la fecha de termino.");
            map.put("código: ", jsonData.get("codigoReserva").toString());
            result.add(map);
            return result;
        }
        for (ReservaHabitacion reserva: reservahabitaciones){
            if(reserva.getHabitacion().getIdHabitacion().equals(Long.parseLong(jsonData.get("IdHab").toString())) && reserva.getReserva().getEstado()==1){

                if(fechaInicio.after(reserva.getFechaInicioRH()) && fechaInicio.before(reserva.getFechaTerminoRH())){
                    map.put("status", "401");
                    map.put("message", "La fecha de inicio no se puede agregar, ya que no está disponible.");
                    result.add(map);
                    return result;
                }
                if(fechaTermino.after(reserva.getFechaInicioRH()) && fechaTermino.before(reserva.getFechaTerminoRH())){
                    map.put("status", "401");
                    map.put("message", "La fecha de termino no se puede agregar, ya que no está disponible.");
                    result.add(map);
                    return result;
                }
                if(reserva.getFechaInicioRH().after(fechaInicio) && reserva.getFechaInicioRH().before(fechaTermino)){
                    map.put("status", "401");
                    map.put("message", "Existe una reserva dentro de este periodo (i).");
                    result.add(map);
                    return result;
                }
                if(reserva.getFechaTerminoRH().after(fechaInicio) && reserva.getFechaTerminoRH().before(fechaTermino)){
                    map.put("status", "401");
                    map.put("message", "Existe una reserva dentro de este periodo (T)..");
                    result.add(map);
                    return result;
                }
                if(fechaTermino.equals(reserva.getFechaTerminoRH()) || fechaTermino.equals(reserva.getFechaInicioRH())
                || fechaInicio.equals(reserva.getFechaTerminoRH()) || fechaInicio.equals(reserva.getFechaTerminoRH())){
                    map.put("status", "401");
                    map.put("message", "Uno de los días extremos calza con un día de reserva");
                    result.add(map);
                    return result;
                }
            }
        }
        Reserva aux = reservaRepository.findReservaByCodigoReserva(Integer.parseInt(jsonData.get("codigoReserva").toString()));
        if(aux!= null){
            map.put("status", "401");
            map.put("message", "Error, el código de reserva ya existe.");
            map.put("código: ", jsonData.get("codigoReserva").toString());
            result.add(map);
            return result;
        }
        Reserva reserva =reservaRepository.save(new Reserva(Integer.parseInt(jsonData.get("estado").toString()),
                Integer.parseInt(jsonData.get("descuento").toString()),
                Integer.parseInt(jsonData.get("codigoReserva").toString()),
                usuario2,
                cliente));

        Habitacion habitacion = habitacionRepository.findHabitacionByIdHab(Long.parseLong(jsonData.get("IdHab").toString()));
        if(habitacion==null){
            map.put("status", "401");
            map.put("message", "Error, la habitación ingresada no existe.");
            result.add(map);
            return result;
        }

        ReservaHabitacion reservaHabitacion = resHabRepository.save(new ReservaHabitacion(formatter.parse(jsonData.get("fechaInicio").toString()),
                formatter.parse(jsonData.get("fechaTermino").toString()),
                reserva,
                habitacion));

        map.put("status", "201");
        map.put("message", "OK");
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
