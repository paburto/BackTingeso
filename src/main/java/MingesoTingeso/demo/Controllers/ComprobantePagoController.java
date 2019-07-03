package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.*;
import MingesoTingeso.demo.Repositories.*;
import MingesoTingeso.demo.Services.EmailSenderComprobante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.regex.Pattern;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comprobante")
public class ComprobantePagoController {
    @Autowired
    ComprobantePagoRepository comprobantePagoRepository;

    @Autowired
    RegistroRepository registroRepository;

    @Autowired
    ResHabRepository resHabRepository;

    @Autowired
    RegistroServicioRepository registroServicioRepository;

    @Autowired
    ServicioRepository servicioRepository;
    @Autowired
    ClienteRegistroRepository clienteRegistroRepository;

    @GetMapping("/")
    @ResponseBody
    public List<ComprobantePago> getAllComprobantes(){
        return comprobantePagoRepository.findAll();
    }

    @GetMapping("/id")
    @ResponseBody
    public ComprobantePago getById(@PathVariable Long id){
        return comprobantePagoRepository.findComprobantePagoById(id);
    }

    @GetMapping("/registro")
    @ResponseBody
    public ComprobantePago getByIdRegistro(@PathVariable Long id){
        List<ComprobantePago> data = comprobantePagoRepository.findAll();
        for(ComprobantePago cp : data){
            if(cp.getRegistro().getIdRegistro().equals(id)){
                return cp;
            }
        }
        return null;
    }

    @PostMapping("/create")
    @ResponseBody
    public List<HashMap<String, Object>> create(@RequestBody List<Map<String, Object>> jsonData) throws ParseException{
        List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = new HashMap<>();
        for(Map<String, Object> json : jsonData){
            Registro registro = registroRepository.findRegistroByIdRegistro(Long.parseLong(json.get("idRegistro").toString()));
            if(registro != null){
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Instant inicio = formatter.parse(json.get("fechaInicio").toString()).toInstant();
                Instant termino = formatter.parse(json.get("fechaTermino").toString()).toInstant();
                List<ClienteRegistro> cr = clienteRegistroRepository.findByRegistro(registro);
                List<RegistroServicio> rs = registroServicioRepository.findRegistroServicioByRegistro(registro);
                List<Servicio> servicios = new ArrayList<>();
                for(RegistroServicio registroServicio : rs){
                    if(registroServicio.getRegistro().getIdRegistro().equals(registro.getIdRegistro())){
                        servicios.add(registroServicio.getServicio());
                    }
                }
                long totalDias = ChronoUnit.DAYS.between(inicio, termino);
                long total = registro.getHabitacion().getPrecioNoche()*totalDias;
                for(Servicio sh : servicios){
                    total = total + sh.getPrecio();
                }
                LocalDateTime timeNow = LocalDateTime.now();
                String detalles = createDetails(servicios, inicio, termino, registro.getHabitacion(), totalDias, total);
                String detallesHTML = createDetailsHTML(servicios, inicio, termino, registro.getHabitacion(), totalDias, total);
                ComprobantePago resultado = comprobantePagoRepository.save(new ComprobantePago(total, detalles, timeNow, registro));
                for(ClienteRegistro clienteRegistro : cr){
                    Thread mail = new Thread(new EmailSenderComprobante(clienteRegistro.getCliente().getCorreoCliente(), "Hotelería Mingeso - Check-out", detallesHTML, clienteRegistro.getCliente().getNombreCliente(), registro.getHabitacion().getNroHabitacion()));
                    mail.start();
                }
                map.put("status", 201);
                map.put("data", resultado);
                map.put("message", "OK.");
                result.add(map);
                map = new HashMap<>();
            }
            else{
                map.put("status", 401);
                map.put("data", null);
                map.put("message", "No existe un registro con ese id.");
                result.add(map);
                map = new HashMap<>();
            }
        }
        return result;
    }

    private String createDetails(List<Servicio> servicios, Instant inicio, Instant termino, Habitacion habitacion, long totalDias, long totalFinal){
        String i = inicio.toString().split("T")[0];
        String t = termino.toString().split("T")[0];
        String detalles = "Total de dias en la habitacion " + habitacion.getNroHabitacion() + ":\r\nDesde: " + i + "\r\nHasta: " + t + "\r\nTotal de dias: " + totalDias + "\r\nTotal por habitacion: " + habitacion.getPrecioNoche()*totalDias + "\r\nServicios:\r\n";
        int totalServicios = 0;
        if(servicios.size() > 0){
            for(Servicio serv : servicios){
                detalles = detalles +  serv.getNombreServicio() + " Precio: " + serv.getPrecio() + "\r\n";
                totalServicios = totalServicios + serv.getPrecio();
            }
            detalles = detalles + "Total a pagar: " + totalFinal;
            return detalles;
        }
        else{
            detalles = detalles + "No ha consumido servicios.\r\n";
            detalles = detalles + "Total a pagar: " + totalFinal;
            return detalles;
        }
    }

    private String createDetailsHTML(List<Servicio> servicios, Instant inicio, Instant termino, Habitacion habitacion, long totalDias, long totalFinal){
        String inicioFormatted = inicio.toString().split(Pattern.quote("T"))[0].replace('-', '/');
        String terminoFormatted = termino.toString().split(Pattern.quote("T"))[0].replace('-', '/');
        String[] inicio_preFormmat = inicioFormatted.split(Pattern.quote("/"));
        String[] termino_preFormmat = terminoFormatted.split(Pattern.quote("/"));
        String inicioFinal = inicio_preFormmat[2] + "/" + inicio_preFormmat[1] + "/" + inicio_preFormmat[0];
        String terminoFinal = termino_preFormmat[2] + "/" + termino_preFormmat[1] + "/" + termino_preFormmat[0];
        String detalles = "Habitacion: " + habitacion.getNroHabitacion() + "<br>\r\nDesde: " + inicioFinal + "<br>\r\nHasta: " + terminoFinal + "<br>\r\nTotal de dias: " + totalDias + "<br>\r\nTotal por habitacion: " + habitacion.getPrecioNoche()*totalDias + "<br>\r\nServicios:<br>\r\n";
        int totalServicios = 0;
        if(servicios.size() > 0){
            for(Servicio serv : servicios){
                detalles = detalles +  serv.getNombreServicio() + " Precio: " + serv.getPrecio() + "<br>\r\n";
                totalServicios = totalServicios + serv.getPrecio();
            }
            detalles = detalles + "Total a pagar: " + totalFinal;
            return detalles;
        }
        else{
            detalles = detalles + "No ha consumido servicios.<br>\r\n";
            detalles = detalles + "Total a pagar: " + totalFinal;
            return detalles;
        }
    }
}
