package com.kspt.alexandr;
import java.io.*;
import java.util.Scanner;

public class Spliter {

    int countLines(File file) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(file));
        try {
            byte[] c = new byte[1024];
            int counter = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++counter;
                    }
                }
            }
            return (counter == 0 && !empty) ? 1 : counter;
        } finally {
            is.close();
        }
    }

    int countChars(File file) throws IOException {
        FileInputStream in = new FileInputStream(file);
        byte[] array = new byte[in.available()];
        in.read(array);
        String text = new String(array);
        int count = 0;
        for (char ch : text.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                count++;
            }
        }
        return count;
    }


    public void parserByLines(File file, int lines) throws IOException {
        int size = countLines(file);
        int parts = size / lines;
        if (size % lines != 0) {
            parts++;
        }
        int counter = 0;
        for (int i = 0; i != parts; i++) {
            File newFile = new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\output\\ofile" + (i + 1));
            Scanner scanner = new Scanner(file);
            FileWriter fr = new FileWriter(newFile);
            String line = "";
            for (int j = 0; j != lines; j++) {
                counter++;
                line = scanner.nextLine();
                fr.write(line + " ");
            }
            counter = 0;
            fr.close();
        }
    }

    public static void main(String[] args) throws IOException {
        Spliter s = new Spliter();
        File newFile = new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\input\\fileread");
        s.parserByLines(newFile, 6);

    }
}