package project20280.stacksqueues;

import project20280.interfaces.Queue;
import project20280.list.DoublyLinkedList;

public class LinkedQueue<E> implements Queue<E> {

    private DoublyLinkedList<E> ll;

    public static void main(String[] args) {
    }

    public LinkedQueue() {
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
    public void enqueue(E e) {
        // TODO
        ll.addLast(e);
    }

    @Override
    public E first() {
        // TODO
        return ll.get(0);
    }

    @Override
    public E dequeue() {
        // TODO
        E dataE = first();
        ll.removeFirst();
        return dataE;
    }

    public String toString() {
        return ll.toString();
    }
}
