package MingesoTingeso.demo.Services;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

public class EmailSenderComprobante implements Runnable {
    public EmailSenderComprobante(String to, String subject, String detalles, String username, int habitacion){
        this.to = to;
        this.subject = subject;
        this.detalles = detalles;
        this.username = username;
        this.habitacion = habitacion;
    }

    private String to;
    private String subject;
    private String detalles;
    private String username;
    private int habitacion;

    public void sendMail() throws AddressException, MessagingException, IOException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("noresponder.alaya@gmail.com", "alayaDigitalSolutions");
            }
        });
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("noresponder.alaya@gmail.com", false));

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(this.to));
        msg.setSubject(this.subject);
        msg.setSentDate(new Date());

        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(comprobantePago(this.detalles, this.habitacion, this.username), "text/html");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);
        msg.setContent(multipart);
        Transport.send(msg);
    }

    public void run() {
        try {
            sendMail();
        }
        catch(Exception e) {
            System.out.println("Exception caught while sending message");
        }
    }

    public String comprobantePago(String detalles, int habitacion, String username){
        String messageUserWelcome = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\r\n" +
                "<html xmlns=\"http://www.w3.org/1999/xhtml\">\r\n" +
                "<head>\r\n" +
                "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" />\r\n" +
                "<title>Demystifying Email Design</title>\r\n" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/>\r\n" +
                "</head>\r\n" +
                "<body style=\"margin: 0; padding: 0;\">\r\n" +
                "	<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">	\r\n" +
                "		<tr>\r\n" +
                "			<td style=\"padding: 10px 0 30px 0;\">\r\n" +
                "				<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"border: 1px solid #cccccc; border-collapse: collapse;\">\r\n" +
                "					<tr>\r\n" +
                "						<td align=\"center\" bgcolor=\"#70bbd9\" style=\"padding: 40px 0 30px 0; color: #153643; font-size: 28px; font-weight: bold; font-family: Arial, sans-serif;\">\r\n" +
                "							<img src=\"https://i.ibb.co/0JvbDKy/h1.gif\" alt=\"¡Bienvenido a Hotel Mingeso!\" width=\"300\" height=\"230\" style=\"display: block;\" />" +
                "						</td>\r\n" +
                "					</tr>\r\n" +
                "					<tr>\r\n" +
                "						<td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">\r\n" +
                "							<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" +
                "								<tr>\r\n" +
                "									<td style=\"color: #153643; font-family: Arial, sans-serif; font-size: 24px;\">\r\n" +
                "										<b>¡Ha realizado el check-out de una habitaci\u00F3n!</b>\r\n" +
                "									</td>\r\n" +
                "								</tr>\r\n" +
                "								<tr>\r\n" +
                "									<td style=\"padding: 20px 0 30px 0; color: #153643; font-family: Arial, sans-serif; font-size: 16px; line-height: 20px;\">\r\n" +
                "										Estimado(a) "+ username +", usted ha realizado el check-out de la habitaci\u00F3n "+ habitacion +". Detalle a continuaci\u00F3n:<br>\r\n" +
                "                                       Detalle:<br>" + detalles + "<br>\r\n" +
                "									</td>\r\n" +
                "								</tr>\r\n" +
                "								<tr>\r\n" +
                "									<td>\r\n" +
                "                                       ¡Muchas gracias por su visita, lo esperamos nuevamente!\r\n" +
                "									</td>\r\n" +
                "								</tr>\r\n" +
                "							</table>\r\n" +
                "						</td>\r\n" +
                "					</tr>\r\n" +
                "					<tr>\r\n" +
                "						<td bgcolor=\"#ee4c50\" style=\"padding: 30px 30px 30px 30px;\">\r\n" +
                "							<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" +
                "								<tr>\r\n" +
                "									<td style=\"color: #ffffff; font-family: Arial, sans-serif; font-size: 14px;\" width=\"75%\">\r\n" +
                "										&reg; Hotel Mingeso, Santiago 2019<br/>\r\n" +
                "									</td>\r\n" +
                "									<td align=\"right\" width=\"25%\">\r\n" +
                "										<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\r\n" +
                "											<tr>\r\n" +
                "												<td style=\"font-family: Arial, sans-serif; font-size: 12px; font-weight: bold;\">\r\n" +
                "													</a>\r\n" +
                "												</td>\r\n" +
                "												<td style=\"font-size: 0; line-height: 0;\" width=\"20\">&nbsp;</td>\r\n" +
                "												<td style=\"font-family: Arial, sans-serif; font-size: 12px; font-weight: bold;\">\r\n" +
                "													</a>\r\n" +
                "												</td>\r\n" +
                "											</tr>\r\n" +
                "										</table>\r\n" +
                "									</td>\r\n" +
                "								</tr>\r\n" +
                "							</table>\r\n" +
                "						</td>\r\n" +
                "					</tr>\r\n" +
                "				</table>\r\n" +
                "			</td>\r\n" +
                "		</tr>\r\n" +
                "	</table>\r\n" +
                "</body>\r\n" +
                "</html>";

        return messageUserWelcome;
    }
}
