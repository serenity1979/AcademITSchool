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

    public Range getIntersection(Range secondRange) {
        if ((secondRange.from > to) || (from > secondRange.to)) {
            return null;
        }

        double newFrom = from;
        double newTo;
        if (from < secondRange.from) {
            if (secondRange.from <= to) {
                newFrom = secondRange.from;
            }
            if (secondRange.to <= to) {
                newTo = secondRange.to;
            } else {
                newTo = to;
            }
        } else {
            newFrom = from;
            if (to <= secondRange.to) {
                newTo = to;
            } else {
                newTo = secondRange.to;
            }
        }
        return new Range(newFrom, newTo);
    }

    public Range[] toUnite(Range secondRange) {
        if (to < secondRange.from) {
            Range[] unionRange = {this, secondRange};
            return unionRange;
        } else if (secondRange.to < from) {
            Range[] unionRange = {secondRange, this};
            return unionRange;
        } else {
            double newFrom;
            double newTo;
            if (from <= secondRange.from) {
                newFrom = from;
            } else {
                newFrom = secondRange.from;
            }
            if (to <= secondRange.to) {
                newTo = secondRange.to;
            } else {
                newTo = to;
            }
            Range[] unionRange = {new Range(newFrom, newTo)};
            return unionRange;
        }
    }

    public Range[] isResidual(Range secondRange) {
        if ((to < secondRange.from) || (secondRange.to < from)) {
            Range[] ResidualRange = {this};
            return ResidualRange;
        } else if (from <= secondRange.from) {
            if (to >= secondRange.to) {
                Range[] ResidualRange = {new Range(from, secondRange.from), new Range(secondRange.to, to)};
                return ResidualRange;
            } else {
                Range[] ResidualRange = {new Range(from, secondRange.from)};
                return ResidualRange;
            }
        } else {
            if (to >= secondRange.to) {
                Range[] ResidualRange = {new Range(secondRange.to, to)};
                return ResidualRange;
            } else {
                Range[] ResidualRange = {};
                return ResidualRange;
            }
        }
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
        return Math.abs(to - from);
    }

}
