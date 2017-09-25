package ru.academits.bozhko.main;
import ru.academits.bozhko.shape.Shape;

import java.util.Comparator;
/**
 * Created by Serenity on 26.09.2017.
 */
public class SortByPerimeter implements Comparator<Shape> {

    @Override
    public int compare(Shape obj1, Shape obj2) {
        double parameter1 = obj1.getPerimeter();
        double parameter2 = obj2.getPerimeter();

        if (parameter1 > parameter2) {
            return -1;
        } else if (parameter1 < parameter2) {
            return 1;
        } else {
            return 0;
        }
    }
}
