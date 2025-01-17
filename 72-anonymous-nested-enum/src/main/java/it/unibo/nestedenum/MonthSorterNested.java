package it.unibo.nestedenum;

import java.util.Comparator;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    private static final int SHORT_MONTH = 28;
    private static final int USUAL_MONTH = 30;
    private static final int LONG_MONTH = 31;

    @Override
    public Comparator<String> sortByDays() {
        return new SortByDate();
    }

    @Override
    public Comparator<String> sortByOrder() {
        return new SortByMonthOrder();
    }

    public static class SortByDate implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int daysO1 = Month.fromString(o1).getDays();
            int daysO2 = Month.fromString(o2).getDays();
            return Integer.compare(daysO1, daysO2);
        }
        
    }

    public static class SortByMonthOrder implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            int daysO1 = Month.fromString(o1).ordinal();
            int daysO2 = Month.fromString(o2).ordinal();
            return Integer.compare(daysO1, daysO2);
        }
        
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

        private String nameMonth;
        private int days;

        private int getDays() {
            return this.days;
        }

        private String getNameMonth() {
            return this.nameMonth;
        }

        private Month(final String monthName, final int days) {
            this.nameMonth = monthName;
            this.days = days;
        }

        private static Month fromString(String nameMonth) {
            Month matchedMonth = null;
            for(Month month : Month.values()) {
                if(month.getNameMonth().startsWith(nameMonth.toLowerCase())) {
                    if(matchedMonth != null) {
                        throw new IllegalArgumentException("String that match more then one month");
                    }
                    matchedMonth = month;
                }
            }
            if(matchedMonth == null) {
                throw new IllegalArgumentException("String that don't found a month");
            }
            return matchedMonth;
        }
    }
}
