package com.kspt.alexandr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spliter {

    public void parseByLines(File file, int lines, String name, boolean option) throws IOException {
        Scanner scanner = new Scanner(file);
        char ch1 = 'a';
        char ch2 = 'a';
        String suffix = "";
        for (int i = 0; scanner.hasNextLine(); i++) {
            File newFile = new File("C:\\idea\\" + name + nameCreator(option,i));
            FileWriter fr = new FileWriter(newFile);
            String line = "";
            for (int j = 0; j != lines; j++) {
                if (!scanner.hasNextLine()) break;
                line = scanner.nextLine();
                fr.write(line + "\n");
            }
            fr.close();
        }
        scanner.close();
    }
    public void parseBySize(File file, int size, String name, boolean option) throws IOException {
        long sizeCounter = 0;
        char ch1 = 'a';
        char ch2 = 'a';
        String suffix = "";
        FileInputStream inputStream = new FileInputStream(file);
        byte[] bytes =  new byte[inputStream.available()];
        

    }


    public void parseByChars(File file, int chars, String name, boolean option) throws IOException {
        int counterForName = 0;
        char ch1 = 'a';
        char ch2 = 'a';
        String suffix = "";
        Scanner scanner = new Scanner(file);
        for (int n = 0; scanner.hasNextLine(); n++) {
            counterForName++;
            String line = scanner.nextLine();
            if (line.length() <= chars) {
                File newFile = new File("C:\\idea\\"+ name + nameCreator(option, counterForName));
                FileWriter fw = new FileWriter(newFile);
                fw.write(line);
                fw.close();
            } else {
                List<String> listOfStr = new ArrayList<String>();
                int num = line.length() / chars;
                if (line.length() % chars != 0) {
                    num++;
                }
                int last = chars;
                int first = 0;
                for (int s = 0; s!= num ;s++ ) {
                    listOfStr.add(line.substring(first, last));
                    first = last;
                    if(line.substring(last).length()> chars){
                        last = last+chars;
                    } else { last = line.length(); }
                }
                for (String string : listOfStr) {
                    counterForName++;
                    File newFile = new File("C:\\idea\\"+ name + nameCreator(option, counterForName));
                    FileWriter fw = new FileWriter(newFile);
                    fw.write(string);
                    fw.close();
                }
            }
        }
        scanner.close();
    }
    public String nameCreator(boolean option, int iteration){
        char ch1 = 'a';
        char ch2 = 'a';
        String suffix = "";
        if (option) {
            suffix = Integer.toString(iteration + 1);
        } else {

            if (iteration == 0) {
                suffix += ch1;
                suffix += ch2;
            }
            if (iteration == 26) {
                suffix = "";
                ch2 = 'a';
                ch1++;
                suffix += ch1;
                suffix += ch2;
            }
            if (iteration > 0 && iteration < 26) {
                suffix = "";
                ch2 += iteration -1;
                suffix += ch1;
                suffix += ch2;
            }
        }
        return suffix;
    }
}