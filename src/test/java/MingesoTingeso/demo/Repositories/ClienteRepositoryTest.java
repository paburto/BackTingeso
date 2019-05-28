package MingesoTingeso.demo.Repositories;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import MingesoTingeso.demo.Models.Cliente;
import static org.junit.Assert.*;
import java.util.Date;

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
}
