import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    private static class Node<T> {
        T item;
        Node<T> next;
        Node<T> prev;

        public Node(Node<T> p, T i, Node<T> n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node<T> sentinel;
    private int size;

    public LinkedListDeque61B() {
        sentinel = new Node<>(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node<T> oldFirst = sentinel.next;
        Node<T> newNode = new Node(sentinel, x, oldFirst);
        sentinel.next = newNode;
        oldFirst.prev = newNode;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        Node<T> oldLast = sentinel.prev;
        Node<T> newNode = new Node(oldLast, x, sentinel);
        oldLast.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node<T> p = sentinel;
        while (p.next != sentinel) {
            p = p.next;
            returnList.add(p.item);
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        Node<T> firstNode = sentinel.next;
        Node<T> secondNode = sentinel.next.next;
        firstNode.next = null;
        firstNode.prev = null;
        secondNode.prev = sentinel;
        sentinel.next = secondNode;
        return firstNode.item;
    }

    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        size -= 1;
        Node<T> secondLastNode = sentinel.prev.prev;
        Node<T> lastNode = sentinel.prev;
        lastNode.next = null;
        lastNode.prev = null;
        sentinel.prev = secondLastNode;
        secondLastNode.next = sentinel;
        return lastNode.item;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        Node<T> p = sentinel;
        int count = -1;
        while (p.next != sentinel) {
            p = p.next;
            count += 1;
            if (count == index) {
                return p.item;
            }
        }
        return null;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        if (index == 0) {
            return sentinel.next.item;
        }
        sentinel = sentinel.next;
        return getRecursive(index - 1);
    }
}
