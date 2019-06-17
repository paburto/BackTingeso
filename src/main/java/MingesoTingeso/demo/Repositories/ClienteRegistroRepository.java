package MingesoTingeso.demo.Repositories;

import MingesoTingeso.demo.Models.Cliente;
import MingesoTingeso.demo.Models.ClienteRegistro;
import MingesoTingeso.demo.Models.Registro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ClienteRegistroRepository extends JpaRepository<ClienteRegistro, Long> {
    List<ClienteRegistro> findByCliente(Cliente cliente);
    List<ClienteRegistro> findByRegistro(Registro registro);
}
