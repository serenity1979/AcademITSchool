package ru.academits.bozhko.arraylist;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> myList0 = new ArrayList<>();
        myList0.add(0, 100);
        myList0.add(200);
        System.out.println("List 0:" + myList0.toString());

        ArrayList<Integer> myList1 = new ArrayList<>();
        myList1.add(10);
        myList1.add(11);
        System.out.println("List 1:" + myList1.toString());

        ArrayList<Integer> myList2 = new ArrayList<>();
        myList2.add(20);
        myList2.add(21);
        myList2.add(90);
        myList2.add(91);
        System.out.println("List 2:" + myList2.toString());

        ArrayList<Integer> myList3 = new ArrayList<>();
        myList0.addAll(myList3);
        System.out.println("List 0 (+List3):" + myList0.toString());

        ArrayList<Integer> myList4 = new ArrayList<>();
        System.out.println("List 4:" + myList4.toString());
        myList4.addAll(myList0);
        System.out.println("List 4 (+List0):" + myList4.toString());
        myList4.addAll(myList1);
        System.out.println("List 4 (+List1):" + myList4.toString());

        myList4.retainAll(myList1);
        System.out.println("List 4 (только которые содержатся List1):" + myList4.toString());
        ArrayList<Integer> myList5 = new ArrayList<>();
        myList5.add(30);
        myList5.add(31);
        myList5.add(40);
        myList5.add(41);
        myList5.add(60);
        myList5.add(61);
        myList5.add(50);
        myList5.add(51);
        System.out.println("List 5:" + myList5.toString());
        myList2.addAll(myList4);
        System.out.println("List 2 (+List4):" + myList2.toString());
        myList2.addAll(myList1);
        System.out.println("List 2 (+List1):" + myList2.toString());
        myList2.addAll(myList5);
        myList2.add(90);
        myList2.add(91);
        // вывод коллекции. заполянли чтобы проверить как отработает расширение/емкость
        System.out.println("List 2 (+List15 + элементы 90, 91):" + myList2.toString());
        System.out.println("ListSize " + myList2.size());
        System.out.println("Размер коллекции = " + myList2.size());
        System.out.println("Последняя позиция элемента 10, index = " + myList2.lastIndexOf(10));
        myList2.remove(0);
        System.out.println("List 2:" + myList2.toString());
        System.out.print("Проверка  foreach, только четные элементы List2: ");
        for (Integer element : myList2) {
            if (element % 2 == 0) {
                System.out.printf("%s, ", element);
            }
        }
        System.out.println();
        System.out.print("Проверка  toArray(T1[]: ");
        Integer[] arr = new Integer[1];
        arr = myList2.toArray(arr);
        System.out.print("[");
        for (Integer e : arr) {
            System.out.printf("%s,", e.toString());
        }
        System.out.print("]");

        System.out.println("\nУдалим 4 элемент из List2, его значение: " + myList2.remove(3));
        System.out.println("List 2:" + myList2.toString());
        myList0.set(0, 10);
        System.out.printf("Замена первого элемента в List0. Новое значение: %s\n\n", myList0.get(0));

        System.out.println("ListIterator<Integer> List2");
        ListIterator<Integer> i = myList2.listIterator(1);
        System.out.print("ListSize = " + myList2.size() + " and hashNext = " + i.hasNext());
        System.out.println(" previousIndex - " + i.previousIndex() + ", nextIndex  -" + i.nextIndex());
        i.add(500);
        System.out.println("insert 500 ");
        i.next();
        System.out.println("next Index " + i.nextIndex());
        System.out.println("next and insert 900 ");
        i.add(999);
        i.next();
        System.out.println("next Index " + i.nextIndex());
        i.next();
        System.out.println("next Index " + i.nextIndex() + " - удаляем элемент");
        i.remove();
        System.out.println("next Index " + i.nextIndex());
        i.next();
        System.out.println("next Index " + i.nextIndex());
        System.out.println("ListSize " + myList2.size());
        System.out.println("List 2:" + myList2);

        ArrayList<Integer> myList6 = new ArrayList<>(20);
        myList6.addAll(0, myList5);
        System.out.println(myList6);
    }
}
