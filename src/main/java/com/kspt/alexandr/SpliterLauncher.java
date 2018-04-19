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
        //if (!list.get(1).equals("split") || !list.get(1).equals("Split")) throw new NoSuchElementException();
        if (list.get(1).equals("-d")) {
            flags.setD();
        }
        if ((!list.get(2).equals("-i") && !list.get(2).equals("-c") && !list.get(2).equals("-n")) ||
                (list.get(2).equals("-i") && list.get(2).equals("-c")) ||
                (list.get(2).equals("-i") && list.get(2).equals("-n")) ||
                (list.get(2).equals("-n") && list.get(2).equals("-c"))) System.out.println("only one Flag can be used");
        if (list.get(2).equals("-i")) {
            flags.setI();
            if (list.get(3).equals("")) flags.setNum(100);
            flags.setNum(Integer.parseInt(list.get(3)));
        }
        if (list.get(2).equals("-c")) {
            if (list.get(3).equals("")) throw new NoSuchElementException();
            flags.setC();
            flags.setNum(Integer.parseInt(list.get(3)));
        }
        if (list.get(2).equals("-n")) {
            if (list.get(3).equals("")) throw new NoSuchElementException();
            flags.setN();
            flags.setNum(Integer.parseInt(list.get(3)));
        }
        if (!list.get(4).equals("-o")) throw new NoSuchElementException();
        else {
            if (list.get(5).equals("")) {
                flags.setO();
                flags.setOutputFileName("X");
            }
            if (list.get(5).equals("-")) {
                flags.setO();
                flags.setOutputFileName(flags.inputFileName);
            }
            flags.setO();
            flags.setOutputFileName(list.get(5));
        }
        if (list.get(6).equals("")) throw new NoSuchElementException();
        flags.setInputFileName(list.get(6));
        flags.SplitText();
        in.close();

    }
}