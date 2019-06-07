package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.Habitacion;
import MingesoTingeso.demo.Models.Registro;
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

    @GetMapping("/")
    @ResponseBody
    public List<Registro> getAllRegitros() {
        return registroRepository.findAll();
    }

    @GetMapping("/codigoHabitacion")
    @ResponseBody
    public List<Registro> getByCodigoHabitacion(@PathVariable int codigoHabitacion){
        List<Registro> newRegistro = new ArrayList<>();
        List<Registro> data = registroRepository.findAll();
        for(Registro registro : data){
            if(registro.getHabitacion().getNroHabitacion() == codigoHabitacion){
                newRegistro.add(registro);
            }
        }
        return newRegistro;
    }

    @GetMapping("/idHabitacion")
    @ResponseBody
    public List<Registro> getByidHabitacion(@PathVariable Long idHab){
        return registroRepository.findRegistroByIdHab(idHab);
    }

    @GetMapping("/representante")
    @ResponseBody
    public List<Registro> getByRepresentante(@PathVariable String representante){
        return registroRepository.findRegistroByRepresentante(representante);
    }

    @PostMapping("/create")
    @ResponseBody
    public List<HashMap<String, Object>> create(@RequestBody Map<String, Object> jsonData) throws ParseException {
        List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = new HashMap<>();

        Habitacion hab = habitacionRepository.findHabitacionByNroHabitacion(Integer.parseInt(jsonData.get("numeroHabitacion").toString()));
        if(hab != null){
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date fechaInicio = new Date();
            Date fechaTermino = new Date();
            fechaInicio = formatter.parse(jsonData.get("fechaInicio").toString());
            fechaTermino = formatter.parse(jsonData.get("fechaTermino").toString());
            registroRepository.save(new Registro(jsonData.get("representante").toString(), fechaInicio, fechaTermino, hab));
            map.put("status", 201);
            map.put("message", "OK.");
            result.add(map);
            return result;
        }
        else{
            map.put("status", 401);
            map.put("message", "No existe una habitacion con ese numero de habitacion.");
            result.add(map);
            return result;
        }
    }

}

