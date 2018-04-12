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
        newFile = new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\input\\fileread");
    }

    @Test
    public void countLines() throws IOException {
        s = new Spliter();
        newFile = new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\input\\fileread");
        assertEquals(14, s.countLines(newFile));
    }

    @Test
    public void countChars() throws IOException {
        s =new Spliter();
        newFile = new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\input\\fileread");
        assertEquals(124, s.countChars(newFile));
    }
}