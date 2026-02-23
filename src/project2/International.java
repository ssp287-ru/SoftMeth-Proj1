package project2;

import project1.Major;
import project1.Profile;

public class International extends NonResident{
    private boolean isStudyAbroad;
    private double internationalTuition = 35758;
    private double universityFee = 3891;
    private double adminFee = 500;
    private double healthInsurance = 2650;


    /**
     * Constructor Method
     *
     * @param profile
     * @param major
     * @param credits
     */
    public International(Profile profile, Major major, int credits, boolean isStudyAbroad) {
        super(profile, major, credits);
        this.isStudyAbroad = isStudyAbroad;
    }


    // Waiting on email clarification to come back to fully implement
    @Override
    public double tuition(int creditsEnrolled) {
        if(isStudyAbroad){
            return 1;
        }
        return 0;
    }

}
