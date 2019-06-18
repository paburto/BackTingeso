package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.Registro;
import MingesoTingeso.demo.Models.RegistroServicio;
import MingesoTingeso.demo.Repositories.RegistroRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;


@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class RegistroServicioControllerTest {
    @Autowired
    RegistroServicioController rsc;
    @Autowired
    RegistroRepository rr;
    @Test
    public void getAllRegistroServicios() {
        List<RegistroServicio> h1 = rsc.getAllRegistroServicios();
        List<RegistroServicio> h2 = rsc.getAllRegistroServicios();
        assertEquals(h1.size(),h2.size());
    }

    @Test
    public void getRegistroServicioById() {
        List<RegistroServicio> h1 = rsc.getAllRegistroServicios();
        long id = h1.get(0).getId();
        RegistroServicio h = rsc.getRegistroServicioById(id);
        assertEquals(id,(long)h.getId());
    }

    @Test
    public void getRegistroServicioByIdRegistro() {
        List<Registro> h1 = rr.findAll();
        Registro exp = h1.get(0);
        Long id = exp.getIdRegistro();
        List<RegistroServicio> h = rsc.getRegistroServicioByIdRegistro(id);
        assertEquals(true,h.size()>=0);
    }

    @Test
    public void create() throws ParseException {
        HashMap<String, Object> map = new HashMap<>();
        RegistroServicio regs = rsc.getAllRegistroServicios().get(0);

        map.put("idRegistro", (long)-100);
        map.put("idServicio", (long)-100);
        List<HashMap<String, String>> cr = rsc.create(map);
        assertEquals(401, Integer.parseInt(cr.get(0).get("status")));


    }
}
