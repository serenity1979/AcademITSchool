package ru.academits.bozhko.main;

import ru.academits.bozhko.range.Range;

/**
 * Created by Serenity on 10.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        Range myRange = new Range(10.5, 100.65);
        double selectNumber = 56.2;
        if (myRange.isInside(selectNumber)) {
            System.out.printf("число %.3f принадлежит числовому интервалу {%.2f; %.2f }", selectNumber, myRange.getFrom(), myRange.getTo());
        } else {
            System.out.printf("число %.3f не принадлежит числовому интервалу {%.2f; %.2f }", selectNumber, myRange.getFrom(), myRange.getTo());
        }
        System.out.printf("%nДлина числового интервала {%.2f; %.2f } = %.2f", myRange.getFrom(), myRange.getTo(), myRange.getLength());
        System.out.println();

        myRange.setFrom(selectNumber);
        if (myRange.isInside(selectNumber / 2)) {
            System.out.printf("число %.3f принадлежит числовому интервалу {%.2f; %.2f }", selectNumber / 2, myRange.getFrom(), myRange.getTo());
        } else {
            System.out.printf("число %.3f не принадлежит числовому интервалу {%.2f; %.2f }", selectNumber / 2, myRange.getFrom(), myRange.getTo());
        }
        System.out.printf("%nДлина числового интервала {%.2f; %.2f } = %.2f", myRange.getFrom(), myRange.getTo(), myRange.getLength());

        myRange.setTo(150);
        System.out.println();
        if (myRange.isInside(selectNumber)) {
            System.out.printf("число %.3f принадлежит числовому интервалу {%.2f; %.2f }", selectNumber, myRange.getFrom(), myRange.getTo());
        } else {
            System.out.printf("число %.3f не принадлежит числовому интервалу {%.2f; %.2f }", selectNumber, myRange.getFrom(), myRange.getTo());
        }
        System.out.printf("%nДлина числового интервала {%.2f; %.2f } = %.3f%n%n", myRange.getFrom(), myRange.getTo(), myRange.getLength());

        Range secondRange = new Range(60.1, 166.9);
        System.out.println("На текущий момент имеем два числовых интервала:");
        System.out.printf("Числовой интервал 1 {%.2f; %.2f }%n", myRange.getFrom(), myRange.getTo());
        System.out.printf("Числовой интервал 2 {%.2f; %.2f }%n", secondRange.getFrom(), secondRange.getTo());

        Range intersectionRange = myRange.getIntersection(secondRange);
        if (intersectionRange == null) {
            System.out.println("Нет пересечений");
        } else {
            System.out.printf("Числовой интервал их пересечения {%.2f; %.2f }%n", intersectionRange.getFrom(), intersectionRange.getTo());
        }

        Range[] uniteRange = myRange.toUnite(secondRange);
        System.out.print("Числовой интервал их объединения:");
        for (Range element : uniteRange) {
            System.out.printf(" {%.2f; %.2f } ", element.getFrom(), element.getTo());
        }
        System.out.println();

        Range[] residualRange = myRange.getResidual(secondRange);
        System.out.print("Числовой интервал их разности (из первого второй):");
        if (residualRange.length > 0) {
            for (Range element : residualRange) {
                System.out.printf(" {%.2f; %.2f } ", element.getFrom(), element.getTo());
            }
        } else {
            System.out.print(" пустое множество.");
        }
    }
}

