package deque;

import net.sf.saxon.expr.Component;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayDeque;
import java.util.ArrayList;
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

    @Override
    public void addFirst(T x) {
        items[nextFront] = x;
        size += 1;
        nextFront = Math.floorMod(nextFront - 1, items.length);
    }

    @Override
    public void addLast(T x) {
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
        size -= 1;
        int removeIndex = Math.floorMod(nextFront + 1, items.length);
        nextFront = removeIndex;
        T removeItem = items[removeIndex];
        items[removeIndex] = null;
        return removeItem;
    }

    @Override
    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        size -= 1;
        int removeIndex = Math.floorMod(nextBack - 1, items.length);
        T removeItem = items[removeIndex];
        items[removeIndex] = null;
        nextBack = removeIndex;
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
}
