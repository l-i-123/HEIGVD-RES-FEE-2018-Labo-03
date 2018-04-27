package client;

import config.PrankProtocol;
import model.mail.Person;
import model.prank.Prank;

import java.io.*;
import java.util.Arrays;
import data.JsonObjectMapper;

/**
 * Created by elien on 27.04.2018.
 */
public class ClientHandler {

    public void handleClientConnection(InputStream is, OutputStream os) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(os));

        Prank victime = new Prank();
        int nb_Victim;

        writer.println("Hello. Online HELP is available. Will you find it?");
        writer.flush();

        String command;
        boolean done = false;
        int commmandCounter = 0;
        while (!done && ((command = reader.readLine()) != null)) {
            switch (command.toUpperCase()) {
                case PrankProtocol.CMD_HELP:
                    writer.println("Commands: " + Arrays.toString(PrankProtocol.SUPPORTED_COMMANDS));
                    break;
                case PrankProtocol.CMD_LOAD_LIST_OF_VICTIMS:
                    writer.println(PrankProtocol.RESPONSE_LOAD_START);
                    writer.flush();
                    nb_Victim = victime.importVictim(reader);
                    writer.println(PrankProtocol.RESPONSE_LOAD_DONE);


                    writer.println(JsonObjectMapper.toJson(victime));
                    writer.flush();
                    break;
                case PrankProtocol.CMD_BYE:
                    done = true;
                    //writer.println(JsonObjectMapper.toJson());
                    //writer.flush();
                    break;
                default:
                    writer.println("Huh? please use HELP if you don't know what commands are available.");
                    writer.flush();
                    break;
            }
            writer.flush();
        }
    }
}
