package com.kspt.alexandr;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Spliter {
    public String inputFilename;
    public String outputFileName;
    public File inputFile;
    public File outputFile;
    public int linesInFile;
    public int charsInFile;
    public int sizeOfFile;

    public void setInputFilename(String inputFilename) {
        this.inputFilename = inputFilename;
    }

    public void setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
    }

    public void setInputFile(File inputFile) {
        this.inputFile = inputFile;
    }

    public void setOutputFile(File outputFile) {
        this.outputFile = outputFile;
    }

    public void setLinesInFile(int linesInFile) {
        this.linesInFile = linesInFile;
    }

    public void setCharsInFile(int charsInFile) {
        this.charsInFile = charsInFile;
    }

    public void setSizeOfFile(int sizeOfFile) {
        this.sizeOfFile = sizeOfFile;
    }

    public void parseByLines(File file, int lines, String name, boolean option) throws IOException {
        Scanner scanner = new Scanner(file);
        String prefix = "";
        List<Character> alph = makeAlph();

        for (int i = 0; scanner.hasNextLine(); i++) {
            if (option) {
                prefix = Integer.toString(i + 1);
            } else {
                prefix = alph.get(0).toString() + alph.get(i);
            }
            File newFile = new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\output\\" + name + prefix);
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

    public void parseByChars(File file, int chars) throws IOException {
        Scanner scanner = new Scanner(file);
        for (int i = 0; scanner.hasNext(); i++) {
            File newFile = new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\output\\chars" + (i + 1));
            FileWriter fr = new FileWriter(newFile);
            char[] ch;
            for (int j = 0; j != chars; j++) {
                if (!scanner.hasNext()) break;
                ch = scanner.next().toCharArray();

                fr.write(ch.length + "\n");
            }
            fr.close();
        }
        scanner.close();
    }

    public void parseBySize(File inp, int size) throws IOException {
        //
    }


    public static void main(String[] args) throws IOException {
        Spliter s = new Spliter();
        File newFile = new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\input\\fileread");
        s.parseByLines(newFile, 6, "FileName", false);
        //  File newFile1 = new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\input\\FileForChar");
        // s.parseByChars(newFile1, 1);
    }

    private List<Character> makeAlph() {
        List<Character> alph = new ArrayList<Character>();
        for (char i = '\u0430'; i <= '\u044f'; i++) {
            alph.add(i);
        }
        return alph;
    }
}