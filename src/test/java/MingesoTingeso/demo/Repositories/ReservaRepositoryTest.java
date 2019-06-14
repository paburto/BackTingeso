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
	/*@Autowired
	ReservaRepository reservaRepository;

	@Test
	public void findReservaByIdReserva() {
		List<Reserva> lr = reservaRepository.findAll();
		long id = lr.get(0).getIdReserva();
		assertEquals(id, (long)reservaRepository.findReservaByIdReserva(id).getIdReserva());
	}

	@Test
	public void findReservaByDescuento() {
		List<Reserva> lr = reservaRepository.findAll();
		int descuento = lr.get(0).getDescuento();
		assertEquals(descuento, reservaRepository.findReservaByDescuento(descuento).get(0).getDescuento());
	}

	@Test
	public void findReservaByEstado() {
		List<Reserva> lr = reservaRepository.findAll();
		int estado = lr.get(0).getEstado();
		assertEquals(estado, reservaRepository.findReservaByEstado(estado).get(0).getEstado());
	}
	
	@Test
	public void findReservaByCodigoReserva(){
		List<Reserva> lr = reservaRepository.findAll();
		int codigo = lr.get(0).getCodigoReserva();
		assertEquals(codigo, reservaRepository.findReservaByCodigoReserva(codigo).getCodigoReserva());
	}

	@Test
	public void getReservaByCodigoReserva(){
		List<Reserva> lr = reservaRepository.findAll();
		int codigo = lr.get(0).getCodigoReserva();
		assertEquals(codigo, reservaRepository.getReservaByCodigoReserva(codigo).getCodigoReserva());
	}
*/
}
