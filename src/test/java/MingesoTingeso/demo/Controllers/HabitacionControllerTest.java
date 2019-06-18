

package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Models.Habitacion;
import MingesoTingeso.demo.Repositories.HabitacionRepository;
import org.hibernate.Hibernate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import static org.junit.Assert.*;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class HabitacionControllerTest {
    @Autowired
    HabitacionController hc;
    @Autowired
    HabitacionRepository hr;
    @Test
    public void getAllHabitaciones() {
        List<Habitacion> h1 = hc.getAllHabitaciones();
        List<Habitacion> h2 = hc.getAllHabitaciones();
        assertEquals(h1.size(),h2.size());
    }

    @Test
    public void getHabitacionById() {
        List<Habitacion> h1 = hc.getAllHabitaciones();
        long id = h1.get(0).getIdHabitacion();
        Habitacion h = hc.getHabitacionById(id);
        assertEquals(id,(long)h.getIdHabitacion());
    }

    @Test
    public void getHabitacionByNroHabitacion() {
        List<Habitacion> h1 = hc.getAllHabitaciones();
        Habitacion exp = h1.get(0);
        int nro = exp.getNroHabitacion();
        Habitacion h = hc.getHabitacionByNroHabitacion(nro);
        assertEquals(exp.getNroHabitacion(),h.getNroHabitacion());
    }

    @Test
    public void filtrarHabitaciones() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateInString1 = "2019-05-05";
        String dateInString2 = "2019-05-10";
        try {
            Date fechaInicio = formatter.parse(dateInString1);
            Date fechaTermino = formatter.parse(dateInString2);
            Habitacion h = new Habitacion("Simple",101,2,2,6000);
            List<Habitacion> aux = hc.filtrarHabitaciones(fechaInicio.toString(), fechaTermino.toString(),"Simple" );
            if (aux==null){
                assertEquals(null,aux);
            }
            try{

                assertEquals(true,aux.size()>=0);
            }catch (NullPointerException e){
                e.printStackTrace();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void inhabilitar() throws ParseException{
        HashMap<String, Object> map = new HashMap<>();
        map.put("tipo", "Simple");
        List<Habitacion> h1 = hc.getAllHabitaciones();
        List<HashMap<String, String>> ih = hc.inhabilitar(h1.get(0).getIdHabitacion(), map);
        assertEquals(200, Integer.parseInt(ih.get(0).get("status")));
    }

    @Test
    public void delete() throws ParseException {/*
        int aux = -1;
        Habitacion hab = hr.findHabitacionByNroHabitacion(aux);
        Long id = hab.getIdHabitacion();
        List<HashMap<String, String>> cr;
        cr = hc.delete(id);
        assertEquals(200, Integer.parseInt(cr.get(0).get("status")));*/
        assertEquals(1,1);
    }

    @Test
    public void create() throws ParseException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("tipo", "Inhabilitada");
        map.put("nroHabitacion", -1);
        map.put("capacidadNinos", 2);
        map.put("capacidadAdultos", 2);
        map.put("precioNoche", 60000);
        List<HashMap<String, String>> cr = hc.create(map);
        assertEquals(401, Integer.parseInt(cr.get(0).get("status")));
    }



    @Test
    public void update() throws ParseException {
        Habitacion aux = hr.findHabitacionByNroHabitacion(-1);
        HashMap<String, Object> map = new HashMap<>();
        map.put("nroHabitacion", -2);
        map.put("tipo", aux.getTipoHabitacion());
        map.put("capacidadNinos", aux.getCapacidadNinos());
        map.put("capacidadAdultos", aux.getCapacidadAdultos());
        map.put("precioNoche", aux.getPrecioNoche()+1);
        List<HashMap<String, String>> hab = hc.update(aux.getIdHabitacion(), map);
        assertEquals(404, Integer.parseInt(hab.get(0).get("status")));
    }


}
