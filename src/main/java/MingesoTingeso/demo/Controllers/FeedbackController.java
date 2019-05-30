package MingesoTingeso.demo.Services;

import MingesoTingeso.demo.configFIles.EmailCfg;
import MingesoTingeso.demo.Services.Feedback;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;

@RestController
@RequestMapping("feedback")

public class FeedbackController {

    private EmailCfg emailCfg;

    public FeedbackController(EmailCfg emailCfg) {
        this.emailCfg = emailCfg;
    }

    @PostMapping
    public void seendFeedback(@RequestBody Feedback feedback, BindingResult bindingResult) throws ValidationException {
        if (bindingResult.hasErrors()){
            throw new ValidationException("Feedback no es válido");
        }

    }

    //Creando Mail Sender
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost(this.emailCfg.getHost());
    mailSender.setPort(this.emailCfg.getPort());
    mailSender.setUsername(this.emailCfg.getUsername());
    mailSender.setPassword(this.emailCfg.getPassword());

    // Creando instancia de Mail
    SimpleMailMessage mailMessage = new SimpleMailMessage();
    mailMessage.setFrom(feedback.getEmail());
    mailMessage.setTo("rc@feedback.com");
    mailMessage.setSubject("New feedback from " + feedback.getName());
    mailMessage.setText(feedback.getFeedback());

    // Send mail
        mailSender.send(mailMessage)

}
