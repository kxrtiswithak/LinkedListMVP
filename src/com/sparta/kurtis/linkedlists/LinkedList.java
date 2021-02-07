package com.sparta.kurtis.linkedlists;

import com.sparta.kurtis.Printer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.List;

// basically copied https://www.javatpoint.com/java-programs#singly-linked-list-programs
// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html#set(int,E)
// TODO: indexOf, clear, clone
// TODO: iterate to certain index
// TODO: getFirst, getLast

/**
 * Singly-linked list abstract implementation. Only permits {@code String}
 * elements (including {@code null}).
 *
 * <p>All of the operations perform as could be expected for a singly-linked
 * list.  Operations that index into the list will traverse the list from
 * the beginning only.
 *
 * @author  Kurtis Hanson
 */
public abstract class LinkedList {
    private Node head = null;
    private Node tail = null;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    /**
     * Appends the specified string element to the end of this list.
     *
     * <p>This method is equivalent to {@link #addLast}.
     *
     * @param data element to be appended to this list
     * @return {@code true}
     */
    public boolean add(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        return true;
    }

    /**
     * Inserts the specified string element at the specified position in this list.
     * Shifts the element currently at that position (if any) and any
     * subsequent elements to the right (adds one to their indices).
     * Prints error message if index out of bounds.
     *
     * @param index index at which the specified element is to be inserted
     * @param data element to be inserted
     */
    public void add(int index, String data) {
        Node newNode = new Node(data);

        int count = 0;
        if (size() > index) {
            Node current = head;
            while (count < index - 1) {
                current = current.next;
                count++;
            }
            newNode.next = current.next;
            current.next = newNode;
            tail = current;
        } else {
            Printer.printErrorMessage("index out of bounds");
        }
    }

    /**
     * Inserts the specified string element at the beginning of this list.
     *
     * @param data the element to add
     */
    public void addFirst(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            Node temp = head;
            head = newNode;
            head.next = temp;
        }
    }

    /**
     * Appends the specified string element to the end of this list.
     *
     * <p>This method is equivalent to {@link #add}.
     *
     * @param data the element to add
     */
    public void addLast(String data) {
        add(data);
    }

    /**
     * Retrieves and removes the head (first string element) of this list.
     * Prints error message if list is empty
     *
     * <p>This method is equivalent to {@link #removeFirst()}.
     *
     * @return the head of this list
     */
    public String remove() {
        String removed = head.data;
        if (head == null) {
            Printer.printErrorMessage("list is empty");
        } else {
            if (size() > 0) {
                head = head.next;
            } else {
                head = tail = null;
            }
        }
        return removed;
    }

    /**
     * Removes the string element at the specified position in this list.  Shifts any
     * subsequent elements to the left (subtracts one from their indices).
     * Returns the element that was removed from the list.
     * Prints error message and returns null if list is empty.
     *
     * @param index the index of the element to be removed
     * @return the element previously at the specified position
     */
    public String remove(int index) {
        String removed;
        int count = 0;
        if (head == null) {
            Printer.printErrorMessage("List is empty");
            return null;
        } else {
            if (size() > 0) {
                Node current = head;
                while (count < index - 1) {
                    current = current.next;
                    count++;
                }
                tail = current;
                removed = current.next.data;
                tail.next = current.next.next;
            } else {
                removed = tail.next.data;
                head = tail = null;
            }
        }
        return removed;
    }

    /**
     * Removes the first occurrence of the specified element from this list,
     * if it is present.  If this list does not contain the element, it is
     * unchanged.  More formally, removes the element with the lowest index
     * {@code i} such that
     * {@code Objects.equals(o, get(i))}
     * (if such an element exists).  Returns {@code true} if this list
     * contained the specified element (or equivalently, if this list
     * changed as a result of the call).
     *
     * @param data element to be removed from this list, if present
     * @return {@code true} if this list contained the specified element
     */
    public boolean remove(String data) {
        int count = 0;
        if (head == null) {
            Printer.printErrorMessage("List is empty");
            return false;
        } else {
            if (size() > 0) {
                Node current = head;
                while (current.next != tail) {
                    if (data.equals(current.data)) {
                        remove(count);
                        return true;
                    }
                    current = current.next;
                    count++;
                }
            } else {
                if (data.equals(head.data)) {
                    remove();
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     * Prints error message if list is empty
     *
     * <p>This method is equivalent to {@link #remove()}.
     *
     * @return the head of this list
     */
    public String removeFirst() {
        return remove();
    }

    /**
     * Removes and returns the last string element from this list.
     * Prints error message and returns null if list is empty.
     *
     * @return the last element from this list
     */
    public String removeLast() {
        String last;
        if (head == null) {
            Printer.printErrorMessage("List is empty");
            return null;
        } else {
            if (size() > 0) {
                Node current = head;
                while (current.next != tail) {
                    current = current.next;
                }
                tail = current;
                last = tail.next.data;
                tail.next = null;
            } else {
                last = tail.next.data;
                head = tail = null;
            }
        }
        return last;
    }

    /**
     * Replaces the string element at the specified position in this list with the
     * specified string element.
     * Prints error message and returns null if list is empty or index out of bounds.
     *
     * @param index index of the element to replace
     * @param data element to be stored at the specified position
     * @return the element previously at the specified position
     */
    public String set(int index, String data) {
        String previous;
        int count = 0;
        if (head == null) {
            Printer.printErrorMessage("List is empty");
            return null;
        } else {
            if (size() > index) {
                Node current = head;
                while (count < index) {
                    current = current.next;
                    count++;
                }
                tail = current;
                previous = tail.data;
                tail.data = data;
            } else {
                Printer.printErrorMessage("index out of bounds");
                return null;
            }
        }
        return previous;
    }

    /**
     * Returns the string element at the specified position in this list.
     * Prints error message and returns null if list is empty or index out of bounds.
     *
     * @param index index of the element to return
     * @return the element at the specified position in this list
     */
    public String get(int index) {
        int count = 0;
        if (head == null) {
            Printer.printErrorMessage("List is empty");
            return null;
        } else {
            if (size() > index) {
                Node current = head;
                while (count < index) {
                    current = current.next;
                    count++;
                }
                return current.data;
            } else {
                Printer.printErrorMessage("index out of bounds");
                return null;
            }
        }
    }

    /**
     * Returns the number of elements in this list.
     * Prints error message and returns null if list is empty.
     *
     * @return the number of elements in this list
     */
    public int size() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

    /**
     * Returns a formatted string representation of the contents of the list.
     *
     * @return a formatted string representation of the list
     */
    @Override
    public String toString() {
        Node current = head;
        StringBuilder linkedListString = new StringBuilder();
        int count = 1;

        if (head == null) {
            Printer.printErrorMessage("list is empty");
            return linkedListString.toString();
        }

        linkedListString.append("\n================\n\n");
        while (current != null) {
            linkedListString.append(String.format("%d: %s\n",
                    count, current.data));
            current = current.next;
            count++;
        }
        linkedListString.append("\n================\n");

        return String.valueOf(linkedListString);
    }

    /**
     * Returns an array containing all of the elements in this list
     * in proper sequence (from first to last element).
     *
     * <p>The returned array will be "safe" in that no references to it are
     * maintained by this list.  (In other words, this method must allocate
     * a new array).  The caller is thus free to modify the returned array.
     *
     * <p>This method acts as bridge between array-based and collection-based
     * APIs.
     *
     * @return an array containing all of the elements in this list
     *         in proper sequence
     */
    public String[] toArray() {
        String[] linkedListArray = new String[size()];
        for (int i = 0; i < linkedListArray.length; i++) {
            linkedListArray[i] = get(i);
        }

        return linkedListArray;
    }
}
