package MingesoTingeso.demo.Controllers;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

import MingesoTingeso.demo.Models.*;
import MingesoTingeso.demo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservahabitacion")
public class ReservaHabitacionController {
	@Autowired
	ResHabRepository reshabRepository;

	@Autowired
	RegistroRepository registroRepository;

	@Autowired
	ReservaRepository reservaRepository;

	@Autowired
	HabitacionRepository habitacionRepository;


	@GetMapping
	@ResponseBody
	public List<ReservaHabitacion> getAllReservasHabitaciones() {
		return reshabRepository.findAll();
	}


	@PostMapping("/update/{codigoReserva}")
	@ResponseBody
	public List<HashMap<String, String>> update(@PathVariable int codigoReserva, @RequestBody Map<String, Object> jsonData) throws ParseException {
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		System.out.println(jsonData);
		Reserva reservaU = reservaRepository.findReservaByCodigoReserva(codigoReserva);
		int auxEstado = reservaU.getEstado();
		HashMap<String, String> map = new HashMap<>();


		Long idReserva = reservaU.getIdReserva();
		List<ReservaHabitacion> reservahabitaciones = reshabRepository.findAll();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		Date actual = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date fechaInicio = new Date(),fechaTermino = new Date();




		Habitacion habitacion = habitacionRepository.findHabitacionByIdHab(Long.parseLong(jsonData.get("IdHab").toString()));

		if(habitacion==null){
			map.put("status", "401");
			map.put("message", "Error, la habitación ingresada no existe.");
			result.add(map);
			return result;
		}
		try {
			fechaInicio = formatter.parse(jsonData.get("fechaInicio").toString());
			fechaTermino = formatter.parse(jsonData.get("fechaTermino").toString());
		}
		catch (ParseException ex) {
			map.put("status", "401");
			map.put("message", "Error al convertir date.");
			result.add(map);
			return result;
		}

		reservaU.setEstado(0);
		if(fechaInicio.before(actual)){
			map.put("status", "401");
			map.put("message", "Error: La fecha de inicio debe ser mayor a la actual.");
			result.add(map);
			return result;
		}
		else if(fechaInicio.after(fechaTermino)){
			map.put("status", "401");
			map.put("message", "La fecha de inicio no puede estar después de la fecha de termino.");
			result.add(map);
			return result;
		}
		for (ReservaHabitacion reserva: reservahabitaciones){
			if(reserva.getHabitacion().getIdHabitacion().equals(Long.parseLong(jsonData.get("IdHab").toString()))
					&& reserva.getReserva().getEstado()==1 && !reserva.getHabitacion().getTipoHabitacion().equals("Inhabilitada")){

				if(fechaInicio.after(reserva.getFechaInicioRH()) && fechaInicio.before(reserva.getFechaTerminoRH())){
					map.put("status", "401");
					map.put("message", "La fecha de inicio no se puede agregar, ya que no está disponible.");
					result.add(map);
					return result;
				}
				if(fechaTermino.after(reserva.getFechaInicioRH()) && fechaTermino.before(reserva.getFechaTerminoRH())){
					map.put("status", "401");
					map.put("message", "La fecha de termino no se puede agregar, ya que no está disponible.");
					result.add(map);
					return result;
				}
				if(reserva.getFechaInicioRH().after(fechaInicio) && reserva.getFechaInicioRH().before(fechaTermino)){
					map.put("status", "401");
					map.put("message", "Existe una reserva dentro de este periodo (i).");
					result.add(map);
					return result;
				}
				if(reserva.getFechaTerminoRH().after(fechaInicio) && reserva.getFechaTerminoRH().before(fechaTermino)){
					map.put("status", "401");
					map.put("message", "Existe una reserva dentro de este periodo (T)..");
					result.add(map);
					return result;
				}
				if(fechaTermino.equals(reserva.getFechaTerminoRH()) || fechaTermino.equals(reserva.getFechaInicioRH())
						|| fechaInicio.equals(reserva.getFechaTerminoRH()) || fechaInicio.equals(reserva.getFechaInicioRH())){
					map.put("status", "401");
					map.put("message", "Uno de los días extremos calza con un día de reserva");
					result.add(map);
					return result;
				}
			}
			else if(reserva.getHabitacion().getIdHabitacion().equals(Long.parseLong(jsonData.get("IdHab").toString()))){
				if (reserva.getHabitacion().getTipoHabitacion().equals("Inhabilitada")){
					map.put("status", "401");
					map.put("message", "La habitación seleccionada está anulada.");
					result.add(map);
					return result;
				}
			}
			if (reserva.getReserva().getIdReserva().equals(idReserva)){
				reserva.setFechaInicioRH(fechaInicio);
				reserva.setFechaTerminoRH(fechaTermino);
				reshabRepository.save(reserva);
			}
		}

		reservaU.setEstado(auxEstado);



		map.put("status", "201");
		map.put("message", "OK");
		result.add(map);
		return result;
	}


	@GetMapping(value="/{fechaInit}/{fechaTerm}")
	@ResponseBody
	public List<HashMap<String, String>> mostrar(@PathVariable String fechaInit, @PathVariable String fechaTerm) throws ParseException {
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<>();


		List<ReservaHabitacion> reservahabitaciones = reshabRepository.findAll();
		List<Habitacion> habitaciones = habitacionRepository.findAll();
		List<Habitacion> nhabitaciones = new ArrayList<Habitacion>();

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		LocalDate localDate = LocalDate.now();
		Date actual = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
		Date fechaInicio = new Date(),fechaTermino = new Date();



		try {
			fechaInicio = formatter.parse(fechaInit);
			fechaTermino = formatter.parse(fechaTerm);
		}
		catch (ParseException ex) {
			map.put("status", "401");
			map.put("message", "Error al convertir date.");
			result.add(map);
			return result;
		}

		if(fechaInicio.before(actual)){
			map.put("status", "401");
			map.put("message", "Error: La fecha de inicio debe ser mayor a la actual.");
			result.add(map);
			return result;
		}
		else if(fechaInicio.after(fechaTermino)){
			map.put("status", "401");
			map.put("message", "La fecha de inicio no puede estar después de la fecha de termino.");
			result.add(map);
			return result;
		}
		for (ReservaHabitacion reserva: reservahabitaciones){
			if(reserva.getReserva().getEstado()==1 && !reserva.getHabitacion().getTipoHabitacion().equals("Inhabilitada")){

				if(fechaInicio.after(reserva.getFechaInicioRH()) && fechaInicio.before(reserva.getFechaTerminoRH())){
					nhabitaciones.add(reserva.getHabitacion());
				}
				if(fechaTermino.after(reserva.getFechaInicioRH()) && fechaTermino.before(reserva.getFechaTerminoRH())){
					nhabitaciones.add(reserva.getHabitacion());
				}
				if(reserva.getFechaInicioRH().after(fechaInicio) && reserva.getFechaInicioRH().before(fechaTermino)){
					nhabitaciones.add(reserva.getHabitacion());
				}
				if(reserva.getFechaTerminoRH().after(fechaInicio) && reserva.getFechaTerminoRH().before(fechaTermino)){
					nhabitaciones.add(reserva.getHabitacion());
				}
				if(fechaTermino.equals(reserva.getFechaTerminoRH()) || fechaTermino.equals(reserva.getFechaInicioRH())
						|| fechaInicio.equals(reserva.getFechaTerminoRH()) || fechaInicio.equals(reserva.getFechaInicioRH())){
					nhabitaciones.add(reserva.getHabitacion());
				}
			}
			else if(reserva.getHabitacion().getTipoHabitacion().equals("Inhabilitada")){
				nhabitaciones.add(reserva.getHabitacion());
			}
		}
		 int aux=0;
		 ReservaHabitacion rh= new ReservaHabitacion();
		 for (Habitacion hab: habitaciones){
		 	for (Habitacion nhab: nhabitaciones){
				if (nhab.equals(hab)){
					aux=1;
				}
			}
		 	if (aux==0 && !hab.getTipoHabitacion().equals("Inhabilitada")){
				map.put("idHabitacion", String.valueOf(hab.getIdHabitacion()));
				map.put("nroHabitacion", String.valueOf(hab.getNroHabitacion()));
				map.put("capacidadNinos", String.valueOf(hab.getCapacidadNinos()));
				map.put("capacidadAdultos", String.valueOf(hab.getCapacidadAdultos()));
				map.put("precioNoche", String.valueOf(hab.getPrecioNoche()));
				map.put("tipoHabitacion", hab.getTipoHabitacion());
				result.add(map);
				map = new HashMap<>();
			}
		 	else{
		 		aux=0;
			}

		 }
		return result;
	}



	@GetMapping(value = "/rack")
	@ResponseBody
	public List<HashMap<String, String>> getAllRack() {
			List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<>();
			Date hoy = Calendar.getInstance().getTime();
			List<ReservaHabitacion> reservahabitacion = reshabRepository.findByActivaAndFechaTerminoGreaterThan(true, hoy);
			List<Registro> registros = registroRepository.findByFechaTerminoGreaterThan(hoy);
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			for(ReservaHabitacion rh : reservahabitacion){
				map.put("tipo", "Reservada");
				map.put("fechaInicio", formatter.format(rh.getFechaInicioRH()));
				map.put("fechaTermino", formatter.format(rh.getFechaTerminoRH()));
				map.put("nroHabitacion", Integer.toString(rh.getHabitacion().getNroHabitacion()));
				map.put("nombreCliente", rh.getReserva().getCliente().getNombreCliente());
				map.put("codigo",Integer.toString(rh.getReserva().getCodigoReserva()));
				result.add(map);
				map = new HashMap<>();
			}
			for(Registro r: registros){
				map.put("tipo", "Ocupada");
				map.put("fechaInicio", formatter.format(r.getFechaInicio()));
				map.put("fechaTermino", formatter.format(r.getFechaTermino()));
				map.put("nroHabitacion", Integer.toString(r.getHabitacion().getNroHabitacion()));
				map.put("nombreCliente", r.getRepresentante());
				map.put("codigo", "0");
				result.add(map);
				map = new HashMap<>();
			}
		return result;
	}

	@GetMapping(value = "/habitaciones/{idReserva}")
	@ResponseBody
	public List<HashMap<String,String>> getHabitacionesByIdReserva(@PathVariable Long idReserva){
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Reserva reserva = reservaRepository.findByIdReserva(idReserva);
		List<ReservaHabitacion> lrh = reshabRepository.findByReservaAndActiva(reserva,true);
		float desc = reserva.getDescuento()/100f;
		List<HashMap<String,String>> listaHabitaciones = new ArrayList<>();
		HashMap<String,String> map;
		for(int i = 0; i<lrh.size(); i++){
			map = new HashMap<>();
			Habitacion h = lrh.get(i).getHabitacion();
			map.put("idHab", h.getIdHabitacion().toString());
			map.put("tipoHabitacion",h.getTipoHabitacion());
			map.put("precioNoche",Integer.toString(h.getPrecioNoche()));
			map.put("precioConDescuento", Integer.toString(Math.round(h.getPrecioNoche()-h.getPrecioNoche()*desc)));
			map.put("nroHabitacion",Integer.toString(h.getNroHabitacion()));
			map.put("capacidadNinos",Integer.toString(h.getCapacidadNinos()));
			map.put("capacidadAdultos",Integer.toString(h.getCapacidadAdultos()));
			map.put("fechaInicio",formatter.format(lrh.get(i).getFechaInicioRH()));
			map.put("fechaTermino",formatter.format(lrh.get(i).getFechaTerminoRH()));
			listaHabitaciones.add(map);
		}
		return listaHabitaciones;
	}

	@GetMapping(value = "/desactivar")
	@ResponseBody
	public HttpStatus desactivar(@RequestParam("idHab") Long idHab, @RequestParam("idReserva") Long idReserva){
		Reserva reserva = reservaRepository.findByIdReserva(idReserva);
		Habitacion habitacion = habitacionRepository.findHabitacionByIdHab(idHab);
		ReservaHabitacion reservaHabitacion  = reshabRepository.findByReservaAndHabitacion(reserva,habitacion);
		reservaHabitacion.setActiva(false);
		reshabRepository.save(reservaHabitacion);
		return  HttpStatus.OK;
	}
}

