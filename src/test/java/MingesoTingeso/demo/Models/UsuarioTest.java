package MingesoTingeso.demo.Models;

import MingesoTingeso.demo.Repositories.UsuarioRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class UsuarioTest {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Test
    public void getIdUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
      u.setIdUsuario(1L);
      assertEquals(1L,(long)u.getIdUsuario());
    }

    @Test
    public void getNombreUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
      assertEquals("Diego Águila",u.getNombreUsuario());
    }

    @Test
    public void getRolUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
      assertEquals("Operador",u.getRolUsuario());
    }

    @Test
    public void getCorreoUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
      assertEquals("diego.aguila@usach.cl",u.getCorreoUsuario());
    }

    @Test
    public void getRutUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
      assertEquals(123456789,u.getRutUsuario());
    }

    @Test
    public void getIdUser() {
        Usuario u = usuarioRepository.findAll().get(0);
        assertEquals(true,u.getIdUser()>0);
    }

    @Test
    public void getPassword() {
        Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
        assertEquals("tingeso",u.getPassword());
    }

    @Test
    public void setIdUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
      u.setIdUsuario(1L);
      assertEquals(1L,(long)u.getIdUsuario());
    }

    @Test
    public void setNombreUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
      u.setNombreUsuario("Edgar Blau");
      assertEquals("Edgar Blau",u.getNombreUsuario());
    }

    @Test
    public void setRolUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
      u.setRolUsuario("Administrador");
      assertEquals("Administrador",u.getRolUsuario());
    }

    @Test
    public void setCorreoUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
      u.setCorreoUsuario("edgar.blau@usach.cl");
      assertEquals("edgar.blau@usach.cl",u.getCorreoUsuario());
    }

    @Test
    public void setRutUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789, "tingeso");
      u.setRutUsuario(123456780);
      assertEquals(123456780,u.getRutUsuario());
    }
}
