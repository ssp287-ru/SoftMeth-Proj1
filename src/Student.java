//The Student class represents a student in the system
//It uses a Profile object to store persona information
public class Student {

    //Instance variables store student data
    private Profile profile;
    private Major major;
    private int credits;

    //constructors
    public Student(Profile profile, Major major, int credits){
        this.profile = profile;
        this.major = major;
        this.credits = credits;
    }

    //Getter for profile
    public Profile getProfile(){
        return profile;
    }

    //Getter for major
    public Major getMajor(){
        return this.major;
    }

    //Getter for credits
    public int getCredits(){
        return credits;
    }

    //Setter for major
    public void setMajor(Major major){
        this.major = major;
    }

    //Setter for credits
    public void setCredits(int credits){
        this.credits = credits;
    }

    //Determines a students class standing based on credits
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

    //toString defines how a student prints
    @Override
    public String toString() {
        return profile + ", Major: " + major +
                ", Credits: " + credits +
                ", Standing: " + getStanding();
    }

    //equals to compare two Student objects
    public boolean equals(Student other) {
        return this.profile.equals(other.profile);
    }

}
