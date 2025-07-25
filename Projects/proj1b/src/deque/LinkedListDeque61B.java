package deque;

import com.github.javaparser.quality.NotNull;

import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {
    @Override
    public boolean equals(Object o) {
        // 检查是否属于同一内存
        if (this == o) {
            return true;
        }
        // 检查是否属于 Deque61B 类
        // 类型转换，确保可以使用类内方法，get, size 等
        if (!(o instanceof Deque61B<?> other)) {
            return false;
        }
        if (this.size != other.size()) {
            return false;
        }
        for (int i = 0; i < other.size(); ++i) {
            if (!(this.get(i) == other.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder returnSB = new StringBuilder("[");
        for (T x : this) {
            returnSB.append(x);
            returnSB.append(", ");
        }
        returnSB.delete(returnSB.length() - 2, returnSB.length());
        returnSB.append("]");
        return returnSB.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListDeque61BIterator();
    }

    private class LinkedListDeque61BIterator implements Iterator<T> {
        private Node curPos;

        public LinkedListDeque61BIterator() {
            curPos = sentinel.next;
        }

        @Override
        public boolean hasNext() {
            return curPos != sentinel;
        }

        @Override
        public T next() {
            T returnItem = curPos.item;
            curPos = curPos.next;
            return returnItem;
        }
    }

    private class Node {
        T item;
        Node next;
        Node prev;

        public Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    private Node sentinel;
    private int size;

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        Node oldFirst = sentinel.next;
        Node newNode = new Node(sentinel, x, oldFirst);
        sentinel.next = newNode;
        oldFirst.prev = newNode;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        Node oldLast = sentinel.prev;
        Node newNode = new Node(oldLast, x, sentinel);
        oldLast.next = newNode;
        sentinel.prev = newNode;
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node p = sentinel;
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
        Node firstNode = sentinel.next;
        Node secondNode = sentinel.next.next;
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
        Node secondLastNode = sentinel.prev.prev;
        Node lastNode = sentinel.prev;
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
        Node p = sentinel;
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
        return getRecursiveHelper(sentinel.next, index - 1);
    }

    private T getRecursiveHelper(Node node, int index) {
        if (index == 0) {
            return node.item;
        }
        return getRecursiveHelper(node.next, index - 1);
    }
}
