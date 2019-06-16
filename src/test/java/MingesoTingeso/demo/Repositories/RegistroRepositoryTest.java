package MingesoTingeso.demo.Repositories;

import MingesoTingeso.demo.Models.*;
import MingesoTingeso.demo.Models.Registro;
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
public class RegistroRepositoryTest {
    @Autowired
    RegistroRepository registroRepository;
    @Autowired
    HabitacionRepository habitacionRepository;


    private boolean assertArrayEquals(List<Registro> esperado, List<Registro> h) {
        for ( Object o : esperado ) {
            if ( !h.remove( o ) ) {
                return false;
            }
        }
        return h.isEmpty();
    }

    @Test
    public void findRegistroByIdRegistro() {
        List<Registro> lu = registroRepository.findAll();
        long id = lu.get(0).getIdRegistro();
        assertEquals(id, (long)registroRepository.findRegistroByIdRegistro(id).getIdRegistro());
    }




    @Test
    public void findRegistroByRepresentante() {
        List<Registro>  reg = registroRepository.findAll();
        String auxR = reg.get(0).getRepresentante();
        List<Registro> h = registroRepository.findRegistroByRepresentante(auxR);


        List<Registro> esperado = registroRepository.findAll();
        List<Registro> h1 = registroRepository.findAll();
        for (Registro rs: h1){
            if (rs.getRepresentante().equals(auxR)){
                esperado.remove(rs);
            }
        }
        assertArrayEquals(esperado, h);
    }

    @Test
    public void findRegistroByHabitacion() {
        List<Habitacion>  reg = habitacionRepository.findAll();
        Habitacion aux = reg.get(0);
        List<Registro> h = registroRepository.findRegistroByHabitacion(aux);


        List<Registro> esperado = registroRepository.findAll();
        List<Registro> h1 = registroRepository.findAll();
        for (Registro rs: h1){
            if (rs.getHabitacion().equals(aux)){
                esperado.remove(rs);
            }
        }
        assertArrayEquals(esperado, h);
    }
}
