package MingesoTingeso.demo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

    Reserva findReservaByIdReserva(Long id);

    List<Reserva> findReservaByDescuento(int descuento);

    List<Reserva> findReservaByEstado(int estado);

  	Reserva deleteReservaByIdReserva(Long idReserva);

    Reserva findReservaByCodigoReserva(int codigoReserva);

    Reserva getReservaByCodigoReserva(int codigoReserva);

}

