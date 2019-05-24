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
	@RequestMapping(value = "/{idUser}", method = RequestMethod.GET)
    @ResponseBody
    public Usuario getUsuarioByIdUser(@PathVariable Long idUser) {
        return usuarioRepository.findUsuarioByIdUser(idUser);
    }

	@RequestMapping(value = "/nombre/{idUser}", method = RequestMethod.GET)
    @ResponseBody
    public Usuario getUsuarioByIdUser(@PathVariable int nombre ) {
        return usuarioRepository.findUsuarioByNombre(nombre);
    }

    @RequestMapping(value = "/RolUsuario/{idUser}", method = RequestMethod.GET)
    @ResponseBody
    public Usuario getUsuarioByIdUser(@PathVariable int Rolusuario ) {
        return usuarioRepository.findUsuarioByRolUsuario(rolUsuario);
    }

    @RequestMapping(value = "/CorreoUsuario/{idUser}", method = RequestMethod.GET)
    @ResponseBody
    public Usuario getUsuarioByIdUser(@PathVariable int CorreoUsuario ) {
        return usuarioRepository.findUsuarioByEstado(correoUsuario);
    }

	@PostMapping("/create")
    @ResponseBody
    public List<HashMap<String, String>> create(@RequestBody Map<String, Object> jsonData) throws ParseException {
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<>();
		Usuario usuario = usuarioRepository.findUsuarioByIdUser(Integer.parseInt(jsonData.get("idUser").toString()));
		if(usuario == null) {
			usuarioRepository.save(new Usuario(jsonData.get("idUser").toString(),
                                                        jsonData.get("nombreUsuario").toString(),
                                                        jsonData.get("rolUsuario").toString(),
														jsonData.get("correoUsuario").toString()));
			map.put("status", "201");
			map.put("message", "OK");
			map.put("item", jsonData.get("id").toString());
			result.add(map);
			return result;
		}
		else {
			map.put("status", "401");
			map.put("message", "User code already exist.");
			map.put("item", usuario.getid());
			result.add(map);
			return result;
		}
    }

	@PostMapping("/update/{id}")
    @ResponseBody
    public List<HashMap<String, String>> update(@PathVariable Long id, @RequestBody Map<String, Object> jsonData) throws ParseException {
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
			usuario.setNombreUsuario(jsonData.get("nombreUsuario").toString());
            usuario.setRolUsuario(jsonData.get("rolUsuario").toString());
            usuario.setCorreoUsuario(jsonData.get("correoUsuario").toString());
			usuarioRepository.save(usuario);
			map.put("status", "200");
			map.put("message", "OK");
			map.put("item", usuario.getEstado());
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
			String erasedUser = usuario.getNomnbreUsuario();
            String erasedUser = usuario.getRolUsuario();
            String erasedUser = usuario.getCorreoUsuario();
			usuarioRepository.deleteByIdUser(id);
			map.put("status", "200");
			map.put("message", "OK, user erased!.");
			map.put("item", erasedUser);
			result.add(map);
			return result;
		}
    }

}