package project1;

/**
 * Defines a student in the system
 * Includes student profile, major, and credits
 * @author Lucas Barrales
 */
public class Student implements Comparable<Student>{

    //Instance variables store student data
    private Profile profile;
    private Major major;
    private int credits;

    /**
     * Constructor Method
      * @param profile
     * @param major
     * @param credits
     */
    public Student(Profile profile, Major major, int credits){
        this.profile = profile;
        this.major = major;
        this.credits = credits;
    }

    /**
     * Getter Method for project1.Profile
      * @return
     */
    public Profile getProfile(){
        return profile;
    }

    /**
     * Getter Method for Major
      * @return
     */
    public Major getMajor(){
        return this.major;
    }

    /**
     * Getter Method for Credits
      * @return
     */
    public int getCredits(){
        return credits;
    }

    /**
     * Setter method for Major
      * @param major
     */
    public void setMajor(Major major){
        this.major = major;
    }

    /**
     * Setter method for Credits
      * @param credits
     */
    public void setCredits(int credits){
        this.credits = credits;
    }

    /**
     * Calculates a student's standing based on credits
      * @return project1.Student's Standing (Freshman/Sophomore/Junior/Senior)
     */
    public String getStanding(){
        if (credits < 30){
            return "Freshman";
        } else if (credits < 60){
            return "Sophomore";
        } else if (credits < 90){
            return "Junior";
        } else {
            return "Senior";
        }
    }

    /**
     * Overrides toString() method
      * @return String with format "studentProfile, Major major, Credits credits, Standing standing
     */
    @Override
    public String toString() {
        return profile + ", Major: " + major +
                ", Credits: " + credits +
                ", Standing: " + getStanding();
    }

    /**
     * Overrides equals() method
      * @param otherObject project1.Student object to compare to
     * @return true if student profiles are equal, false otherwise
     */
    @Override
    public boolean equals(Object otherObject) {
        if (!(otherObject instanceof Student)){
            return false;
        }
        Student other = (Student) otherObject;
        return this.profile.equals(other.profile);
    }

    /**
     * Overrides compareTo() method
     * Uses student profiles to compare
     * @param otherStudent the object to be compared.
     * @return -1 if this.profile is before, 1 if otherStudent.profile is before, 0 if equal
     */
    @Override
    public int compareTo(Student otherStudent){
        return this.getProfile().compareTo(otherStudent.getProfile());
    }

}
