package ru.academits.bozhko.hashtable;


import java.util.*;


public class HashTable<T> implements Collection<T> {
    private ArrayList<T>[] hashTable;  // коллекция, массив объектов
    private int tableSize;             // размер коллекции, реальное количество элеметов
    private int modCount;              // количество изменений

    // конструктор создания массива обектов по умолчанию
    public HashTable() {
        //noinspection unchecked
        this.hashTable = new ArrayList[100];
    }

    // конструктор создания массива обектов определенного размера
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
        int i = getIndex(o);
        return hashTable[i] != null && hashTable[i].contains(o);  // метод contains проверяет есть ли в массиве элемент
    }

    //Возвращает итератор по элементам в этой коллекции.
    @Override
    public Iterator<T> iterator() {
        return new HashTableIterator();
    }

    //Возвращает массив, содержащий все элементы в этой коллекции. возвращает новый массив объектов
    @Override
    public Object[] toArray() {
        Object[] array = new Object[tableSize];  // создаем массив длиной коллекции
        int i = 0;
        for (T element : this) {                 // проход по iterator this hashTable
            array[i] = element;
            i++;
        }
        return array;
    }

    //?? Возвращает массив, содержащий все элементы в этой коллекции; Тип времени выполнения возвращаемого массива-указанный массив.
    // дописывает в передаваемый массив
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

    //удаляет все объекты коллекции c из текущей коллекции. Если текущая коллекция изменилась, возвращает true, иначе возвращается false
    public boolean removeAll(Collection<?> c) {
        int countTrueStep = 0;
        for (Object element : c) {
            int i = getIndex(element);
            if (hashTable[i] != null && hashTable[i].size() > 0) {
                if (hashTable[i].remove(element)) {
                    countTrueStep++;
                }
            }
        }
        tableSize -= countTrueStep;
        modCount++;
        return countTrueStep != 0;
    }

    //удаляет все объекты из текущей коллекции, кроме тех, которые содержатся в коллекции c.
    // Если текущая коллекция после удаления изменилась, возвращает true, иначе возвращается false
    @Override
    public boolean retainAll(Collection<?> c) {
        int countTrueStep = 0;
        for (ArrayList<T> rowOfTable : this.hashTable) {              // проходим по индексу массива
            if (rowOfTable != null && rowOfTable.size() > 0) {
                for (int i = 0; i < rowOfTable.size(); i++) {          // проходим по коллекции по индексу массива
                    if (!c.contains(rowOfTable.get(i))) {       // проверяем что элемент коллекции есть в с
                        rowOfTable.remove(rowOfTable.get(i));   // если нет удаляем и меняем количество эелементов внашей коллекции,
                        countTrueStep++;
                        tableSize--;
                        i--;                                     //  и делаем шаг назад, так элемент удален и другие элементы коллекции сдвинулись
                    }
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

    // определения индекса в массиве для объекта
    private int getIndex(Object o) {
        return (o == null) ? 0 : Math.abs(o.hashCode() % hashTable.length);
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
            if (currentIndex + 1 > tableSize) {
                throw new NoSuchElementException("Индекс за пределами таблицы, индекс " + currentIndex);
            }

            return currentIndex + 1 < tableSize;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                return null;
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
                    return element;                                          //  возвращает объект
                }
            }
            return null;
        }
    }
}
