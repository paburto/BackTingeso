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
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import static org.junit.Assert.*;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class HabitacionControllerTest {
    @Autowired
    HabitacionController hc;
    @Test
    public void getAllHabitaciones() {
      List<Habitacion> h1 = hc.getAllHabitaciones();
      List<Habitacion> h2 = hc.getAllHabitaciones();
      assertEquals(h1.size(),h2.size());
    }

    @Test
    public void getHabitacionById() {
      List<Habitacion> ha = hc.getAllHabitaciones();
      Habitacion h = hc.getHabitacionById(1L);
      assertEquals(1L,(long)h.getIdHabitacion());
    }

    @Test
    public void inhabilitar(){

    }
    
    @Test
    public void update() {
    }

    @Test
    public void create() {

    }

    @Test
    public void delete() {

    }
}
