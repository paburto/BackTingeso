package MingesoTingeso.demo.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class HistorialTest {

    @Test
    public void getIdHistorial() {
      Historial h = new Historial("Lorem");
      h.setIdHistorial(1);
      assertEquals(1,h.getIdHistorial());
    }

    @Test
    public void setIdHistorial() {
      Historial h = new Historial("Lorem");
      h.setIdHistorial(1);
      assertEquals(1,h.getIdHistorial());
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
