package MingesoTingeso.demo.Repositories;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import MingesoTingeso.demo.Models.Usuario;
import static org.junit.Assert.*;
@DataJpaTest 
@SpringBootTest(classes=UsuarioRepository.class)
public class UsuarioRepositoryTest {
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Test
	public void findUsuarioByIdUser() {
		long idTest = 1;
		Usuario u = usuarioRepository.findUsuarioByIdUser(idTest);
		u.setCorreoUsuario("tingeso@usach.cl");
		assertEquals("tingeso@usach.cl", u.getCorreoUsuario());
	}
	
	@Test
	public void findUsuarioByCorreoUsuario() {
		Usuario u = usuarioRepository.findUsuarioByCorreoUsuario("aiura@tingeso.com");
		assertEquals("Aquiles Brinco", u.getNombreUsuario());
	}
	
	@Test
	public void findUsuarioByRutUsuario() {
		Usuario u = usuarioRepository.findUsuarioByRutUsuario(191472584);
		assertEquals("Elba Lazo", u.getNombreUsuario());
	}
	
	@Test
	public void deleteUsuarioByIdUser() {
		Usuario crear = usuarioRepository.save(new Usuario("usuarioTest", "user", "test@usach.cl", 189411839));
		Usuario delete = usuarioRepository.deleteUsuarioByIdUser(crear.getIdUsuario());
		assertEquals(crear.getNombreUsuario(), delete.getNombreUsuario());
	}
	
}
