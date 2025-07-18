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
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
