package com.sparta.kurtis.linkedlists.circular;

import com.sparta.kurtis.Printer;
import com.sparta.kurtis.linkedlists.LinkedList;
import com.sparta.kurtis.linkedlists.Node;

public class CircularLinkedList extends LinkedList {

    @Override
    public boolean add(String data) {
        Node newNode = new Node(data);
        if (this.getHead() == null) {
            setHead(newNode);
        } else {
            getTail().setNext(newNode);
        }
        setTail(newNode);
        newNode.setNext(getHead());
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
                    current = current.getNext();
                    count++;
                }
                newNode.setNext(current.getNext());
                current.setNext(newNode);
            }
    }

    @Override
    public void addFirst(String data) {
        Node newNode = new Node(data);
        if (this.getHead() == null) {
            setTail(newNode);

        } else {
            newNode.setNext(getHead());
        }
        setHead(newNode);
        getTail().setNext(getHead());
    }

    @Override
    public String remove() {
        String removed = null;
        if (getHead() == null) {
            Printer.printErrorMessage("List is empty");
        } else {
            removed = getHead().getData();
            if (getHead() == getTail()) {
                setHead(null);
                setTail(null);
            } else {
                setHead(getHead().getNext());
                getTail().setNext(getHead());
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
                    current = current.getNext();
                    count++;
                }
                removed = current.getNext().getData();
                current.setNext(current.getNext().getNext());

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
                removed = getHead().getData();
                setTail(null);
                setHead(null);
            } else {
                Node current = getHead();
                while (current.getNext() != getTail()) {
                    current = current.getNext();
                }
                removed = current.getNext().getData();
                setTail(current);
                getTail().setNext(getHead());
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
                    current = current.getNext();
                    count++;
                }
                previous = current.getData();
                current.setData(data);
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
                    current = current.getNext();
                    count++;
                }
                previous = current.getData();
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
                current = current.getNext();
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
                    if (current.getData() == data) {
                        return index;
                    }
                    index++;
                    current = current.getNext();
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
