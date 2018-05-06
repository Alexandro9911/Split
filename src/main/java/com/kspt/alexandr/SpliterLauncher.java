package com.kspt.alexandr;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

public class SpliterLauncher {

    @Option(name = "-d", required = true, usage = "type of file name")
    private boolean prefix;

    @Option(name = "-i", required = true, usage = "lines in file")
    private int lines = 100;

    @Option(name = "-c", required = true, usage = "chars in file")
    private int chars;

    @Option(name = "-n", required = true, usage = "size of files")
    private int size;

    @Option(name = "-o", required = true, usage = "output file name")
    private String outputFileName;

    @Argument(required = true, metaVar = "InputName", usage = "Input file name")
    private String inputFileName;

    public String getOutputFileName() {
        return outputFileName;
    }

    public String getInputFileName() {
        return inputFileName;
    }

    public static void main(String[] args) throws IOException {
        new SpliterLauncher().launch(args);
    }

    private void launch(String[] args) throws IOException{
        CmdLineParser parser = new CmdLineParser(this);
        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("");
            parser.printUsage(System.err);
            return;
        }
        System.out.println(chars);
        Spliter spl = new Spliter();

    }
}