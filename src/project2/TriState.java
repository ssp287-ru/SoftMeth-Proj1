package project2;

import project1.Major;
import project1.Profile;

public class TriState extends NonResident{
    private final String newYork = "NY";
    private final String connecticut = "CT";
    private String state;

    /**
     * Constructor Method
     *
     * @param profile
     * @param major
     * @param credits
     */
    public TriState(Profile profile, Major major, int credits, String state) {
        super(profile, major, credits);
        this.state = state;
    }


    @Override
    public double tuition(int creditsEnrolled) {
        boolean isFullTime = (creditsEnrolled >= 12); // 12+ credits is full time
        int remission;
        switch(state) {
            case (newYork):
                remission = 4000;
            case (connecticut):
                remission = 5000;
            default:
                remission = 0;
        }
        if (isFullTime){
            boolean addAdditionalFee = (creditsEnrolled >= 16); // 16+ credits is additional fee
            if (addAdditionalFee){
                return super.getFullTimeTuition() + super.getUniversityFee() +
                        super.getPerCreditHour() * (creditsEnrolled - 16) - remission;
            }
            else{
                return super.getFullTimeTuition() + super.getUniversityFee() - remission;
            }
        }
        else{
            return super.getPerCreditHour() * creditsEnrolled + super.getPartTimeUniversityFee();
        }
    }
}
