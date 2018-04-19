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
    public void parseByLines() throws IOException{
        s.parseByLines(newFile, 6, "name", true);
        boolean first = new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\output\\name1").exists();
        boolean second = new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\output\\name2").exists();
        boolean third = new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\output\\name3").exists();
        assertEquals(true, first && second && third );
    }
}