package project1;
/**
 * Defines dates based on integeres representing month, day, and year
 * Months are defined 1-12
 * @author Lucas Barrales
 */

import java.util.Calendar;
public class Date implements Comparable<Date> {
    // Instance variables store the state of the object
    private int month;
    private int day;
    private int year;

    /**
     * Constructor method
      * @param month
     * @param day
     * @param year
     */
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    /**
     * Getter method
      * @return this.month
     */
    public int getMonth() {
        return month;
    }

    /**
     * Getter method
      * @return this.day
     */
    public int getDay() {
        return day;
    }

    /**
     * Getter method
      * @return this.year
     */
    public int getYear(){
        return year;
    }

    /**
     * Setter method
      * @param month
     */
    public void setMonth(int  month){
        this.month = month;
    }

    /**
     * Setter method
      * @param day
     */
    public void setDay(int day){
        this.day = day;
    }

    /**
     * Setter method
     * @param year
     */
    public void setYear(int year){
        this.year = year;
    }

    /**
     * Defines how date object is printed with toString() method
     * @return project1.Date in format MM/DD/YYYY
     */
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }

    /**
     * Compares two date objects and checks if they're equal
     * @param other project1.Date object to compare
     * @return True if years, months, and days are same, false otherwise
     */
    @Override
    public boolean equals (Object other) {
        if (!(other instanceof Date)){
            return false;
        }
        Date otherDate = (Date) other;
        return this.month == otherDate.month &&
                this.day == otherDate.day &&
                this.year == otherDate.year;
    }

    /**
     * Compares two date objects
     * @param o the object to be compared.
     * @return -1 if this.date comes before o.date, 1 if o.date comes before, 0 otherwise
     */
    @Override
    public int compareTo(Date o) {
        if (this.equals(o)){ // if the same day
            return 0;
        }
        if  (this.getYear() < o.getYear() || // if this.year comes before o.year
            (this.getYear() == o.getYear() && this.getMonth() < o.getMonth()) || // if years are same, but month is earlier
            (this.getYear() == o.getYear() && this.getMonth() == o.getMonth() && this.getDay() < o.getDay())){ // if years & months are same, but day is earlier
            return -1;
        }
        return 1; // if not the same day and this does not come first, o must come first, thus 1.
    }

    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    // months are 0-11 in Calendar, add 1 to make 1-12
    public static final int JAN = Calendar.JANUARY + 1; // 1
    public static final int FEB = Calendar.FEBRUARY + 1; // 2
    public static final int MAR = Calendar.MARCH + 1; // 3
    public static final int APR = Calendar.APRIL + 1; // 4
    public static final int MAY = Calendar.MAY + 1; // 5
    public static final int JUN = Calendar.JUNE + 1; // 6
    public static final int JUL = Calendar.JULY + 1; // 7
    public static final int AUG = Calendar.AUGUST + 1; // 8
    public static final int SEP = Calendar.SEPTEMBER + 1; // 9
    public static final int OCT = Calendar.OCTOBER + 1; // 10
    public static final int NOV = Calendar.NOVEMBER + 1; // 11
    public static final int DEC = Calendar.DECEMBER + 1; // 12

    int[] months31Days = {JAN, MAR, MAY, JUL, AUG, OCT, DEC};
    int[] months30Days = {APR, JUN, SEP, NOV};

    /**
     * Checks if a date is valid
     * @return True if date is valid, false otherwise
     */
    public boolean isValid(){
        int day = this.getDay();
        int month = this.getMonth();
        int year = this.getYear();
        if (month < 1 || month > 12 || day < 1){ // month out of 1-12 or day is 0 or negative
            return false;
        }
        for (int monthWith31Days : months31Days){
            if (monthWith31Days == month && day > 31) {
                return false;
            }
        } // if month is a month with 31 days
        for (int monthWith30Days : months30Days){
            if (monthWith30Days == month && day > 30) {
                return false;
            }
        } // if month is a month with 30 days
        boolean isLeap =    (year % QUADRENNIAL == 0 && year % CENTENNIAL != 0) ||
                            (year % CENTENNIAL == 0 && year % QUATERCENTENNIAL == 0);
        if (isLeap && day > 29) {
            return false;
        }
        if (day > 28){
            return false;
        }

        return true;
    }
}
