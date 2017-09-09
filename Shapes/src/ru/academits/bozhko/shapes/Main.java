package ru.academits.bozhko.shapes;

public class Main {
    public static void main(String[] args) {
      //  System.out.println("Hello world");

        Range myRange = new Range(100.5, 10.65);
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
            System.out.printf("число %.3f принадлежит числовому инервалу {%.3f; %.3f }", selectNumber / 2, myRange.getFrom(), myRange.getTo());
        } else {
            System.out.printf("число %.3f не принадлежит числовому интервалу {%.3f; %.3f }", selectNumber / 2, myRange.getFrom(), myRange.getTo());
        }
        System.out.printf("%nДлина числового интервала {%.3f; %.3f } = %.3f", myRange.getFrom(), myRange.getTo(), myRange.getLength());
        myRange.setTo(250);
        System.out.println();
        if (myRange.isInside(selectNumber)) {
            System.out.printf("число %.3f принадлежит числовому инервалу {%.3f; %.3f }", selectNumber, myRange.getFrom(), myRange.getTo());
        } else {
            System.out.printf("число %.3f не принадлежит числовому интервалу {%.3f; %.3f }", selectNumber, myRange.getFrom(), myRange.getTo());
        }
        System.out.printf("%nДлина числового интервала {%.3f; %.3f } = %.3f", myRange.getFrom(), myRange.getTo(), myRange.getLength());
    }

}
