package org.magenic.Exercise1.logger;

import java.io.IOException;
import java.util.logging.*;

public class MyLogger {
    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;
    static private FileHandler fileHTML;
    static private Formatter formatterHTML;

    static public void setup() throws IOException{
        //get and configure global logger
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        //suppress logging output to console
        Logger rootLogger = Logger.getLogger("");
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler){
            rootLogger.removeHandler(handlers[0]);
        }

        logger.setLevel(Level.INFO);
        fileTxt = new FileHandler("Logging.txt");
        fileHTML = new FileHandler("Logging.html");
        //create txt formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);
        //create html formatter
        formatterHTML = new MyFormatter();
        fileHTML.setFormatter(formatterHTML);
        logger.addHandler(fileHTML);

    }

}
