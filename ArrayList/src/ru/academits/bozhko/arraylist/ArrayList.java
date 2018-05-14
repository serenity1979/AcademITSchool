package ru.academits.bozhko.arraylist;

import java.util.*;

public class ArrayList<T> implements List<T> {
    @SuppressWarnings("unchecked")
    private T[] items = (T[]) new Object[10];  // элемент списка
    private int listSize; // длина списка
    private int modCount;  //

    public ArrayList() {
        this.items = (T[]) new Object[10];
    }

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        //noinspection unchecked
        this.items = (T[]) new Object[capacity];
    }

    private class MyIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int initialModCount = modCount;

        @Override
        public boolean hasNext() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return currentIndex + 1 < listSize;
        }

        @Override
        public T next() {
            if (currentIndex + 1 > listSize) {
                throw new NoSuchElementException();
            }
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            currentIndex++;
            return items[currentIndex];
        }
    }

    //Возвращает итератор по элементам в этом списке в правильной последовательности.
    public Iterator<T> iterator() {
        return new MyIterator();
    }

    // Возвращает количество элементов в этом списке.
    @Override
    public int size() {
        return listSize;
    }

    // проверка, что список пустой. Возвращает true, если этот список не содержит элементов.
    @Override
    public boolean isEmpty() {
        return listSize == 0;
    }

    // проверка на наличие объекта в списке. Возвращает true, если этот список содержит указанный элемент.
    @Override
    public boolean contains(Object o) {
        return this.indexOf(o) != -1;
    }

    //Возвращает массив, содержащий все элементы в этом списке в правильной последовательности (от первого до последнего элемента).
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    // Возвращает массив, содержащий все элементы в этом списке в правильной последовательности (от первого до последнего элемента);
    // тип выполнения возвращаемого массива - тип указанного массива.
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    // Добавляет указанный элемент в конец этого списка.
    @Override
    public boolean add(T t) {
        add(listSize, t);
        return true;
    }

    // Удаляет первое вхождение указанного элемента из этого списка, если оно присутствует.
    @Override
    public boolean remove(Object o) {
        for (int i = 0; i < listSize; i++) {
            if (Objects.equals(o, items[i])) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    // проверка на наличие списка в списке. Возвращает true, если этот список содержит указанный список.?
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!this.contains(element)) {
                return false;
            }
        }
        return true;
    }

    // Добавляет все элементы указанной коллекции в конец этого списка в том порядке, в котором они возвращаются Итератором указанной коллекции.
    @Override
    public boolean addAll(Collection<? extends T> c) {
        return this.addAll(this.listSize, c);
    }

    // Вставляет все элементы указанной коллекции в этот список, начиная с указанной позиции.
    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index > listSize || index < 0) {
            throw new IndexOutOfBoundsException("Индекс : " + index + " вне границ списка");
        }

        if (listSize + c.size() >= items.length) {
            ensureCapacity();
        }
        System.arraycopy(items, index, items, index + c.size(), listSize - index);
        listSize = listSize + c.size();
        int i = index;
        for (T element : c) {
            items[i] = element;
            modCount++;
            i++;
        }
        return true;
    }

    // Удаляет из этого списка все его элементы, которые содержатся в указанной коллекции.
    @Override
    public boolean removeAll(Collection<?> c) {
        int expecModCount = 0;
        for (Object element : c) {
            for (int i = 0; i < listSize; ++i) {
                if (Objects.equals(items[i], element)) {
                    this.remove(i);
                    --i;
                    expecModCount++;
                }
            }
        }
        return expecModCount != 0;
    }

    // Сохраняет только элементы в этом списке, которые содержатся в указанной коллекции.
    @Override
    public boolean retainAll(Collection<?> c) {
        int expecModCount = 0;
        for (int i = 0; i < listSize; ++i) {
            if (!c.contains(items[i])) {
                this.remove(i);
                --i;
                expecModCount++;
            }
        }
        return expecModCount != 0;
    }

    // Удаляет все элементы из этого списка.
    @Override
    public void clear() {
        listSize = 0;

    }

    // Возвращает элемент в указанной позиции в этом списке.
    @Override
    public T get(int index) {
        if (index >= listSize || index < 0) {
            throw new IndexOutOfBoundsException("Индекс : " + index + " вне границ списка");
        }
        return items[index];
    }

    // Заменяет элемент в указанной позиции в этом списке указанным элементом. раз не void - возврат старого значения?
    @Override
    public T set(int index, T element) {
        if (index >= listSize || index < 0) {
            throw new IndexOutOfBoundsException("Индекс : " + index + " вне границ списка");
        }
        T oldElement = items[index];
        items[index] = element;
        return oldElement;
    }

    // Вставляет указанный элемент в указанную позицию в этом списке.
    @Override
    public void add(int index, T element) {
        if (index > listSize || index < 0) {
            throw new IndexOutOfBoundsException("Индекс : " + index + " вне границ списка");
        }
        listSize++;
        if (listSize >= items.length) {
            ensureCapacity();
        }

        items[index] = element;
        modCount++;
    }

    // Удаляет элемент в указанной позиции в этом списке. раз не void - возврат старого значения?
    @Override
    public T remove(int index) {
        if (index >= listSize || index < 0) {
            throw new IndexOutOfBoundsException("Индекс : " + index + " вне границ списка");
        }
        T oldElement = items[index];
        if (index < listSize - 1) {

            System.arraycopy(items, index + 1, items, index, listSize - index - 1);
        }
        --listSize;
        ++modCount;
        return oldElement;
    }

    // Возвращает индекс первого вхождения указанного элемента в этом списке или -1, если этот список не содержит этот элемент.
    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < listSize; ++i) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    // Возвращает индекс последнего вхождения указанного элемента в этом списке или -1, если этот список не содержит элемент.
    @Override
    public int lastIndexOf(Object o) {
        for (int i = listSize - 1; i >= 0; --i) {
            if (Objects.equals(items[i], o)) {
                return i;
            }
        }
        return -1;
    }

    // Возвращает итератор списка над элементами в этом списке (в правильной последовательности).
    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    // Возвращает итератор списка над элементами в этом списке (в правильной последовательности), начиная с указанной позиции в списке.
    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder componentsString = new StringBuilder();
        componentsString.append("{");
        for (int i = 0; i < listSize; ++i) {
            componentsString.append(items[i]).append(",");
        }
        componentsString.deleteCharAt(componentsString.length() - 1);
        return componentsString.append("}").toString();
    }

    // Возвращает представление части этого списка между указанным fromIndex, inclusive и toIndex, исключительным.
    // TODO Метод sublist реализовывать не нужно.
    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    public void ensureCapacity() {
        items = Arrays.copyOf(items, listSize * 2);
    }

    private void trimToSize() {
        if (items.length > listSize) {
            items = Arrays.copyOf(items, listSize);
        }
    }

}
