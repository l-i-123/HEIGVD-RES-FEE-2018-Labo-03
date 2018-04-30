import model.prank.PrankGenerator;
import smtp.SmtpClient;

import java.io.*;
import java.util.Properties;

/**
 * Created by elien on 27.04.2018.
 */
public class MailPrank {


    public static void main(String[] args) {

        String address = null;
        int port = 0;
        int nbGroups = 0;
        try {
            InputStream is = new FileInputStream(new File("config" + File.separator + "config.properties"));
            Properties properties = new Properties();
            properties.load(is);
            is.close();

            address = properties.getProperty("address");
            port = Integer.parseInt(properties.getProperty("port"));
            nbGroups = Integer.parseInt(properties.getProperty("nbGroups"));

        } catch (IOException e) {
            System.out.println("Error reading config file");
            e.printStackTrace();
        }

        SmtpClient smtp = new SmtpClient(address, port);
        PrankGenerator prank = new PrankGenerator(smtp, nbGroups);

        try {
            prank.generateGroup();
            prank.generatePrank();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
