package MingesoTingeso.demo.Repositories;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import MingesoTingeso.demo.Models.ReservaHabitacion;
@DataJpaTest 
@SpringBootTest(classes=ResHabRepository.class)
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
