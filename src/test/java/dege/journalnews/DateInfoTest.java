/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dege.journalnews;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deneg
 */
public class DateInfoTest {

    DateInfo d1 = new DateInfo(1, 1);
    DateInfo d2 = new DateInfo(12, 1);

    public DateInfoTest() {
    }

    @Test
    public void testStart() {
	assertEquals(d1.getStartDate(), 1);
	assertEquals(d1.getStartYear(), 1);
    }
    
    @Test
    public void testEnd() {
	assertEquals(d1.getEndMonth(), 12);
	assertEquals(d2.getEndMonth(), 11);
	assertEquals(d1.getEndYear(), 1);
	assertEquals(d2.getEndYear(), 2);
    }
}
