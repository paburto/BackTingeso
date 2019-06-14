package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.Habitacion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import static org.junit.Assert.*;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class HabitacionControllerTest {
   /* @Autowired
    HabitacionController hc;
    @Test
    public void getAllHabitaciones() {
      List<Habitacion> h1 = hc.getAllHabitaciones();
      List<Habitacion> h2 = hc.getAllHabitaciones();
      assertEquals(h1.size(),h2.size());
    }

    @Test
    public void getHabitacionById() {
        List<Habitacion> h1 = hc.getAllHabitaciones();
        long id = h1.get(0).getIdHabitacion();
        Habitacion h = hc.getHabitacionById(id);
        assertEquals(id,(long)h.getIdHabitacion());
    }

    @Test
    public void inhabilitar() throws ParseException{
    	HashMap<String, Object> map = new HashMap<>();
    	map.put("tipo", "Simple");
    	List<Habitacion> h1 = hc.getAllHabitaciones();
    	List<HashMap<String, String>> ih = hc.inhabilitar(h1.get(0).getIdHabitacion(), map);
    	assertEquals(200, Integer.parseInt(ih.get(0).get("status")));
    }

	@Test
    public void update() throws ParseException {
		/*List<Habitacion> h1 = hc.getAllHabitaciones();
		HashMap<String, Object> map = new HashMap<>();
    	map.put("tipo", h1.get(0).getTipoHabitacion());
    	map.put("nroHabitacion", h1.get(0).getNroHabitacion());
    	map.put("capacidadNinos", h1.get(0).getCapacidadNinos());
    	map.put("capacidadAdultos", h1.get(0).getCapacidadAdultos());
    	map.put("precioNoche", h1.get(0).getPrecioNoche());
		List<HashMap<String, String>> hab = hc.update(h1.get(0).getIdHabitacion(), map);
		assertEquals(200, Integer.parseInt(hab.get(0).get("status")));
    }

    @Test
    public void create() throws ParseException {
    	Random randomGenerator = new Random();
    	int randomInt = randomGenerator.nextInt(10000) + 1000;
    	HashMap<String, Object> map = new HashMap<>();
    	map.put("tipo", "Inhabilitada");
    	map.put("nroHabitacion", randomInt);
    	map.put("capacidadNinos", 2);
    	map.put("capacidadAdultos", 2);
    	map.put("precioNoche", 60000);
    	List<HashMap<String, String>> cr = hc.create(map);
    	assertEquals(201, Integer.parseInt(cr.get(0).get("status")));
    }

    @Test
    public void delete() {

    }*/
}
