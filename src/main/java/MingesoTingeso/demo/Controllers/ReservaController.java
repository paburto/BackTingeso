package MingesoTingeso.demo.Controllers;
import java.net.SocketOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import MingesoTingeso.demo.Models.*;
import MingesoTingeso.demo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.remoting.soap.SoapFaultException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservas")
public class ReservaController {
    @Autowired
    SendMailController enviar;

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

    private Random randomGenerator = new Random();

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Reserva getReservaByIdReserva(@PathVariable Long id) {
        return reservaRepository.findByIdReserva(id);
    }

    @RequestMapping(value = "conUsuario/{id}", method = RequestMethod.GET)
    @ResponseBody
    public HashMap<String,String> getReservaConUsuario(@PathVariable Long id){
        Reserva reserva = reservaRepository.findByIdReserva(id);
        Cliente cliente = reserva.getCliente();
        HashMap<String,String> map;
        map = new HashMap<>();
        map.put("idReserva", reserva.getIdReserva().toString());
        map.put("idCliente", cliente.getIdCliente().toString());
        map.put("descuento",Integer.toString(reserva.getDescuento()));
        map.put("codigoReserva",Integer.toString(reserva.getCodigoReserva()));
        map.put("nombreCliente",cliente.getNombreCliente());
        map.put("correoCliente",cliente.getCorreoCliente());
        map.put("rutCliente", Integer.toString(cliente.getRut()));
        return map;
    }

    @RequestMapping(value = "/codigoReserva/{codigoReserva}", method = RequestMethod.GET)
    @ResponseBody
    public Reserva getReservaByCodigoReserva(@PathVariable int codigoReserva) {
        return reservaRepository.findReservaByCodigoReserva(codigoReserva);
    }

    @RequestMapping(value = "/tipoHabitacion/{idHabitacion}", method = RequestMethod.GET)
    @ResponseBody
    public List<Habitacion> getHabitacionByTipo(@PathVariable String tipo) {
        return habitacionRepository.findHabitacionByTipo(tipo);
    }

    @RequestMapping(value = "/byCliente/{idCliente}", method = RequestMethod.GET)
    @ResponseBody
    public Cliente getClienteById(@PathVariable Long idCliente) {
        return clienteRepository.findClienteByIdCliente(idCliente);
    }

    @RequestMapping(value = "/mostrarReservas" , method = RequestMethod.GET)
    @ResponseBody
    public List<HashMap<String, String>> getAllRackP() {
        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>();
        List<ReservaHabitacion> reservahabitacion = resHabRepository.findAll();
        List<Reserva> reserva = reservaRepository.findAll();
        List<Cliente> cliente = clienteRepository.findAll();
        LocalDate localDate = LocalDate.now();
        Date actual = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());



        for(ReservaHabitacion rh : reservahabitacion){
            for(Reserva r : reserva){
                for(Cliente c : cliente){
                    if(rh.getReserva().getIdReserva().equals(r.getIdReserva()) && r.getCliente().getIdCliente().equals(c.getIdCliente()) && rh.getFechaInicioRH().after(actual)){
                        map.put("idReserva", rh.getReserva().getIdReserva().toString());
                        map.put("codigoReserva", Integer.toString(r.getCodigoReserva()));
                        map.put("descuento", Integer.toString(r.getDescuento()));
                        map.put("estado", Integer.toString(r.getEstado()));
                        map.put("hola", "hasjdbaks");
                        map.put("nroHabitacion", Integer.toString(rh.getHabitacion().getNroHabitacion()));
                        map.put("idHab", rh.getHabitacion().getIdHabitacion().toString());
                        map.put("idUser", r.getUsuario().getIdUsuario().toString());

                        map.put("idCliente", c.getIdCliente().toString());
                        map.put("nombreCliente", c.getNombreCliente());
                        map.put("rut", Integer.toString(c.getRut()));

                        map.put("fechaInicio", rh.getFechaInicioRH().toString());
                        map.put("fechaTermino", rh.getFechaTerminoRH().toString());
                        result.add(map);
                        map = new HashMap<>();
                    }
                }
            }
        }
        return result;
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
            result.add(map);
            return result;
        }
        for (ReservaHabitacion reserva: reservahabitaciones){
            if(reserva.getHabitacion().getIdHabitacion().equals(Long.parseLong(jsonData.get("IdHab").toString()))
                    && reserva.getReserva().getEstado()==1 && !reserva.getHabitacion().getTipoHabitacion().equals("Inhabilitada")){

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
                || fechaInicio.equals(reserva.getFechaTerminoRH()) || fechaInicio.equals(reserva.getFechaInicioRH())){
                    map.put("status", "401");
                    map.put("message", "Uno de los días extremos calza con un día de reserva");
                    result.add(map);
                    return result;
                }
            }
            else if(reserva.getHabitacion().getIdHabitacion().equals(Long.parseLong(jsonData.get("IdHab").toString()))){
                if (reserva.getHabitacion().getTipoHabitacion().equals("Inhabilitada")){
                    map.put("status", "401");
                    map.put("message", "La habitación seleccionada está anulada.");
                    result.add(map);
                    return result;
                }
            }
        }
        Reserva aux = new Reserva();

        int randomInt;
        do {
            randomInt = randomGenerator.nextInt(50) + 1;
            aux = reservaRepository.findReservaByCodigoReserva(randomInt);
        }while(aux!=null);
        Reserva reserva =reservaRepository.save(new Reserva(Integer.parseInt(jsonData.get("estado").toString()),
                Integer.parseInt(jsonData.get("descuento").toString()),
                randomInt,
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

        enviar.sendMail(jsonData.get("correo").toString(), "Hotelería Mingeso - Reserva Creada", "Se ha creado una reserva en nuestro sitio web.");


        map.put("status", "201");
        map.put("message", "OK");
        result.add(map);
        return result;
    }


    @PostMapping("/createmulti")
    @ResponseBody
    public List<HashMap<String, String>> createMulti(@RequestBody Map<String, Object> jsonData) throws ParseException {
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
            result.add(map);
            return result;
        }

        //Calculamos todas las habitaciones a reservar
        String array = jsonData.get("id").toString();
        // Separamos por espacio
        String[] splited = array.split(" ");
        // Guardamos los nros
        Long[] identificadores = new Long[splited.length];
        for(int i = 0; i < splited.length; i++) {
            identificadores[i] = Long.parseLong(splited[i]);
        }

        Reserva aux = new Reserva();

        Habitacion habitacion;
        int randomInt;
        Reserva reserva;
        int descuento = Integer.parseInt(jsonData.get("descuento").toString());
        ReservaHabitacion reservaHabitacion;
        for(Long i: identificadores){
            do {
                randomInt = randomGenerator.nextInt(50) + 1;
                aux = reservaRepository.findReservaByCodigoReserva(randomInt);
            }while(aux!=null);

            reserva =reservaRepository.save(new Reserva(1,
                    descuento,
                    randomInt,
                    usuario2,
                    cliente));


             habitacion = habitacionRepository.findHabitacionByIdHab(i);
            if(habitacion==null){
                map.put("status", "401");
                map.put("message", "Error, la habitación ingresada no existe.");
                result.add(map);
                return result;
            }
            resHabRepository.save(new ReservaHabitacion(fechaInicio,
                    fechaTermino,
                    reserva,
                    habitacion));

        }
        enviar.sendMail(jsonData.get("correo").toString(), "Hotelería Mingeso - Reserva Creada", "Se ha creado una reserva en nuestro sitio web.");


        map.put("status", "201");
        map.put("message", "OK");
        result.add(map);
        return result;
    }








    @PostMapping("/update/{codigoReserva}")
    @ResponseBody
    public List<HashMap<String, String>> update(@PathVariable int codigoReserva, @RequestBody Map<String, Object> jsonData) throws ParseException {
        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        System.out.println(jsonData);
        Reserva reservaU = reservaRepository.findReservaByCodigoReserva(codigoReserva);
        List<ReservaHabitacion> reservahabitaciones = resHabRepository.findAll();
        HashMap<String, String> map = new HashMap<>();
        if (reservaU==null) {
            map.put("status", "401");
            map.put("message", "Error codigo de reserva nulo.");
            result.add(map);
            return result;
        }

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Cliente cliente = clienteRepository.findClienteByRut(Integer.parseInt(jsonData.get("rut").toString()));
        Cliente editar= reservaU.getCliente();
        if (Integer.parseInt(jsonData.get("rut").toString()) != reservaU.getCliente().getRut() && cliente!=null){
            map.put("status", "401");
            map.put("message", "Error, rut ya registrado.");
            result.add(map);
            return result;
        }
        editar.setRut(Integer.parseInt(jsonData.get("rut").toString()));
        editar.setNombreCliente(jsonData.get("nombre").toString());
        editar.setCorreoCliente(jsonData.get("correo").toString());
        editar.setTelefonoCliente(Integer.parseInt(jsonData.get("telefono").toString()));
        editar.setFechaNacimiento(formatter.parse(jsonData.get("fechaNacimiento").toString()));
        clienteRepository.save(editar);

        reservaU.setEstado(Integer.parseInt(jsonData.get("estado").toString()));
        reservaU.setDescuento(Integer.parseInt(jsonData.get("descuento").toString()));
        reservaRepository.save(reservaU);

        enviar.sendMail(jsonData.get("correo").toString(), "Hotelería Mingeso - Usuario Modificado", "Se ha modificado una cuenta cliente en nuestro sitio web.");

        map.put("status", "201");
        map.put("message", "OK");
        result.add(map);
        return result;

    }


    @CrossOrigin(origins = "*")
    @PostMapping("/delete/{codigoReserva}")
    @ResponseBody
    public List<HashMap<String, String>> anularR(@PathVariable int codigoReserva) throws ParseException {

        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>();
        Reserva reserva = reservaRepository.findReservaByCodigoReserva(codigoReserva);
        if(reserva == null) {
            map.put("status", "404");
            map.put("codigoReserva;", String.valueOf(codigoReserva));
            map.put("message", "Reserva no existe!.");
            map.put("item", "");
            result.add(map);
            return result;
        }
        else {
            if(reserva.getEstado()==0){
                map.put("status", "200");
                map.put("message", "La reserva ya estaba anulada!!.");
                result.add(map);
                return result;
            }
            reserva.setEstado(0);
            reservaRepository.save(reserva);
            map.put("status", "200");
            map.put("message", "OK, anulada!.");
            result.add(map);
            return result;
        }
    }

}
