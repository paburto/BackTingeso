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

import MingesoTingeso.demo.Models.Servicio;
import MingesoTingeso.demo.Repositories.ServicioRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/servicios")
public class ServicioController {
	@Autowired
	ServicioRepository servicioRepository;

	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Servicio> getAllServicios() {
        return servicioRepository.findAll();
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public Servicio getServicioById(@PathVariable Long id) {
      return servicioRepository.findServicioByIdServicio(id);
  }

	@PostMapping("/update/{id}")
	@ResponseBody
	public List<HashMap<String, String>> update(@PathVariable Long id, @RequestBody Map<String, Object> jsonData) throws ParseException {
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<>();
		Servicio servicio = servicioRepository.findServicioByIdServicio(id);
		if(servicio == null) {
			map.put("status", "404");
			map.put("message", "El servicio no existe");
			result.add(map);
			return result;
		}
		else {
      servicio.setNombreServicio(jsonData.get("nombreServicio").toString());
			servicio.setDescripcionServicio(jsonData.get("descripcion").toString());
			servicio.setPrecio(Integer.parseInt(jsonData.get("precioServicio").toString()));
      servicio.setCategoriaServicio(jsonData.get("categoriaServicio").toString());
			servicioRepository.save(servicio);
			map.put("status", "200");
			map.put("message", "El servicio ha sido editado");
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
	Servicio servicio = servicioRepository.findServicioByIdServicio(id);
		if(servicio == null) {
			map.put("status", "404");
			map.put("message", "Servicio no existe");
			result.add(map);
			return result;
		}
		else {
			servicioRepository.deleteById(id);
			map.put("status", "200");
			map.put("message", "El servicio ha sido borrado");
			result.add(map);
			return result;
		}
  }


		@PostMapping("/create")
		@ResponseBody
		public List<HashMap<String, String>> create(@RequestBody Map<String, Object> jsonData) throws ParseException {
  		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
  		HashMap<String, String> map = new HashMap<>();
  		servicioRepository.save(new Servicio(
      jsonData.get("descripcion").toString(),
      jsonData.get("nombreServicio").toString(),
  		Integer.parseInt(jsonData.get("precioServicio").toString()),
      jsonData.get("categoriaServicio").toString()));
  		map.put("status", "201");
  		map.put("message", "Servicio agregado con exito");
  		result.add(map);
  		return result;
		}
}
