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
		Cliente aux = clienteRepository.findAll().get(0);
		long idTest = aux.getIdCliente();
		Cliente c = clienteRepository.findClienteByIdCliente(idTest);
		long comp = c.getIdCliente();
		assertEquals(idTest, comp);
	}

	@Test
	public void findClienteByRut(){
		Cliente aux = clienteRepository.findAll().get(0);
		int rutTest = aux.getRut();
		Cliente c = clienteRepository.findClienteByRut(rutTest);
		assertEquals(rutTest,c.getRut());

	}
}
