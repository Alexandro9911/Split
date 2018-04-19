package com.kspt.alexandr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class SpliterLauncher {
    public static void main(String[] arguments) throws IOException {
        Scanner in = new Scanner(System.in);
        String[] args = in.nextLine().split(" ");
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, args);
        Flags flags = new Flags();
        for (String arg : list) {
            if (!list.get(0).equals("split")) throw new NoSuchElementException();
            if (arg.equals("-o")) {
                flags.setO();
                if (list.get(list.indexOf(arg) + 1).equals("")) {
                    flags.setOutputFileName("x");
                }
                if (list.get(list.indexOf(arg) + 1).equals("-")) {
                    if (list.get(list.size() - 1).equals("")) throw new NoSuchElementException();
                    flags.setOutputFileName(list.get(list.size() - 1));
                }
                if (list.get(list.indexOf(arg) + 1).equals(list.get(list.indexOf(arg) + 1))) {
                    flags.setOutputFileName(list.get(list.indexOf(arg) + 1));
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
            if (arg.matches("[1234567890]")) {
                flags.setNum(Integer.parseInt(arg));
            }
            if (list.get(list.size() - 1).equals("")) throw new NoSuchElementException();
            else {
                flags.setInputFileName(list.get(list.size() - 1));
            }
        }
        flags.SplitText();
        in.close();

    }
}