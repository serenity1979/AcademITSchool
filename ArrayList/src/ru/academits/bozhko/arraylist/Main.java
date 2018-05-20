package ru.academits.bozhko.arraylist;

import ru.academits.bozhko.arraylist.ArrayList;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> myList0 = new ArrayList<>();
        myList0.add(100);
        myList0.add(200);
        System.out.println(myList0.toString());

        ArrayList<Integer> myList1 = new ArrayList<>();
        myList1.add(10);
        myList1.add(11);
        System.out.println(myList1.toString());

        ArrayList<Integer> myList2 = new ArrayList<>();
        myList2.add(20);
        myList2.add(21);
        myList2.add(90);
        myList2.add(91);
        System.out.println(myList2.toString());

        ArrayList<Integer> myList4 = new ArrayList<>();
        myList4.addAll(myList0);
        myList4.addAll(myList1);
        System.out.println(myList4.toString());

        myList4.retainAll(myList1);
        System.out.println(myList4.toString());
        ArrayList<Integer> myList5 = new ArrayList<>();
        myList5.add(30);
        myList5.add(31);
        myList5.add(40);
        myList5.add(41);
        myList5.add(60);
        myList5.add(61);
        myList5.add(50);
        myList5.add(51);
        myList2.addAll(myList4);
        myList2.addAll(myList1);
        myList2.addAll(myList5);
        myList2.add(90);
        myList2.add(91);
        // вывод коллекции. заполянли чтобы проверить как отработает расширение/емкость
        System.out.println(myList2.toString());
        System.out.println("ListSize " + myList2.size());
        System.out.println("Размер коллекции = " + myList2.size());
        System.out.println("Последняя позиция элемента 10, index = " + myList2.lastIndexOf(10));
        myList2.remove(0);
        System.out.println(myList2.toString());
        for (Integer element : myList2) {
            if (element % 2 == 0) {
                System.out.println(element);
            }

            System.out.println("Проверка  toArray(T1[] a)");
            System.out.println(myList5);
            Integer[] arr = new Integer[1];
            arr = myList5.toArray(arr);
            for (Integer e : arr) {
                System.out.println(e);
            }

            System.out.println("  ListIterator<Integer> ");
            ListIterator<Integer> i = myList2.listIterator(1);
            System.out.println("ListSize " + myList2.size() + " and hashNext " + i.hasNext());
            System.out.println("previousIndex - " + i.previousIndex() + ", nextIndex  -" + i.nextIndex());
            i.add(500);
            System.out.println("insert 500 ");
            i.next();
            System.out.println("nextIndex 1-" + i.nextIndex());
            System.out.println("next and insert 900 ");
            i.add(999);
            i.next();
            System.out.println("next Index " + i.nextIndex());
            i.next();
            System.out.println("next Index " + i.nextIndex());
            i.next();
            System.out.println("next Index " + i.nextIndex());
            System.out.println("ListSize " + myList2.size());
            System.out.println(myList2);
        }
    }
}
