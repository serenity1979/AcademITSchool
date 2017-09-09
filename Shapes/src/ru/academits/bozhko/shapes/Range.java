package ru.academits.bozhko.shapes;

/**
 * Created by Serenity on 10.09.2017.
 */
public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        double max = (from > to) ? from : to;
        double min = (from < to) ? from : to;
        this.from = min;
        this.to = max;
    }

    public void setFrom(double from) {

        double max = (from > to) ? from : to;
        double min = (from < to) ? from : to;
        this.from = min;
        this.to = max;
    }

    public double getFrom() {
        return this.from;
    }

    public void setTo(double to) {
        double max = (from > to) ? from : to;
        double min = (from < to) ? from : to;
        this.from = min;
        this.to = max;
    }

    public double getTo() {
        return this.to;
    }

    public boolean isInside(double number) {
        return (from <= number && number <= to);

    }

    public double getLength() {
        return Math.abs(to - from);
    }
}
