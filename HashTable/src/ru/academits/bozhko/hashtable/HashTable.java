package ru.academits.bozhko.hashtable;


import java.util.*;


public class HashTable<T> implements Collection<T> {
    private ArrayList<T>[] hashTable;
    private int tableSize;
    private int modCount;

    public HashTable() {
        //noinspection unchecked
        this.hashTable = new ArrayList[100];
    }

    public HashTable(int capacity) {
        //noinspection unchecked
        this.hashTable = new ArrayList[capacity];
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
        Object[] array = new Object[tableSize];
        int i = 0;
        for (T element : this) {
            array[i] = element;
            i++;
        }
        return array;
    }

    //?? Возвращает массив, содержащий все элементы в этой коллекции; Тип времени выполнения возвращаемого массива-указанный массив.
    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < tableSize) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(this.toArray(), tableSize, a.getClass());
        }
        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(this.toArray(), 0, a, 0, tableSize);
        if (a.length > tableSize) {
            a[tableSize] = null;
        }
        return a;
    }

    //Гарантирует, что эта Коллекция содержит указанный элемент (необязательная операция).
    @Override
    public boolean add(T t) {
        int i = getIndex(t);
        if (hashTable[i] == null) {
            hashTable[i] = new ArrayList<>();
        }
        this.hashTable[i].add(t);
        tableSize++;
        modCount++;
        return true;
    }

    //Удаляет один экземпляр указанного элемента из этой коллекции, если он присутствует (необязательная операция).
    @Override
    public boolean remove(Object o) {
        int i = getIndex(o);
        boolean statusStep = false;
        if (hashTable[i].remove(o)) {
            tableSize--;
            modCount++;
            statusStep = true;
        }
        return statusStep;
    }

    //Возвращает True, если Коллекция содержит все элементы в указанном наборе.
    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object element : c) {
            if (!this.contains(element)) {
                return false;
            }
        }
        return true;
    }

    //Добавляет все элементы указанной коллекции в эту коллекцию (необязательная операция).
    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean statusStep = false;
        for (T element : c) {
            statusStep = this.add(element);
        }
        return statusStep;
    }

    //Удаляет все элементы этой коллекции, которые также содержатся в указанной коллекции (необязательная операция).
    public boolean removeAll(Collection<?> c) {
        int countTrueStep = 0;
        for (Object element : c) {
            int i = getIndex(element);
            if (hashTable[i] != null && hashTable[i].size() >= 1) {
                if (remove(element)) {
                    countTrueStep++;
                }
            }
        }
        tableSize -= countTrueStep;
        modCount++;
        return countTrueStep != 0;
    }

    //Сохраняет только элементы в этой коллекции, содержащиеся в указанной коллекции (необязательная операция).
    @Override
    public boolean retainAll(Collection<?> c) {
        int countTrueStep = 0;
        for (ArrayList<T> rowOfTable : this.hashTable) {
            for (Object element : c) {
                if (rowOfTable != null && rowOfTable.size() > 0) {
                    remove(element);
                    countTrueStep++;
                }
            }
        }
        return countTrueStep != 0;
    }

    //Удаляет все элементы из этой коллекции (необязательная операция).
    @Override
    public void clear() {
        for (ArrayList<T> list : hashTable) {
            if (list != null && list.size() > 0) {
                list.clear();
                modCount++;
            }
        }
        tableSize = 0;
    }

    private int getIndex(Object o) {
        return Math.abs(o.hashCode() % hashTable.length);
    }

    private class HashTableIterator implements Iterator<T> {
        private int currentIndex = -1;
        private int initialModCount = modCount;
        private int currentListIndex = 0; // индекс по списку в массиве ХЭШ-таблицы
        private int currentHashIndex = 0; // индекс по массиву ХЭШ-таблице

        @Override
        public boolean hasNext() {
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException("не последовательный скачок в модификации пропущен шаг");
            }
            return currentIndex + 1 < tableSize;
        }

        @Override
        public T next() {
            if (currentIndex + 1 > tableSize) {
                throw new NoSuchElementException("Индекс за пределами таблицы, индекс " + currentIndex);
            }
            if (initialModCount != modCount) {
                throw new ConcurrentModificationException("не последовательный скачок в модификации пропущен шаг, модификаций= " + modCount);
            }
            if (currentIndex >= hashTable.length) {
                throw new ConcurrentModificationException("Индекс за пределами длины масива/таблицы, индекс " + currentIndex + ">" + hashTable.length);
            }

            T element;
            for (int i = currentHashIndex; i < hashTable.length; i++) {      //  проходим по массиву
                currentHashIndex = i;                                        //  увеличиваем индекс массива после прохода по индексу, у которого нет списка. чтобы не проходит их дважы и не зацикливаться
                if (hashTable[i] != null && hashTable[i].size() > 0) {       //  проверяем что в массиве есть список и в ХЭШ-талице есть элементы
                    element = hashTable[i].get(currentListIndex);            //  возвращает объект из списка по индексу списка
                    currentIndex++;                                          //  текущий курсор увеличиваем на единицу
                    currentListIndex++;                                      //  увеличиваем индекс в списке на следующий
                    if (currentListIndex == hashTable[i].size()) {           //  проверяем индекс списка на вход за пределы списка  - что это последний элемент списка
                        this.currentHashIndex++;                             //  переход на следующий индекс массива
                        this.currentListIndex = 0;                           //  переход на начало списка
                    }
                    return element;                                             //  возвращает объект
                }
            }
            return null;
        }
    }
}
