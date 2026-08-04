package io.github.sma1lo.pecan.collections.list;

public class DoubleList {
    private double[] elements;
    private int size;

    public DoubleList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }

        elements = new double[initialCapacity];

    }

    public DoubleList() {
        this(10);
    }

    public void add(double value) {
        if (size == elements.length) {
            grow();
        }

        elements[size++] = value;
    }

    public boolean remove(double value) {
        for (int i = 0; i < size; i++) {
            if (Double.compare(elements[i], value) == 0) {
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

    public double get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(index);
        }

        return elements[index];
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

        double[] newElements = new double[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);

        elements = newElements;
    }
}