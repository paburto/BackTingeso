package MingesoTingeso.demo.Controllers;

import org.junit.Test;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import MingesoTingeso.demo.Models.ReservaHabitacion;

import static org.junit.Assert.*;

public class ReservaHabitacionControllerTest {

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
