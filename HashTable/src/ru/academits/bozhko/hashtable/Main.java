package ru.academits.bozhko.hashtable;

import ru.academits.bozhko.vector.Vector;

public class Main {
    public static void main(String[] args) {
        HashTable<Vector> myTable1 = new HashTable<>();
        myTable1.add(new Vector(3));
        myTable1.add(new Vector(new double[]{10, 5.2}));
        myTable1.add(new Vector(4, new double[]{10, 12, 3}));
        System.out.println("Размер таблицы: " + myTable1.size());
        HashTable<Vector> myTable2 = new HashTable<>(2);
        myTable2.add(new Vector(4, new double[]{10, 12, 3}));
        System.out.println("Размер таблицы: " + myTable2.size());
    }
}
