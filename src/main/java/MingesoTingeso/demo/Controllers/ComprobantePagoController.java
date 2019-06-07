package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.ComprobantePago;
import MingesoTingeso.demo.Models.Registro;
import MingesoTingeso.demo.Repositories.ComprobantePagoRepository;
import MingesoTingeso.demo.Repositories.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/comprobante")
public class ComprobantePagoController {
    @Autowired
    ComprobantePagoRepository comprobantePagoRepository;

    @Autowired
    RegistroRepository registroRepository;

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

    @GetMapping("/create")
    @ResponseBody
    public List<HashMap<String, Object>> create(@RequestBody Map<String, Object> jsonData) throws ParseException{
        List<HashMap<String, Object>> result = new ArrayList<HashMap<String, Object>>();
        HashMap<String, Object> map = new HashMap<>();

        Registro registro = registroRepository.findRegistroByIdRegistro(Long.parseLong(jsonData.get("idRegistro").toString()));
        if(registro != null){
            LocalDateTime timeNow = LocalDateTime.now();
            ComprobantePago resultado = comprobantePagoRepository.save(new ComprobantePago(Integer.parseInt(jsonData.get("total").toString()), jsonData.get("detalle").toString(), timeNow, registro));
            map.put("status", 201);
            map.put("data", resultado);
            map.put("message", "OK.");
            result.add(map);
            return result;
        }
        else{
            map.put("status", 401);
            map.put("data", null);
            map.put("message", "No existe una habitacion con ese numero de habitacion.");
            result.add(map);
            return result;
        }
    }
}
