package project2;

import org.junit.Test;
import project1.Profile;
import util.Date;
import project1.Major;

import static org.junit.Assert.*;

/**
 * Tests TriState tuition method to verify proper calculations
 * @author Shivang Patel
 */
public class TriStateTest {
    private Profile placeholderProfile = new Profile("Alx", "Preston", new Date(10, 31, 2005));
    private TriState student = new TriState(placeholderProfile, Major.CS, 109, "NY");

    /**
     * Verifies full time tuition is properly calculated including state rebate
     */
    @Test
    public void fullTime() {
        double expectedTuition = 35758 + 3891 - 4000;  // 35758(tuition) + 3891(universityFee) - 4000(NY Rebate) = 35649
       assertTrue(student.tuition(15) == expectedTuition);
    }

    /**
     * Verifies part time tuition is properly calculated and ignores state rebate
     */
    @Test
    public void partTime(){
        double expectedTuition = 1162 * 9 + 3891 * 0.5; // Tristate student with 9 credits: 1,162 * 9 + 3,891 * 50% = $12,403.50
        assertTrue(student.tuition(9) == expectedTuition);
    }
}