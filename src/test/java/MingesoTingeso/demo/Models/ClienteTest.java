package MingesoTingeso.demo.Models;

import org.junit.Test;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import static org.junit.Assert.*;
/**
public class ClienteTest {

    @Test
    public void setIdCliente() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          c.setIdCliente(1L);
          assertEquals(1L,(long)c.getIdCliente());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getIdCliente() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          c.setIdCliente(1L);
          assertEquals(1L,(long)c.getIdCliente());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getRut() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          assertEquals(75483759,c.getRut());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setRut() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          c.setRut(7123456);
          assertEquals(7123456,c.getRut());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getNombreCliente() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          assertEquals("Edgar Blau", c.getNombreCliente());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setNombreCliente() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          c.setNombreCliente("José Mellado");
          assertEquals("José Mellado", c.getNombreCliente());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getTelefonoCliente() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          assertEquals(912345678,c.getTelefonoCliente());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setTelefonoCliente() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          c.setTelefonoCliente(912345679);
          assertEquals(912345679,c.getTelefonoCliente());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getFechaNacimiento() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          assertEquals(fecha,c.getFechaNacimiento());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setFechaNacimiento() {
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          dateInString = "2000-10-11";
          try{
            fecha = formatter.parse(dateInString);
            c.setFechaNacimiento(fecha);
            assertEquals(fecha,c.getFechaNacimiento());
          } catch(ParseException e){
            e.printStackTrace();
          }
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void getCorreoCliente(){
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          assertEquals("edgar.blau@usach.cl", c.getCorreoCliente());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }

    @Test
    public void setCorreoCliente(){
      SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
      String dateInString = "2000-10-10";
      try {
          Date fecha = formatter.parse(dateInString);
          Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);
          c.setCorreoCliente("diego.aguila@usach.cl");
          assertEquals("diego.aguila@usach.cl",c.getCorreoCliente());
      } catch (ParseException e) {
          e.printStackTrace();
      }
    }
}
 **/