package MingesoTingeso.demo.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServicioTest {

    @Test
    public void getIdServicio() {
      Servicio s = new Servicio("Lorem","Servicio",1000);
      s.setIdServicio(1);
      assertEquals(1,s.getIdServicio());
    }

    @Test
    public void getDescripcionServicio() {
      Servicio s = new Servicio("Lorem","Servicio",1000);
      assertEquals("Lorem",s.getDescripcionServicio());
    }

    @Test
    public void getNombreServicio() {
      Servicio s = new Servicio("Lorem","Servicio",1000);
      assertEquals("Servicio",s.getNombreServicio());
    }

    @Test
    public void getPrecio() {
      Servicio s = new Servicio("Lorem","Servicio",1000);
      assertEquals(1000,s.getPrecio());
    }

    @Test
    public void setIdServicio() {
      Servicio s = new Servicio("Lorem","Servicio",1000);
      s.setIdServicio(1);
      assertEquals(1,s.getIdServicio());
    }

    @Test
    public void setDescripcionServicio() {
      Servicio s = new Servicio("Lorem","Servicio",1000);
      s.setDescripcionServicio("Lorem2");
      assertEquals("Lorem2",s.getDescripcionServicio());
    }

    @Test
    public void setNombreServicio() {
      Servicio s = new Servicio("Lorem","Servicio",1000);
      s.setNombreServicio("Servicio2");
      assertEquals("Servicio2",s.getNombreServicio());
    }

    @Test
    public void setPrecio() {
      Servicio s = new Servicio("Lorem","Servicio",1000);
      s.setPrecio(1001);
      assertEquals(1001,s.getPrecio());
    }
}
