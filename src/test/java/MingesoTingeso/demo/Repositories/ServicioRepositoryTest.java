package MingesoTingeso.demo.Repositories;

import static org.junit.Assert.*;

import java.util.List;

import MingesoTingeso.demo.Models.Servicio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import MingesoTingeso.demo.Models.Habitacion;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ServicioRepositoryTest {
    @Autowired
    ServicioRepository servicioRepository;

    @Test
    public void findServicioByIdServicio() {
        List<Servicio> h1 = servicioRepository.findAll();
        long id = h1.get(0).getIdServicio();
        Servicio h = servicioRepository.findServicioByIdServicio(id);
        assertEquals(id,(long)h.getIdServicio());
    }

}
