package MingesoTingeso.demo.Controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import MingesoTingeso.demo.Models.Usuario;

import static org.junit.Assert.*;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class UsuarioControllerTest {
    @Autowired
    UsuarioController uc;

    @Test
    public void getAllUsuarios() {
        List<Usuario> ua = uc.getAllUsuarios();
        Usuario u  = ua.get(0);
        assertEquals(1L, (long)u.getIdUsuario());
    }

    @Test
    public void getUsuarioById() {
      Usuario u = uc.getUsuarioById(1L);
      assertEquals(1L, (long)u.getIdUsuario());
    }

    @Test
    public void create() {

    }

    @Test
    public void update() {

    }

    @Test
    public void delete() {

    }
}
