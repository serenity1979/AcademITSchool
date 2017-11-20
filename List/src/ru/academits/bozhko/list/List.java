package ru.academits.bozhko.list;

public class List<T> {
    private ListItem<T> head;
    private int listSize;

    public List() {
        this.listSize = 0;
    }

    public List(ListItem<T> head) {
        this.head = head;
        this.listSize = 1;
    }

    // получение размера списка
    public int getListSize() {
        return listSize;
    }

    // получение первого узла
    public ListItem<T> getHead() {
        return head;
    }

    //получение узла по индексу
    public ListItem<T> getIndexImen(int index) {
        if (index < 1 || index > listSize) {
            throw new IllegalArgumentException("индекс вне диапозона списка");
        }

        int i = 1;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                return p;
            }
            i++;
        }
        return null;
    }

    // вставка элемента в начало
    public void addBeginItem(T data) {
        ListItem<T> p = new ListItem<T>(data, head);
        this.listSize++;
    }

    // вставка элемента по индексу
    public void addBeginItem(int index, T data) {
        ListItem<T> p = getIndexImen(index);
        ListItem<T> q = new ListItem<T>(data);
        q.setNext(p.getNext());
        p.setNext(q);
        this.listSize++;
    }

/* получение/изменение значения по указанному индексу.Изменение значения по индексу пусть выдает старое значение.


удаление элемента по индексу, пусть выдает значение элемента
удаление узла по значению
удаление первого элемента, пусть выдает значение элемента
вставка и удаление узла после указанного узла
разворот списка за линейное время
копирование списка

 */

/*


    public void setHead(ListItem<T> head) {
        this.head = head;
    }

    public void setListSize(int listSize) {
        this.listSize = listSize;
    }*/
}
