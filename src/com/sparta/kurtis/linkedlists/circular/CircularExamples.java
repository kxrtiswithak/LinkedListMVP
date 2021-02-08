package com.sparta.kurtis.linkedlists.circular;

import com.sparta.kurtis.Printer;
import com.sparta.kurtis.linkedlists.Example;

public class CircularExamples extends Example {

    @Override
    public void examples() {
        CircularLinkedList monopolyBoard = new CircularLinkedList();

        String monopolySpace1 = "Go";
        String monopolySpace2 = "Old Kent Road";
        String monopolySpace3 = "King's Cross Station";
        String monopolySpace4 = "Euston Road";
        String monopolySpace5 = "Whitehall";
        String monopolySpace6 = "Marylebone Station";
        String monopolySpace7 = "Bow Street";
        String monopolySpace8 = "Trafalgar Square";
        String monopolySpace9 = "Fenchurch Street Station";
        String monopolySpace10 = "Picadilly";
        String monopolySpace11 = "Bond Street";
        String monopolySpace12 = "Liverpool Street Station";
        String monopolySpace13 = "Mayfair";

        //A
        Printer.printMessage("A) Setting the board up...");
        monopolyBoard.add(monopolySpace3);
        monopolyBoard.addFirst(monopolySpace1);
        monopolyBoard.add(monopolySpace4);
        monopolyBoard.add(monopolySpace5);
        monopolyBoard.add(1, monopolySpace2);
        Printer.printMessage("Going round the board twice...");
        Printer.printStringCircularLinkedList(monopolyBoard, 2);

        //B
        String monopolySpaceUpdate = "Waterloo Station";
        Printer.printMessage("B) Changing station name to keep people on their toes...");
        Printer.printMessage("From " + monopolyBoard.get(2) + " to " + monopolySpaceUpdate);
        monopolyBoard.set(2, monopolySpaceUpdate);
        Printer.printStringCircularLinkedList(monopolyBoard, 1);

        //C
        Printer.printStringCircularLinkedList(monopolyBoard, 1);

        //D
        monopolyBoard.remove(monopolySpace5);
        Printer.printMessage("They told us to try again this way, who are we dispute them?");
        monopolyBoard.remove(-1);
        Printer.printStringCircularLinkedList(monopolyBoard, 1);

        //E
        Printer.printInt(monopolyBoard.indexOf(monopolySpace1));
        Printer.printMessage("Index of" + monopolySpace12 + " is:");
        Printer.printInt(monopolyBoard.indexOf(monopolySpace12));
        Printer.printMessage("Index of 'hello' is:");

        //F
        Printer.printMessage("\nE) board was destroyed in 'accidental' table flipping...");
        monopolyBoard.clear();
        Printer.printStringCircularLinkedList(monopolyBoard, 1);
    }
}
