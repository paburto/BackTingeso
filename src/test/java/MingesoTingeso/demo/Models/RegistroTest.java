package MingesoTingeso.demo.Models;

import org.junit.Test;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import static org.junit.Assert.*;
/**
public class RegistroTest {

    @Test
    public void getIdRegistro() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString1 = "2019-05-05";
      String dateInString2 = "2019-05-10";
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          Habitacion h = new Habitacion("Simple",101,2,2,6000);
          Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
          r.setIdRegistro(1L);
          assertEquals(1L,(long)r.getIdRegistro());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getRepresentante() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString1 = "2019-05-05";
      String dateInString2 = "2019-05-10";
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          Habitacion h = new Habitacion("Simple",101,2,2,6000);
          Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
          assertEquals("Edgar Blau",r.getRepresentante());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getFechaInicio() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString1 = "2019-05-05";
      String dateInString2 = "2019-05-10";
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          Habitacion h = new Habitacion("Simple",101,2,2,6000);
          Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
          assertEquals(fechaInicio,r.getFechaInicio());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getFechaTermino() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString1 = "2019-05-05";
      String dateInString2 = "2019-05-10";
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          Habitacion h = new Habitacion("Simple",101,2,2,6000);
          Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
          assertEquals(fechaTermino,r.getFechaTermino());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setIdRegistro() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString1 = "2019-05-05";
      String dateInString2 = "2019-05-10";
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          Habitacion h = new Habitacion("Simple",101,2,2,6000);
          Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
          r.setIdRegistro(1L);
          assertEquals(1L,(long)r.getIdRegistro());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setRepresentante() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString1 = "2019-05-05";
      String dateInString2 = "2019-05-10";
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          Habitacion h = new Habitacion("Simple",101,2,2,6000);
          Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
          r.setRepresentante("Diego Águila");
          assertEquals("Diego Águila",r.getRepresentante());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setFechaInicio() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString1 = "2019-05-05";
      String dateInString2 = "2019-05-10";
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          Habitacion h = new Habitacion("Simple",101,2,2,6000);
          Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
          dateInString1 = "2019-05-06";
          try{
            fechaInicio = formatter.parse(dateInString1);
            r.setFechaInicio(fechaInicio);
            assertEquals(fechaInicio,r.getFechaInicio());
          } catch (ParseException e){
            e.printStackTrace();
          }
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setFechaTermino() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString1 = "2019-05-05";
      String dateInString2 = "2019-05-10";
      try {
          Date fechaInicio = formatter.parse(dateInString1);
          Date fechaTermino = formatter.parse(dateInString2);
          Habitacion h = new Habitacion("Simple",101,2,2,6000);
          Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
          dateInString2 = "2019-05-11";
          try{
            fechaTermino = formatter.parse(dateInString2);
            r.setFechaTermino(fechaTermino);
            assertEquals(fechaTermino,r.getFechaTermino());
          } catch (ParseException e){
            e.printStackTrace();
          }
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

}
**/