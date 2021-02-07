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
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (this.getHead() == null) {
            setTail(newNode);

        } else {
            newNode.next = getHead();
        }
        setHead(newNode);
        getTail().next = getHead();
    }

    @Override
    public void addLast(String data) {
        this.add(data);
    }

    @Override
    public String remove() {
        String removed = null;
        if (getHead() == null) {
            Printer.printErrorMessage("List is empty");
        } else {
            removed = getHead().data;
            if (getHead() == getTail()) {
                setHead(null);
                setTail(null);
            } else {
                setHead(getHead().next);
                getTail().next = getHead();
            }
        }
        return removed;
    }

    @Override
    public String removeFirst() {
        return remove();
    }

    @Override
    public String removeLast() {
        String removed = null;
        if (getHead() == null) {
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
        } else {
            do {
                count++;
                current = current.next;
            } while (current != getHead());
        }

        return count;
    }
}
