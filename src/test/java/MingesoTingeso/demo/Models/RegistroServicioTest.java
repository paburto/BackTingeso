package MingesoTingeso.demo.Models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class RegistroServicioTest {
    @Test
    public void getId() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");

            RegistroServicio rs = new RegistroServicio(r,s);
            rs.setId(1L);
            assertEquals(1L,(long)rs.getId());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getServicio() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");

            RegistroServicio rs = new RegistroServicio(r,s);
            rs.setServicio(s);
            assertEquals(s,rs.getServicio());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRegistro() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");

            RegistroServicio rs = new RegistroServicio(r,s);
            rs.setRegistro(r);
            assertEquals(r,rs.getRegistro());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setId() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");

            RegistroServicio rs = new RegistroServicio(r,s);
            rs.setId(1L);
            assertEquals(1L,(long)rs.getId());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void setServicio() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");

            RegistroServicio rs = new RegistroServicio(r,s);
            rs.setServicio(s);
            assertEquals(s,rs.getServicio());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setRegistro() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");

            RegistroServicio rs = new RegistroServicio(r,s);
            rs.setRegistro(r);
            assertEquals(r,rs.getRegistro());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
