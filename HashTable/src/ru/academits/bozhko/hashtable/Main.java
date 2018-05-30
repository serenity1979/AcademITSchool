package ru.academits.bozhko.hashtable;

import ru.academits.bozhko.vector.Vector;

public class Main {
    public static void main(String[] args) {
        HashTable<Vector> myTable = new HashTable<>();
        myTable.add(new Vector(3));
        myTable.add(new Vector(new double[]{10, 5.2}));
        myTable.add(new Vector(4, new double[]{10, 12, 3}));
        System.out.println("Размер таблицы: " + myTable.size());
    }
}
