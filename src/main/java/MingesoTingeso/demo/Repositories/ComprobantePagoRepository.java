package MingesoTingeso.demo.Repositories;

import MingesoTingeso.demo.Models.ComprobantePago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComprobantePagoRepository extends JpaRepository<ComprobantePago, Long> {
    ComprobantePago findComprobantePagoById(Long id);

}
