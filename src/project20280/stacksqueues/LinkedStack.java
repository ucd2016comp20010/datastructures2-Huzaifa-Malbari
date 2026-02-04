package project20280.stacksqueues;

import project20280.interfaces.Stack;
import project20280.list.DoublyLinkedList;

public class LinkedStack<E> implements Stack<E> {

    DoublyLinkedList<E> ll;

    public static void main(String[] args) {
    }

    public LinkedStack() {
        // TODO
        ll = new DoublyLinkedList<E>();
    }

    @Override
    public int size() {
        return ll.size();
    }

    @Override
    public boolean isEmpty() {
        return ll.isEmpty();
    }

    @Override
    public void push(E e) {
        // TODO
        ll.addFirst(e);
    }

    @Override
    public E top() {
        // TODO
        return ll.get(0);
    }

    @Override
    public E pop() {
        // TODO
        E data = top();
        ll.removeFirst();
        return data;
    }

    public String toString() {
        return ll.toString();
    }
}
