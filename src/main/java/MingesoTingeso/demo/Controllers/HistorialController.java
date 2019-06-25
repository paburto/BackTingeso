package MingesoTingeso.demo.Controllers;
import java.time.LocalDate;
import java.util.*;

import MingesoTingeso.demo.Models.Historial;
import MingesoTingeso.demo.Models.Usuario;
import MingesoTingeso.demo.Repositories.HistorialRepository;
import MingesoTingeso.demo.Repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/historial")
public class HistorialController {
    @Autowired
    HistorialRepository historialRepository;
    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/")
    @ResponseBody
    public List<Historial> getAllHistorial(){
        return historialRepository.findAll();
    }

    @GetMapping("/history")
    @ResponseBody
    public List<HashMap<String, Object>> getHistory(){

        List<Historial> data = historialRepository.findAll(Sort.by("idHis").ascending());
        List<HashMap<String, Object>> result = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();

        for(Historial history : data){
            map.put("Empleado", history.getUsuario().getNombreUsuario());
            map.put("Correo", history.getUsuario().getCorreoUsuario());
            map.put("Fecha", history.getFecha());
            map.put("Descripcion", history.getDescripcion());
            result.add(map);
            map = new HashMap<>();
        }
        return result;
    }

    public void create(Usuario user, String description){
        Usuario existUser = usuarioRepository.findUsuarioByIdUser(user.getIdUser());
        if(existUser != null){
            LocalDate date = LocalDate.now();
            historialRepository.save(new Historial(description, date, existUser));
        }
    }

}
