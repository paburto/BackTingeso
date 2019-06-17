package MingesoTingeso.demo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Long>{

    Reserva findByIdReserva(long id);

    Reserva findReservaByIdReserva(long idReserva);

    List<Reserva> findReservaByDescuento(int descuento);

    List<Reserva> findReservaByEstado(int estado);

  	Reserva deleteReservaByIdReserva(long idReserva);

    Reserva findReservaByCodigoReserva(int codigoReserva);

    Reserva getReservaByCodigoReserva(int codigoReserva);

}

