package ru.academits.bozhko.java;

import ru.academits.bozhko.list.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new List<Integer>();

        list.addBeginItem(new Integer(4));
        list.addBeginItem(new Integer(2));
        list.addBeginItem(new Integer(1));
        list.addIndexItem(2, new Integer(3));

        System.out.printf("односвязный список: %s",list.toString());
        System.out.printf("Размер списка - %d%n",list.getListSize());

        list.turnoverList();
        System.out.printf("Список - Разворот: %s",list.toString());
    }
}
