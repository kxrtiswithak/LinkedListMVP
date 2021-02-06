package com.sparta.kurtis;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Printer {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printStringLinkedList(List<String> list) {
        System.out.printf("%n================%n%n");
        for (String element : list) {
            System.out.printf("%d: %s%n", list.indexOf(element), element);
        }
        System.out.printf("%n================%n");
    }

    public static void printStringLinkedListReverse(LinkedList<String> list) {
        int count = 1;
        System.out.printf("%n================%n%n");
        Iterator<String> iterator = list.descendingIterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
            System.out.printf("%d: %s%n", list.indexOf(element), element);
            count++;
        }
        System.out.printf("%n================%n");
    }


    public static void printErrorMessage(String message) {
        System.err.println(message);
    }

    public static void printStringArray(String[] stringArray) {
        System.out.println(Arrays.toString(stringArray));
    }
}
