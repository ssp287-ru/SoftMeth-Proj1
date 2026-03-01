package util;

import org.junit.Test;
import static org.junit.Assert.*;

public class DateTest {

    @Test
    public void testDaysInFebruary() {
        Date invalid = new Date(2, 29, 2003); // Feb 29th, 2003, should be invalid
        Date valid = new Date(2, 29, 2004); // Feb 29th, 2004, should be valid
        assertFalse(invalid.isValid());
        assertTrue(valid.isValid());
    }

    @Test
    public void testMonthDayBounds(){
        Date invalidDay = new Date(3, -1, 2004); // 3/-1/2004, invalid day
        Date invalidMonthNeg = new Date(-1,1, 2005); // -1/1/2005, invalid month
        Date invalidMonthPos = new Date(13, 4, 2006); // 13/4/2006, invalid month
        assertFalse(invalidDay.isValid());
        assertFalse(invalidMonthNeg.isValid());
        assertFalse(invalidMonthPos.isValid());
    }

    @Test
    public void testStandardDate(){
        Date valid = new Date(10, 31, 2005); // 10/31/2005, should be valid
        assertTrue(valid.isValid());
    }
}