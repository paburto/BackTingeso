package MingesoTingeso.demo.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReservaHabitacionTest {

    @Test
    public void getIdRH() {
      ReservaHabitacion rh = new ReservaHabitacion("2019-05-05","2019-05-10");
      rh.setIdRH(1);
      assertEquals(1,rh.getIdRH());
    }

    @Test
    public void getFechaInicioRH() {
      ReservaHabitacion rh = new ReservaHabitacion("2019-05-05","2019-05-10");
      assertEquals("2019-05-05",rh.getFechaInicioRH());
    }

    @Test
    public void getFechaTerminoRH() {
      ReservaHabitacion rh = new ReservaHabitacion("2019-05-05","2019-05-10");
      assertEquals("2019-05-10",rh.getFechaTerminoRH());
    }

    @Test
    public void getReserva() {
      ReservaHabitacion rh = new ReservaHabitacion("2019-05-05","2019-05-10");
      Reserva r = new Reserva(1,10);
      rh.setReserva(r);
      assertEquals(r,rh.getReserva());

    }

    @Test
    public void getHabitacion() {
      ReservaHabitacion rh = new ReservaHabitacion("2019-05-05","2019-05-10");
      Habitacion h = new Habitacion("Simple",101,2,2,6000);
      rh.setHabitacion(h);
      assertEquals(h,rh.getHabitacion());
    }

    @Test
    public void setIdRH() {
      ReservaHabitacion rh = new ReservaHabitacion("2019-05-05","2019-05-10");
      rh.setIdRH(1);
      assertEquals(1,rh.getIdRH());
    }

    @Test
    public void setFechaInicioRH() {
      ReservaHabitacion rh = new ReservaHabitacion("2019-05-05","2019-05-10");
      assertEquals("2019-05-05",rh.getFechaInicioRH());
    }

    @Test
    public void setFechaTerminoRH() {
      ReservaHabitacion rh = new ReservaHabitacion("2019-05-05","2019-05-10");
      assertEquals("2019-05-10",rh.getFechaTerminoRH());
    }

    @Test
    public void setReserva() {
      ReservaHabitacion rh = new ReservaHabitacion("2019-05-05","2019-05-10");
      Reserva r = new Reserva(1,10);
      rh.setReserva(r);
      assertEquals(r,rh.getReserva());
    }

    @Test
    public void setHabitacion() {
      ReservaHabitacion rh = new ReservaHabitacion("2019-05-05","2019-05-10");
      Habitacion h = new Habitacion("Simple",101,2,2,6000);
      rh.setHabitacion(h);
      assertEquals(h,rh.getHabitacion());
    }
}
