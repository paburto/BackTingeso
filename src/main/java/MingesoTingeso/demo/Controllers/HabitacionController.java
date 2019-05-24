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

import MingesoTingeso.demo.Models.Habitacion;
import MingesoTingeso.demo.Repositories.HabitacionRepository;

//Evaluacion 07-mayo-2019

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/habitaciones")
public class HabitacionController {
	@Autowired
	HabitacionRepository habitacionRepository;

	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Habitacion> getAllHabitaciones() {
        return habitacionRepository.findAll();
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Habitacion getHabitacionById(@PathVariable Long id) {
        return habitacionRepository.findHabitacionByIdHab(id);
    }

		@PostMapping("/update/{id}")
			@ResponseBody
			public List<HashMap<String, String>> update(@PathVariable Long id, @RequestBody Map<String, Object> jsonData) throws ParseException {
			List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<>();
			Habitacion habitacion = habitacionRepository.findHabitacionByIdHab(id);
			System.out.println("hola");
			if(habitacion == null) {
				map.put("status", "404");
				map.put("message", "Product does not exist!.");
				map.put("item", "");
				result.add(map);
				return result;
			}

			else {
				habitacion.setTipoHabitacion(jsonData.get("tipo").toString());
				habitacion.setCapacidadNinos(Integer.parseInt(jsonData.get("capacidadNinos").toString()));
				habitacion.setCapacidadAdultos(Integer.parseInt(jsonData.get("capacidadAdultos").toString()));
				habitacion.setPrecioNoche(Integer.parseInt(jsonData.get("precioNoche").toString()));
				habitacionRepository.save(habitacion);
				map.put("status", "200");
				map.put("message", "OK");
				result.add(map);
				return result;
			}
		}



	@RequestMapping(value = "/precio/{precio}", method = RequestMethod.GET)
    @ResponseBody
    public Habitacion getHabitacionByPrecio(@PathVariable int precioNoche) {
        return habitacionRepository.findHabitacionByPrecioNoche(precioNoche);
    }

	@CrossOrigin(origins = "*")
	@PostMapping("/delete/{id}")
    @ResponseBody
    public List<HashMap<String, String>> update(@PathVariable Long id) throws ParseException {
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<>();
		Habitacion habitacion = habitacionRepository.findHabitacionByIdHab(id);
		if(habitacion == null) {
			map.put("status", "404");
			map.put("message", "Product does not exist!.");
			map.put("item", "");
			result.add(map);
			return result;
		}
		else {
			habitacionRepository.deleteById(id);
			map.put("status", "200");
			map.put("message", "OK, Habitacion erased!.");
			result.add(map);
			return result;
		}
    }
}
