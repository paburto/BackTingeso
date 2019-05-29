package MingesoTingeso.demo.Controllers;

import org.junit.Test;
import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import MingesoTingeso.demo.Models.Usuario;

import static org.junit.Assert.*;

public class UsuarioControllerTest {

    @Test
    public void getAllUsuarios() {
        UsuarioController uc = new UsuarioController();
        List<Usuario> ua = uc.getAllUsuarios();
        Usuario u  = ua.get(0);
        assertEquals(1L, (long)u.getIdUsuario());
    }

    @Test
    public void getUsuarioById() {
      UsuarioController uc = new UsuarioController();
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
