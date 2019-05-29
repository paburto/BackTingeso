package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.Habitacion;
import org.junit.Test;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import static org.junit.Assert.*;

public class HabitacionControllerTest {

    @Test
    public void getAllHabitaciones() {
      HabitacionController hc = new HabitacionController();
      List<Habitacion> h1 = hc.getAllHabitaciones();
      List<Habitacion> h2 = hc.getAllHabitaciones();
      assertEquals(h1.size(),h2.size());
    }

    @Test
    public void getHabitacionById() {
      HabitacionController hc = new HabitacionController();
      List<Habitacion> ha = hc.getAllHabitaciones();
      Habitacion h = hc.getHabitacionById(1L);
      assertEquals(ha.get(0),h);
    }

    @Test
    public void update() {
      /*
      HabitacionController hc = new HabitacionController();
      List<Habitacion> ha = hc.getAllHabitaciones();
      HashMap<String, Object> map = new HashMap<>();
      map.put("nroHabitacion",111);
      List<HashMap<String, String>> up = hc.update(1L,map);
      Habitacion h = ha.get(0);
      assertEquals(111,h.getNroHabitacion());
      */
    }

    @Test
    public void create() {

    }

    @Test
    public void delete() {

    }
}
