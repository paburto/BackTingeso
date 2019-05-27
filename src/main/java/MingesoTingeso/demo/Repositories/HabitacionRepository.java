package MingesoTingeso.demo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.Habitacion;

public interface HabitacionRepository extends JpaRepository<Habitacion, Long>{

Habitacion findHabitacionByIdHab(Long idHab);

Habitacion findHabitacionByNroHabitacion(int nroHabitacion); 

Habitacion findHabitacionByTipo(String tipo);

Habitacion findHabitacionByCapacidadNinos(int capacidadNinos);

Habitacion findHabitacionByCapacidadAdultos(int capacidadAdultos);

Habitacion findHabitacionByPrecioNoche(int precioNoche);

Habitacion deleteHabitacionByIdHab(Long idHab);

}
