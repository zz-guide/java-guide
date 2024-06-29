package org.zz.bufferedwriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

/**
 * BufferedWriter,处理流
 */
public class Main {
    static String currentDirPath = "./base-foundation/src/main/java/basic/io/bufferedwriter/";

    public static void main(String[] args) {
        t1();
    }

    public static void t1() {
        File file = new File(currentDirPath + "t.txt");
        try (BufferedWriter bufferedReader = new BufferedWriter(new FileWriter(file))) {
            bufferedReader.write("asdasd");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
