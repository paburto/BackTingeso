package MingesoTingeso.demo.Models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import static org.junit.Assert.assertEquals;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ComprobantePagoTest {
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
            LocalDateTime cpfecha = LocalDateTime.now();
            ComprobantePago cp = new ComprobantePago((long)10000, "test", cpfecha, r);
            cp.setId(1L);
            assertEquals(1L,(long)cp.getId());
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
            LocalDateTime cpfecha = LocalDateTime.now();
            ComprobantePago cp = new ComprobantePago((long)10000, "test", cpfecha, r);
            cp.setId(1L);
            assertEquals(1L,(long)cp.getId());
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
            LocalDateTime cpfecha = LocalDateTime.now();
            ComprobantePago cp = new ComprobantePago((long)10000, "test", cpfecha, r);
            cp.setRegistro(r);
            assertEquals(r, cp.getRegistro());
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
            LocalDateTime cpfecha = LocalDateTime.now();
            ComprobantePago cp = new ComprobantePago((long)10000, "test", cpfecha, r);
            cp.setRegistro(r);
            assertEquals(r, cp.getRegistro());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void getTotal() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            LocalDateTime cpfecha = LocalDateTime.now();
            ComprobantePago cp = new ComprobantePago((long)10000, "test", cpfecha, r);
            cp.setTotal(1L);
            assertEquals(1L,(long)cp.getTotal());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setTotal() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            LocalDateTime cpfecha = LocalDateTime.now();
            ComprobantePago cp = new ComprobantePago((long)10000, "test", cpfecha, r);
            cp.setTotal(1L);
            assertEquals(1L,(long)cp.getTotal());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getDetalle() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            LocalDateTime cpfecha = LocalDateTime.now();
            ComprobantePago cp = new ComprobantePago((long)10000, "test", cpfecha, r);
            cp.setDetalle("test1");
            assertEquals("test1",cp.getDetalle());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setDetalle() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            LocalDateTime cpfecha = LocalDateTime.now();
            ComprobantePago cp = new ComprobantePago((long)10000, "test", cpfecha, r);
            cp.setDetalle("test1");
            assertEquals("test1",cp.getDetalle());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getFecha() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            LocalDateTime cpfecha = LocalDateTime.now();
            ComprobantePago cp = new ComprobantePago((long)10000, "test", cpfecha, r);
            cpfecha = LocalDateTime.now();
            cp.setFecha(cpfecha);
            assertEquals(cpfecha,cp.getFecha());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void setFecha() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            Registro r = new Registro("Edgar Blau",fechaInicio,fechaTermino, h);
            LocalDateTime cpfecha = LocalDateTime.now();
            ComprobantePago cp = new ComprobantePago((long)10000, "test", cpfecha, r);
            cpfecha = LocalDateTime.now();
            cp.setFecha(cpfecha);
            assertEquals(cpfecha,cp.getFecha());
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
