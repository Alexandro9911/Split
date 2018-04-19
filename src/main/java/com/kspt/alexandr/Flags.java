package com.kspt.alexandr;

import java.io.File;
import java.io.IOException;

public class Flags {
    public boolean o;
    public boolean d;
    public boolean i;
    public boolean c;
    public boolean n;
    int num;
    String inputFileName;
    String outputFileName;
    File inputFile;

    public void setO() {
        this.o = true;
    }

    public void setD() {
        this.d = true;
    }

    public void setI() {
        this.i = true;
    }

    public void setC() {
        this.c = true;
    }

    public void setN() {
        this.n = true;
    }

    public void setNum(int x) {
        this.num = x;
    }

    public void setInputFileName(String name) {
        this.inputFileName = name;
    }

    public void setOutputFileName(String name) {
        this.outputFileName = name;
    }

    public void SplitText() throws IOException { // еще не готово
        Spliter spl = new Spliter();
        inputFile = new File("C:\\Users\\LEGION\\IdeaProjects\\Split\\src\\main\\resources\\input\\" +
                inputFileName);
        if (i) {
            spl.parseByLines(inputFile, num, outputFileName, d);
        }
        if (c) {
            spl.parseByChars(inputFile, num);
        }
        if (n) {
            spl.parseBySize(inputFile, num);
        }

    }
}
