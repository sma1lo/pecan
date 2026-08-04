package io.github.sma1lo.pecan.collections.list;

public class FloatList {
    private float[] elements;
    private int size;

    public FloatList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }

        elements = new float[initialCapacity];
    }

    public FloatList() {
        this(10);
    }

    public void add(float value) {
        if (size == elements.length) {
            grow();
        }

        elements[size++] = value;
    }

    public boolean remove(float value) {
        for (int i = 0; i < size; i++) {
            if (Float.compare(elements[i], value) == 0) {
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

    public float get(int index) {
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

        float[] newElements = new float[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);

        elements = newElements;
    }
}