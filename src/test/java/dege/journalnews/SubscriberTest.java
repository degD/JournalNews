package dege.journalnews;

import org.junit.Test;
import static org.junit.Assert.*;

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
