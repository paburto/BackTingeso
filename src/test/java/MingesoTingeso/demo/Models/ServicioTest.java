
package MingesoTingeso.demo.Models;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ServicioTest {

    @Test
    public void getIdServicio() {
        Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");
        s.setIdServicio(1L);
        assertEquals(1L,(long)s.getIdServicio());
    }

    @Test
    public void getDescripcionServicio() {
        Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");
        assertEquals("Lorem",s.getDescripcionServicio());
    }

    @Test
    public void getNombreServicio() {
        Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");
        assertEquals("Servicio",s.getNombreServicio());
    }

    @Test
    public void getPrecio() {
        Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");
        assertEquals(1000,s.getPrecio());
    }

    @Test
    public void setIdServicio() {
        Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");
        s.setIdServicio(1L);
        assertEquals(1L,(long)s.getIdServicio());
    }

    @Test
    public void setDescripcionServicio() {
        Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");
        s.setDescripcionServicio("Lorem2");
        assertEquals("Lorem2",s.getDescripcionServicio());
    }

    @Test
    public void setNombreServicio() {
        Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");
        s.setNombreServicio("Servicio2");
        assertEquals("Servicio2",s.getNombreServicio());
    }

    @Test
    public void setPrecio() {
        Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");
        s.setPrecio(1001);
        assertEquals(1001,s.getPrecio());
    }

    @Test
    public void setCategoriaServicio() {
        Servicio s = new Servicio("Lorem","Servicio",1000,"Categoria");
        s.setCategoriaServicio("categoria");
        assertEquals("categoria",s.getCategoriaServicio());
    }
}