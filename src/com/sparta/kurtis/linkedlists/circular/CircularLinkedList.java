package com.sparta.kurtis.linkedlists.circular;

import com.sparta.kurtis.linkedlists.Node;
import com.sparta.kurtis.linkedlists.singly.SinglyLinkedList;

public class CircularLinkedList extends SinglyLinkedList {

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
}
