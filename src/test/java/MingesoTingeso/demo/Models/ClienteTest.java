package MingesoTingeso.demo.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClienteTest {

    @Test
    public void setIdCliente() {
      Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,"2000-10-10");
      c.setIdCliente(1);
      assertEquals(1,c.getIdCliente());
    }

    @Test
    public void getIdCliente() {
      Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,"2000-10-10");
      c.setIdCliente(1);
      assertEquals(1,c.getIdCliente());
    }

    @Test
    public void getRut() {
      Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,"2000-10-10");
      assertEquals(75483759,c.getRut());
    }

    @Test
    public void setRut() {
      Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,"2000-10-10");
      c.setRut(7123456);
      assertEquals(7123456,c.getRut());
    }

    @Test
    public void getNombreCliente() {
        Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,"2000-10-10");
        assertEquals("Edgar Blau", c.getNombreCliente());
    }

    @Test
    public void setNombreCliente() {
        Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,"2000-10-10");
        c.setNombreCliente("José Mellado");
        assertEquals("José Mellado", c.getNombreCliente());
    }

    @Test
    public void getTelefonoCliente() {
      Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,"2000-10-10");
      assertEquals(912345678,c.getTelefonoCliente());
    }

    @Test
    public void setTelefonoCliente() {
      Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,"2000-10-10");
      c.setTelefonoCliente(912345679);
      assertEquals(912345679,c.getTelefonoCliente());
    }

    @Test
    public void getFechaNacimiento() {
      Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,"2000-10-10");
      assertEquals("2000-10-10",c.getFechaNacimiento());
    }

    @Test
    public void setFechaNacimiento() {
      Cliente c = new Cliente(75483759,"Edgar Blau","edgar.blau@usach.cl",912345678,"2000-10-10");
      c.setFechaNacimiento("2000-10-11");
      assertEquals("2000-10-11",c.getFechaNacimiento());
    }
}
