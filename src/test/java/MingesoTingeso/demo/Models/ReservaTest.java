package MingesoTingeso.demo.Models;

import org.junit.Test;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import static org.junit.Assert.*;

public class ReservaTest {

    @Test
    public void setIdReserva() {
      Reserva r = new Reserva(1,10);
      r.setIdReserva(2L);
      assertEquals(2L,(long)r.getIdReserva());
    }

    @Test
    public void getIdReserva() {
      Reserva r = new Reserva(1,10);
      r.setIdReserva(2L);
      assertEquals(2L,(long)r.getIdReserva());
    }

    @Test
    public void getDescuento() {
      Reserva r = new Reserva(1,10);
      assertEquals(10,r.getDescuento());
    }

    @Test
    public void setDescuento() {
      Reserva r = new Reserva(1,10);
      r.setDescuento(15);
      assertEquals(15,r.getDescuento());
    }

    @Test
    public void getEstado() {
        Reserva r= new Reserva(1,10);
        assertEquals(1, r.getEstado());
    }

    @Test
    public void setEstado() {
        Reserva r= new Reserva(1,10);
        r.setEstado(20);
        assertEquals(20, r.getEstado());
    }

    @Test
    public void getCliente() {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      String dateInString = "08/05/2019";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(23948432,"Edgar Blau","edgar.blau@usach.cl",912345678, fecha);
          Reserva r = new Reserva(1,10);
          r.setCliente(c);
          assertEquals(c,r.getCliente());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setCliente() {
      SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
      String dateInString = "08/05/2019";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(23948432,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          Reserva r = new Reserva(1,10);
          r.setCliente(c);
          assertEquals(c,r.getCliente());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getUsuario() {
      Usuario u = new Usuario("José Mellado","Operador","jose.mellado@usach.cl",22345109);
      Reserva r = new Reserva(1,10);
      r.setUsuario(u);
      assertEquals(u,r.getUsuario());
    }

    @Test
    public void setUsuario() {
      Usuario u = new Usuario("José Mellado","Operador","jose.mellado@usach.cl",22345109);
      Reserva r = new Reserva(1,10);
      r.setUsuario(u);
      assertEquals(u,r.getUsuario());
    }
}
