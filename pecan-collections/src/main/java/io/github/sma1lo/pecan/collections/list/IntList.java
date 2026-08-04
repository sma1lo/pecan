package io.github.sma1lo.pecan.collections.list;

public class IntList {
    private int[] elements;
    private int size;

    public IntList(int initialCapacity) {
        elements = new int[initialCapacity];
    }

    public void add(int value) {
        if (size == elements.length) {
            grow();
        }

        elements[size++] = value;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        return elements[index];
    }

    public int size() {
        return size;
    }

    private void grow() {
        int[] newElements = new int[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }
}