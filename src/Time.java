/**
 * Enum class for class periods / time, includes two additional properties - Hour and Minute
 * @author Shivang Patel
 */
public enum Time {
    periodOne(8, 30),
    periodTwo(10, 20),
    periodThree(12, 10),
    periodFour(14, 0),
    periodFive(15, 50),
    periodSix(17, 10);

    private final int hour; // Hour a class begins, uses military time designations
    private final int minute; // Minute in the hour a class begins

    /**
     * Constructor used by JVM to create Time objects defined above
     * @param hour Hour section takes place
     * @param minute minute in hour section takes place
     */
    Time(int hour, int minute){
        this.hour = hour;
        this.minute = minute;
    }

    /**
     * toString() override method for class
     * @return Returns the period name, hour, and minute in the format periodName, hour:minute
     */
    @Override
    public String toString(){
        if (minute == 0){
            return name() + ", " + hour + ":00";
        }
        return name() + ", " + hour + ":" + minute;
    }

    /**
     * Accessor Method for hour
     * @return Returns hour parameter for a given time object
     */
    public int getHour(){
        return hour;
    }



}
