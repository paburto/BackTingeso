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
public class RegistroServicioControllerTest {
    @Autowired
    UsuarioController uc;
    @Test
    public void getAllRegistroServicios() {
        assertEquals(1,1);
    }

    @Test
    public void getRegistroServicioById() {
        assertEquals(1,1);
    }

    @Test
    public void getRegistroServicioByIdRegistro() {
        assertEquals(1,1);
    }

    @Test
    public void create() {
        assertEquals(1,1);
    }
}
