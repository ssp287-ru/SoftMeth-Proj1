package project2;

import project1.Major;
import project1.Profile;

public class Resident extends Student {
    private double scholarship;
    private final double perCreditHour = 482;
    private final double fullTimeTuition = 14933;
    private final double universityFee = 3891;
    private final double partTimeUniversityFee = 0.5 * universityFee;

    /**
     * Constructor Method
     *
     * @param profile
     * @param major
     * @param credits
     */
    public Resident(Profile profile, Major major, int credits, int scholarship) {
        super(profile, major, credits);
        this.scholarship = scholarship;
    }


    @Override
    public double tuition(int creditsEnrolled) {
        boolean isFullTime = (creditsEnrolled >= 12); // 12+ credits is full-time
        if (isFullTime){
            boolean addAdditionalFee = (creditsEnrolled >= 16); // 16+ credits adds extra fee per credit
            if (addAdditionalFee){
                return fullTimeTuition + universityFee +
                        perCreditHour * (creditsEnrolled - 16) - scholarship;
            }
            else{
                return fullTimeTuition + universityFee - scholarship;
            }
        }
        else{
            return perCreditHour * creditsEnrolled + partTimeUniversityFee;
        }
    }

}
