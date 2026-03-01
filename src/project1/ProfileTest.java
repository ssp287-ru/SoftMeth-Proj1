package project1;

import org.junit.Test;
import util.Date;

import static org.junit.Assert.*;

public class ProfileTest {
    private int leftEarlier = -1;
    private int rightEarlier = 1;
    private int sameTime = 0;

    @Test
    public void compareTo() {
        Profile student1 = new Profile("Otto", "Octavious", new Date(1, 10, 1931));
        Profile student2 = new Profile("Peter", "Parker", new Date(5, 10, 1931));
        assert(student1.compareTo(student2) == leftEarlier); // Test Case 1
        student1 = new Profile("Otto", "Parker", new Date(1, 10, 1931));
        student2 = new Profile("Peter", "Parker", new Date(5, 10, 1931));
        assert(student1.compareTo(student2) == leftEarlier); // Test Case 2
        student1 = new Profile("Peter", "Parker", new Date(1, 10, 1931));
        student2 = new Profile("Peter", "Parker", new Date(1, 11, 1931));
        assert(student1.compareTo(student2) == leftEarlier); // Test Case 3
        student2 = student1;
        assert(student1.compareTo(student2) == sameTime);; // Test Case 4
        student1 = new Profile("Peter", "Parker", new Date(5, 10, 1931));
        student2 = new Profile("Otto", "Octavious", new Date(1, 10, 1931));
        assert(student1.compareTo(student2) == rightEarlier); // Test Case 5
        student1 = new Profile("Peter", "Parker", new Date(5, 10, 1931));
        student2 = new Profile("Otto", "Parker", new Date(1, 10, 1931));
        assert(student1.compareTo(student2) == rightEarlier); // Test Case 6
        student1 = new Profile("Peter", "Parker", new Date(1, 11, 1931));
        student2 = new Profile("Peter", "Parker", new Date(1, 10, 1931));
        assert(student1.compareTo(student2) == rightEarlier); // Test Case 7
    }

}