package ru.academits.bozhko.java;

import ru.academits.bozhko.list.List;
import ru.academits.bozhko.list.ListItem;


public class Main {
    public static void main(String[] args) {
        List<Integer> list = new List<Integer>();
        list.addBeginItem(null);
        list.addBeginItem(4);
        list.addBeginItem(2);
        list.addBeginItem(1);
        list.insertByIndexItem(2, null);
        System.out.printf("односвязный список: %s", list.toString());
        System.out.printf("Размер списка - %d%n", list.getSize());

        Integer oldIthemDelete = list.deleteByIndexItem(2);
        System.out.printf("удалим третий элемент, односвязный список: %s, который был равен %s%n", list.toString(), oldIthemDelete);

        list.insertByIndexItem(1, 3);
        Integer oldIthem = list.changeDataIndex(1, 5);
        System.out.printf("односвязный список: %s, старое значение по 2 эелементу = %s%n", list.toString(), oldIthem.toString());

        list.deleteFirstItem();
        list.addNextNewItem(list.getHead(), new ListItem<Integer>(oldIthemDelete)); //????
        System.out.printf("односвязный список: %s%n", list.toString());

        list.turnoverList();
        System.out.printf("Список - Разворот: %s", list.toString());

    }
}
