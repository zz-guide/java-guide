package advanced.log.logging;

import java.io.IOException;
import java.util.Date;
import java.util.logging.*;

public class Main {
    public static void main(String[] args) {
//        tConsole();
        tFile();
    }

    public static void tConsole() {
        // JDK自带
        Logger log = Logger.getLogger("testLog");
        log.setLevel(Level.INFO);
        log.warning("xxxx testLog warning");
    }

    public static void tFile() {
        FileHandler fileHandler;//文件控制器
        try {
            fileHandler = new FileHandler("./logging.log");
            fileHandler.setLevel(Level.INFO);
            fileHandler.setFormatter(new Formatter() {//定义一个匿名类
                //Formatter 接受 LogRecord，并将它转换为一个字符串。
                @Override
                public String format(LogRecord record) {
                    Date date = new Date();
                    String sDate = date.toString();
                    return "[" + sDate + "]" + "[" + record.getLevel() + "]" + ":" + record.getMessage() + "\n";
                }
            });

            Logger log = Logger.getLogger("testLog");
            log.addHandler(fileHandler);
            log.info("你好世界");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
    }
}
