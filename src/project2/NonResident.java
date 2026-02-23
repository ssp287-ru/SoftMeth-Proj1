package project2;

import project1.Major;
import project1.Profile;

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

    public double  getFullTimeTuition(){
        return fullTimeTuition;
    }

    public double getUniversityFee(){
        return universityFee;
    }

    public double getPerCreditHour(){
        return perCreditHour;
    }

    public double getPartTimeUniversityFee(){
        return partTimeUniversityFee;
    }

}
