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

import MingesoTingeso.demo.Models.ReservaHabitacion;
import MingesoTingeso.demo.Models.Cliente;
import MingesoTingeso.demo.Models.Reserva;
import MingesoTingeso.demo.Repositories.ClienteRepository;
import MingesoTingeso.demo.Repositories.ResHabRepository;
import MingesoTingeso.demo.Repositories.ReservaRepository;
import MingesoTingeso.demo.Controllers.ClienteController;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservahabitacion")
public class ReservaHabitacionController {
	@Autowired
	ResHabRepository reshabRepository;

	@Autowired
	ClienteRepository clienteRepository;

	@Autowired
	ReservaRepository reservaRepository;


	ClienteController clienteController;

	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ReservaHabitacion> getAllReservasHabitaciones() {
        return reshabRepository.findAll();
    }



	@PostMapping("/create")
	@ResponseBody
	public List<HashMap<String, String>> createSimple(@RequestBody Map<String, Object> jsonData) throws ParseException {
		List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = new HashMap<>();
		Date fechaInicio = null,fechaTermino = null;
		SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
		try {
			fechaInicio = formato.parse(jsonData.get("fechaInicio").toString());
			fechaTermino = formato.parse(jsonData.get("fechaTermino").toString());
		}
		catch (ParseException ex)
		{
			map.put("fechaInicio", fechaInicio.toString());
			map.put("fechaTermino", fechaTermino.toString());
			map.put("status", "401");
			map.put("message", "Error al convertir date.");
			result.add(map);
			return result;
		}
		List<ReservaHabitacion> reservahabitaciones = reshabRepository.findAll();
		for (ReservaHabitacion reserva: reservahabitaciones){
			if(fechaInicio.after(reserva.getFechaTerminoRH()) && fechaInicio.after(reserva.getFechaTerminoRH())){
				map.put("status", "401");
				map.put("message", "La fecha de inicio no se puede agregar, ya que no está disponible.");
				result.add(map);
				return result;
			}
			if(fechaTermino.after(reserva.getFechaTerminoRH()) && fechaTermino.after(reserva.getFechaTerminoRH())){
				map.put("status", "401");
				map.put("message", "La fecha de termino no se puede agregar, ya que no está disponible.");
				result.add(map);
				return result;
			}
		}
		return result;
	}


		@RequestMapping(value = "/rack" , method = RequestMethod.GET)
	    @ResponseBody
	    public List<HashMap<String, String>> getAllRack() {
				List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
				HashMap<String, String> map = new HashMap<>();
        List<ReservaHabitacion> reservahabitacion = reshabRepository.findAll();
				List<Reserva> reserva = reservaRepository.findAll();
				List<Cliente> cliente = clienteRepository.findAll();
				for(ReservaHabitacion rh : reservahabitacion){
					for(Reserva r : reserva){
						for(Cliente c : cliente){
							if(rh.getReserva().getIdReserva() == r.getIdReserva() && r.getCliente().getIdCliente() == c.getIdCliente()){
								map.put("fechaInicio", rh.getFechaInicioRH().toString());
								map.put("fechaTermino", rh.getFechaTerminoRH().toString());
								map.put("idHab", rh.getHabitacion().getIdHabitacion().toString());
								map.put("idReserva", rh.getReserva().getIdReserva().toString());
								map.put("descuento", Integer.toString(r.getDescuento()));
								map.put("estado", Integer.toString(r.getEstado()));
								map.put("idUser", r.getUsuario().getIdUsuario().toString());
								map.put("idCliente", c.getIdCliente().toString());
								map.put("nombreCliente", c.getNombreCliente());
								map.put("rut", Integer.toString(c.getRut()));
								map.put("telefono", Integer.toString(c.getTelefonoCliente()));
								map.put("fechaNacimiento", c.getFechaNacimiento().toString());
								result.add(map);
								map = new HashMap<>();
							}
						}
					}
				}
				return result;
	    }






}
