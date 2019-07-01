package MingesoTingeso.demo.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    public int sendMail(String from, String to, String subject, String body) {

        SimpleMailMessage mail = new SimpleMailMessage();

        mail.setFrom(from);
        mail.setTo(to);
        mail.setSubject(subject);
        mail.setText(body);

        javaMailSender.send(mail);
        return 0;
    }

    public int reservaMail(String from, String to, String subject, String username, int habitacion, String fechaInicio, String fechaTermino){
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
                "							<img src=\"https://i.ibb.co/zRw8YmP/h1.gif\" alt=\"¡Bienvenido a Hotel Mingeso!\" width=\"300\" height=\"230\" style=\"display: block;\" />" +
                "						</td>\r\n" +
                "					</tr>\r\n" +
                "					<tr>\r\n" +
                "						<td bgcolor=\"#ffffff\" style=\"padding: 40px 30px 40px 30px;\">\r\n" +
                "							<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" +
                "								<tr>\r\n" +
                "									<td style=\"color: #153643; font-family: Arial, sans-serif; font-size: 24px;\">\r\n" +
                "										<b>¡Ha hecho una reserva de habitaci\u00F3n!</b>\r\n" +
                "									</td>\r\n" +
                "								</tr>\r\n" +
                "								<tr>\r\n" +
                "									<td style=\"padding: 20px 0 30px 0; color: #153643; font-family: Arial, sans-serif; font-size: 16px; line-height: 20px;\">\r\n" +
                "										Estimado(a) "+ username +", usted ha realizado una reserva de la habitaci\u00F3n"+ habitacion +". Detalle a continuaci\u00F3n:\r\n" +
                "                                       Fecha de inicio: " + fechaInicio + "\r\n" +
                "                                       Fecha de termino: " + fechaTermino + "\r\n" +
                "									</td>\r\n" +
                "								</tr>\r\n" +
                "								<tr>\r\n" +
                "									<td>\r\n" +
                "										<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" +
                "											<tr>\r\n" +
                "												<td width=\"260\" valign=\"top\">\r\n" +
                "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" +
                "														<tr>\r\n" +
                "															<td>\r\n" +
                "																<img src=\"https://i.ibb.co/fNtM5rP/left.gif\" alt=\"\" width=\"100%\" height=\"140\" style=\"display: block;\" />\r\n" +
                "															</td>\r\n" +
                "														</tr>\r\n" +
                "														<tr>\r\n" +
                "															<td style=\"padding: 25px 0 0 0; color: #153643; font-family: Arial, sans-serif; font-size: 16px; line-height: 20px;\">\r\n" +
                "																Para cualquier duda, usted puede contactar con nuestros canales digitales como Twitter, Facebook, como tambi\u00E9n nuestros canales telefonicos.\r\n" +
                "															</td>\r\n" +
                "														</tr>\r\n" +
                "													</table>\r\n" +
                "												</td>\r\n" +
                "												<td style=\"font-size: 0; line-height: 0;\" width=\"20\">\r\n" +
                "													&nbsp;\r\n" +
                "												</td>\r\n" +
                "												<td width=\"260\" valign=\"top\">\r\n" +
                "													<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\r\n" +
                "														<tr>\r\n" +
                "															<td>\r\n" +
                "																<img src=\"https://i.ibb.co/dGKgtTX/right.gif\" alt=\"\" width=\"100%\" height=\"140\" style=\"display: block;\" />\r\n" +
                "															</td>\r\n" +
                "														</tr>\r\n" +
                "														<tr>\r\n" +
                "															<td style=\"padding: 25px 0 0 0; color: #153643; font-family: Arial, sans-serif; font-size: 16px; line-height: 20px;\">\r\n" +
                "																Al momento de hacer Check-in en nuestro hotel, recuerde llevar su c\u00F3odigo de reserva, o presente este correo al recepcionista.\r\n" +
                "															</td>\r\n" +
                "														</tr>\r\n" +
                "													</table>\r\n" +
                "												</td>\r\n" +
                "											</tr>\r\n" +
                "										</table>\r\n" +
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

        return sendMail(from, to, subject, messageUserWelcome);
    }

    public int comprobantePago(String from, String to, String subject, String detalles, int habitacion, String username){
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
                "							<img src=\"https://i.ibb.co/zRw8YmP/h1.gif\" alt=\"¡Bienvenido a Hotel Mingeso!\" width=\"300\" height=\"230\" style=\"display: block;\" />" +
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
                "										Estimado(a) "+ username +", usted ha realizado el check-out de la habitaci\u00F3n"+ habitacion +". Detalle a continuaci\u00F3n:\r\n" +
                "                                       Detalle:\r\n" + detalles + "\r\n" +
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

        return sendMail(from, to, subject, messageUserWelcome);
    }
}