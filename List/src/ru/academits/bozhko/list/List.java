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

    // + получение размера списка
    public int getSize() {
        return listSize;
    }

    // + получение первого узла
    public ListItem<T> getHead() {
        return head;
    }

    // + получение узла по индексу
    public ListItem<T> getIndexItem(int index) {
        if (index < 0 || index > listSize) {
            throw new IllegalArgumentException("индекс вне диапозона списка");
        }

        int i = 0;
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (i == index) {
                return p;
            }
            i++;
        }
        return null;
    }

    // + вставка элемента в начало
    public void addBeginItem(T data) {
        if (data != null) {
            head = new ListItem<>(data, head);
            this.listSize++;
        }
    }

    // + вставка элемента по индексу
    public void insertByIndexItem(int index, T data) {
        if (index < 0 || index > listSize) {
            throw new IllegalArgumentException("индекс вне диапозона списка");
        }
        if (data != null) {
            if (index == 0) {
                this.addBeginItem(data);
            } else {
                ListItem<T> p = getIndexItem(index - 1);
                p.setNext(new ListItem<>(data, p.getNext()));
                this.listSize++;
            }
        }
    }

    // + получение/изменение значения по указанному индексу.Изменение значения по индексу пусть выдает старое значение.
    public T changeDataIndex(int index, T data) {
        if (data != null) {
            ListItem<T> p = getIndexItem(index);
            T oldData = p.getData();
            p.setData(data);
            return oldData;
        }
        return null;
    }

    //+ удаление элемента по индексу, пусть выдает значение элемента +
    public T deleteByIndexItem(int index) {
        T oldData = null;
        if (index > 0 && index < listSize) {
            ListItem<T> p = getIndexItem(index - 1);
            ListItem<T> q = p.getNext();
            oldData = q.getData();
            p.setNext(q.getNext());
            this.listSize--;
        } else if (index == 0) {
            oldData = deleteFirstItem();
        }
        return oldData;
    }

    //+ удаление первого элемента, пусть выдает значение элемента
    public T deleteFirstItem() {
        T oldData = head.getData();
        head = head.getNext();
        this.listSize--;
        return oldData;
    }

    //+ удаление узла по значению
    public boolean deleteValueItem(T data) {
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            if (data.equals(p.getNext().getData())) {
                p.setNext(p.getNext().getNext());
                this.listSize--;
                return true;
            }
        }
        return false;
    }

    // + разворот списка за линейное время

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

    // + вставка узла после указанного узла   - а если указан узел не из текущего списка... нужна проверка? +
    public void addNextNewItem(ListItem<T> listItem, T newData) {
        if (newData != null) {
            if (listItem == null) {
                this.addBeginItem(newData);
            } else if (listItem.getNext() != null) {
                listItem.setNext(new ListItem<>(newData, listItem.getNext()));
                listSize++;
            } else {
                listItem.setNext(new ListItem<>(newData));
                listSize++;
            }
        }
    }

    // + удаление узла после указанного узла
    public void deleteNextItem(ListItem<T> data) {
        if (data.getNext() != null) {
            data.setNext(data.getNext().getNext());
            listSize--;
        }
    }

    // + копирование списка
    public List<T> copyList() {
        if (head != null) {
            List<T> newList = new List<>(new ListItem<>(head.getData()));
            ListItem<T> q = newList.getHead();
            for (ListItem<T> p = head.getNext(); p != null; p = p.getNext()) {
                newList.addNextNewItem(q, p.getData());  // ссылки разные
                q = q.getNext();
            }
            return newList;
        }
        return null;
    }

    @Override
    public String toString() {
        //     return super.toString();
        StringBuilder componentsString = new StringBuilder();
        for (ListItem<T> p = head; p != null; p = p.getNext()) {
            componentsString.append(p.getData().toString()).append(" ");
        }
        return componentsString.toString();
    }
}
