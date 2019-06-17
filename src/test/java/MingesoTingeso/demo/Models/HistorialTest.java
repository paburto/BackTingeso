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
public class HistorialTest {

    @Test
    public void getIdHistorial() {
        Historial h = new Historial("Lorem");
        h.setIdHistorial(1L);
        assertEquals(1L,(long)h.getIdHistorial());
    }

    @Test
    public void setIdHistorial() {
        Historial h = new Historial("Lorem");
        h.setIdHistorial(1L);
        assertEquals(1L,(long)h.getIdHistorial());
    }

    @Test
    public void getDescripcionHistorial() {
        Historial h = new Historial("Lorem");
        assertEquals("Lorem",h.getDescripcionHistorial());
    }

    @Test
    public void setDescripcionHistorial() {
        Historial h = new Historial("Lorem");
        h.setDescripcionHistorial("Lorem2");
        assertEquals("Lorem2",h.getDescripcionHistorial());
    }

}