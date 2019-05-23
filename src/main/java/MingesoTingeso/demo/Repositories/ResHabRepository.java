package MingesoTingeso.demo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.ReservaHabitacion;

public interface ResHabRepository extends JpaRepository<ReservaHabitacion, Long>{

	ReservaHabitacion findReservaHabitacionById(Long id);


}
