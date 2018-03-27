package org.magenic.Exercise1;

import org.magenic.Exercise1.logger.MyLogger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.io.IOException;
import java.util.logging.Logger;

@SpringBootApplication
public class Application {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    public static void main(String[] args) {
        try {
            MyLogger.setup();
        } catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Problems with creating the log files");
        }
        SpringApplication.run(Application.class, args);
    }
}
