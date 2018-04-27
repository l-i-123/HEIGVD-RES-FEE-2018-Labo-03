import model.mail.Message;
import smtp.SmtpClient;

/**
 * Created by elien on 27.04.2018.
 */
public class MailPrank {


    public static void main(String[] args) {
        SmtpClient smtp = new SmtpClient("localhost", 2525);

        Message message = new Message("elie@elie.com", "elie1.salut.com", "test", "Bonjour comment allez-vous");

        smtp.sendMessage(message);

    }
}
