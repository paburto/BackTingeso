package MingesoTingeso.demo.Models;

import MingesoTingeso.demo.Repositories.ServicioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class RegistroTest {
    @Autowired
    ServicioRepository servicioRepository;

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
    public void getHabitacion() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            assertEquals(h,r.getHabitacion());
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

    @Test
    public void setHabitacion() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            h = new Habitacion("Simple",1112,2,2,8000);
            r.setHabitacion(h);
            assertEquals(h,r.getHabitacion());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setPrecio() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            h = new Habitacion("Simple",1112,2,2,8000);
            int xd = 8500;
            r.setPrecio(xd);
            assertEquals(xd,r.getPrecio());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
