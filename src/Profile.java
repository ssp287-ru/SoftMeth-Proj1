//Profile class represents a persons identity information
//It will be used by Student class
public class Profile {

    //Instance variable that store profile information
    private String firstName;
    private String lastName;
    private Date dateOfBirth;


    //Constructor; creates Profile object with a name and DOB
    public Profile(String firstName, String lastName, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    //Getter for first name
    public String getFirstName() {
        return firstName;
    }

    //Getter for last name
    public String getLastName() {
        return lastName;
    }

    //Getter for DOB
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    //Setter for first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Setter for last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //Setter for DOB
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    //toString defines how an Object prints
    @Override
    public String toString() {
        return firstName + " " + lastName + " " + dateOfBirth;
    }

    //equals to compare two Profile objects
    public boolean equals(Profile other) {
        return this.firstName.equals(other.firstName) &&
                this.lastName.equals(other.lastName) &&
                this.dateOfBirth.equals(other.dateOfBirth);

    }

}

