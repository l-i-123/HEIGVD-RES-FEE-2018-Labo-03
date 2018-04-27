package config;

/**
 * Created by elien on 27.04.2018.
 */
public class PrankProtocol {
    public final static String VERSION = "1.0";

    public final static int DEFAULT_PORT = 2525;

    public final static String CMD_HELP = "HELP";
    public final static String CMD_SET_NB_GROUPE = "SET_NB_GROUP";
    public final static String CMD_LOAD_LIST_OF_VICTIMS = "LD_VICTIMS_RECEIVER";
    public final static String CMD_LOAD_VICTIM_SENDER = "LD_VICTIM_SENDER";
    public final static String CMD_LOAD_MESSAGE = "LS_MESSAGE";
    public final static String CMD_INFO = "INFO";
    public final static String CMD_BYE = "BYE";

    public final static String CMD_LOAD_ENDOFDATA_MARKER = "ENDOFDATA";

    public final static String RESPONSE_LOAD_START = "Send your data [end with ENDOFDATA]";
    public final static String RESPONSE_LOAD_DONE = "DATA LOADED";

    public final static String[] SUPPORTED_COMMANDS = new String[]{CMD_HELP, CMD_SET_NB_GROUPE, CMD_LOAD_LIST_OF_VICTIMS, CMD_LOAD_VICTIM_SENDER, CMD_LOAD_MESSAGE, CMD_INFO, CMD_BYE};
}
