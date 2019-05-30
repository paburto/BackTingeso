package MingesoTingeso.demo.Controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;
import MingesoTingeso.demo.Models.Cliente;
import static org.junit.Assert.*;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ClienteControllerTest extends AbstractTest{
    @Autowired
    ClienteController cc;

    @Test
    public void getAllClientes() throws Exception {
      String uri = "http://159.203.94.72:8060/backend/clientes";
      MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
         .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
      
      int status = mvcResult.getResponse().getStatus();
      assertEquals(200, status);
    }

    @Test
    public void getNombreClienteById() {
      List<Cliente> cs = cc.getAllClientes();
      Cliente c1 = cs.get(0);
      String nombreC1 = cc.getNombreClienteById(1L);
      assertEquals(nombreC1, c1.getNombreCliente());
    }
}
