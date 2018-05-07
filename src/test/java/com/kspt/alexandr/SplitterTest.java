package com.kspt.alexandr;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class SplitterTest {
    private Splitter s;
    private String inputFileName;
    private String outputFileNameForLines;
    private File lines1;
    private File lines2;
    private File lines3;
    private File linesaa;
    private File linesab;
    private File linesac;

    @Before
    public void create() throws IOException {
        s = new Splitter();
        inputFileName = "fileread";
        outputFileNameForLines = "lines";
        lines1 = new File("lines1"+".txt");
        lines2 = new File("lines2"+".txt");
        lines3 = new File("lines3"+".txt");
        linesaa = new File("linesaa"+".txt");
        linesab = new File("linesab"+".txt");
        linesac = new File("linesac"+".txt");
        s.parseByLines(inputFileName, 6, outputFileNameForLines, false);
    }
    @Test
    public  void nameCreatorTest(){
       String str1 = s.nameCreator(true, 5);
       String str2 = s.nameCreator(false,2);
       String str3 = s.nameCreator(false, 1);
       String str4 = s.nameCreator(false,27);
       assertEquals(true, str1.equals("5"));
       assertEquals(true, str2.equals("ab"));
       assertEquals(true, str3.equals("aa"));
       assertEquals(true, str4.equals("ba"));
    }
    @Test
    public void automaticSizeTest(){
        assertEquals(69.0, s.automaticSize(inputFileName,4),0.0001);
        assertEquals(39.3, s.automaticSize(inputFileName,7),0.0001);
    }

    @Test
    public void parseByLinesTest() throws IOException {
        s.parseByLines(inputFileName, 6,  outputFileNameForLines, false);
        s.parseByLines(inputFileName, 6, outputFileNameForLines, true);
        List<File> expected = new ArrayList<File>();
        List<File> actual = new ArrayList<File>();
        List<File> actualFalse = new ArrayList<File>();
        actualFalse.add(linesaa);
        expected.add(lines1);
        expected.add(lines2);
        expected.add(lines3);
        actual.add(linesaa);
        actual.add(linesab);
        actual.add(linesac);
        boolean answ = true;
        boolean answ1 = true;
        int counter = 0;
        if (expected.size() != actual.size()) answ = false;
        if (expected.size() !=actualFalse.size()) answ1 = false;
        for (File files : expected) {
            Scanner scannerExpected = new Scanner(files);
            Scanner scannerActual = new Scanner(actual.get(counter));
            while (scannerActual.hasNextLine()) {
                String strexpected = scannerExpected.nextLine();
                String strActual = scannerActual.nextLine();
                if (!strexpected.equals(strActual)) {
                    answ = false;
                }
            }
            if (!answ) {
                break;
            } else {
                counter++;
            }
        }
        assertEquals(true, answ);
        assertEquals(false, answ1);
    }

}