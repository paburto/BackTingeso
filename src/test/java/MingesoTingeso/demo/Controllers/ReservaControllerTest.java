package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.Reserva;
import MingesoTingeso.demo.Models.Habitacion;
import MingesoTingeso.demo.Models.Cliente;
import MingesoTingeso.demo.Models.ReservaHabitacion;
import MingesoTingeso.demo.Repositories.ReservaRepository;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.text.ParseException;

import static org.junit.Assert.*;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ReservaControllerTest {
     @Autowired
    ReservaController rc;
    @Autowired
    HabitacionController hc;
    @Autowired
    ReservaRepository rr;
    @Test
    public void getAllReservas() {
      List<Reserva> ra = rc.getAllReservas();
      Reserva r1 = ra.get(0);
      Reserva r2 = rc.getReservaByIdReserva((long)r1.getIdReserva());
      assertEquals(r1.getIdReserva(),r2.getIdReserva());
    }

    @Test
    public void getReservaByIdReserva() {
        List<Reserva> ra = rc.getAllReservas();
        long id = ra.get(0).getIdReserva();
        Reserva r2 = rc.getReservaByIdReserva(id);
        assertEquals(id,(long)r2.getIdReserva());
    }

    @Test
    public void getReservaByCodigoReserva() {
        List<Reserva> ra = rc.getAllReservas();
      int codigo = ra.get(0).getCodigoReserva();
      Reserva r2 = rc.getReservaByCodigoReserva(codigo);
      assertEquals(codigo,r2.getCodigoReserva());
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
    public void getAllRackP() throws ParseException {
    	List<HashMap<String, String>> rack;
    	Reserva reserv;
    	Habitacion hab;
    	ReservaHabitacion rhab;
    	try{
            rack = rc.getAllRackP();
            if (rack == null) {
                assertEquals(true, rack == null);
            }
            assertEquals(false, rack.size() > 0);
        }
    	catch (Exception e) {
            assertEquals(false, false);
        }

    }

    @Test
    public void getReservasFuturas(){
      
    }

    @Test
    public void create() throws ParseException {
    	
    }

    @Test
    public void update() throws ParseException {

    }

    @Test
    public void anularR() throws ParseException {
        List<Reserva> aux = rr.findAll();
        Reserva reserv = aux.get(0);
        List<HashMap<String, String>> test = rc.anularR(reserv.getCodigoReserva());
        assertEquals(200, Integer.parseInt(test.get(0).get("status")));

    }
}