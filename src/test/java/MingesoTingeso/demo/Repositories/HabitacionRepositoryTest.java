package MingesoTingeso.demo.Repositories;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import MingesoTingeso.demo.Models.Habitacion;

@RunWith( SpringJUnit4ClassRunner.class )
@SpringBootTest
public class HabitacionRepositoryTest {
	@Autowired
	HabitacionRepository habitacionRepository;
	
	@Test
	public void findHabitacionByIdHab() {
		long idTest = 1;
		Habitacion hab = habitacionRepository.findHabitacionByIdHab(idTest);
		hab.setCapacidadAdultos(20);
		assertEquals(20, hab.getCapacidadAdultos());
	}
	
	@Test
	public void findHabitacionByNroHabitacion() {
		Habitacion hab = habitacionRepository.findHabitacionByNroHabitacion(102);
		hab.setCapacidadAdultos(20);
		assertEquals(20, hab.getCapacidadAdultos());
	}
	
	@Test
	public void findHabitacionByTipo() {
		Habitacion hab = habitacionRepository.findHabitacionByTipo("Simple");
		hab.setCapacidadNinos(10);
		assertEquals(10, hab.getCapacidadNinos());
	}
	
	@Test
	public void findHabitacionByCapacidadNinos() {
		Habitacion hab = habitacionRepository.findHabitacionByCapacidadNinos(1);
		hab.setPrecioNoche(20000);
		assertEquals(20000, hab.getPrecioNoche());
	}
	
	@Test
	public void findHabitacionByCapacidadAdultos() {
		Habitacion hab = habitacionRepository.findHabitacionByCapacidadAdultos(2);
		hab.setPrecioNoche(40000);
		assertEquals(40000, hab.getPrecioNoche());
	}
	
	@Test
	public void findHabitacionByPrecioNoche() {
		Habitacion hab = habitacionRepository.findHabitacionByPrecioNoche(50000);
		hab.setNroHabitacion(520);
		assertEquals(520, hab.getNroHabitacion());
	}
	
	@Test
	public void deleteHabitacionByIdHab() {
		Habitacion crear = habitacionRepository.save(new Habitacion("Simple", 666, 2, 3, 20000));
		Habitacion delete = habitacionRepository.deleteHabitacionByIdHab(crear.getIdHabitacion());
		assertEquals(crear.getNroHabitacion(), delete.getNroHabitacion());
	}
}
