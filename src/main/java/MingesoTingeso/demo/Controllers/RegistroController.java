package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.Cliente;
import MingesoTingeso.demo.Models.ClienteRegistro;
import MingesoTingeso.demo.Models.Habitacion;
import MingesoTingeso.demo.Models.Registro;
import MingesoTingeso.demo.Repositories.ClienteRegistroRepository;
import MingesoTingeso.demo.Repositories.ClienteRepository;
import MingesoTingeso.demo.Repositories.HabitacionRepository;
import MingesoTingeso.demo.Repositories.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/registro")
public class RegistroController {

    @Autowired
    RegistroRepository registroRepository;

    @Autowired
    HabitacionRepository habitacionRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ClienteRegistroRepository clienteRegistroRepository;

    @GetMapping("/")
    @ResponseBody
    public List<Registro> getAllRegitros() {
        return registroRepository.findAll();
    }

    @RequestMapping(value = "/nroHabitacion/{nro}", method = RequestMethod.GET)
    @ResponseBody
    public List<Registro> getByCodigoHabitacion(@PathVariable int nro){
        List<Registro> newRegistro = new ArrayList<>();
        List<Registro> data = registroRepository.findAll();
        for(Registro registro : data){
            if(registro.getHabitacion().getNroHabitacion() == nro){
                newRegistro.add(registro);
            }
        }
        return newRegistro;
    }

    @GetMapping("/idHabitacion")
    @ResponseBody
    public List<Registro> getByidHabitacion(@PathVariable Long idHab){
        Habitacion habitacion = habitacionRepository.findHabitacionByIdHab(idHab);
        return registroRepository.findRegistroByHabitacion(habitacion);
    }

    @GetMapping("/representante")
    @ResponseBody
    public List<Registro> getByRepresentante(@PathVariable String representante){
        return registroRepository.findRegistroByRepresentante(representante);
    }

    @PostMapping(value = "/create")
    @ResponseBody
    public Registro create(@RequestBody List<Map<String, String>> data, @RequestParam(value = "idHab") Long idHab, @RequestParam(value = "fechaInicio") String fechaInicio, @RequestParam(value ="fechaTermino") final String fechaTermino) throws ParseException {
        Habitacion habitacion = habitacionRepository.findHabitacionByIdHab(idHab);
        Registro registro = new Registro();
        String representante = "";
        for(int i = 0; i<data.size(); i++){
            if(data.get(i).get("representante").equals("si")){
                representante = data.get(i).get("nombre");
            }
        }
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        registro.setFechaInicio(formatter.parse(fechaInicio));
        registro.setFechaTermino(formatter.parse(fechaTermino));
        registro.setHabitacion(habitacion);
        registro.setRepresentante(representante);
        registroRepository.save(registro);
        ClienteRegistro cr;
        Cliente cliente;
        for(int i = 0; i<data.size(); i++){
            cliente = new Cliente();
            cliente.setNombreCliente(data.get(i).get("nombre"));
            cliente.setFechaNacimiento(formatter.parse(data.get(i).get("fechaNacimiento")));
            cliente.setCorreoCliente(data.get(i).get("correo"));
            cliente.setRut(Integer.parseInt(data.get(i).get("rut")));
            cliente.setTelefonoCliente(Integer.parseInt(data.get(i).get("telefono")));
            clienteRepository.save(cliente);
            clienteRegistroRepository.save(new ClienteRegistro(cliente,registro));
        }
        return registro;
    }



}
