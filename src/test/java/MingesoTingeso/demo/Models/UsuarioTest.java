package MingesoTingeso.demo.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class UsuarioTest {

    @Test
    public void getIdUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789);
      u.setIdUsuario(1L);
      assertEquals(1L,(long)u.getIdUsuario());
    }

    @Test
    public void getNombreUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789);
      assertEquals("Diego Águila",u.getNombreUsuario());
    }

    @Test
    public void getRolUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789);
      assertEquals("Operador",u.getRolUsuario());
    }

    @Test
    public void getCorreoUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789);
      assertEquals("diego.aguila@usach.cl",u.getCorreoUsuario());
    }

    @Test
    public void getRutUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789);
      assertEquals(123456789,u.getRutUsuario());
    }

    @Test
    public void setIdUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789);
      u.setIdUsuario(1L);
      assertEquals(1L,(long)u.getIdUsuario());
    }

    @Test
    public void setNombreUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789);
      u.setNombreUsuario("Edgar Blau");
      assertEquals("Edgar Blau",u.getNombreUsuario());
    }

    @Test
    public void setRolUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789);
      u.setRolUsuario("Administrador");
      assertEquals("Administrador",u.getRolUsuario());
    }

    @Test
    public void setCorreoUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789);
      u.setCorreoUsuario("edgar.blau@usach.cl");
      assertEquals("edgar.blau@usach.cl",u.getCorreoUsuario());
    }

    @Test
    public void setRutUsuario() {
      Usuario u = new Usuario("Diego Águila","Operador","diego.aguila@usach.cl",123456789);
      u.setRutUsuario(123456780);
      assertEquals(123456780,u.getRutUsuario());
    }
}
