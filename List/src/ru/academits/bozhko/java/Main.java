package ru.academits.bozhko.java;

import ru.academits.bozhko.list.List;


public class Main {
    public static void main(String[] args) {
        List<Integer> list = new List<>();
        list.addBeginItem(null);
        list.addBeginItem(4);
        list.addBeginItem(2);
        list.addBeginItem(4);
        list.insertByIndexItem(2, null);
        System.out.printf("односвязный список: %s", list.toString());
        System.out.printf("Размер списка = %d%n", list.getSize());
        System.out.printf("Получение узла по индексу 1:%s%n", list.getItem(1));

        Integer oldIthemDelete = list.deleteByIndexItem(2);
        System.out.printf("удалим 3 элемент,      наш список: %s, 3-й элемент был равен %s, размер %d%n", list.toString(), oldIthemDelete, list.getSize());

        list.addNextNewItem(null, oldIthemDelete);
        System.out.printf("добавим удаленный элемент 1-ым, список: %s, размер %d%n", list.toString(), list.getSize());

        list.insertByIndexItem(1, 3);
        System.out.printf("Вставим 2 элемент =3 в наш Список: %s, размер %d%n", list.toString(), list.getSize());

        Integer oldIthem = list.changeDataIndex(1, 5);
        System.out.printf("Заменим 2 элемент на 5,наш Список: %s, старое значение по 2 эелементу = %s, размер %d%n", list.toString(), oldIthem.toString(), list.getSize());

        list.deleteFirstItem();
        System.out.printf("удалим 1 элемент      ,наш Список: %s, размер %d%n", list.toString(), list.getSize());

        if (list.deleteValueItem(oldIthemDelete)) {
            System.out.printf("удален по значению %d     ,наш Список: %s, размер %d%n", oldIthemDelete, list.toString(), list.getSize());
        }

        list.addBeginItem(20);
        list.addBeginItem(40);
        System.out.printf("односвязный список: %s, затем ", list.toString());
        list.deleteNextItem(list.getHead());
        System.out.printf("удалим элемент 2      ,наш Список: %s, размер %d%n", list.toString(), list.getSize());

        list.turnoverList();
        System.out.printf("Список  - Разворот: %s%n", list.toString());

        list.addBeginItem(null);
        List<Integer> listClone = list.copyList();
        System.out.printf("Список  -    Копия: %s, размер %d%n", listClone.toString(), listClone.getSize());

        List<Integer> listNull = new List<>();
        listClone = listNull.copyList();
        System.out.printf("односвязный список 2 %s, ", listNull.toString());
        System.out.printf("список - копия 2: %s, размер %d", listClone.toString(), listClone.getSize());

    }
}
