package ru.academits.bozhko.range;

/**
 * Created by Serenity on 10.09.2017.
 */
public class Main {
    public static void main(String[] args) {
        Range myRange = new Range(10.5, 100.65);
        double selectNumber = 99.2;
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
        System.out.printf("%nДлина числового интервала {%.3f; %.3f } = %.3f%n", myRange.getFrom(), myRange.getTo(), myRange.getLength());

 /*       Range secondRange = new Range(50.1, 120.1);
        Range intersectionRange = myRange.getIntersection(secondRange);
        System.out.printf("Числовой интервал пересичения {%.3f; %.3f }%n", intersectionRange.getFrom(), intersectionRange.getTo());

        Range[] merger = myRange.toUnite(secondRange);
        System.out.print("Объединение 2 интервало. Итог:");
        for (Range e : merger) {
            System.out.printf(" {%.3f; %.3f } ", e.getFrom(), e.getTo());
        }
*/
    }

}

