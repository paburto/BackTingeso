package MingesoTingeso.demo.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HistorialTest {

    @Test
    public void getIdRegistro() {
      Registro r = new Registro("Edgar Blau","2019-05-05","2019-05-10");
      r.setIdRegistro(1);
      assertEquals(1,r.getIdRegistro());
    }

    @Test
    public void getRepresentante() {
      Registro r = new Registro("Edgar Blau","2019-05-05","2019-05-10");
      assertEquals("Edgar Blau",r.getRepresentante());
    }

    @Test
    public void getFechaInicio() {
      Registro r = new Registro("Edgar Blau","2019-05-05","2019-05-10");
      assertEquals("2019-05-05",r.getFechaInicio());
    }

    @Test
    public void getFechaTermino() {
      Registro r = new Registro("Edgar Blau","2019-05-05","2019-05-10");
      assertEquals("2019-05-10",r.getFechaTermino());
    }

    @Test
    public void setIdRegistro() {
      Registro r = new Registro("Edgar Blau","2019-05-05","2019-05-10");
      r.setIdRegistro(1);
      assertEquals(1,r.getIdRegistro());
    }

    @Test
    public void setRepresentante() {
      Registro r = new Registro("Edgar Blau","2019-05-05","2019-05-10");
      r.setRepresentante("Diego Águila");
      assertEquals("Diego Águila",r.getRepresentante());
    }

    @Test
    public void setFechaInicio() {
      Registro r = new Registro("Edgar Blau","2019-05-05","2019-05-10");
      r.setFechaInicio("2019-05-06");
      assertEquals("2019-05-06",r.getFechaInicio());
    }

    @Test
    public void setFechaTermino() {
      Registro r = new Registro("Edgar Blau","2019-05-05","2019-05-10");
      r.setFechaTermino("2019-05-11");
      assertEquals("2019-05-11",r.getFechaTermino());
    }

}
