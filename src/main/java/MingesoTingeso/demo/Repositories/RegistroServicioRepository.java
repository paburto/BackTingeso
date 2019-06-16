package MingesoTingeso.demo.Repositories;
import java.util.List;

import MingesoTingeso.demo.Models.RegistroServicio;
import MingesoTingeso.demo.Models.Registro;
import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.ReservaHabitacion;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RegistroServicioRepository extends JpaRepository<RegistroServicio, Long>{
  RegistroServicio findRegistroServicioById(Long id);
	List<RegistroServicio> findRegistroServicioByRegistro(Registro registro);
}
