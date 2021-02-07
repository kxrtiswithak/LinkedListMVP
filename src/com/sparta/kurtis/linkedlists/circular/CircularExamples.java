package com.sparta.kurtis.linkedlists.circular;

import com.sparta.kurtis.Printer;
import com.sparta.kurtis.linkedlists.Example;

public class CircularExamples extends Example {

    //TODO: come up with some examples, consult powerpoint
    @Override
    public void examples() {
        CircularLinkedList monopoly = new CircularLinkedList();
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

        monopoly.add(monopolySpace1);
        monopoly.add(monopolySpace2);
        monopoly.add(monopolySpace3);
        monopoly.add(monopolySpace4);
        monopoly.add(monopolySpace5);
        monopoly.add(monopolySpace6);
        monopoly.add(monopolySpace7);
        monopoly.add(monopolySpace8);
        monopoly.add(monopolySpace9);
        monopoly.add(monopolySpace10);
        monopoly.add(monopolySpace11);
        monopoly.add(monopolySpace12);
        monopoly.add(monopolySpace13);

        Printer.printStringCircularLinkedList(monopoly, 2);
    }
}
