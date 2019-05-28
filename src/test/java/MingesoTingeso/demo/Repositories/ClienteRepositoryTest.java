package MingesoTingeso.demo.Repositories;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import MingesoTingeso.demo.Models.Cliente;
import static org.junit.Assert.*;
import java.util.Date;
@DataJpaTest 
@SpringBootTest(classes=ClienteRepository.class)
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
