package io.github.sma1lo.pecan.collections.list;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class IntList {
    private int[] elements;
    private int size;

    public IntList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        elements = new int[initialCapacity];
    }

    public IntList() {
        this(10);
    }

    public void add(int value) {
        if (size == elements.length) {
            grow();
        }
        elements[size++] = value;
    }

    public boolean remove(int value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                fastRemove(i);
                return true;
            }
        }
        return false;
    }

    public int removeByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        int oldValue = elements[index];
        fastRemove(index);
        return oldValue;
    }

    private void fastRemove(int index) {
        int moved = size - index - 1;
        if (moved > 0) {
            System.arraycopy(elements, index + 1, elements, index, moved);
        }
        size--;
    }

    public int removeLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        int lastIndex = size - 1;
        int oldValue = elements[lastIndex];
        size--;
        return oldValue;
    }

    public int removeFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        int oldValue = elements[0];
        fastRemove(0);
        return oldValue;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return elements[index];
    }

    public int getFirst() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return elements[0];
    }

    public int getLast() {
        if (size == 0) {
            throw new NoSuchElementException("List is empty");
        }
        return elements[size - 1];
    }

    @Override
    public IntList clone() {
        try {
            IntList v = (IntList) super.clone();
            v.elements = Arrays.copyOf(elements, elements.length);
            return v;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        size = 0;
    }

    private void grow() {
        int newCapacity = elements.length == 0 ? 10 : elements.length * 2;
        int[] newElements = new int[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);
        elements = newElements;
    }
}
