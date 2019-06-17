package MingesoTingeso.demo.Repositories;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
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

    @Autowired
    List<Reserva> lr;

	@Before
    public void before(){
        List<Reserva> lr = reservaRepository.findAll();
    }

	@Test
	public void findReservaByIdReserva() {
		long id = lr.get(0).getIdReserva();
		assertEquals(id, (long)reservaRepository.findByIdReserva(id).getIdReserva());
	}

	@Test
	public void findReservaByDescuento() {
		int descuento = lr.get(0).getDescuento();
		assertEquals(descuento, reservaRepository.findReservaByDescuento(descuento).get(0).getDescuento());
	}

	@Test
	public void findReservaByEstado() {
		int estado = lr.get(0).getEstado();
		assertEquals(estado, reservaRepository.findReservaByEstado(estado).get(0).getEstado());
	}
	
	@Test
	public void findReservaByCodigoReserva(){
		int codigo = lr.get(0).getCodigoReserva();
		assertEquals(codigo, reservaRepository.findReservaByCodigoReserva(codigo).getCodigoReserva());
	}

	@Test
	public void getReservaByCodigoReserva(){
		int codigo = lr.get(0).getCodigoReserva();
		assertEquals(codigo, reservaRepository.getReservaByCodigoReserva(codigo).getCodigoReserva());
	}
}
