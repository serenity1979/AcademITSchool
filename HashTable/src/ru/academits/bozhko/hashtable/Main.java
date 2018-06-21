package ru.academits.bozhko.hashtable;

import ru.academits.bozhko.vector.Vector;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HashTable<Vector> myTable1 = new HashTable<>();
        myTable1.add(new Vector(3));
        myTable1.add(new Vector(new double[]{10, 5.2}));
        myTable1.add(new Vector(4, new double[]{10, 12, 3}));
        System.out.println("Размер таблицы myTable1: " + myTable1.size());

        for (Vector element : myTable1) {
            System.out.println(element);
        }

        HashTable<Vector> myTable2 = new HashTable<>(2);
        myTable2.add(new Vector(4, new double[]{10, 12, 3}));
        System.out.println("Размер таблицы myTable2: " + myTable2.size());

        ArrayList<Vector> myList = new ArrayList<>();
        myList.add(new Vector(4, new double[]{10, 12, 3}));

        for (Vector iterator : myTable1) {
            System.out.print(iterator + " ");
        }
        System.out.println();
        System.out.println("Количество элементов в Хэш-таблице: " + myTable1.size());

        Object[] array = myTable1.toArray();
        for (Object e : array) {
            System.out.print(e + " ");
        }

        myTable1.removeAll(myList);
        System.out.println("Размер таблицы myTable1: " + myTable1.size());
    }
}
