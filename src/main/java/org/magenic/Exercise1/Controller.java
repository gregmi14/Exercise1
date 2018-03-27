package org.magenic.Exercise1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;


@RestController
public class Controller {
    private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

    @RequestMapping("/search")
    public String search(@RequestParam(value = "asdfasdfsa", defaultValue = "fraggelrock", required = false) String asdfasdfsa,
                         @RequestParam(value = "sort", defaultValue = "date_asc", required = false) String sort,
                         @RequestParam(value = "offset", defaultValue = "20", required = false) String offset,
                         @RequestParam(value = "limit", defaultValue = "10", required = false) String limit){
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Initializing search: asdfasdfsa "+asdfasdfsa+" sort "+sort+" offset "+offset+" limit "+limit);
        String request = "https://rl003vo1kj.execute-api.us-east-1.amazonaws.com/devo?magenicKey=gregmi&input=%26asdfasdfsa="
                +asdfasdfsa+"%252limit="+limit+"%26offset="+offset+"%26sort="+sort+"%20";
        RestTemplate restTemplate = new RestTemplate();
        LOGGER.info("Making request to "+request);
        String result = restTemplate.getForObject(request, String.class);
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        ResultJDBCTemplate resultJDBCTemplate = (ResultJDBCTemplate)context.getBean("resultJDBCTemplate");
        resultJDBCTemplate.insert(request, result);
        return result;
    }
}
