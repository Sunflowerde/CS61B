package deque;

import net.sf.saxon.expr.Component;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayDeque61B<T> implements Deque61B<T> {
    // 底层数组
    private T[] items;
    // The number of item in items
    private int size;
    // Point to the next item to addFirst
    private int nextFront;
    // Point to the next item to addLast
    private int nextBack;

    // constructor
    public ArrayDeque61B() {
        items = (T[]) new Object[8];
        size = 0;
        nextFront = items.length - 1;
        nextBack = 0;
    }

    private void resize(int newCapacity) {
        T[] newItems = (T[]) new Object[newCapacity];
        int first = Math.floorMod(nextFront + 1, items.length);
        for (int i = 0; i < size; ++i) {
            newItems[i] = items[first];
            first = Math.floorMod(first + 1, items.length);
        }
        items = newItems;
        nextFront = items.length - 1;
        nextBack = size;
    }

    @Override
    public void addFirst(T x) {
        if (size == items.length) {
            resize(2 * size);
        }
        items[nextFront] = x;
        size += 1;
        nextFront = Math.floorMod(nextFront - 1, items.length);
    }

    @Override
    public void addLast(T x) {
        if (size == items.length) {
            resize(2 * size);
        }
        items[nextBack] = x;
        size += 1;
        nextBack = Math.floorMod(nextBack + 1, items.length);
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        int step = 0;
        while (step < size) {
            returnList.add(get(step));
            step += 1;
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
        if (isEmpty()) {
            return null;
        }
        int removeIndex = Math.floorMod(nextFront + 1, items.length);
        nextFront = removeIndex;
        T removeItem = items[removeIndex];
        items[removeIndex] = null;
        size -= 1;
        if (4 * size < items.length && items.length >= 16) {
            resize(items.length / 2);
        }
        return removeItem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        int removeIndex = Math.floorMod(nextBack - 1, items.length);
        T removeItem = items[removeIndex];
        items[removeIndex] = null;
        nextBack = removeIndex;
        size -= 1;
        if (4 * size < items.length && items.length >= 16) {
            resize(items.length / 2);
        }
        return removeItem;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        int front = Math.floorMod(nextFront + 1, items.length);
        int step = 0;
        while (step != index) {
            step += 1;
            front = Math.floorMod(front + 1, items.length);
        }
        return items[front];
    }

    @Override
    public T getRecursive(int index) {
        throw new UnsupportedOperationException("No need to implement getRecursive for proj1b");
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayDeque61BIterator();
    }

    private class ArrayDeque61BIterator implements Iterator<T> {
        int curPos = Math.floorMod(nextFront + 1, items.length);
        int step = 1;

        @Override
        public boolean hasNext() {
            return step <= size;
        }

        @Override
        public T next() {
            T returnItem = items[curPos];
            step += 1;
            curPos = Math.floorMod(curPos + 1, items.length);
            return returnItem;
        }
    }
}