package MingesoTingeso.demo.Repositories;

import MingesoTingeso.demo.Models.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistroRepository extends JpaRepository<Registro, Long> {
    Registro findRegistroByIdRegistro(Long idRegistro);

    List<Registro> findRegistroByIdHab(Long idHab);

    List<Registro> findRegistroByRepresentante(String representante);
}
