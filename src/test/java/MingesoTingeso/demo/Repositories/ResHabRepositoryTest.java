package MingesoTingeso.demo.Repositories;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import MingesoTingeso.demo.Models.ReservaHabitacion;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ResHabRepositoryTest {
	@Autowired
	ResHabRepository resHabRepository;
	
	@Test
	public void findReservaHabitacionById() {
		long idTest = 1;
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String dateInString = "2000-10-10";
	    try {
	    	ReservaHabitacion rh = resHabRepository.findReservaHabitacionById(idTest);
	    	Date fecha = formatter.parse(dateInString);
			rh.setFechaInicioRH(fecha);
			assertEquals(fecha, rh.getFechaInicioRH());
	    }catch (ParseException e) {
	          e.printStackTrace();
	    }
		
	}
	
}
