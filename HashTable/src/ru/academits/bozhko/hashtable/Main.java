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
        myTable.add(new Vector(4, new double[]{10, 12, 3}));
        System.out.printf("         myTable ( %d ) : ", myTable.size());

        for (Vector element : myTable) {
            System.out.print(element + " ");
        }


        System.out.print("\nПреобразование в массив: ");
        Object[] array = myTable.toArray();
        for (Object e : array) {
            System.out.print(e + " ");
        }
        System.out.println();

        ArrayList<Vector> myList = new ArrayList<>();
        myList.add(new Vector(4, new double[]{10, 12, 3}));
        myList.add(new Vector(new double[]{10, 5.2}));
        myList.add(new Vector(new double[]{101, 102}));
        System.out.print("                 Список: ");
        for (Vector element : myList) {
            System.out.print(element + " ");
        }
        System.out.println();

        myTable.removeAll(myList);
        System.out.printf(" myTable(s%d), removeAll: ", myTable.size());
        for (Vector element : myTable) {
            System.out.print(element + " ");
        }

        myTable.add(new Vector(new double[]{101, 102}));
        System.out.printf("\n          myTable( %d ) : ", myTable.size());
        for (Vector element : myTable) {
            System.out.print(element + " ");
        }

        myTable.retainAll(myList);
        System.out.printf("\n myTable(s%d), retainAll: ", myTable.size());
        for (Vector element : myTable) {
            System.out.print(element + " ");
        }
    }
}
