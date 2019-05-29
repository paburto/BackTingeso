package MingesoTingeso.demo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

  Cliente findClienteByIdCliente(Long idCliente);
  Cliente findClienteByRut(int rut);

}
