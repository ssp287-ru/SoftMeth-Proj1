package project2;

import project1.Major;
import project1.Profile;

/**
 * Defines a NonResident student
 * @author Shivang Patel
 */
public abstract class NonResident extends Student{
    private final double perCreditHour = 1162;
    private final double fullTimeTuition = 35758;
    private final double universityFee = 3891;
    private final double partTimeUniversityFee = 0.5 * universityFee;

    /**
     * Constructor Method
     *
     * @param profile
     * @param major
     * @param credits
     */
    public NonResident(Profile profile, Major major, int credits) {
        super(profile, major, credits);
    }

    /**
     * Tuition method for non-resident students
     * @param creditsEnrolled
     * @return
     */
    public double tuition(int creditsEnrolled){
        if (creditsEnrolled >= 12){ // if student is full time
            if (creditsEnrolled > 16){ // if need to apply additional fee
                return fullTimeTuition + universityFee + perCreditHour * (creditsEnrolled - 16);
            }
            else{
                return fullTimeTuition + universityFee;
            }
        }
        return perCreditHour * creditsEnrolled + partTimeUniversityFee; // if student is part time
    }

    /**
     * Getter method
     * @return
     */
    public double  getFullTimeTuition(){
        return fullTimeTuition;
    }

    /**
     * Getter method
     * @return
     */
    public double getUniversityFee(){
        return universityFee;
    }

    /**
     * Getter method
     * @return
     */
    public double getPerCreditHour(){
        return perCreditHour;
    }

    /**
     * Getter method
     * @return
     */
    public double getPartTimeUniversityFee(){
        return partTimeUniversityFee;
    }

}
