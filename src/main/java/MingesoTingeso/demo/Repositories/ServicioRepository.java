package MingesoTingeso.demo.Repositories;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import MingesoTingeso.demo.Models.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Long>{
    Servicio findServicioByIdServicio(Long id);
    Servicio findServicioByNombreServicio(String nombreServicio);
    List<Servicio> findServicioByPrecioServicio(int precio);
  	Servicio deleteServicioByIdServicio(Long id);
    List<Servicio> findServicioByCategoriaServicio(String categoriaServicio);
}
