package MingesoTingeso.demo.Controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import MingesoTingeso.demo.Models.Registro;
import MingesoTingeso.demo.Repositories.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

	@Autowired
	RegistroRepository registroRepository;

	@Autowired
	ResHabRepository resHabRepository;

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

		@GetMapping(value = "/nroHabitacion/{nroHabitacion}")
		@ResponseBody
		public Habitacion getHabitacionByNroHabitacion(@PathVariable int nroHabitacion) {
				return habitacionRepository.findHabitacionByNroHabitacion(nroHabitacion);
		}

		@GetMapping(value = "/filtrar")
		@ResponseBody
		public List<Habitacion> filtrarHabitaciones(@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaTermino") String fechaTermino, @RequestParam String tipo){
			List<Habitacion> listaHabitacion = habitacionRepository.findHabitacionByTipo(tipo);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date inicio;
			Date termino;
			try {
				inicio = formatter.parse(fechaInicio);
				termino = formatter.parse(fechaTermino);
			} catch (java.text.ParseException e) {
				return null;
			}
			List<Habitacion> salida = new ArrayList<>();
			List<ReservaHabitacion> lrh;
			List<Registro> lr;
			boolean apta;
			for(Habitacion h: listaHabitacion){
				apta = true;
				lrh = resHabRepository.findByHabitacionAndFechaTerminoGreaterThan(h,inicio);
				lr = registroRepository.findByHabitacionAndFechaTerminoGreaterThan(h,inicio);
				for(ReservaHabitacion rh: lrh){
					if(rh.getFechaInicioRH().equals(inicio) || rh.getFechaInicioRH().equals(termino) || rh.getFechaTerminoRH().equals(inicio) || rh.getFechaTerminoRH().equals(termino)){
						apta = false;
						break;
					}
					if(rh.getFechaInicioRH().compareTo(inicio) < 0 && rh.getFechaTerminoRH().compareTo(inicio) > 0){
						apta = false;
						break;
					}
					if(rh.getFechaInicioRH().compareTo(termino) < 0 && rh.getFechaTerminoRH().compareTo(termino) >0){
						apta = false;
						break;
					}
					if(rh.getFechaInicioRH().compareTo(inicio) > 0 && rh.getFechaInicioRH().compareTo(termino) < 0){
						apta = false;
						break;
					}
					if(rh.getFechaTerminoRH().compareTo(inicio) > 0 && rh.getFechaTerminoRH().compareTo(termino) <0){
						apta = false;
						break;
					}
				}
				if(apta){
					for(Registro r: lr){
						if(r.getFechaInicio().equals(inicio) || r.getFechaInicio().equals(termino) || r.getFechaTermino().equals(inicio) || r.getFechaTermino().equals(termino)){
							apta = false;
							break;
						}
						if(r.getFechaInicio().compareTo(inicio) < 0 && r.getFechaTermino().compareTo(inicio) > 0){
							apta = false;
							break;
						}
						if(r.getFechaInicio().compareTo(termino) < 0 && r.getFechaTermino().compareTo(termino) >0){
							apta = false;
							break;
						}
						if(r.getFechaInicio().compareTo(inicio) > 0 && r.getFechaInicio().compareTo(termino) < 0){
							apta = false;
							break;
						}
						if(r.getFechaTermino().compareTo(inicio) > 0 && r.getFechaTermino().compareTo(termino) <0){
							apta = false;
							break;
						}
					}
				}
				if(apta){
					salida.add(h);
				}
			}
			return salida;
		}

		@PostMapping("/deshabilitar/{id}")
			@ResponseBody
			public List<HashMap<String, String>> inhabilitar(@PathVariable Long id, @RequestBody Map<String, Object> jsonData) throws ParseException {
			List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<>();
			Habitacion habitacion = habitacionRepository.findHabitacionByIdHab(id);

			if(habitacion == null) {
				map.put("status", "404");
				map.put("message", "La habitacion no existe");
				result.add(map);
				return result;
			}
			else{
				habitacion.setTipoHabitacion(jsonData.get("tipo").toString());
				habitacionRepository.save(habitacion);
				map.put("status", "200");
				map.put("message", "Operación realizada con exito");
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
				result.add(map);
				return result;
			}

			else {
				Habitacion h = habitacionRepository.findHabitacionByNroHabitacion(Integer.parseInt(jsonData.get("nroHabitacion").toString()));
				if (h != null){
					map.put("status", "404");
					map.put("message", "Nro de habitacion ya existe, ingrese otro nro");
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
