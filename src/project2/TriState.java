package project2;

import project1.Major;
import project1.Profile;

/**
 * Defines a student from the TriState area (New York or Connecticut), includes variable for state location
 * @author Shivang Patel
 */
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

    /**
     * Tuition method for TriState students,
     * @param creditsEnrolled
     * @return
     */
    @Override
    public double tuition(int creditsEnrolled) {
        boolean isFullTime = (creditsEnrolled >= 12); // 12+ credits is full time
        int remission;
        if (this.state.equals("NY")) {
            remission = 4000;
        } else if (this.state.equals("CT")) {
            remission = 5000;
        }
        else{
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
