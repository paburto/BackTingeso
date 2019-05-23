package MingesoTingeso.demo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

  	Reserva findReservaByIdReserva(Long id);

    Reserva findReservaByDescuento(int descuento);

    Reserva findReservaByEstado(int estado);


  	Reserva deleteReservaByIdReserva(Long idReserva);


}
