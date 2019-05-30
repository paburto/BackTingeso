package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.Reserva;
import MingesoTingeso.demo.Models.Habitacion;
import MingesoTingeso.demo.Models.Cliente;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import static org.junit.Assert.*;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ReservaControllerTest {
    @Autowired
    ReservaController rc;

    @Test
    public void getAllReservas() {
      List<Reserva> ra = rc.getAllReservas();
      Reserva r1 = ra.get(0);
      Reserva r2 = rc.getReservaByIdReserva((long)r1.getIdReserva());
      assertEquals(r1.getIdReserva(),r2.getIdReserva());
    }

    @Test
    public void getReservaByIdReserva() {
      Reserva r  = rc.getReservaByIdReserva(1L);
      assertEquals(1L,(long)r.getIdReserva());
    }

    @Test
    public void getReservaByCodigoReserva() {
      Reserva r1 = rc.getReservaByIdReserva(1L);
      int codigo = r1.getCodigoReserva();
      Reserva r2 = rc.getReservaByCodigoReserva(codigo);
      assertEquals(r1.getIdReserva(),r2.getIdReserva());
    }

    @Test
    public void getHabitacionByTipo() {
      List<Habitacion> ha = rc.getHabitacionByTipo("Simple");
      Habitacion h = ha.get(0);
      assertEquals("Simple", h.getTipoHabitacion());
    }

    @Test
    public void getClienteById() {
      Cliente c = rc.getClienteById(1L);
      assertEquals(1L,(long)c.getIdCliente());
    }

    @Test
    public void create() {

    }

    @Test
    public void update() {

    }
}
