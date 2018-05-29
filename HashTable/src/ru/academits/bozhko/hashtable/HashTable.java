package ru.academits.bozhko.hashtable;


import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class HashTable<T> implements Collection<T> {
    private ArrayList<T>[] hashTable;
    private int tableSize;
    private int modCount;

    public HashTable() {
        this.hashTable = new ArrayList[100];
    }

    public HashTable(int capacity) {
        this.hashTable = new ArrayList[capacity];
    }

    // удаляет все элементы из списка, который удовлетворяет данному Предикату
    @Override
    public boolean removeIf(Predicate<? super T> filter) {
        return false;
    }

    //Создает последний элементы в этой коллекции.
    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    //Возвращает последовательный поток с этой коллекцией в качестве источника.
    @Override
    public Stream<T> stream() {
        return null;
    }

    //Возвращает возможно параллельный поток с этой коллекцией в качестве источника.
    @Override
    public Stream<T> parallelStream() {
        return null;
    }

    //Возвращает количество элементов в этой коллекции.
    @Override
    public int size() {
        return tableSize;
    }

    //Возвращает true, если эта коллекция не содержит элементов.
    @Override
    public boolean isEmpty() {
        return tableSize == 0;
    }

    //! Возвращает true, если эта Коллекция содержит указанный элемент.
    @Override
    public boolean contains(Object o) {
        int i = (o == null) ? 0 : Math.abs(o.hashCode() % hashTable.length);
        return hashTable[i] != null && hashTable[i].contains(o);
    }

    //Возвращает итератор по элементам в этой коллекции.
    @Override
    public Iterator<T> iterator() {
        return new HashTableIterator();
    }

    //Возвращает массив, содержащий все элементы в этой коллекции.
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    //?? Возвращает массив, содержащий все элементы в этой коллекции; Тип времени выполнения возвращаемого массива-указанный массив.
    @Override
    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    //Гарантирует, что эта Коллекция содержит указанный элемент (необязательная операция).
    @Override
    public boolean add(T t) {
        int i = getIndex(t);
        if (hashTable[i] == null) {
            hashTable[i] = new ArrayList<>();
            tableSize++;
        }
        this.hashTable[i].add(t);
        modCount++;
        return true;
    }

    //Удаляет один экземпляр указанного элемента из этой коллекции, если он присутствует (необязательная операция).
    @Override
    public boolean remove(Object o) {
        int i = getIndex(o);

        return false;
    }

    //Возвращает True, если Коллекция содержит все элементы в указанном наборе.
    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    //Добавляет все элементы указанной коллекции в эту коллекцию (необязательная операция).
    @Override
    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    //Удаляет все элементы этой коллекции, которые также содержатся в указанной коллекции (необязательная операция).
    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    //Сохраняет только элементы в этой коллекции, содержащиеся в указанной коллекции (необязательная операция).
    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    //Удаляет все элементы из этой коллекции (необязательная операция).
    @Override
    public void clear() {
    }

    private int getIndex(Object o) {
        return Math.abs(o.hashCode() % hashTable.length);
    }

    private class HashTableIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int initialModCount = modCount;


        @Override
        public boolean hasNext() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return currentIndex + 1 < tableSize;
        }

        @Override
        public T next() {
            if (currentIndex + 1 > tableSize) {
                throw new NoSuchElementException();
            }
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            if (currentIndex >= hashTable.length) {
                throw new ConcurrentModificationException();
            }

            currentIndex++;
            return hashTable[currentIndex].get(0); // надо выводить элемент списка!
        }
    }
}
