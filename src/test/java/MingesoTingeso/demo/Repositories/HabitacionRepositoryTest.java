package MingesoTingeso.demo.Repositories;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import MingesoTingeso.demo.Models.Habitacion;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class HabitacionRepositoryTest {
	@Autowired
	HabitacionRepository habitacionRepository;

	@Test
	public void findHabitacionByIdHab() {
		Habitacion hab = habitacionRepository.findHabitacionByIdHab(1L);
		hab.setCapacidadAdultos(20);
		assertEquals(20, hab.getCapacidadAdultos());
	}

	@Test
	public void findHabitacionByNroHabitacion() {

		Habitacion hab = habitacionRepository.findHabitacionByNroHabitacion(666);
		hab.setCapacidadAdultos(20);
		assertEquals(20, hab.getCapacidadAdultos());
	}

	@Test
	public void findHabitacionByTipo() {
		List<Habitacion> hab = habitacionRepository.findHabitacionByTipo("Simple");
		if(!hab.isEmpty()) {
			hab.get(0).setCapacidadNinos(10);
			assertEquals(10, hab.get(0).getCapacidadNinos());
		}
	}

	@Test
	public void findHabitacionByCapacidadNinos() {
		List<Habitacion> hab = habitacionRepository.findHabitacionByCapacidadNinos(2);
		if(!hab.isEmpty()) {
			hab.get(0).setPrecioNoche(20000);
			assertEquals(20000, hab.get(0).getPrecioNoche());
		}
	}

	@Test
	public void findHabitacionByCapacidadAdultos() {
		List<Habitacion> hab = habitacionRepository.findHabitacionByCapacidadAdultos(2);
		if(!hab.isEmpty()) {
			hab.get(0).setPrecioNoche(40000);
			assertEquals(40000, hab.get(0).getPrecioNoche());
		}
	}

	@Test
	public void findHabitacionByPrecioNoche() {
		List<Habitacion> hab = habitacionRepository.findHabitacionByPrecioNoche(50000);
		if(!hab.isEmpty()) {
			hab.get(0).setNroHabitacion(520);
			assertEquals(520, hab.get(0).getNroHabitacion());
		}
	}
}
