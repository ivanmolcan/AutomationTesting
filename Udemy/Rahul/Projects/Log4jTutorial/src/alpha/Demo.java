package alpha;

import org.apache.logging.log4j.*;

public class Demo {

    private static Logger log = LogManager.getLogger(Demo.class.getName());

    public static void main(String[] args) {

        //resources/log4j2.xml treba priradit v Project Structure/modules, ze moj package resources su resources
        log.debug("I have clicked on button");
        log.info("Button is displayed");
        log.error("Button is not displayed");
        log.fatal("Button is missing");

    }
}
