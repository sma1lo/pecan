package io.github.sma1lo.pecan.collections.list;

public class ByteList {
    private byte[] elements;
    private int size;

    public ByteList(int initialCapacity) {
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }

        elements = new byte[initialCapacity];

    }

    public ByteList() {
        this(10);
    }

    public void add(byte value) {
        if (size == elements.length) {
            grow();
        }

        elements[size++] = value;
    }

    public boolean remove(byte value) {
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

    public byte get(int index) {
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

        byte[] newElements = new byte[newCapacity];
        System.arraycopy(elements, 0, newElements, 0, size);

        elements = newElements;
    }
}