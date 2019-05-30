package MingesoTingeso.demo.Controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import MingesoTingeso.demo.Models.Cliente;
import static org.junit.Assert.*;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ClienteControllerTest {
    @Autowired
    ClienteController cc;

    @Test
    public void getAllClientes() {
      List<Cliente> c1 = cc.getAllClientes();
      List<Cliente> c2 = cc.getAllClientes();
      assertEquals(c1.size(),c2.size());

    }

    @Test
    public void getNombreClienteById() {
      List<Cliente> cs = cc.getAllClientes();
      Cliente c1 = cs.get(0);
      String nombreC1 = cc.getNombreClienteById(1L);
      assertEquals(nombreC1, c1.getNombreCliente());
    }
}
