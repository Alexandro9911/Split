package com.kspt.alexandr;

import java.io.IOException;

public class Flags {
    public boolean d;
    public boolean l;
    public boolean c;
    public boolean n;
    int num;
    String inputFileName;
    String outputFileName;

    public void setD() {
        this.d = true;
    }

    public void setL() {
        this.l = true;
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

    public void splitText() throws IOException {
        Splitter spl = new Splitter();
        if (l) {
            spl.parseByLines(inputFileName, num, outputFileName, d);
        }
        if (c) {
            spl.parseByChars(inputFileName, num, outputFileName, d);
        }
        if (n) {
            spl.parseByNum(inputFileName,  num, outputFileName, d);
        }
    }
}

