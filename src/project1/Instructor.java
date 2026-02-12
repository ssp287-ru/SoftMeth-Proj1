package project1;

/**
 * Enum class for Instructors, has no additional properties
 * @author Shivang Patel
 */
public enum Instructor {
    Patel,
    Lim,
    Zimnes,
    Harper,
    Kaur,
    Taylor,
    Ramesh,
    Ceravolo,
    Brown;

    /**
     * Constructor called by JVM to create instructor objects defined above.
     */
    Instructor(){
    }

    /**
     * toString() override function
     * @return Returns last name of instructor
     */
    @Override
    public String toString() {
        return name();
    }

}
