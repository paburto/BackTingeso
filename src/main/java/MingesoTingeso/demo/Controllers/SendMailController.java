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
    @PostMapping
    public List<HashMap<String, String>> sendMail(String correo, String asunto, String mensaje) throws ParseException {

        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>();

        if (correo == null && asunto==null && mensaje==null){
            map.put("status", "401");
            map.put("message", "Error correo nulo.");
            result.add(map);
            return result;
        }

        //String message = body +"\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
        mailService.sendMail("noresponder.alaya@gmail.com",correo,asunto,mensaje);


        map.put("status", "200");
        map.put("message", "OK.");
        result.add(map);
        return result;
        /**
        return "send_mail_view";*/
    }

}