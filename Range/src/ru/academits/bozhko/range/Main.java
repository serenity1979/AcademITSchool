package ru.academits.bozhko.range;

/**
 * Created by Serenity on 10.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        Range myRange = new Range(10.5, 100.65);
        double selectNumber = 56.2;
        if (myRange.isInside(selectNumber)) {
            System.out.printf("число %.3f принадлежит числовому интервалу {%.3f; %.3f }", selectNumber, myRange.getFrom(), myRange.getTo());
        } else {
            System.out.printf("число %.3f не принадлежит числовому интервалу {%.3f; %.3f }", selectNumber, myRange.getFrom(), myRange.getTo());
        }
        System.out.printf("%nДлина числового интервала {%.3f; %.3f } = %.3f", myRange.getFrom(), myRange.getTo(), myRange.getLength());
        System.out.println();

        myRange.setFrom(selectNumber);
        if (myRange.isInside(selectNumber / 2)) {
            System.out.printf("число %.3f принадлежит числовому интервалу {%.3f; %.3f }", selectNumber / 2, myRange.getFrom(), myRange.getTo());
        } else {
            System.out.printf("число %.3f не принадлежит числовому интервалу {%.3f; %.3f }", selectNumber / 2, myRange.getFrom(), myRange.getTo());
        }
        System.out.printf("%nДлина числового интервала {%.3f; %.3f } = %.3f", myRange.getFrom(), myRange.getTo(), myRange.getLength());

        myRange.setTo(250);
        System.out.println();
        if (myRange.isInside(selectNumber)) {
            System.out.printf("число %.3f принадлежит числовому интервалу {%.3f; %.3f }", selectNumber, myRange.getFrom(), myRange.getTo());
        } else {
            System.out.printf("число %.3f не принадлежит числовому интервалу {%.3f; %.3f }", selectNumber, myRange.getFrom(), myRange.getTo());
        }
        System.out.printf("%nДлина числового интервала {%.3f; %.3f } = %.3f%n%n", myRange.getFrom(), myRange.getTo(), myRange.getLength());

        Range secondRange = new Range(55.1, 206.9);
        System.out.println("На текущий момент имеем два числовых интервала:");
        System.out.printf("Числовой интервал 1 {%.3f; %.3f }%n", myRange.getFrom(), myRange.getTo());
        System.out.printf("Числовой интервал 2 {%.3f; %.3f }%n", secondRange.getFrom(), secondRange.getTo());

        Range intersectionRange = myRange.getIntersection(secondRange);
        if (intersectionRange == null) {
            System.out.println("Нет пересечений");
        } else {
            System.out.printf("Числовой интервал их пересечения {%.3f; %.3f }%n", intersectionRange.getFrom(), intersectionRange.getTo());
        }

        Range[] uniteRange = myRange.toUnite(secondRange);
        System.out.print("Числовой интервал их объединения:");
        for (Range element : uniteRange) {
            System.out.printf(" {%.2f; %.2f } ", element.getFrom(), element.getTo());
        }
        System.out.println();

        Range[] residualRange = myRange.isResidual(secondRange);
        System.out.print("Числовой интервал их разности:");
        if (residualRange.length > 0) {
            for (Range element : residualRange) {
                System.out.printf(" {%.2f; %.2f } ", element.getFrom(), element.getTo());
            }
        } else {
            System.out.print(" пустое множество.");
        }
    }
}

