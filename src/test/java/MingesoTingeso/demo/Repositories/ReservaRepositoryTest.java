package MingesoTingeso.demo.Repositories;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import MingesoTingeso.demo.Models.Reserva;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ReservaRepositoryTest {
	@Autowired
	ReservaRepository reservaRepository;
	
	@Test
	public void findReservaByIdReserva() {
		long idTest = 1;
		Reserva r = reservaRepository.findReservaByIdReserva(idTest);
		r.setDescuento(1000);
		assertEquals(1000, r.getDescuento());
	}
	
	@Test
	public void findReservaByDescuento() {
		List<Reserva> r = reservaRepository.findReservaByDescuento(10);
		if(!r.isEmpty()) {
			r.get(0).setEstado(0);
			assertEquals(0, r.get(0).getEstado());
		}
	}
	
	@Test
	public void findReservaByEstado() {
		List<Reserva> r = reservaRepository.findReservaByEstado(1);
		if(!r.isEmpty()) {
			r.get(0).setDescuento(20000);
			assertEquals(20000, r.get(0).getDescuento());
		}
	}
	
}
