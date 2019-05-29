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

    @Test
    public void getAllReservas() {
      ReservaController rc = new ReservaController();
      List<Reserva> ra = rc.getAllReservas();
      Reserva r = ra.get(0);
      assertEquals(1L, (long)r.getIdReserva());
    }

    @Test
    public void getReservaByIdReserva() {
      ReservaController rc = new ReservaController();
      Reserva r  = rc.getReservaByIdReserva(1L);
      assertEquals(1L,(long)r.getIdReserva());
    }

    @Test
    public void getReservaByCodigoReserva() {
      ReservaController rc = new ReservaController();
      Reserva r1 = rc.getReservaByIdReserva(1L);
      int codigo = r1.getCodigoReserva();
      Reserva r2 = rc.getReservaByCodigoReserva(codigo);
      assertEquals(r1,r2);

    }

    @Test
    public void getHabitacionByTipo() {
      ReservaController rc = new ReservaController();
      List<Habitacion> ha = rc.getHabitacionByTipo("Simple");
      Habitacion h = ha.get(0);
      assertEquals("Simple", h.getTipoHabitacion());
    }

    @Test
    public void getClienteById() {
      ReservaController rc = new ReservaController();
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
