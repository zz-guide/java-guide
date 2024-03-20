package basic.io.bufferedreader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * BufferedReader,处理流
 */
public class Main {
    static String currentDirPath = "./base-foundation/src/main/java/basic/io/bufferedreader/";

    public static void main(String[] args) {
        t1();
    }

    public static void t1() {
        File file = new File(currentDirPath + "t.txt");
        String res = "";
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            res = bufferedReader.readLine();
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
