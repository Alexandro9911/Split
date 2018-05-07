package com.kspt.alexandr;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.Option;

import java.io.IOException;

public class SplitterLauncher {

    @Option(name = "-d", required = true, usage = "type of file name")
    private boolean prefix;

    @Option(name = "-l", usage = "lines in file")
    private int lines = -1;

    @Option(name = "-c", usage = "chars in file")
    private int chars = -1;

    @Option(name = "-n", usage = "size of files")
    private int numr = -1;

    @Option(name = "-o", usage = "output file name")
    private String outputFileName = null;

    @Argument(required = true, metaVar = "InputName", usage = "Input file name")
    private String inputFileName = null;

    public String getInputFileName() {
        return inputFileName;
    }

    public static void main(String[] args) throws IOException {
        new SplitterLauncher().launch(args);
    }
    private void launch(String[] args) throws IOException {
        Flags flags = new Flags();
        if (inputFileName == null) throw new IllegalArgumentException();
        flags.setInputFileName(getInputFileName());
        if (prefix ) {
            flags.setD();
        }
        if (lines != -1) {
            flags.setL();
            flags.setNum(lines);
        }
        if (chars != -1) {
            flags.setC();
            flags.setNum(chars);
        }
        if (numr != -1) {
            flags.setN();
            flags.setNum(numr);
        }
        if (outputFileName == null) {
            flags.setOutputFileName("x");
        }
        if (outputFileName.equals("-")) {
            flags.setOutputFileName(inputFileName);
        }
        if (outputFileName != null && outputFileName.equals("-")) {
            flags.setOutputFileName(outputFileName);
        }
        if (lines != -1 && chars != -1 && numr != -1) throw new IllegalArgumentException();
        try {
            flags.splitText();
        } catch (IllegalArgumentException ex) {
            System.err.println();
        }
    }
}