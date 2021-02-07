package com.sparta.kurtis.linkedlists.singly;

import com.sparta.kurtis.Printer;
import com.sparta.kurtis.linkedlists.Example;

public class SinglyExamples extends Example {
    public void examples() {

        // TODO: format examples and method calls
        SinglyLinkedList tubeStations = new SinglyLinkedList();
        String station1 = "Euston";

        // A
        Printer.printMessage("\nA) Hopping on the Northern Line...");
        tubeStations.add(station1);
        tubeStations.add("King's Cross");
        tubeStations.add("Angel");
        tubeStations.add("Old Street");
        tubeStations.add("Moorgate");
        tubeStations.add("Bank");
        tubeStations.add("London Bridge");
        tubeStations.add("Borough");
        tubeStations.add("Elephant Castle");
        Printer.printMessage(tubeStations.toString());

        // B
        Printer.printMessage("Number of stops: " + tubeStations.size());
        Printer.printMessage("\nB) Temporary closures at '" + tubeStations.removeFirst() + "', line starting at '" + tubeStations.get(0) + "' instead:");
        Printer.printMessage(tubeStations.toString());
        Printer.printMessage("Updated number of stops: " + tubeStations.size());

        // C
        Printer.printMessage("\nC) '" + station1 + "' reopened:");
        tubeStations.addFirst(station1);
        System.out.println(tubeStations.toString());

        // D
        Printer.printMessage("\nD) Rush hour, no space for anyone waiting at '" + tubeStations.remove(1) + "', thus getting skipped:");
        Printer.printMessage(tubeStations.toString());

        // E
        String station2 = "Warren Street";
        Printer.printMessage("\nE) New station '" + station2 + "' being added to the line:");
        tubeStations.add(1, station2);
        Printer.printMessage(tubeStations.toString());

        // F
        String station3 = "Goodge Street";
        Printer.printMessage("\nF) '" + station3 + "' closing down due to vandalism and riots:");
        Printer.printMessage(tubeStations.toString());

        // G
        int stationIndex = 2;
        String newStationName = "Tottenham Court Road";
        Printer.printMessage("\nG) Bojo passed a law to change one of the stations name from '" + tubeStations.get(stationIndex) + "' to '" + newStationName + "':");
        tubeStations.set(stationIndex, newStationName);
        Printer.printMessage(tubeStations.toString());
    }
}
