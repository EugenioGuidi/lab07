package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    private static final int TIMES = 100;
    private static final int SHORT_MONTH = 28;
    private static final int USUAL_MONTH = 30;
    private static final int LONG_MONTH = 31;

    public enum Month {

        JANUARY(LONG_MONTH), 
        FEBRUARY(SHORT_MONTH), 
        MARCH(LONG_MONTH), 
        APRIL(USUAL_MONTH), 
        MAY(LONG_MONTH), 
        JUNE(USUAL_MONTH), 
        JULY(LONG_MONTH), 
        AUGUST(LONG_MONTH), 
        SEPTEMBER(USUAL_MONTH), 
        OCTOBER(LONG_MONTH), 
        NOVEMBER(USUAL_MONTH), 
        DECEMBER(LONG_MONTH);

        private int days;

        Month(final int days) {
            this.days = days;
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return null;
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
