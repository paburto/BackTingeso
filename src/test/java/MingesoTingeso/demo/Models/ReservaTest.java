package MingesoTingeso.demo.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReservaTest {

    @Test
    public void setIdReserva() {
    }

    @Test
    public void getDescuento() {
    }

    @Test
    public void setDescuento() {
    }

    @Test
    public void getEstado() {
        Reserva r= new Reserva(1,10);
        assertEquals(1, r.getEstado());
    }

    @Test
    public void setEstado() {
        Reserva r= new Reserva(1,10);
        r.setEstado(20);
        assertEquals(20, r.getEstado());
    }

    @Test
    public void getCliente() {
    }

    @Test
    public void setCliente() {
    }

    @Test
    public void getUsuario() {
    }

    @Test
    public void setUsuario() {
    }
}