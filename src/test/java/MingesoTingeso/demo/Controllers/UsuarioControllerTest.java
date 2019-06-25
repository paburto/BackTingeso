package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.Habitacion;
import MingesoTingeso.demo.Repositories.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import MingesoTingeso.demo.Models.Usuario;
import org.springframework.test.web.servlet.MockMvc;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class UsuarioControllerTest {
    @Autowired
    UsuarioController uc;
    @Autowired
    UsuarioRepository ur;
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
    public void create() throws ParseException {
        HashMap<String, Object> map = new HashMap<>();
        Usuario user = uc.getAllUsuarios().get(0);
        map.put("rut_usuario", 10000001);
        map.put("nombre_usuario", "test");
        map.put("rol_usuario", "test");
        map.put("correo_usuario", "test@test.test");
        map.put("password", "test");
        List<HashMap<String, String>> cr = uc.create(map);
        assertEquals(201, Integer.parseInt(cr.get(0).get("status")));
        cr = uc.create(map);
        assertEquals(401, Integer.parseInt(cr.get(0).get("status")));
    }

    @Test
    public void update() throws ParseException {
        HashMap<String, Object> map = new HashMap<>();
        Usuario user = uc.getAllUsuarios().get(0);
        map.put("rut_usuario", user.getRutUsuario());
        map.put("nombre_usuario", user.getNombreUsuario());
        map.put("rol_usuario", user.getRolUsuario());
        map.put("correo_usuario", "test@test.test");
        map.put("password", user.getPassword());
        List<HashMap<String, String>> hab = uc.update(user.getRutUsuario(), map);
        assertEquals(200, Integer.parseInt(hab.get(0).get("status")));
        hab = uc.update(-5645, map);
        assertEquals(404, Integer.parseInt(hab.get(0).get("status")));
    }

    @Test
    public void delete() throws ParseException {
        Usuario aux = ur.findUsuarioByRutUsuario(10000001);
        List<HashMap<String, String>> cr = uc.delete(aux.getIdUsuario());
        assertEquals(200, Integer.parseInt(cr.get(0).get("status")));
        cr = uc.delete((long)-105);
        assertEquals(404, Integer.parseInt(cr.get(0).get("status")));
    }
}
