package project2;

import org.junit.Test;
import project1.Profile;
import util.Date;
import project1.Major;
import static org.junit.Assert.*;

/**
 * Test functions to verify that correct tuition is being calculated for non-study abroad international and study-abroad international students.
 * @author Shivang Patel
 */
public class InternationalTest {
    private final Profile placeholderProfile = new Profile("Alx", "Preston", new Date(10, 31, 2005));
    private final International student = new International(placeholderProfile, Major.CS, 109, false);
    private final International studentStudyAbroad = new International(placeholderProfile, Major.CS, 109, true);

    /**
     * Verifies study abroad tuition is properly calculated
     */
    @Test
    public void studyAbroad() {
        double expectedTuition = 3891 + 2650 + 500; // university fee + admin fee + health insurance fee = 7041
        assertTrue(studentStudyAbroad.tuition(12) == expectedTuition);
    }

    /**
     * Verifies non-study abroad international tuition is properly calculated
     */
    @Test
    public void notStudyAbroad() {
        double expectedTuition = 35758 + 3891 + 2650 + 500; // tuition + university fee + admin fee + health insurance fee = 42799
        assertTrue(student.tuition(12) == expectedTuition);
    }

}