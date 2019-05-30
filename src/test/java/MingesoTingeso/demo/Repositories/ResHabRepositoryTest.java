package MingesoTingeso.demo.Repositories;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import MingesoTingeso.demo.Repositories.ResHabRepository;
import MingesoTingeso.demo.Models.ReservaHabitacion;
import MingesoTingeso.demo.Models.Habitacion;
import MingesoTingeso.demo.Models.Reserva;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ResHabRepositoryTest {
	@Autowired
	ResHabRepository resHabRepository;
	@Autowired
  HabitacionRepository habRepository;
	@Autowired
  ReservaRepository resRepository;

  @Test
	public void findReservaHabitacionByHabitacion() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    String dateInString = "2000-10-10";
    try {
      Habitacion h  = habRepository.findHabitacionByIdHab(1L);
    	List<ReservaHabitacion> rha = resHabRepository.findReservaHabitacionByHabitacion(h);
      ReservaHabitacion rh = rha.get(0);
    	Date fecha = formatter.parse(dateInString);
			rh.setFechaInicioRH(fecha);
			assertEquals(fecha, rh.getFechaInicioRH());
    }catch (ParseException e) {
          e.printStackTrace();
    }

	}
	// @Test
	// public void findReservaHabitacionByReserva() {
  //   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
  //   String dateInString = "2000-10-10";
  //   try {
  //   	ReservaHabitacion rh = resHabRepository.findReservaHabitacionByReserva(1L);
  //   	Date fecha = formatter.parse(dateInString);
	// 		rh.setFechaInicioRH(fecha);
	// 		assertEquals(fecha, rh.getFechaInicioRH());
  //   }catch (ParseException e) {
  //         e.printStackTrace();
  //   }
  // }
}
