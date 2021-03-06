package MingesoTingeso.demo.Repositories;
import java.util.Date;
import java.util.List;

import MingesoTingeso.demo.Models.Habitacion;
import MingesoTingeso.demo.Models.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.ReservaHabitacion;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ResHabRepository extends JpaRepository<ReservaHabitacion, Long>{
	List<ReservaHabitacion> findAll();
	List<ReservaHabitacion> findByActivaAndFechaTerminoGreaterThan(boolean activa, Date fechaTermino);
	List<ReservaHabitacion> findReservaHabitacionByHabitacion(Habitacion habitacion);
	List<ReservaHabitacion> findByReserva(Reserva reserva);
	List<ReservaHabitacion> findByReservaAndActiva(Reserva reserva, boolean activa);
	ReservaHabitacion findByReservaAndHabitacion(Reserva reserva, Habitacion habitacion);
	List<ReservaHabitacion> findByHabitacionAndFechaTerminoGreaterThan(Habitacion habitacion, Date fechaTermino);
}
