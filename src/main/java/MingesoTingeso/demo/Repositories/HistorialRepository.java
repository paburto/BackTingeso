package MingesoTingeso.demo.Repositories;

import MingesoTingeso.demo.Models.Historial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistorialRepository extends JpaRepository<Historial, Long> {
    Historial findHistorialByIdHis(Long idHis);
}
