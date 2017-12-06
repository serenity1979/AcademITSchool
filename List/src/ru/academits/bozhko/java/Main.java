package ru.academits.bozhko.java;

import ru.academits.bozhko.list.List;


public class Main {
    public static void main(String[] args) {
        List<Integer> list = new List<>();
        list.addBeginItem(null);
        list.addBeginItem(4);
        list.addBeginItem(2);
        list.addBeginItem(4);
        list.insertAtIndex(2, null);
        System.out.printf("Односвязный список: %s", list.toString());
        System.out.printf("Размер списка = %d%n", list.getSize());
        System.out.printf("Получение узла по индексу 1:%s%n", list.getItem(1));

        Integer oldItemDelete = list.deleteByIndexItem(2);
        System.out.printf("Удалим 3 элемент,           наш список: %s,         3-й элемент был равен %s, размер %d%n", list.toString(), oldItemDelete, list.getSize());

        list.addNextNewItem(null, oldItemDelete);
        System.out.printf("Добавим удаленный элемент 1-ым, список: %s, размер %d%n", list.toString(), list.getSize());

        int index = 5;
        list.insertAtIndex(index, 3);
        System.out.printf("Вставим %d элемент = 3 в     наш Список: %s, размер %d%n", index, list.toString(), list.getSize());

        Integer oldIthem = list.changeDataIndex(1, 5);
        System.out.printf("Заменим 2 элемент на 5,     наш Список: %s, старое значение по 2 эелементу = %s, размер %d%n", list.toString(), oldIthem.toString(), list.getSize());

        list.deleteFirstItem();
        System.out.printf("Удалим 1 элемент,           наш Список: %s, размер %d%n", list.toString(), list.getSize());

//        oldItemDelete= new Integer(7);
        if (list.delete(oldItemDelete)) {
            System.out.printf("Удален по значению %d , наш Список: %s, размер %d%n", oldItemDelete, list.toString(), list.getSize());
        } else {
            System.out.printf("Удаленных элементов нет, так как в списке нет узла со значением %d%n", oldItemDelete);
        }

        list.addBeginItem(20);
        list.addBeginItem(40);
        System.out.printf("Односвязный список: %s, затем ", list.toString());
        list.deleteNextItem(list.getHead());
        System.out.printf("удалим элемент 2 ,%nнаш Список: %s, размер %d%n", list.toString(), list.getSize());

        list.addBeginItem(null);
        System.out.printf("Список: %s ", list.toString());
        list.turnoverList();
        System.out.printf("Разворот: %s%n", list.toString());

        List<Integer> listNull = new List<>();
        System.out.printf("Список: %s ", listNull.toString());
        listNull.turnoverList();
        System.out.printf("Разворот: %s%n", listNull.toString());

        list.addBeginItem(null);
        List<Integer> listClone = list.copyList();
        System.out.printf("односвязный список %s, ", list.toString());
        System.out.printf("Список (копия): %s, размер %d%n", listClone.toString(), listClone.getSize());

        listClone = listNull.copyList();
        System.out.printf("односвязный список 2 %s, ", listNull.toString());
        System.out.printf("список(копия): %s, размер %d", listClone.toString(), listClone.getSize());

    }
}