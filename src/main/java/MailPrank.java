import config.Protocol;
import model.mail.Message;
import smtp.SmtpClient;

/**
 * Created by elien on 27.04.2018.
 */
public class MailPrank {


    public static void main(String[] args) {

        SmtpClient smtp = new SmtpClient(Protocol.IP_ADDRESS, Protocol.DEFAULT_PORT);

        Message message = new Message("elie@elie.com", "elie1.salut.com", "test", "Bonjour comment allez-vous");

        smtp.sendMessage(message);

    }
}
