package MingesoTingeso.demo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

  Usuario findUsuarioByIdUser(Long idUser);

  Usuario findUsuarioByNombreUsuario(String nombreUsuario);

  Usuario findUsuarioByrolUsuario(String rolUsuario);
  
  Usuario findUsuarioBycorreoUsuario(String correoUsuario);