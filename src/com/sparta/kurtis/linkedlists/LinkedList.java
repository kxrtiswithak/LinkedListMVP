package com.sparta.kurtis.linkedlists;

import com.sparta.kurtis.Printer;

// basically copied https://www.javatpoint.com/java-programs#singly-linked-list-programs
// https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html#set(int,E)
// TODO: add javadocs comments for each method
// TODO: indexOf, clear, clone
// TODO: iterate to certain index
// TODO: getFirst, getLast


public abstract class LinkedList {
    private Node head = null;
    private Node tail = null;

    public boolean add(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            return false;
        } else {
            tail.next = newNode;
            tail = newNode;
            return true;
        }
    }

    public void add(int index, String data) {
        Node newNode = new Node(data);

        int count = 0;
        if (head == null) {
            Printer.printErrorMessage("List is empty");
        } else {
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
                add(data);
            }
        }
    }

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

    public void addLast(String data) {
        add(data);
    }

    public void remove() {
        if (head == null) {
            Printer.printErrorMessage("list is empty");
        } else {
            if (size() > 0) {
                head = head.next;
            } else {
                head = tail = null;
            }
        }
    }

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

    public boolean remove(String item) {
        int count = 0;
        if (head == null) {
            Printer.printErrorMessage("List is empty");
            return false;
        } else {
            if (size() > 0) {
                Node current = head;
                while (current.next != tail) {
                    if (item.equals(current.data)) {
                        remove(count);
                        return true;
                    }
                    current = current.next;
                    count++;
                }
            } else {
                if (item.equals(head.data)) {
                    remove();
                    return true;
                }
            }
        }
        return false;
    }

    public String removeFirst() {
        String first = head.data;
        remove();
        return first;
    }

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

    public void set(int index, String data) {
        int count = 0;
        if (head == null) {
            Printer.printErrorMessage("List is empty");
        } else {
            if (size() > index) {
                Node current = head;
                while (count < index) {
                    current = current.next;
                    count++;
                }
                tail = current;
                tail.data = data;
            } else {
                Printer.printErrorMessage("index out of bounds");
            }
        }
    }

    public String get(int index) {
        int count = 0;
        if (head == null) {
            Printer.printErrorMessage("List is empty");
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
            }
        }
        return null;
    }

    public int size() {
        int count = 0;
        Node current = head;

        while (current != null) {
            count++;
            current = current.next;
        }

        return count;
    }

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

    public String[] toArray() {
        String[] linkedListArray = new String[size()];
        for (int i = 0; i < linkedListArray.length; i++) {
            linkedListArray[i] = get(i);
        }

        return linkedListArray;
    }
}
