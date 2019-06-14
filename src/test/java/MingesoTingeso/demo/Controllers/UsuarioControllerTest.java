package MingesoTingeso.demo.Controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import MingesoTingeso.demo.Models.Usuario;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.*;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class UsuarioControllerTest {
    /*@Autowired
    UsuarioController uc;
    @Test
    public void getAllUsuarios() {
        List<Usuario> h1 = uc.getAllUsuarios();
        List<Usuario> h2 = uc.getAllUsuarios();
        assertEquals(h1.size(),h2.size());
    }

    @Test
    public void getUsuarioById() {
        List<Usuario> h1 = uc.getAllUsuarios();
        long id = h1.get(0).getIdUsuario();
        Usuario u = uc.getUsuarioById(id);
        assertEquals(id,(long)u.getIdUsuario());
    }

    @Test
    public void create() {

    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {

    }*/
}
