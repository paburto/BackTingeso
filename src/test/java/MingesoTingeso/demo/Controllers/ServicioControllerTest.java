package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.Servicio;
import MingesoTingeso.demo.Repositories.ServicioRepository;
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
public class ServicioControllerTest {
    @Autowired
    ServicioController sc;
    @Autowired
    ServicioRepository sr;
    @Test
    public void getAllServicios() {
        List<Servicio> h1 = sc.getAllServicios();
        List<Servicio> h2 = sc.getAllServicios();
        assertEquals(h1.size(),h2.size());
    }

    @Test
    public void getServicioById() {
        List<Servicio> h1 = sr.findAll();
        long id = h1.get(0).getIdServicio();
        Servicio s = sc.getServicioById(id);
        assertEquals(id,(long)s.getIdServicio());
    }

    @Test
    public void update() throws ParseException {
        Servicio aux = sr.findAll().get(0);
        HashMap<String, Object> map = new HashMap<>();
        map.put("nombreServicio", aux.getNombreServicio());
        map.put("descripcion", aux.getDescripcionServicio());
        map.put("precioServicio", aux.getPrecio()+1);
        map.put("categoriaServicio", aux.getCategoriaServicio());

        List<HashMap<String, String>> serv = sc.update(aux.getIdServicio(), map);
        assertEquals(200, Integer.parseInt(serv.get(0).get("status")));
        serv = sc.update((long)-1000, map);
        assertEquals(404, Integer.parseInt(serv.get(0).get("status")));
    }

    @Test
    public void create() throws ParseException {
        Servicio aux = sr.findAll().get(0);
        HashMap<String, Object> map = new HashMap<>();
        map.put("nombreServicio", "test");
        map.put("descripcion", "test");
        map.put("precioServicio", -10);
        map.put("categoriaServicio","test");

        List<HashMap<String, String>> serv = sc.create(map);
        assertEquals(201, Integer.parseInt(serv.get(0).get("status")));
    }

    @Test
    public void delete() throws ParseException {
        Servicio aux = sr.findServicioByNombreServicio("test");

        List<HashMap<String, String>> serv = sc.update(aux.getIdServicio());
        assertEquals(200, Integer.parseInt(serv.get(0).get("status")));
        serv = sc.update((long)-1000);
        assertEquals(404, Integer.parseInt(serv.get(0).get("status")));
    }
}
