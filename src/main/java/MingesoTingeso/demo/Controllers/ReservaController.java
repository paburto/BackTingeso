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

import MingesoTingeso.demo.Models.Reserva;
import MingesoTingeso.demo.Repositories.ReservaRepository;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservas")
public class ReservaController {
	@Autowired
	ReservaRepository reservaRepository;

	@RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<Reserva> getAllReservas() {
        return reservaRepository.findAll();
    }

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Reserva getReservaById(@PathVariable Long id) {
        return reservaRepository.findReservaByIdReserva(id);
    }

		@CrossOrigin(origins = "*")
		@PostMapping("/delete/{id}")
	    @ResponseBody
	    public List<HashMap<String, String>> update(@PathVariable Long id) throws ParseException {
			List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
			HashMap<String, String> map = new HashMap<>();
			Reserva reserva = reservaRepository.findReservaByIdReserva(id);
			if(reserva == null) {
				map.put("status", "404");
				map.put("message", "Reserva does not exist!.");
				map.put("item", "");
				result.add(map);
				return result;
			}
			else {
				reservaRepository.deleteById(id);
				map.put("status", "200");
				map.put("message", "OK, reserva erased!.");
				result.add(map);
				return result;
			}
	}
}
