package MingesoTingeso.demo.Controllers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class RegistroControllerTest {
    @Autowired
    UsuarioController uc;
    @Test
    public void getAllRegitros() {
        assertEquals(1,1);
    }

    @Test
    public void getByCodigoHabitacion() {
        assertEquals(1,1);
    }

    @Test
    public void getByidHabitacion() {
        assertEquals(1,1);
    }

    @Test
    public void getByRepresentante() {
        assertEquals(1,1);
    }

    @Test
    public void create() {
        assertEquals(1,1);
    }
}
