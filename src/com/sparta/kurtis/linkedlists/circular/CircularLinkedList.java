package com.sparta.kurtis.linkedlists.circular;

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
        String removed;
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
        return removed;
    }
}
