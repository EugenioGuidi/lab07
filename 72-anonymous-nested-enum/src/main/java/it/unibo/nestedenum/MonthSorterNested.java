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
        return new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int daysO1 = getMonth(o1).getDays();
                int daysO2 = getMonth(o2).getDays();
                if(daysO1 < daysO2) {
                    return -1;
                }
                if(daysO1 == daysO2) {
                    return 0;
                }
                if(daysO1 > daysO2) {
                    return 1;
                }
                throw new IllegalArgumentException("Days o1 or o2 not valid in compartorByDays");
            }
            
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                int daysO1 = getMonth(o1).ordinal();
                int daysO2 = getMonth(o2).ordinal();
                if(daysO1 < daysO2) {
                    return -1;
                }
                if(daysO1 == daysO2) {
                    return 0;
                }
                if(daysO1 > daysO2) {
                    return 1;
                }
                throw new IllegalArgumentException("Days o1 or o2 not valid in compartorByOrder");
            }
              
        };
    }

    private Month getMonth(String nameMonth) {
        //qui devo richiamare probabilmente fromToString
        return Month.valueOf(nameMonth.toUpperCase());
    }

    public enum Month {
        JANUARY("january", LONG_MONTH),
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

        private int getDays() {
            return this.days;
        }

        private Month(final String monthName, final int days) {
            this.monthName = monthName;
            this.days = days;
        }
    }



}
