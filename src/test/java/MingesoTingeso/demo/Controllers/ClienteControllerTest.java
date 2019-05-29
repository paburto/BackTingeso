package MingesoTingeso.demo.Controllers;

import org.junit.Test;
import java.util.List;
import MingesoTingeso.demo.Models.Cliente;

import static org.junit.Assert.*;

public class ClienteControllerTest {

    @Test
    public void getAllClientes() {
      ClienteController cc = new ClienteController();
      List<Cliente> c1 = cc.getAllClientes();
      List<Cliente> c2 = cc.getAllClientes();
      assertEquals(c1.size(),c2.size());

    }

    @Test
    public void getNombreClienteById() {
      ClienteController cc = new ClienteController();
      List<Cliente> cs = cc.getAllClientes();
      Cliente c1 = cs.get(0);
      String nombreC1 = cc.getNombreClienteById(1L);
      assertEquals(nombreC1, c1.getNombreCliente());
    }
}
