package ru.academits.bozhko.hashtable;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Predicate;
import java.util.stream.Stream;


public class HashTable<T> implements Collection<T> {
    private ArrayList<T>[] hashTable;
    private int tableSize;
    private int modCount;

    public HashTable() {
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

    //Returns the number of elements in this collection.
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
        return null;
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
        return false;
    }

    //Удаляет один экземпляр указанного элемента из этой коллекции, если он присутствует (необязательная операция).
    @Override
    public boolean remove(Object o) {
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
}
