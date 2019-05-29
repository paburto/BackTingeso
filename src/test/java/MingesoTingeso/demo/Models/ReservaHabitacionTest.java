/*package MingesoTingeso.demo.Models;

import org.junit.Test;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import static org.junit.Assert.*;

public class ReservaHabitacionTest {

    @Test
    public void getIdRH() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString1 = "2019-05-05";
      String dateInString2 = "2019-05-10";
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          ReservaHabitacion rh = new ReservaHabitacion(fechaInicio,fechaTermino);
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
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          ReservaHabitacion rh = new ReservaHabitacion(fechaInicio,fechaTermino);
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
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          ReservaHabitacion rh = new ReservaHabitacion(fechaInicio,fechaTermino);
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
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          ReservaHabitacion rh = new ReservaHabitacion(fechaInicio,fechaTermino);
          Reserva r = new Reserva(1,10);
          rh.setReserva(r);
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
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          ReservaHabitacion rh = new ReservaHabitacion(fechaInicio,fechaTermino);
          Habitacion h = new Habitacion("Simple",101,2,2,6000);
          rh.setHabitacion(h);
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
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          ReservaHabitacion rh = new ReservaHabitacion(fechaInicio,fechaTermino);
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
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          ReservaHabitacion rh = new ReservaHabitacion(fechaInicio,fechaTermino);
          dateInString1 = "2019-05-06";
          try{
            fechaInicio = formatter.parse(dateInString1);
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
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          ReservaHabitacion rh = new ReservaHabitacion(fechaInicio,fechaTermino);
          dateInString2 = "2019-05-11";
          try{
            fechaTermino = formatter.parse(dateInString2);
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
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          ReservaHabitacion rh = new ReservaHabitacion(fechaInicio,fechaTermino);
          Reserva r = new Reserva(1,10);
          rh.setReserva(r);
          assertEquals(r,rh.getReserva());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setHabitacion() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString1 = "2019-05-05";
      String dateInString2 = "2019-05-10";
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          ReservaHabitacion rh = new ReservaHabitacion(fechaInicio,fechaTermino);
          Habitacion h = new Habitacion("Simple",101,2,2,6000);
          rh.setHabitacion(h);
          assertEquals(h,rh.getHabitacion());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }
}
*/