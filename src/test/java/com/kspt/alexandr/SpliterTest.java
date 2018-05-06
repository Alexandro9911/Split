package com.kspt.alexandr;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class SpliterTest {
    private Spliter s;
    private File newFile;

    @Before
    public void create() {
        s = new Spliter();
        newFile =  new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\input\\fileread");
    }
    @Test
    public  void nameCreatorTest(){
       String str1 = s.nameCreator(true, 5);
       String str2 = s.nameCreator(false,2);
       String str3 = s.nameCreator(false, 1);
       String str4 = s.nameCreator(false,27);
       assertEquals(true, str1.equals("6"));
       assertEquals(true, str2.equals("ab"));
       assertEquals(true, str3.equals("aa"));
       assertEquals(true,str4.equals("ba"));
    }

    @Test
    public void parseByLines() throws IOException{
        s.parseByLines("fileread", 6, "line", true);
        File first = new File("C:\\idea\\line1");
        File second = new File("C:\\idea\\line2");
        File third = new File("C:\\idea\\line3");
        File file1 = new File("C\\idea\\ForTests\\line1");
        File file2 = new File("C\\idea\\ForTests\\line2");
        File file3 = new File("C\\idea\\ForTests\\line3");
        assertEquals( true,first.equals(file1) && second.equals(file2) && third.equals(file3));
    }

}