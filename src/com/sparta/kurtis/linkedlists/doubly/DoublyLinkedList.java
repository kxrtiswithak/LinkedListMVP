package com.sparta.kurtis.linkedlists.doubly;

import com.sparta.kurtis.Printer;
import com.sparta.kurtis.linkedlists.Example;

import java.util.LinkedList;

public class DoublyLinkedList extends Example {
    private static LinkedList<String> browserHistory = new LinkedList<>();

    public void examples() {
        Printer.printMessage("\nBrowsing internet...");
        browserHistory.add("medium.com");
        browserHistory.add("stackoverflow.com");
        browserHistory.add("mail.google.com");
        browserHistory.add("stackoverflow.com");
        browserHistory.add("docs.oracle.com");
        browserHistory.add("teamtreehouse.com");
        browserHistory.add("stackoverflow.com");
        browserHistory.add("duckduckgo.com");

        Printer.printMessage("\nGoing back to " + browserHistory.getFirst() + ":");
        Printer.printStringLinkedListReverse(browserHistory);

        Printer.printMessage("\nGoing forward to " + browserHistory.getLast() + ":");
        Printer.printStringLinkedList(browserHistory);

        String website = "stackoverflow.com";
        Printer.printMessage("\nis '" + website + "' in my history?\n"
                + browserHistory.contains(website));

        Printer.printMessage("\nremoving FIRST occurrence of '" + website + "':");
        browserHistory.removeFirstOccurrence(website);
        Printer.printStringLinkedList(browserHistory);

        Printer.printMessage("\nremoving LAST occurrence of '" + website + "':");
        browserHistory.removeLastOccurrence(website);
        Printer.printStringLinkedList(browserHistory);

        Printer.printMessage("\nadding two occurrences of '" + website + "' back from where I removed them:");
        browserHistory.add(1, website);
        browserHistory.add(6, website);
        Printer.printStringLinkedList(browserHistory);

        String website2 = "teamtreehouse.com";
        String website3 = "premierleague.com";
        int website2Index = browserHistory.indexOf(website2);
        Printer.printMessage("\nreplacing '" + website2 + "' with '" + website3 + "':");
        browserHistory.set(website2Index, website3);
        Printer.printStringLinkedList(browserHistory);

    }

}
