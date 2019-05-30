package MingesoTingeso.demo.Repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import MingesoTingeso.demo.Models.Cliente;
import static org.junit.Assert.*;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ClienteRepositoryTest {
	@Autowired
	ClienteRepository clienteRepository;

	@Test
	public void findClienteByIdCliente() {
		long idTest = 1;
		Cliente c = clienteRepository.findClienteByIdCliente(idTest);
		c.setNombreCliente("Juan Perez");
		assertEquals("Juan Perez", c.getNombreCliente());
	}

	@Test
	public void findClienteByRut(){
		Cliente c = clienteRepository.findClienteByRut(18123456);
		assertEquals(18123456,c.getRut());

	}
}
