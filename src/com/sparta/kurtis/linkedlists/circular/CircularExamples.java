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
        monopolyBoard.add(monopolySpace3);
        monopolyBoard.addFirst(monopolySpace1);
        monopolyBoard.add(monopolySpace4);
        monopolyBoard.add(monopolySpace5);
        monopolyBoard.add(1, monopolySpace2);
        Printer.printStringCircularLinkedList(monopolyBoard, 2);

        //B
        monopolyBoard.set(2, "Waterloo Station");
        monopolyBoard.get(2);
        Printer.printStringCircularLinkedList(monopolyBoard, 1);

        //C
        monopolyBoard.removeLast();
        Printer.printStringCircularLinkedList(monopolyBoard, 1);

        //D
        monopolyBoard.remove(monopolySpace5);
        monopolyBoard.remove(-1);
        Printer.printStringCircularLinkedList(monopolyBoard, 1);

        //E
        monopolyBoard.indexOf(monopolySpace1);
        monopolyBoard.indexOf(monopolySpace12);
        monopolyBoard.indexOf("hello");

        //F
        monopolyBoard.clear();
        Printer.printStringCircularLinkedList(monopolyBoard, 1);
    }
}
