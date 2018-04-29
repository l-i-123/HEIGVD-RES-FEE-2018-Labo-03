import config.Protocol;
import model.mail.Message;
import model.prank.Prank;
import model.prank.PrankGenerator;
import smtp.SmtpClient;

/**
 * Created by elien on 27.04.2018.
 */
public class MailPrank {


    public static void main(String[] args) {

        SmtpClient smtp = new SmtpClient(Protocol.IP_ADDRESS, Protocol.DEFAULT_PORT);

        PrankGenerator prank = new PrankGenerator(smtp);

        try {
            prank.generateGroup();
            prank.generatePrank();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
