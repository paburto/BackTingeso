package MingesoTingeso.demo.Models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import static org.junit.Assert.*;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ReservaTest {

    @Test
    public void setIdReserva() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          r.setIdReserva(2L);
          assertEquals(2L,(long)r.getIdReserva());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getIdReserva() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          r.setIdReserva(2L);
          assertEquals(2L,(long)r.getIdReserva());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getDescuento() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          assertEquals(10,r.getDescuento());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setDescuento() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          r.setDescuento(15);
          assertEquals(15,r.getDescuento());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getEstado() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          assertEquals(1, r.getEstado());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setEstado() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          r.setEstado(20);
          assertEquals(20, r.getEstado());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getCliente() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          assertEquals(c,r.getCliente());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setCliente() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          Cliente c2 = new Cliente(23948432,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          r.setCliente(c2);
          assertEquals(c2,r.getCliente());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getUsuario() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          assertEquals(u,r.getUsuario());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setUsuario() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          Usuario u2 = new Usuario("José Mellado","Operador","jose.mellado@usach.cl",123456789, "tingeso");
          r.setUsuario(u2);
          assertEquals(u2,r.getUsuario());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getCodigoReserva(){
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          assertEquals(10, r.getCodigoReserva());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setCodigoReserva(){
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
          Reserva r = new Reserva(1,10,10,u,c);
          r.setCodigoReserva(11);
          assertEquals(11, r.getCodigoReserva());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }
}
