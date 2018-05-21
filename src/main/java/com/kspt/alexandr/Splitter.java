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
     * @throws IOException IOException
     */
    public void parseByLines(String inp, int lines, String name, boolean option) throws IOException {
        File file = new File(inp);
        Scanner scanner = new Scanner(file);
        for (int i = 0; scanner.hasNextLine(); i++) {
            File newFile = new File(name + nameCreator(option, i + 1) + ".txt");
            FileWriter fr = new FileWriter(newFile);
            String line;
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
     * @throws IOException IOException
     */
    public void parseByChars(String inp, int chars, String name, boolean option) throws IOException {
        File file = new File(inp);
        Scanner scanner = new Scanner(file);
        List<String> general = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            general.addAll(stringParser(scanner.nextLine(), chars));
        }
        int counter = 0;
        for (String string : general) {
            File newFile = new File(name + nameCreator(option, counter + 1) + ".txt");
            FileWriter fw = new FileWriter(newFile);
            fw.write(string);
            fw.close();
            counter++;
        }
    }

    /**
     * @param inp    file with text
     * @param num    quantity of outputFiles
     * @param name   nabe of Outputfile
     * @param option true or fals. its for name of outputFile
     *               if true - creating suffixs like <name>1...10...
     *               if false - creating suffis like <name>aa..ab..ac..
     * @throws IOException IOException
     */
    public void parseByNum(String inp, int num, String name, boolean option) throws IOException {
        File file = new File(inp);
        double sizeOfPart = Math.floor((double) file.length() / num);
        FileInputStream in = new FileInputStream(file);
        for (int i = 0; i < num; i++) {
            File newFile = new File(name + nameCreator(option, i + 1) + ".txt");
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
        String suffix;
        if (option) {
            suffix = Integer.toString(i);
        } else {
            if ((i - 1) % 26 == 0) {
                if (i == 1) {
                    suffix = "aa";
                } else {
                    suffix = "";
                    ch1++;
                    ch2 = 'a';
                    suffix += ch1;
                    suffix += ch2;
                }
            } else {
                suffix = "";
                if ((i - 1) / 26 > 0) {
                    ch1 = 'a';
                    ch1 += (i - 1) / 26;
                }
                ch2 += (i - 1) % 26;
                suffix += ch1;
                suffix += ch2;
            }
        }
        return suffix;
    }

    /**
     *
     * @param str string
     * @param num length of strings in outputList in chars
     * @return List of strings with length num
     */
    public List<String> stringParser(String str, int num) {
        List<String> answ = new ArrayList<String>();
        int begin = 0;
        int end = num;
        int parts = str.length() / num;
        if (str.length() % num != 0) {
            parts++;
        }
        String lastOfString = str;
        for (int i = 0; i <= parts; i++) {
            if (str.length() <= num) {
                answ.add(str);
                break;
            } else {
                if (lastOfString.length() <= num) {
                    answ.add(lastOfString);
                    break;
                } else {
                    answ.add(str.substring(begin, end));
                    lastOfString = str.substring(end);
                    begin += num;
                    end += num;
                }
            }
        }
        return answ;
    }
}