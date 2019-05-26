package MingesoTingeso.demo.Controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import MingesoTingeso.demo.Models.Usuario;
import MingesoTingeso.demo.Repositories.UsuarioRepository;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Usuario getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findUsuarioByIdUser(id);
    }

    @PostMapping("/create")
    @ResponseBody
    public List<HashMap<String, String>> create(@RequestBody Map<String, Object> jsonData) throws ParseException {
        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>();
        Usuario usuario = usuarioRepository.findUsuarioByRutUsuario(Integer.parseInt(jsonData.get("rut_usuario").toString()));
        if(usuario == null) {
            usuarioRepository.save(new Usuario(jsonData.get("nombre_usuario").toString(),
                    jsonData.get("rol_usuario").toString(),
                    jsonData.get("correo_usuario").toString(),
                    Integer.parseInt(jsonData.get("rut_usuario").toString())));
            map.put("status", "201");
            map.put("message", "OK");
            result.add(map);
            return result;
        }
        else {
            map.put("status", "401");
            map.put("message", "User rut already exist.");
            map.put("item", usuario.getNombreUsuario());
            result.add(map);
            return result;
        }
    }

    @PostMapping("/update/{rutUsuario}")
    @ResponseBody
    public List<HashMap<String, String>> update(@PathVariable int rutUsuario, @RequestBody Map<String, Object> jsonData) throws ParseException {
        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>();
        Usuario usuario = usuarioRepository.findUsuarioByRutUsuario(rutUsuario);
        if(usuario == null) {
            map.put("status", "404");
            map.put("message", "User does not exist!.");
            map.put("item", "");
            result.add(map);
            return result;
        }
        else {
            usuario.setNombreUsuario(jsonData.get("nombre_usuario").toString());
            usuario.setRolUsuario(jsonData.get("rol_usuario").toString());
            usuario.setCorreoUsuario(jsonData.get("correo_usuario").toString());
            usuario.setRutUsuario(Integer.parseInt(jsonData.get("rut_usuario").toString()));
            usuarioRepository.save(usuario);
            map.put("status", "200");
            map.put("message", "OK");
            map.put("item", usuario.getNombreUsuario());
            result.add(map);
            return result;
        }
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/delete/{id}")
    @ResponseBody
    public List<HashMap<String, String>> update(@PathVariable Long id) throws ParseException {
        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>();
        Usuario usuario = usuarioRepository.findUsuarioByIdUser(id);
        if(usuario == null) {
            map.put("status", "404");
            map.put("message", "User does not exist!.");
            map.put("item", "");
            result.add(map);
            return result;
        }
        else {
            String erasedUser = usuario.getNombreUsuario();
            usuarioRepository.deleteById(id);
            map.put("status", "200");
            map.put("message", "OK, user erased!.");
            map.put("item", erasedUser);
            result.add(map);
            return result;
        }
    }
}

