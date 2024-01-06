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
public class SubscriberTest {
    
    public SubscriberTest() {
    }

    @Test
    public void testIndividual() {
	Individual i = new Individual("TEST", "TEST");
	assertTrue("GetBillingInformation has implemented", i.getBillingInformation() instanceof String);
    }
    
    @Test
    public void testCorporation() {
	Corporation c = new Corporation("TEST", "TEST");
	assertTrue("GetBillingInformation has implemented", c.getBillingInformation() instanceof String);
    }
    
}
