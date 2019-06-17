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
public class ClienteRegistroTest {
    @Test
    public void getId() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2000-10-10";
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);

            Date fecha = formatter.parse(dateInString);
            Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);

            ClienteRegistro cr = new ClienteRegistro(c,r);

            cr.setId(1L);
            assertEquals(1L,(long)cr.getId());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getCliente() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2000-10-10";
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);

            Date fecha = formatter.parse(dateInString);
            Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);

            ClienteRegistro cr = new ClienteRegistro(c,r);

            cr.setCliente(c);
            assertEquals(c,(cr.getCliente()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getRegistro() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2000-10-10";
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);

            Date fecha = formatter.parse(dateInString);
            Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);

            ClienteRegistro cr = new ClienteRegistro(c,r);

            cr.setRegistro(r);
            assertEquals(r,(cr.getRegistro()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setId() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2000-10-10";
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);

            Date fecha = formatter.parse(dateInString);
            Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);

            ClienteRegistro cr = new ClienteRegistro(c,r);

            cr.setId(1L);
            assertEquals(1L,(long)cr.getId());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void setCliente() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2000-10-10";
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);

            Date fecha = formatter.parse(dateInString);
            Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);

            ClienteRegistro cr = new ClienteRegistro(c,r);

            cr.setCliente(c);
            assertEquals(c,(cr.getCliente()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setRegistro() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString = "2000-10-10";
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);

            Date fecha = formatter.parse(dateInString);
            Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,fecha);

            ClienteRegistro cr = new ClienteRegistro(c,r);

            cr.setRegistro(r);
            assertEquals(r,(cr.getRegistro()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
