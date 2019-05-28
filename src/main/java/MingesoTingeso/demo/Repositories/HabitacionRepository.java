package MingesoTingeso.demo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long>{

Habitacion findHabitacionByIdHab(Long idHab);

Habitacion findHabitacionByNroHabitacion(int nroHabitacion);

List<Habitacion> findHabitacionByTipo(String tipo);

List<Habitacion> findHabitacionByCapacidadNinos(int capacidadNinos);

List<Habitacion> findHabitacionByCapacidadAdultos(int capacidadAdultos);

List<Habitacion> findHabitacionByPrecioNoche(int precioNoche);

Habitacion deleteHabitacionByIdHab(Long idHab);

}
