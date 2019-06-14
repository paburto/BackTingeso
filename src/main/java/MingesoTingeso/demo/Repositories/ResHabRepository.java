package MingesoTingeso.demo.Repositories;
import java.util.List;

import MingesoTingeso.demo.Models.Habitacion;
import MingesoTingeso.demo.Models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.ReservaHabitacion;

public interface ResHabRepository extends JpaRepository<ReservaHabitacion, Long>{
	List<ReservaHabitacion> findReservaHabitacionByHabitacion(Habitacion habitacion);
	List<ReservaHabitacion> findReservaHabitacionByReserva(Reserva reserva);
	List<ReservaHabitacion> findReservaHabitacionByIdReserva(Long idReserva);
}
