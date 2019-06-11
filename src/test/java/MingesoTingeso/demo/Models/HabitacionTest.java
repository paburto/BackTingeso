package MingesoTingeso.demo.Models;

import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

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

    @Test
    public void getReservasHabitaciones(){
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString1 = "2019-05-05";
      String dateInString2 = "2019-05-10";
      String dateInString3 = "2000-10-10";
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          Date fechaCliente = formatter.parse(dateInString3);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fechaCliente);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          Habitacion h = new Habitacion("Simple",101,2,2,6000);
          ReservaHabitacion rh = new ReservaHabitacion(fechaInicio,fechaTermino,r,h);
          List<ReservaHabitacion> rha1 = new ArrayList<ReservaHabitacion>();
          rha1.add(rh);
          h.setReservasHabitaciones(rha1);
          List<ReservaHabitacion> rha2 = h.getReservasHabitaciones();
          assertEquals(rha1, rha2);
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setReservasHabitaciones(){
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString1 = "2019-05-05";
      String dateInString2 = "2019-05-10";
      String dateInString3 = "2000-10-10";
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          Date fechaCliente = formatter.parse(dateInString3);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fechaCliente);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          Habitacion h = new Habitacion("Simple",101,2,2,6000);
          ReservaHabitacion rh = new ReservaHabitacion(fechaInicio,fechaTermino,r,h);
          List<ReservaHabitacion> rha = new ArrayList<ReservaHabitacion>();
          rha.add(rh);
          h.setReservasHabitaciones(rha);
          ReservaHabitacion rh2 = rha.get(0);
          assertEquals(rh2.getIdRH(), rh.getIdRH());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }
}
