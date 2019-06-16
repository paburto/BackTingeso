package MingesoTingeso.demo.Repositories;

import MingesoTingeso.demo.Models.Registro;
import MingesoTingeso.demo.Models.RegistroServicio;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class RegistroServicioRepositoryTest {
    @Autowired
    RegistroServicioRepository registroServicioRepository;
    @Autowired
    RegistroRepository registroRepository;


    private boolean assertArrayEquals(List<RegistroServicio> esperado, List<RegistroServicio> h) {
        for ( Object o : esperado ) {
            if ( !h.remove( o ) ) {
                return false;
            }
        }
        return h.isEmpty();
    }

    @Test
    public void findRegistroServicioById() {
        List<RegistroServicio> lu = registroServicioRepository.findAll();
        long id = lu.get(0).getId();
        assertEquals(id, (long)registroServicioRepository.findRegistroServicioById(id).getId());
    }




    @Test
    public void findRegistroServicioByRegistro() {
        List<Registro>  hab = registroRepository.findAll();
        Registro aux = hab.get(0);
        List<RegistroServicio> h = registroServicioRepository.findRegistroServicioByRegistro(aux);


        List<RegistroServicio> esperado = registroServicioRepository.findAll();
        List<RegistroServicio> h1 = registroServicioRepository.findAll();
        for (RegistroServicio rs: h1){
            if (rs.getRegistro().equals(aux)){
                esperado.remove(rs);
            }
        }
        assertArrayEquals(esperado, h);
    }
}
