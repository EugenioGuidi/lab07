package it.unibo.nestedenum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import it.unibo.functional.api.Function;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    private static final int SHORT_MONTH = 28;
    private static final int USUAL_MONTH = 30;
    private static final int LONG_MONTH = 31;
    private static final int NOT_VALID_VAL = 0;

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
            int daysO1 = NOT_VALID_VAL;
            int daysO2 = NOT_VALID_VAL;
            for(MonthSorterNested.Month month : Month.values()) {
                if(month.getName().equals(o1)) {
                    daysO1 = month.getDays();
                }else if(month.getName().equals(o2)) {
                    daysO2 = month.getDays();
                }
            }
            if(daysO1 == NOT_VALID_VAL || daysO2 == NOT_VALID_VAL) {
                throw new IllegalArgumentException("Element non found in month (SortByDate)");
            }
            if(daysO1 < daysO2) {
                return -1;
            }else if(daysO1 == daysO2) {
                return 0;
            }
            return 1;
        }
        
    }

    public static class SortByMonthOrder implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            for(MonthSorterNested.Month month : MonthSorterNested.Month.values()) {
                if(month.fromString(o1) instanceof MonthSorterNested.Month) {
                    return -1;
                }else if(month.fromString(o2) instanceof MonthSorterNested.Month) {
                    return 1;
                }
            }
            throw new IllegalArgumentException("Element non found in month (SortByMonthOrder)");
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

        private String monthName;
        private int days;

        private Month(final String monthName, final int days) {
            this.monthName = monthName;
            this.days = days;
        }

        public String getName() {
            return this.name();
        }

        public int getDays() {
            return this.days;
        }

        public static Month fromString(String name) {
            String nameLowerCase = name.toLowerCase();
            int cont = 0;
            Month month = null;
            for(Month m : Month.values()) {
                if(m.getName().startsWith(nameLowerCase)) {
                    cont = cont + 1;
                    month = m;
                }
            }
            if(cont == 1) {
                return month;
            }else {
                throw new IllegalArgumentException("Too many months found or not at all " + nameLowerCase);
            }
        }
    }
}
