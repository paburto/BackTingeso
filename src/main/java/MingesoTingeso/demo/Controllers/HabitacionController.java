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
import MingesoTingeso.demo.Models.ReservaHabitacion;
import MingesoTingeso.demo.Repositories.ResHabRepository;
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

		@CrossOrigin(origins = "*")
		@PostMapping("/deshabilitar/{id}")
			@ResponseBody
			public List<HashMap<String, String>> inhabilitar(@PathVariable Long id, @RequestBody Map<String, Object> jsonData) throws ParseException {
			List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<>();
			Habitacion habitacion = habitacionRepository.findHabitacionByIdHab(id);

			if(habitacion == null) {
				map.put("status", "404");
				map.put("message", "La habitacion no existe");
				map.put("item", "");
				result.add(map);
				return result;
			}
			else{
				habitacion.setTipoHabitacion(jsonData.get("tipo").toString());
				habitacionRepository.save(habitacion);
				map.put("status", "200");
				map.put("message", "La Habitacion ha sido inhabilitada para reservar");
				result.add(map);
				return result;
			}

		}

		@PostMapping("/habilitar/{id}")
			@ResponseBody
			public List<HashMap<String, String>> habilitar(@PathVariable Long id, @RequestBody Map<String, Object> jsonData) throws ParseException {
			List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<>();
			Habitacion habitacion = habitacionRepository.findHabitacionByIdHab(id);

			if(habitacion == null) {
				map.put("status", "404");
				map.put("message", "La habitacion no existe");
				map.put("item", "");
				result.add(map);
				return result;
			}
			else{
				habitacion.setTipoHabitacion(jsonData.get("tipo").toString());
				habitacionRepository.save(habitacion);
				map.put("status", "200");
				map.put("message", "La Habitacion ha sido habilitada para reservar");
				result.add(map);
				return result;
			}

		}





		@PostMapping("/update/{id}")
			@ResponseBody
			public List<HashMap<String, String>> update(@PathVariable Long id, @RequestBody Map<String, Object> jsonData) throws ParseException {
			List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<>();
			Habitacion habitacion = habitacionRepository.findHabitacionByIdHab(id);

			if(habitacion == null) {
				map.put("status", "404");
				map.put("message", "La habitacion no existe");
				map.put("item", "");
				result.add(map);
				return result;
			}

			else {
				Habitacion h = habitacionRepository.findHabitacionByNroHabitacion(Integer.parseInt(jsonData.get("nroHabitacion").toString()));
				if (h != null){
					map.put("status", "404");
					map.put("message", "Nro de habitacion ya existe, ingrese otro nro");
					map.put("item", "");
					result.add(map);
					return result;
				}
				else{

				habitacion.setTipoHabitacion(jsonData.get("tipo").toString());
				habitacion.setNroHabitacion(Integer.parseInt(jsonData.get("nroHabitacion").toString()));
				habitacion.setCapacidadNinos(Integer.parseInt(jsonData.get("capacidadNinos").toString()));
				habitacion.setCapacidadAdultos(Integer.parseInt(jsonData.get("capacidadAdultos").toString()));
				habitacion.setPrecioNoche(Integer.parseInt(jsonData.get("precioNoche").toString()));
				habitacionRepository.save(habitacion);
				map.put("status", "200");
				map.put("message", "La Habitacion ha sido editada");
				result.add(map);
				return result;
			}
			}
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
			map.put("message", "Habitacion no existe");
			map.put("item", "");
			result.add(map);
			return result;
		}
		else {
			List<ReservaHabitacion> reservahabitacion = habitacion.getReservasHabitaciones();
			Date objDate = new Date();
			for(ReservaHabitacion rh: reservahabitacion){
				if(rh.getFechaTerminoRH().compareTo(objDate) > 0){
					map.put("status", "404");
					map.put("message", "No se puede borrar esta habitacion, hay reservas pendientes");
					map.put("item", "");
					result.add(map);
					return result;
				}
			}
			habitacionRepository.deleteById(id);
			map.put("status", "200");
			map.put("message", "La habitacion ha sido borrada");
			result.add(map);
			return result;
		}
    }


		@PostMapping("/create")
			@ResponseBody
			public List<HashMap<String, String>> create(@RequestBody Map<String, Object> jsonData) throws ParseException {
			List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<>();
			Habitacion habitacion = habitacionRepository.findHabitacionByNroHabitacion(Integer.parseInt(jsonData.get("nroHabitacion").toString()));
			if(habitacion == null) {
				habitacionRepository.save(new Habitacion(jsonData.get("tipo").toString(),
															Integer.parseInt(jsonData.get("nroHabitacion").toString()),
															Integer.parseInt(jsonData.get("capacidadNinos").toString()),
															Integer.parseInt(jsonData.get("capacidadAdultos").toString()),
															Integer.parseInt(jsonData.get("precioNoche").toString())));
				map.put("status", "201");
				map.put("message", "Habitacion agregada con exito");
				result.add(map);
				return result;
			}
			else {
				map.put("status", "401");
				map.put("message", "Nro de habitacion ya existe, ingrese otro nro");
				result.add(map);
				return result;
			}
			}





}
