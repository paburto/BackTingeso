package MingesoTingeso.demo.Controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import MingesoTingeso.demo.Models.ReservaHabitacion;

import static org.junit.Assert.*;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ReservaHabitacionControllerTest {
    @Autowired

    @Test
    public void getAllReservasHabitaciones() {
      ReservaHabitacionController rhc = new ReservaHabitacionController();
      List<ReservaHabitacion> rha = rhc.getAllReservasHabitaciones();
      ReservaHabitacion rh = rha.get(0);
      assertEquals(1L,(long)rh.getIdRH());
    }

    @Test
    public void getAllRack() {

    }
}
