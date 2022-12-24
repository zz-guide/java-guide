package advanced.log.out;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        // 修改System.out输出到文件
        PrintStream ps;
        try {
            ps = new PrintStream("./log.txt");
            System.setOut(ps);
            System.out.println("System.out.println输出到文件");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
