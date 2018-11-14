package com.training;

import java.io.*;

public class File {
    static String readFile(String filename) {
        StringBuilder text = new StringBuilder();
        String line;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            while ((line = bufferedReader.readLine()) != null) {
                text.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text.toString();
    }

    static void writeFile(String text, String filename, boolean append) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, append))) {
            bufferedWriter.write(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
