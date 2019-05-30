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
    public void getAllRackP() {
    	List<HashMap<String, String>> rack = rc.getAllRackP();
    	List<HashMap<String, String>> rack2 = rc.getAllRackP();
    	assertEquals(rack.size(), rack2.size());
    }

    @Test
    public void getReservasFuturas(){
      
    }

    @Test
    public void create() throws ParseException {
    	List<Habitacion> hab = hc.getAllHabitaciones();
    	Random random = new Random();
    	int randomInt = random.nextInt(10000) + 1000;
    	int minDay = (int) LocalDate.of(2019, 7, 7).toEpochDay();
    	int maxDay = (int) LocalDate.of(2022, 12, 12).toEpochDay();
    	int promDay = minDay - maxDay - 1;
    	int maxDayFinal = (int) LocalDate.of(2022, 12, 12).toEpochDay();
    	long randomDayFirst = minDay + random.nextInt(maxDay - minDay);
    	long randomDayEnd = promDay + random.nextInt(maxDayFinal - promDay);
    	LocalDate dateStart = LocalDate.ofEpochDay(randomDayFirst);
    	LocalDate dateEnd = LocalDate.ofEpochDay(randomDayEnd);
    	HashMap<String, Object> map = new HashMap<>();
    	map.put("rut", 189411839);
    	map.put("rutUsuario", 189411839);
    	map.put("nombre", "Edgar Blau");
    	map.put("correo", "edgar.blau@usach.cl");
    	map.put("telefono", 975242480);
    	map.put("fechaNacimiento", "1995-05-19");
    	map.put("fechaInicio", dateStart);
    	map.put("fechaTermino", dateEnd);
    	map.put("estado", 1);
    	map.put("IdHab", hab.get(0).getIdHabitacion());
    	map.put("descuento", 0);
    	map.put("codigoReserva", randomInt);
    	List<HashMap<String, String>> reserva = rc.create(map);
    	assertEquals(201, Integer.parseInt(reserva.get(0).get("status")));
    }

    @Test
    public void update() throws ParseException {
    	List<Habitacion> hab = hc.getAllHabitaciones();
    	List<Reserva> re = rc.getAllReservas();
    	Random random = new Random();
    	int randomInt = random.nextInt(10000) + 1000;
    	int minDay = (int) LocalDate.of(2019, 7, 7).toEpochDay();
    	int maxDay = (int) LocalDate.of(2022, 12, 12).toEpochDay();
    	int promDay = minDay - maxDay - 1;
    	int maxDayFinal = (int) LocalDate.of(2022, 12, 12).toEpochDay();
    	long randomDayFirst = minDay + random.nextInt(maxDay - minDay);
    	long randomDayEnd = promDay + random.nextInt(maxDayFinal - promDay);
    	LocalDate dateStart = LocalDate.ofEpochDay(randomDayFirst);
    	LocalDate dateEnd = LocalDate.ofEpochDay(randomDayEnd);
    	HashMap<String, Object> map = new HashMap<>();
    	map.put("rut", 189411839);
    	map.put("rutUsuario", 189411839);
    	map.put("nombre", "Edgar Blau");
    	map.put("correo", "edgar.blau@usach.cl");
    	map.put("telefono", 975242480);
    	map.put("fechaNacimiento", "1995-05-19");
    	map.put("fechaInicio", dateStart);
    	map.put("fechaTermino", dateEnd);
    	map.put("estado", 1);
    	map.put("IdHab", hab.get(0).getIdHabitacion());
    	map.put("descuento", 0);
    	map.put("codigoReserva", re.get(0).getCodigoReserva());
    	List<HashMap<String, String>> reserva = rc.update(re.get(0).getCodigoReserva(), map);
    	assertEquals(201, Integer.parseInt(reserva.get(0).get("status")));
    }
}
