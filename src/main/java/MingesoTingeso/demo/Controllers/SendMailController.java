package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.Services.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/mail")
public class SendMailController {

    @Autowired
    private MailService mailService;
/**
    @GetMapping("/")
    public String index(){
        return "send_mail_view";
    }
*/
    @PostMapping("/hab")
    public List<HashMap<String, String>> sendMailHabitacion(String correo, String asunto, String username, int habitacion, String fechaInicio, String fechaTermino) throws ParseException {

        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>();

        if (correo == null && asunto==null && fechaInicio==null){
            map.put("status", "401");
            map.put("message", "Error correo nulo.");
            result.add(map);
            return result;
        }

        //String message = body +"\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
        mailService.reservaMail("noresponder.alaya@gmail.com",correo,asunto,username,habitacion, fechaInicio, fechaTermino);


        map.put("status", "200");
        map.put("message", "OK.");
        result.add(map);
        return result;
        /**
        return "send_mail_view";*/
    }

    @PostMapping("/com")
    public List<HashMap<String, String>> sendMailComprobante(String correo, String asunto, String detalles, int habitacion, String username) throws ParseException {

        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>();

        if (correo == null && asunto==null && detalles==null){
            map.put("status", "401");
            map.put("message", "Error correo nulo.");
            result.add(map);
            return result;
        }

        //String message = body +"\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
        mailService.comprobantePago("noresponder.alaya@gmail.com",correo,asunto, detalles, habitacion, username);


        map.put("status", "200");
        map.put("message", "OK.");
        result.add(map);
        return result;
        /**
         return "send_mail_view";*/
    }
}