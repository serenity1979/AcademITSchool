package ru.academits.bozhko.hashtable;

import ru.academits.bozhko.vector.Vector;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        HashTable<Vector> myTable = new HashTable<>();
        myTable.add(null);
        myTable.add(new Vector(3));
        myTable.add(new Vector(new double[]{10, 5.2}));
        myTable.add(new Vector(4, new double[]{10, 12, 3}));
        System.out.println("Размер таблицы myTable: " + myTable.size());

        for (Vector element : myTable) {
            System.out.print(element + " ");
        }


        System.out.println("\nПреобразование в массив:");
        Object[] array = myTable.toArray();
        for (Object e : array) {
            System.out.print(e + " ");
        }
        System.out.println();

        ArrayList<Vector> myList = new ArrayList<>();
        myList.add(new Vector(4, new double[]{10, 12, 3}));
        System.out.println("Список:");
        for (Vector element : myList) {
            System.out.print(element + " ");
        }
        System.out.println();

        myTable.removeAll(myList);
        System.out.println("Размер таблицы myTable, после удаления элементов которые есть в списке: " + myTable.size());
        for (Vector element : myTable) {
            System.out.print(element + " ");
        }

        myTable.add(new Vector(new double[]{101, 102}));
        myTable.add(new Vector(4, new double[]{10, 12, 3}));
        System.out.println("\nmyTable: " + myTable.size());
        for (Vector element : myTable) {
            System.out.print(element + " ");
        }

        myTable.retainAll(myList);
        System.out.println("\nmyTable1, после удаления всех элементов, кроме тех, которые содержатся в коллекции: " + myTable.size());
        for (Vector element : myTable) {
            System.out.print(element + " ");
        }
    }
}
