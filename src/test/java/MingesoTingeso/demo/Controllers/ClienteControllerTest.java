package MingesoTingeso.demo.Controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;


import java.util.List;
import MingesoTingeso.demo.Models.Cliente;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ClienteControllerTest {
    @Autowired
    ClienteController cc;
    @Autowired
    private MockMvc mockMvc;
   
    @Test
    public void getAllClientes() throws Exception {
    	this.mockMvc.perform(get("/clientes")
    	           .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
    	           .andExpect(status().isOk())
    	           .andExpect(content().contentType("application/json"));
    }

    @Test
    public void getNombreClienteById() throws Exception {
    	this.mockMvc.perform(get("/clientes/1")
 	           .accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
 	           .andExpect(status().isOk())
 	           .andExpect(content().contentType("application/json"));
    }
}
