
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

    @Before
    public void create() throws IOException {
        s = new Splitter();
        s.parseByLines("src\\test\\java\\testResources\\inputFiles\\fileread",
                6,
                "src\\test\\java\\testResources\\outputFiles\\linesTest",
                false);
        s.parseByNum("src\\test\\java\\testResources\\inputFiles\\fileread",
                3,
                "src\\test\\java\\testResources\\outputFiles\\NumParse",
                false);
        s.parseByChars("src\\test\\java\\testResources\\inputFiles\\FileForChar",
                3,
                "src\\test\\java\\testResources\\outputFiles\\Chars",
                false);
    }

    private boolean equalsFile(List<File> expected, List<File> actual) throws IOException {
        boolean answ = true;
        int counter = 0;
        if (expected.size() != actual.size()) answ = false;
        for (File files : expected) {
            Scanner scannerExpected = new Scanner(files);
            Scanner scannerActual = new Scanner(actual.get(counter));
            while (scannerActual.hasNextLine()) {
                if (!scannerExpected.hasNextLine()) {
                    answ = false;
                    break;
                }
                String strExpected = scannerExpected.nextLine();
                String strActual = scannerActual.nextLine();
                if (!strExpected.equals(strActual)) {
                    answ = false;
                }
            }
            if (!answ) {
                break;
            } else {
                counter++;
            }
        }
        return answ;
    }

    @Test
    public void equalsFilesTest() throws IOException {
        List<File> expected = new ArrayList<File>();
        List<File> actual = new ArrayList<File>();
        List<File> actualFalse = new ArrayList<File>();
        actual.add(new File("src\\test\\java\\testResources\\inputFiles\\TestEquals1"));
        expected.add(new File("src\\test\\java\\testResources\\inputFiles\\TestEquals2"));
        actualFalse.add(new File("src\\test\\java\\testResources\\inputFiles\\TestEquals3"));
        assertEquals(true, equalsFile(expected, actual));
        assertEquals(false, equalsFile(expected, actualFalse));
    }

    @Test
    public void nameCreatorTest() {
        String str1 = s.nameCreator(true, 5);
        String str2 = s.nameCreator(false, 2);
        String str3 = s.nameCreator(false, 1);
        String str4 = s.nameCreator(false, 27);
        String str5 = s.nameCreator(false, 28);
        assertEquals(true, str1.equals("5"));
        assertEquals(true, str2.equals("ab"));
        assertEquals(true, str3.equals("aa"));
        assertEquals(true, str4.equals("ba"));
        assertEquals(true, str5.equals("bb"));
    }


    @Test
    public void parseByLinesTest() throws IOException {
        List<File> expected = new ArrayList<File>();
        List<File> actual = new ArrayList<File>();

        List<File> actualFalse = new ArrayList<File>();
        expected.add(new File("src\\test\\java\\testResources\\inputFiles\\linesTestaa.txt"));
        expected.add(new File("src\\test\\java\\testResources\\inputFiles\\linesTestab.txt"));
        expected.add(new File("src\\test\\java\\testResources\\inputFiles\\linesTestac.txt"));
        actual.add(new File("src\\test\\java\\testResources\\outputFiles\\linesaa.txt"));
        actual.add(new File("src\\test\\java\\testResources\\outputFiles\\linesab.txt"));
        actual.add(new File("src\\test\\java\\testResources\\outputFiles\\linesac.txt"));
        actualFalse.add(new File("src\\test\\java\\testResources\\inputFiles\\linesaaFalse.txt"));
        assertEquals(true, equalsFile(expected, actual));
        assertEquals(false, equalsFile(expected, actualFalse));
    }

    @Test
    public void stringParserTest() {
        String str = "Polytech KSPT";
        List<String> expected = new ArrayList<String>();
        List<String> expectedFalse = new ArrayList<String>();
        expectedFalse.add("false");
        List<String> actual = s.stringParser(str, 10);
        expected.add("Polytech K");
        expected.add("SPT");
        assertEquals(true, expected.equals(actual));
        assertEquals(false, expectedFalse.equals(actual));
    }

    @Test
    public void parseByCharsTest() throws IOException {
        List<File> expected = new ArrayList<File>();
        List<File> actual = new ArrayList<File>();

        expected.add(new File("src\\test\\java\\testResources\\inputFiles\\CharTest1.txt"));
        expected.add(new File("src\\test\\java\\testResources\\inputFiles\\CharTest2.txt"));
        expected.add(new File("src\\test\\java\\testResources\\inputFiles\\CharTest3.txt"));
        expected.add(new File("src\\test\\java\\testResources\\inputFiles\\CharTest4.txt"));
        expected.add(new File("src\\test\\java\\testResources\\inputFiles\\CharTest5.txt"));
        expected.add(new File("src\\test\\java\\testResources\\inputFiles\\CharTest6.txt"));

        actual.add(new File("src\\test\\java\\testResources\\outputFiles\\Charsaa.txt"));
        actual.add(new File("src\\test\\java\\testResources\\outputFiles\\Charsab.txt"));
        actual.add(new File("src\\test\\java\\testResources\\outputFiles\\Charsac.txt"));
        actual.add(new File("src\\test\\java\\testResources\\outputFiles\\Charsad.txt"));
        actual.add(new File("src\\test\\java\\testResources\\outputFiles\\Charsae.txt"));
        actual.add(new File("src\\test\\java\\testResources\\outputFiles\\Charsaf.txt"));

        assertEquals(true, equalsFile(expected, actual));
    }

    @Test
    public void parseByNum() throws IOException {
        List<File> expected = new ArrayList<File>();
        List<File> actual = new ArrayList<File>();
        List<File> actualFalse = new ArrayList<File>();
        expected.add(new File("src\\test\\java\\testResources\\inputFiles\\NumParse1.txt"));
        expected.add(new File("src\\test\\java\\testResources\\inputFiles\\NumParse2.txt"));
        expected.add(new File("src\\test\\java\\testResources\\inputFiles\\NumParse3.txt"));
        actual.add(new File("src\\test\\java\\testResources\\outputFiles\\NumParseaa.txt"));
        actual.add(new File("src\\test\\java\\testResources\\outputFiles\\NumParseab.txt"));
        actual.add(new File("src\\test\\java\\testResources\\outputFiles\\NumParseac.txt"));
        actualFalse.add(new File("src\\test\\java\\testResources\\outputFiles\\NumParseaa.txt"));
        actualFalse.add(new File("src\\test\\java\\testResources\\inputFiles\\ActualFalse2.txt"));
        actualFalse.add(new File("src\\test\\java\\testResources\\outputFiles\\NumParseab.txt"));
        assertEquals(true, equalsFile(expected, actual));
        assertEquals(false, equalsFile(expected, actualFalse));
    }
}
