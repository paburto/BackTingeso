package MingesoTingeso.demo.Repositories;

import MingesoTingeso.demo.Models.Cliente;
import MingesoTingeso.demo.Models.ClienteRegistro;
import MingesoTingeso.demo.Models.Registro;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
/*
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class ClienteRegistroRepositoryTest {
    @Autowired
    ClienteRepository clienterepository;
    @Autowired
    RegistroRepository registrorepository;
    @Autowired
    ClienteRegistroRepository clienteregistrorepository;

    private boolean assertArrayEquals(List<ClienteRegistro> esperado, List<ClienteRegistro> h) {
        for ( Object o : esperado ) {
            if ( !h.remove( o ) ) {
                return false;
            }
        }
        return h.isEmpty();
    }


    @Test
    public void findByCliente() {
        List<Cliente>  clien = clienterepository.findAll();
        Cliente aux = clien.get(0);
        List<ClienteRegistro> h = clienteregistrorepository.findByCliente(aux);


        List<ClienteRegistro> esperado = clienteregistrorepository.findAll();
        List<ClienteRegistro> h1 = clienteregistrorepository.findAll();
        for (ClienteRegistro rh: h1){
            if (rh.getCliente().equals(aux)){
                esperado.remove(rh);
            }
        }
        assertArrayEquals(esperado, h);
    }



    @Test
    public void findByRegistro() {
        List<Registro>  res = registrorepository.findAll();
        Registro aux = res.get(0);
        List<ClienteRegistro> h = clienteregistrorepository.findByRegistro(aux);


        List<ClienteRegistro> esperado = clienteregistrorepository.findAll();
        List<ClienteRegistro> h1 = clienteregistrorepository.findAll();
        for (ClienteRegistro rh: h1){
            if (!rh.getRegistro().equals(aux)){
                esperado.remove(rh);
            }
        }
        assertArrayEquals(esperado, h);
    }
}
*/