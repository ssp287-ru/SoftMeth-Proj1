package project1;

/**
 * Class used to define project1.Student Profiles
 * Includes firstName, lastName, & date of birth
 * @author Lucas Barrales
 */
public class Profile implements Comparable<Profile> {

    //Instance variable that store profile information
    private String firstName;
    private String lastName;
    private Date dob;


    /**
     * Constructor method
     * @param firstName
     * @param lastName
     * @param dateOfBirth
     */
    public Profile(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dateOfBirth;
    }

    /**
     * Getter method for first name
     * @return
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Getter method for Last name
      * @return
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Getter method for project1.Date of Birth
     * @return
     */
    public Date getDateOfBirth() {
        return dob;
    }

    /**
     * Setter method
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Setter method
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Setter method
     * @param dateOfBirth
     */
    public void setDateOfBirth(Date dateOfBirth) {
        this.dob = dateOfBirth;
    }

    /**
     * Defines how a project1.Profile object prints
     * @return Returns a string in the format "firstName lastName dob"
     */
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + dob;
    }

    /**
     * Checks if two profile objects are equal
     * @param other   the reference object with which to compare.
     * @return True if first name, last name, and date of birth same for both, false otherwise
     */
    @Override
    public boolean equals(Object other) {
        if (other instanceof Profile) {
            Profile otherProfile = (Profile) other;
            return this.firstName.equals(otherProfile.firstName) &&
                    this.lastName.equals(otherProfile.lastName) &&
                    this.dob.equals(otherProfile.dob);
        }
        return false;
    }

    /**
     * Compares two project1.Profile Objects, first by lastname, then firstname, then date of birth
     * @param other the object to be compared.
     * @return -1 if this.profile comes first, 1 if other comes first, 0 if equal
     */
    @Override
    public int compareTo(Profile other){
        switch(this.getLastName().compareTo(other.getLastName())){
            case(-1):
                return -1;
            case(1):
                return 1;
            default:
                switch(this.getFirstName().compareTo(other.getFirstName())){
                    case(-1):
                        return -1;
                    case(1):
                        return 1;
                    default:
                        switch(this.getDateOfBirth().compareTo(other.getDateOfBirth())){
                            case(-1):
                                return -1;
                            case(1):
                                return 1;
                            default:
                                return 0;
                        }
                }
        }
    }

}

