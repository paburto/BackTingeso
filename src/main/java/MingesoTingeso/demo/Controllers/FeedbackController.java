package MingesoTingeso.demo.Controllers;

import MingesoTingeso.demo.configFIles.EmailCfg;
import MingesoTingeso.demo.Services.Feedback;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.ValidationException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private EmailCfg emailCfg;

    public FeedbackController(EmailCfg emailCfg) {
        this.emailCfg = emailCfg;
    }

    @PostMapping
    public List<HashMap<String, String>> sendFeedback(@RequestBody Feedback feedback,
                             BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new ValidationException("Feedback is not valid");
        }

        // Crendo un  mail sender
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailCfg.getHost());
        mailSender.setPort(this.emailCfg.getPort());
        mailSender.setUsername(this.emailCfg.getUsername());
        mailSender.setPassword(this.emailCfg.getPassword());

        // Creando un email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(feedback.getEmail());
        mailMessage.setTo("vicent.brevis@gmail.com");
        mailMessage.setSubject("New feedback from " + feedback.getName());
        mailMessage.setText(feedback.getFeedback());

        // Enviando email
        mailSender.send(mailMessage);

        List<HashMap<String, String>> result = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map = new HashMap<>();
        map.put("status", "200");
        map.put("message", "OK.");
        result.add(map);
        return result;

    }
}