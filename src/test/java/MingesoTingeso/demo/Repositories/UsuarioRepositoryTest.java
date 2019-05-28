package MingesoTingeso.demo.Repositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import MingesoTingeso.demo.Models.Usuario;
import static org.junit.Assert.*;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
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
