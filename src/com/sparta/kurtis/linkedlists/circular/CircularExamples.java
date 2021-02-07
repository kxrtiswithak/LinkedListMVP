package com.sparta.kurtis.linkedlists.circular;

import com.sparta.kurtis.Printer;
import com.sparta.kurtis.linkedlists.Example;

public class CircularExamples extends Example {

    //TODO: come up with some examples, consult powerpoint
    @Override
    public void examples() {
        CircularLinkedList monopolyBoard = new CircularLinkedList();
        CircularLinkedList monopolyBoard2 = new CircularLinkedList();

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

        monopolyBoard.addFirst(monopolySpace2);
        monopolyBoard.addFirst(monopolySpace1);
        monopolyBoard.add(monopolySpace3);
        monopolyBoard.add(monopolySpace4);
        monopolyBoard.add(monopolySpace5);
        monopolyBoard.add(monopolySpace6);
        monopolyBoard.add(monopolySpace7);
        monopolyBoard.add(monopolySpace8);
        monopolyBoard.add(monopolySpace9);
        monopolyBoard.add(monopolySpace10);
        monopolyBoard.add(monopolySpace11);
        monopolyBoard.add(monopolySpace12);
        monopolyBoard.add(monopolySpace13);
//        monopolyBoard.add(2, monopolySpace2);

        Printer.printStringCircularLinkedList(monopolyBoard, 2);
        Printer.printMessage("Size: " + monopolyBoard.size());

        Printer.printMessage("Removed: " + monopolyBoard.removeLast());

        Printer.printStringCircularLinkedList(monopolyBoard, 1);
        Printer.printMessage("Size: " + monopolyBoard.size());

        monopolyBoard.remove(monopolySpace5);
        Printer.printMessage("Removed: " + monopolyBoard.remove(3));
        Printer.printStringCircularLinkedList(monopolyBoard, 1);
        Printer.printMessage("Removed: " + monopolyBoard.remove());
        Printer.printMessage("Removed: " + monopolyBoard.remove());
        Printer.printMessage("Removed: " + monopolyBoard.remove());
        Printer.printMessage("Removed: " + monopolyBoard.remove());
        Printer.printMessage("Removed: " + monopolyBoard.remove());
        Printer.printMessage("Removed: " + monopolyBoard.remove());
        Printer.printMessage("Removed: " + monopolyBoard.remove());
        Printer.printMessage("Removed: " + monopolyBoard.remove());
        Printer.printMessage("Removed: " + monopolyBoard.remove());
        Printer.printMessage("Removed: " + monopolyBoard.remove());
        Printer.printStringCircularLinkedList(monopolyBoard, 1);
    }
}
