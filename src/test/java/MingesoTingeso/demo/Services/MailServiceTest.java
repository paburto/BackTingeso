


import MingesoTingeso.demo.Services.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;

import static org.junit.Assert.*;
@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration
@SpringBootTest
public class MailServiceTest{

    @Test
    public void sendMail() {
        MailService aux = new MailService();
        int test =  aux.sendMail("noresponder.alaya@gmail.com", "vicent.brevis@gmail.com", "Test", "Mensaje de prueba");
        assertEquals(0, test);
    }
}
