/*package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.Habitacion;
import MingesoTingeso.demo.Models.Registro;
import MingesoTingeso.demo.Repositories.RegistroRepository;
import org.hibernate.LazyInitializationException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class RegistroControllerTest {
    @Autowired
    RegistroController rc;
    @Autowired
    RegistroRepository rr;
    @Test
    public void getAllRegitros() {
        List<Registro> h1 = rc.getAllRegitros();
        List<Registro> h2 = rc.getAllRegitros();
        assertEquals(h1.size(),h2.size());
    }

    @Test
    public void getByCodigoHabitacion() {
        try {
            List<Registro> recib = rc.getByCodigoHabitacion(100);
            assertEquals(true, recib.size()>=0);
        }catch (LazyInitializationException e){
            e.printStackTrace();
        }
    }

    @Test
    public void getByidHabitacion() {
        List<Registro> recib = rc.getByidHabitacion((long)1);
        assertEquals(true, recib.size()>=0);
    }

    @Test
    public void getByRepresentante() {
        List<Registro> recib = rc.getByRepresentante("Diego Águila");
        assertEquals(true, recib.size()>=0);
    }

    @Test
    public void create() {
        assertEquals(1,1);
    }
}*/
