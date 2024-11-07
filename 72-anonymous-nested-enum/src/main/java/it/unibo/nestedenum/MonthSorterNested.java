package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    private static final int SHORT_MONTH = 28;
    private static final int USUAL_MONTH = 30;
    private static final int LONG_MONTH = 31;

    @Override
    public Comparator<String> sortByDays() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortByDays'");
    }

    @Override
    public Comparator<String> sortByOrder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortByOrder'");
    }

    public enum Month {
        JENUARY("jenuary", LONG_MONTH),
        FEBRUARY("february", SHORT_MONTH),
        MARCH("march", LONG_MONTH),
        APRIL("april", USUAL_MONTH),
        MAY("may", LONG_MONTH),
        JUNE("june", USUAL_MONTH),
        JULY("july", LONG_MONTH),
        AUGUST("august", LONG_MONTH),
        SEPTEMBER("september", USUAL_MONTH),
        OCTOBER("october", LONG_MONTH),
        NOVEMBER("november", USUAL_MONTH),
        DECEMBER("december", LONG_MONTH);

        private String monthName;
        private int days;

        private Month(final String monthName, final int days) {
            this.monthName = monthName;
            this.days = days;
        }

    }

}
