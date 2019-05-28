package MingesoTingeso.demo.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HabitacionTest {

    @Test
    public void getIdHabitacion() {
      Habitacion h = new Habitacion("Simple",101,2,2,6000);
      h.setIdHabitacion(1L);
      assertEquals(1L,(long)h.getIdHabitacion());
    }

    @Test
    public void setIdHabitacion() {
      Habitacion h = new Habitacion("Simple",101,2,2,6000);
      h.setIdHabitacion(1L);
      assertEquals(1L,(long)h.getIdHabitacion());
    }

    @Test
    public void getNroHabitacion() {
      Habitacion h = new Habitacion("Simple",101,2,2,6000);
      assertEquals(101,h.getNroHabitacion());
    }

    @Test
    public void setNroHabitacion() {
      Habitacion h = new Habitacion("Simple",101,2,2,6000);
      h.setNroHabitacion(102);
      assertEquals(102,h.getNroHabitacion());
    }

    @Test
    public void getTipoHabitacion() {
      Habitacion h = new Habitacion("Simple",101,2,2,6000);
      assertEquals("Simple",h.getTipoHabitacion());
    }

    @Test
    public void setTipoHabitacion() {
      Habitacion h = new Habitacion("Doble",101,2,2,6000);
      h.setTipoHabitacion("Doble");
      assertEquals("Doble",h.getTipoHabitacion());
    }

    @Test
    public void getCapacidadNinos() {
      Habitacion h = new Habitacion("Simple",101,2,2,6000);
      assertEquals(2,h.getCapacidadNinos());
    }

    @Test
    public void setCapacidadNinos() {
      Habitacion h = new Habitacion("Simple",101,2,2,6000);
      h.setCapacidadNinos(102);
      assertEquals(102,h.getCapacidadNinos());
    }

    @Test
    public void getCapacidadAdultos() {
      Habitacion h = new Habitacion("Simple",101,2,2,6000);
      assertEquals(2,h.getCapacidadAdultos());
    }

    @Test
    public void setCapacidadAdultos() {
      Habitacion h = new Habitacion("Simple",101,2,2,6000);
      h.setCapacidadAdultos(102);
      assertEquals(102,h.getCapacidadAdultos());
    }

    @Test
    public void getPrecioNoche() {
      Habitacion h = new Habitacion("Simple",101,2,2,6000);
      assertEquals(6000,h.getPrecioNoche());
    }

    @Test
    public void setPrecioNoche() {
      Habitacion h = new Habitacion("Simple",101,2,2,6000);
      h.setPrecioNoche(102);
      assertEquals(102,h.getPrecioNoche());
    }
}
