package ru.academits.bozhko.range;

/**
 * Created by Serenity on 10.09.2017.
 */
public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getFrom() {
        return this.from;
    }

// todo Пересечение в доработке
 /*
  public Range getIntersection(Range secondRange) {
        Range intersectionRange = new Range(0, 0);

        if ((isInside(secondRange.from)) && (isInside(secondRange.to))) {
            return intersectionRange; // null
        }

        if (from < secondRange.from) {
            if (isInside(secondRange.from)) {
                intersectionRange.from = secondRange.from;
                if (isInside(secondRange.to)) {
                    intersectionRange.to = secondRange.to;
                } else {
                    intersectionRange.to = to;
                }
            }
        } else {
            if (isInside(secondRange.to)) {
                intersectionRange.from = from;
                intersectionRange.to = secondRange.to;
            }
            if (to < secondRange.to) {
                intersectionRange.from = from;
                intersectionRange.to = to;
            }
        }
        return intersectionRange;
    }
// todo объединение в оптимизации и проверке
    public Range[] toUnite(Range secondRange) {
        Range[] unionRange = {null};
        if (isInside(secondRange.from) || isInside(secondRange.to)) {
            Range element = new Range(0, 0);
            if (from <= secondRange.from) {
                element.setFrom(from);
            } else {
                element.setFrom(secondRange.from);
            }
            if (to > secondRange.to) {
                element.setTo(to);
            } else {
                element.setTo(secondRange.to);
            }
            unionRange[0] = element;
        } else {
            unionRange[0] = this;
            unionRange[1] = secondRange;
        }
        return unionRange;
    }
    */

    public void setTo(double to) {
        this.to = to;
    }

    public double getTo() {
        return to;
    }

    public boolean isInside(double number) {
        return (from <= number && number <= to);
    }

    public double getLength() {
        return Math.abs(to - from);
    }

}
