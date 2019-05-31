package MingesoTingeso.demo.Repositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
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
		List<Usuario> lu = usuarioRepository.findAll();
		long id = lu.get(0).getIdUsuario();
		assertEquals(id, (long)usuarioRepository.findUsuarioByIdUser(id).getIdUsuario());
	}

	@Test
	public void findUsuarioByCorreoUsuario() {
		List<Usuario> lu = usuarioRepository.findAll();
		String correo = lu.get(0).getCorreoUsuario();
		assertEquals(correo, usuarioRepository.findUsuarioByCorreoUsuario(correo).getCorreoUsuario());
	}

	@Test
	public void findUsuarioByRutUsuario() {
		List<Usuario> lu = usuarioRepository.findAll();
		int rut = lu.get(0).getRutUsuario();
		assertEquals(rut, usuarioRepository.findUsuarioByRutUsuario(rut).getRutUsuario());
	}
}
