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

		@RequestMapping(value = "/rack" , method = RequestMethod.GET)
	    @ResponseBody
	    public void getAllRack() {
	        List<ReservaHabitacion> reservahabitacion = reshabRepository.findAll();
					List<Reserva> reserva = reservaRepository.findAll();
					List<Cliente> cliente = clienteRepository.findAll();


	    }








}
