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
    public void add(int index, String data) {
        Node newNode = new Node(data);
            if (getHead() == null) {
                setHead(newNode);
                setTail(newNode);
            } else if (size() < index || index < 0) {
                Printer.printErrorMessage("Index out of bounds");
            } else {
                Node current = getHead();
                int count = 0;
                while (count < index - 1) {
                    current = current.next;
                    count++;
                }
                newNode.next = current.next;
                current.next = newNode;
            }
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
    public String remove(int index) {
        String removed = null;
        if (getHead() == null) {
            Printer.printErrorMessage("List is empty");
        } else if (size() < index || index < 0) {
            Printer.printErrorMessage("Index out of bounds");
        } else {
            if (getHead() == getTail()) {
                setHead(null);
                setTail(null);
            } else {
                Node current = getHead();
                int count = 0;
                while (count < index - 1) {
                    current = current.next;
                    count++;
                }
                removed = current.next.data;
                current.next = current.next.next;

            }
        }
        return removed;
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
    public String set(int index, String data) {
        String previous = null;
        if (getHead() == null) {
            Printer.printErrorMessage("List is empty");
        } else {
            if (size() < index || index < 0) {
                Printer.printErrorMessage("Index out of bounds");
            } else {
                Node current = getHead();
                int count = 0;
                while (count < index) {
                    current = current.next;
                    count++;
                }
                previous = current.data;
                current.data = data;
            }
        }
        return previous;
    }

    @Override
    public String get(int index) {
        String previous = null;
        if (getHead() == null) {
            Printer.printErrorMessage("List is empty");
        } else {
            if (size() < index || index < 0) {
                Printer.printErrorMessage("Index out of bounds");
            } else {
                Node current = getHead();
                int count = 0;
                while (count < index) {
                    current = current.next;
                    count++;
                }
                previous = current.data;
            }
        }
        return previous;
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

    public int indexOf(String data) {
        if (getHead() == null) {
            Printer.printErrorMessage("List is empty");
            return -1;
        } else {
            int index = 0;
            if (size() < index) {
                Printer.printErrorMessage("Index out of bounds");
                return -1;
            } else {
                Node current = getHead();
                index = 0;
                do {
                    if (current.data == data) {
                        return index;
                    }
                    index++;
                    current = current.next;
                } while (current != getHead());
            }
        }
        Printer.printErrorMessage(data + " is not in the list.");
        return -1;
    }

    public void clear() {
        int fullSize = size();
        if (getHead() == null) {
            Printer.printErrorMessage("List is empty");
        } else {
            for(int count = 0; count < fullSize; count++) {
                remove();
            }
        }
    }
}
