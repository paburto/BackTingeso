package MingesoTingeso.demo.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProductoTest {

    @Test
    public void testPrecio() {
        Producto p= new Producto();
        p.setPrecio(10000);
        assertEquals(10000, p.getPrecio());
    }

    @Test
    public void testCodigo() {
        Producto p= new Producto();
        p.setCodigoProducto(10000);
        assertEquals(10000, p.getCodigoProducto());
    }
}