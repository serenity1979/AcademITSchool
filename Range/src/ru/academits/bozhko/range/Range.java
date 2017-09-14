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
        return to - from;
    }

    public Range getIntersection(Range secondRange) {
        if ((secondRange.from >= to) || (from >= secondRange.to)) {
            return null;
        }
        return new Range(Math.max(from, secondRange.from), Math.min(to, secondRange.to));
    }

    public Range[] toUnite(Range secondRange) {
        Range newFirstRange = new Range(from, to);
        Range newSecondRange = new Range(secondRange.getFrom(), secondRange.getTo());

        if (newFirstRange.to < newSecondRange.from) {
            return new Range[]{newFirstRange, newSecondRange};
        } else if (newSecondRange.to < newFirstRange.from) {
            return new Range[]{newSecondRange, newFirstRange};
        } else {
            return new Range[]{new Range(Math.min(newFirstRange.from, newSecondRange.from), Math.max(newFirstRange.to, newSecondRange.to))};
        }
    }

    public Range[] getResidual(Range secondRange) {
        if ((to < secondRange.from) || (secondRange.to < from)) {
            return new Range[]{new Range(from, to)};
        } else if (from <= secondRange.from) {
            if (to >= secondRange.to) {
                return new Range[]{new Range(from, secondRange.from), new Range(secondRange.to, to)};
            } else {
                return new Range[]{new Range(from, secondRange.from)};
            }
        } else {
            if (to >= secondRange.to) {
                return new Range[]{new Range(secondRange.to, to)};
            } else {
                return new Range[]{};
            }
        }

    }
}
