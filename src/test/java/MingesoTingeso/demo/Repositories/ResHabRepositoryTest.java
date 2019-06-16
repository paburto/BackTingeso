package MingesoTingeso.demo.Repositories;

import static org.junit.Assert.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;

import MingesoTingeso.demo.Models.Reserva;
import MingesoTingeso.demo.Models.ReservaHabitacion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;


import MingesoTingeso.demo.Models.Habitacion;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ResHabRepositoryTest {
    @Autowired
    ResHabRepository reshabrepository;
    @Autowired
    HabitacionRepository habitacionrepository;
    @Autowired
    ReservaRepository reservarepository;

    private boolean assertArrayEquals(List<ReservaHabitacion> esperado, List<ReservaHabitacion> h) {
        for ( Object o : esperado ) {
            if ( !h.remove( o ) ) {
                return false;
            }
        }
        return h.isEmpty();
    }


    @Test
    public void findReservaHabitacionByHabitacion() {
        List<Habitacion>  hab = habitacionrepository.findAll();
        Habitacion aux = hab.get(0);
        List<ReservaHabitacion> h = reshabrepository.findReservaHabitacionByHabitacion(aux);


        List<ReservaHabitacion> esperado = reshabrepository.findReservaHabitacionByHabitacion(aux);
        List<ReservaHabitacion> h1 = reshabrepository.findAll();
        for (ReservaHabitacion rh: h1){
            if (rh.getHabitacion().equals(aux)){
                esperado.remove(rh);
            }
        }
        assertArrayEquals(esperado, h);
    }



    @Test
    public void findByReserva() {
        List<Reserva>  res = reservarepository.findAll();
        Reserva aux = res.get(0);
        List<ReservaHabitacion> h = reshabrepository.findByReserva(aux);


        List<ReservaHabitacion> esperado = reshabrepository.findByReserva(aux);
        List<ReservaHabitacion> h1 = reshabrepository.findAll();
        for (ReservaHabitacion rh: h1){
            if (!rh.getReserva().equals(aux)){
                esperado.remove(rh);
            }
        }
        assertArrayEquals(esperado, h);
    }

}
