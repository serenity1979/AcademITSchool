package ru.academits.bozhko.java;

import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<>();
        try (Scanner scanner = new Scanner(new FileInputStream("./ArrayList/src/myArrayList.txt"))) {
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
        }

        ArrayList<Integer> newList = new ArrayList<>();
        for (Integer element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        System.out.println(list);
        System.out.println(newList);

        int listLength = list.size() - 1;
        for (int i = listLength; i >= 0; --i) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
        System.out.println(list);

    }
}
