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

        public String getName() {
            return this.name();
        }

        public Month fromString(String name) {
            int cont = 0;
            Month month = null;
            for(Month m : Month.values()) {
                if(m.getName().startsWith(name)) {
                    cont = cont + 1;
                    month = m;
                }
            }
            if(cont == 1) {
                return month;
            }else {
                throw new IllegalArgumentException("Too many months found or not at all");
            }
        }
    }
}
