public class Date {
    // Instance variables store the state of the object
    private int month;
    private int day;
    private int year;

    //Constructor: runs when a Date object is created
    public Date(int month, int day, int year) {
        this.month = month;
        this.day = day;
        this.year = year;
    }

    //Getter method for month
    public int getMonth() {
        return month;
    }

    //Getter method for day
    public int getDay() {
        return day;
    }

    //Getter method for year
    public int getYear(){
        return year;
    }

    //Setter for month
    public void setMonth(int  month){
        this.month = month;
    }

    //Setter for day
    public void setDay(int day){
        this.day = day;
    }

    //Setter for year
    public void setYear(int year){
        this.year = year;
    }

    //toString defines how the object print when use with sout
    @Override
    public String toString() {
        return month + "/" + day + "/" + year;
    }


    //equals compares two Date objects for equality
    public boolean equals (Date other) {
        return this.month == other.month &&
                this.day == other.day &&
                this.year == other.year;
    }
}
