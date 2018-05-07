package com.kspt.alexandr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Splitter {

    /**
     * @param inp    name of file with text
     * @param lines  quantity of lines in one outputFile
     * @param name   name of Outputfile
     * @param option true or fals. its for name of outputFile
     *               if true - creating suffixs like <name>1...10...
     *               if false - creating suffis like <name>aa..ab..ac..
     * @throws IOException
     */
    public void parseByLines(String inp, int lines, String name, boolean option) throws IOException {
        File file = new File(inp);
        Scanner scanner = new Scanner(file);
        for (int i = 0; scanner.hasNextLine(); i++) {
            File newFile = new File(name + nameCreator(option, i + 1) + ".txt");
            FileWriter fr = new FileWriter(newFile);
            String line = "";
            for (int j = 0; j != lines; j++) {
                if (!scanner.hasNextLine()) break;
                line = scanner.nextLine();
                fr.write(line + "\r\n");
            }
            fr.close();
        }
        scanner.close();
    }

    /**
     * @param inp    name of file with text
     * @param chars  quantity of chars in one outputFile
     * @param name   name of Outputfile
     * @param option true or fals. its for name of outputFile
     *               if true - creating suffixs like <name>1...10...
     *               if false - creating suffis like <name>aa..ab..ac..
     * @throws IOException
     */
    public void parseByChars(String inp, int chars, String name, boolean option) throws IOException {
        int counterForName = 0;
        File file = new File(inp);
        Scanner scanner = new Scanner(file);
        for (int n = 0; scanner.hasNextLine(); n++) {
            counterForName++;
            String line = scanner.nextLine();
            if (line.length() <= chars) {
                File newFile = new File(name + nameCreator(option, counterForName + 1 ) + ".txt");
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
                for (int s = 0; s != num; s++) {
                    listOfStr.add(line.substring(first, last));
                    first = last;
                    if (line.substring(last).length() > chars) {
                        last = last + chars;
                    } else {
                        last = line.length();
                    }
                }
                for (String string : listOfStr) {
                    counterForName++;
                    File newFile = new File(name + nameCreator(option, counterForName + 1));
                    FileWriter fw = new FileWriter(newFile);
                    fw.write(string);
                    fw.close();
                }
            }
        }
        scanner.close();
    }

    /**
     * @param inp    file with text
     * @param num    quantity of outputFiles
     * @param name   nabe of Outputfile
     * @param option true or fals. its for name of outputFile
     *               if true - creating suffixs like <name>1...10...
     *               if false - creating suffis like <name>aa..ab..ac..
     * @throws IOException
     */
    public void parseByNum(String inp, int num, String name, boolean option) throws IOException {
        File file = new File(inp);
        double sizeOfPart = automaticSize(inp, num);
        FileInputStream in = new FileInputStream(file);
        for (int i = 1; i <= num; i++) {
            File newFile = new File(name + nameCreator(option, i) + ".txt");
            FileOutputStream out = new FileOutputStream(newFile);
            long read = 0;
            int b;
            while ((b = in.read()) >= 0) {
                if (++read <= sizeOfPart)
                    out.write(b);
                else
                    break;
            }
            out.close();
        }
        in.close();
    }

    /**
     * @param option if true - creating suffixs like <name>1...10...
     *               if false - creating suffis like <name>aa..ab..ac..
     * @param i      iteration
     * @return suffix of outputFile
     */
    public String nameCreator(boolean option, int i) {
        char ch1 = 'a';
        char ch2 = 'a';
        String suffix = "";
        if (option) {
            suffix = Integer.toString(i);
        } else {
            if (i - 1 == 0) {
                suffix += ch1;
                suffix += ch2;
            }
            if (i - 1 < 26 && i - 1 > 0) {
                suffix = "";
                ch2 += i - 1;
                suffix += ch1;
                suffix += ch2;
            }
            if (i - 1 == 26) {
                suffix = "";
                ch1++;
                ch2 = 'a';
                suffix += ch1;
                suffix += ch2;
            }
        }
        return suffix;
    }

    /**
     * Method for another Method "parseByNum"
     * this method counts size of outputFiles
     *
     * @param inp name of file with text
     * @param num quantity of outputFiles
     * @return size of outputFiles
     */
    double automaticSize(String inp, int num) {
        File file = new File(inp);
        long fileSize = file.length();
        long last = fileSize % num;
        if (last == 0) {
            double sizeOfPart;
            sizeOfPart = fileSize / num;
            return sizeOfPart;
        } else {
            double sizeOfPart = fileSize / num;
            sizeOfPart += last * 0.1;
            return sizeOfPart;
        }
    }
}