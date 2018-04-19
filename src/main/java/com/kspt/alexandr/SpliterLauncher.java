package com.kspt.alexandr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SpliterLauncher {
    public static void main(String[] arguments) throws IOException {
        Scanner in = new Scanner(System.in);
        String[] args = in.nextLine().split(" ");
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, args);
        Flags flags = new Flags();
        for (String arg : list) {
            if (!list.get(0).equals("split")) {
                System.out.println("wrong name of command");
                System.exit(0);
            }
            if (list.get(list.size() - 1).equals("")) {
                System.out.println("field inputFile is empty");
                System.exit(0);
            } else {
                flags.setInputFileName(list.get(list.size() - 1));
            }
            if (arg.equals("-o")) {
                flags.setO();
                if (list.get(list.indexOf(arg) + 1).equals("-")) {
                    flags.setOutputFileName(flags.inputFileName);
                } else {
                    if (list.get(list.indexOf(arg) + 1).equals(flags.inputFileName)) {
                        flags.setOutputFileName("x");
                    } else {
                        flags.setOutputFileName(list.get(list.indexOf(arg) + 1));
                    }
                }
            }
            if (arg.equals("-d")) {
                flags.setD();
            }
            if (arg.equals("-i")) {
                flags.setI();
                if (list.get(list.indexOf(arg) + 1).equals("-o")) {
                    flags.setNum(100);
                } else {
                    flags.setNum(Integer.parseInt(list.get(list.indexOf(arg) + 1)));
                }
            }
            if (arg.equals("-c")) {
                flags.setC();
                flags.setNum(Integer.parseInt(list.get(list.indexOf(arg) + 1)));
            }
            if (arg.equals("-n")) {
                flags.setN();
                flags.setNum(Integer.parseInt(list.get(list.indexOf(arg) + 1)));
            }
        }
        if ((flags.i && flags.n && flags.c) || (flags.i && flags.n) || (flags.i && flags.c) || (flags.n && flags.c)) {
            System.out.println("only one flag can be used");
            System.exit(0);
        }
        flags.SplitText();
        in.close();
    }
}