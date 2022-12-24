package advanced.log.commonslogging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Main {
    private static Log log = LogFactory.getLog(Main.class);

    public static void main(String[] args) {
        t1();
    }

    public static void t1() {
        log.info("你好，世界，commons-logging");
    }
}
