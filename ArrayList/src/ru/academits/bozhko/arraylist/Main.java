package ru.academits.bozhko.arraylist;

import ru.academits.bozhko.arraylist.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> myList0 = new ArrayList<>(0);
        myList0.add(0);
        myList0.add(1);
        System.out.println(myList0.toString());

        ArrayList<Integer> myList1 = new ArrayList<>();
        myList1.add(10);
        myList1.add(11);
        System.out.println(myList1.toString());

        ArrayList<Integer> myList2 = new ArrayList<>();
        myList2.add(20);
        myList2.add(21);
        System.out.println(myList2.toString());

        ArrayList<Integer> myList4 = new ArrayList<>();
        myList4.addAll(myList0);
        myList4.addAll(myList1);
        System.out.println(myList4.toString());

        myList4.retainAll(myList1);
        System.out.println(myList4.toString());

    }
}
