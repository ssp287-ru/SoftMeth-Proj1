package project2;

import org.junit.Test;
import project1.Profile;
import util.Date;
import project1.Major;

import static org.junit.Assert.*;

/**
 * Test functions to test proper tuition calculation for full time, full time w/ scholarship, part time, and part time w/ scholarhip
 * @author Shivang Patel
 */
public class ResidentTest {
    private final Profile placeholderProfile = new Profile("Alx", "Preston", new Date(10, 31, 2005));
    private final Resident student = new Resident(placeholderProfile, Major.CS, 109, 0);
    private final Resident studentScholarship = new Resident(placeholderProfile, Major.CS, 109, 10000);


    /**
     * Verifies full time tuition properly calculated
     */
    @Test
    public void fullTime() {
        double expectedTuition = 14933 + 3891 + 482 * (18 - 16); // tuition + university fee + extra credit hours = 19788
        assertTrue(student.tuition(18) == expectedTuition);
    }

    /**
     * Verifies full time w/ scholarship tuition properly calculated
     */
    @Test
    public void fullTimeScholarship() {
        double expectedTuition = 14933 + 3891 + 482 * (18 - 16) - 10000; // tuition + fee + credit hours - scholarship = 9788
        assertTrue(studentScholarship.tuition(18) == expectedTuition);
    }

    /**
     * Verifies part time tuition properly calculated
     */
    @Test
    public void partTime() {
        double expectedTuition = 482 * 10 + 0.5 * 3891; // 10 credit hours + 50% university fee = 6765.5
        assertTrue(student.tuition(10) == expectedTuition);
    }

    /**
     * Verifies part time w/ scholarship properly calculated
     * Redundant, scenario should not be possible
     */
    @Test
    public void partTimeScholarship(){
        double expectedTuition  = 482 * 10 + 0.5 * 3891; // 10 credit hours + 50% university fee = 6765.5, ineligible for scholarship
        assertTrue(studentScholarship.tuition(10) == expectedTuition);
    }
}