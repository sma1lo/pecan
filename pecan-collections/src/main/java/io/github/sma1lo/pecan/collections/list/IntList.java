package io.github.sma1lo.pecan.collections.list;

public class IntList {
    private int[] elements;
    private int size;

    public IntList(int initialCapacity) {
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
                int moved = size - i - 1;

                if (moved > 0) {
                    System.arraycopy(elements, i + 1, elements, i, moved);
                }

                size--;
                return true;
            }
        }

        return false;
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
        int newCapacity = elements.length == 0 ? 10 : elements.length * 2;

        int[] newElements = new int[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);

        elements = newElements;
    }
}