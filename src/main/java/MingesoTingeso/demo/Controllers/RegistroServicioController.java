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

import MingesoTingeso.demo.Repositories.RegistroServicioRepository;
import MingesoTingeso.demo.Repositories.RegistroRepository;
import MingesoTingeso.demo.Repositories.ServicioRepository;
import MingesoTingeso.demo.Models.RegistroServicio;
import MingesoTingeso.demo.Models.Registro;
import MingesoTingeso.demo.Models.Servicio;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/registroServicio")
public class RegistroServicioController {
	@Autowired
	RegistroServicioRepository registroServicioRepository;
	@Autowired
	RegistroRepository registroRepository;
	@Autowired
	ServicioRepository servicioRepository;

	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<RegistroServicio> getAllRegistroServicios() {
        return registroServicioRepository.findAll();
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @ResponseBody
  public RegistroServicio getRegistroServicioById(@PathVariable Long id) {
      return registroServicioRepository.findRegistroServicioById(id);
  }

  @RequestMapping(value = "/registro/{id}", method = RequestMethod.GET)
  @ResponseBody
  public List<RegistroServicio> getRegistroServicioByIdRegistro(@PathVariable Registro r) {
      return registroServicioRepository.findRegistroServicioByRegistro(r);
  }

		@PostMapping("/create")
		@ResponseBody
		public List<HashMap<String, String>> create(@RequestBody Map<String, Object> jsonData) throws ParseException {
  		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
  		HashMap<String, String> map = new HashMap<>();
			Long idRegistro = new Long(Integer.parseInt(jsonData.get("idRegistro").toString()));
			Long idServicio = new Long(Integer.parseInt(jsonData.get("idServicio").toString()));
			Registro r = registroRepository.findRegistroByIdRegistro(idRegistro);
			Servicio s = servicioRepository.findServicioByIdServicio(idServicio);
  		registroServicioRepository.save(new RegistroServicio(r,s));
  		map.put("status", "201");
  		map.put("message", "RegistroServicio agregado con exito");
  		result.add(map);
  		return result;
		}
}
