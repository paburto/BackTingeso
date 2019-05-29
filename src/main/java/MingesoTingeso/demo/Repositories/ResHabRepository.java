package MingesoTingeso.demo.Repositories;
import java.util.List;

import MingesoTingeso.demo.Models.Habitacion;
import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.ReservaHabitacion;

public interface ResHabRepository extends JpaRepository<ReservaHabitacion, Long>{
	List<ReservaHabitacion> findReservaHabitacionByHabitacion(Habitacion habitacion);
	ReservaHabitacion findReservaHabitacionByReserva(Long idReserva);


}
