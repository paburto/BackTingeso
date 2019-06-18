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

public class ReservaHabitacionTest {

    @Test
    public void ReservaHabitacion() {
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
            rh.setIdRH(1L);
            assertEquals(1L,(long)rh.getIdRH());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getIdRH() {
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
          rh.setIdRH(1L);
          assertEquals(1L,(long)rh.getIdRH());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getFechaInicioRH() {
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
          assertEquals(fechaInicio, rh.getFechaInicioRH());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getFechaTerminoRH() {
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
          assertEquals(fechaTermino, rh.getFechaTerminoRH());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getReserva() {
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
          assertEquals(r,rh.getReserva());
      } catch (ParseException e) {
          e.printStackTrace();
      }

    }

    @Test
    public void getHabitacion() {
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
          assertEquals(h,rh.getHabitacion());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setIdRH() {
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
          rh.setIdRH(1L);
          assertEquals(1L,(long)rh.getIdRH());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setFechaInicioRH() {
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
          String dateInString4 = "2019-05-06";
          try{
            fechaInicio = formatter.parse(dateInString4);
            rh.setFechaInicioRH(fechaInicio);
            assertEquals(fechaInicio,rh.getFechaInicioRH());
          } catch (ParseException e){
            e.printStackTrace();
          }
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void isActiva() {
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
            String dateInString4 = "2019-05-06";
            try{
                fechaInicio = formatter.parse(dateInString4);
                rh.setFechaInicioRH(fechaInicio);
                assertEquals(fechaInicio,rh.getFechaInicioRH());
            } catch (ParseException e){
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setFechaTerminoRH() {
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
          String dateInString4 = "2019-05-11";
          try{
            fechaTermino = formatter.parse(dateInString4);
            rh.setFechaTerminoRH(fechaTermino);
            assertEquals(fechaTermino,rh.getFechaTerminoRH());
          } catch (ParseException e){
            e.printStackTrace();
          }
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setReserva() {
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
          Reserva r2 = new Reserva(2,10,10,u,c);
          rh.setReserva(r2);
          assertEquals(r2,rh.getReserva());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setHabitacion() {
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
          Habitacion h2 = new Habitacion("Doble",101,2,2,6000);
          rh.setHabitacion(h2);
          assertEquals(h2,rh.getHabitacion());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setActiva() {
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
            Habitacion h2 = new Habitacion("Doble",101,2,2,6000);
            rh.setHabitacion(h2);
            assertEquals(h2,rh.getHabitacion());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
