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
        head = p;
        this.listSize++;
    }

    // вставка элемента по индексу
    public void addIndexItem(int index, T data) {
        ListItem<T> p = getIndexImen(index);
        ListItem<T> q = new ListItem<T>(data);
        q.setNext(p.getNext());
        p.setNext(q);
        this.listSize++;
    }

    // получение/изменение значения по указанному индексу.Изменение значения по индексу пусть выдает старое значение.
    public T changeDataIndexItem(int index, T data) {
        ListItem<T> p = getIndexImen(index);
        T oldData = p.getData();
        p.setData(data);
        return oldData;
    }

    //удаление элемента по индексу, пусть выдает значение элемента
    public T deleteIndexListItem(int index) {
        T oldData = null;
        if (index > 1 && index <= listSize) {
            ListItem<T> p = getIndexImen(index - 1);
            ListItem<T> q = p.getNext();
            oldData = q.getData();
            p.setNext(q.getNext());
            this.listSize--;
        } else if (index == 1) {
            oldData = deleteFirstListItem();
        }
        return oldData;
    }

    //удаление первого элемента, пусть выдает значение элемента
    public T deleteFirstListItem() {
        T oldData = head.getData();
        head = head.getNext();
        this.listSize--;
        return oldData;
    }

    //удаление узла по значению
    public boolean deleteValueListItem(T data) {
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (data.equals(p.getData())) {
                p.setNext(p.getNext().getNext());
                this.listSize--;
                return true;
            }
        }
        return false;
    }

    //разворот списка за линейное время

    public void turnoverList() {
        ListItem<T> p = head;
        ListItem<T> qVariable = head.getNext();
        p.setNext(null);
        while (qVariable != null) {
            ListItem<T> q = qVariable;
            qVariable = q.getNext();
            q.setNext(p);
            p = q;
        }
        head = p;
    }

    @Override
    public String toString() {
        //     return super.toString();
        StringBuilder componentsString = new StringBuilder();
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            componentsString.append((p.getData()).toString()).append(" ");
        }
        return componentsString.toString();
    }

    /*
вставка и удаление узла после указанного узла
копирование списка

 */
}
