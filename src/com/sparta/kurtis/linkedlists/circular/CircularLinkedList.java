package com.sparta.kurtis.linkedlists.circular;

import com.sparta.kurtis.Printer;
import com.sparta.kurtis.linkedlists.LinkedList;
import com.sparta.kurtis.linkedlists.Node;

public class CircularLinkedList extends LinkedList {

    //TODO: override necessary methods (add, remove, size maybe)

    @Override
    public boolean add(String data) {
        Node newNode = new Node(data);
        if (this.getHead() == null) {
            setHead(newNode);
        } else {
            getTail().next = newNode;
        }
        setTail(newNode);
        newNode.next = getHead();
        return true;
    }

    @Override
    public String remove() {
        String removed = null;
        if (size() < 1) {
            Printer.printErrorMessage("List is empty");
        } else {
            if (getHead() == getTail()) {
                removed = getHead().data;
                setTail(null);
                setHead(null);
            } else {
                Node current = getHead();
                while (current.next != getTail()) {
                    current = current.next;
                }
                removed = current.next.data;
                setTail(current);
                getTail().next = getHead();
            }
        }
        return removed;
    }

    @Override
    public int size() {
        int count = 0;
        Node current = getHead();
        if (getHead() == null && getTail() == null) {
            return count;
//        } else if (getHead() == getTail()) {
//            count = 1;
        } else {
            do {
                count++;
                current = current.next;
            } while (current != getHead());
        }

        return count;
    }
}
