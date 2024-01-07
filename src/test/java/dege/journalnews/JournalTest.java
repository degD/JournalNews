package dege.journalnews;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class JournalTest {
    
    private Journal j;
    
    public JournalTest() {
    }
    
    @Before
    public void setup() {
	j = new Journal("TEST", "1234", 1, 10);
    }

    @Test
    public void testAddingSubscription() {
	Subscription s = new Subscription(null, 1, j, null);
	
	j.addSubscription(s);
	assertEquals(s, j.getSubscriptions().get(0));
    }
    
    @Test
    public void testFinding() {
	Individual subscriber = new Individual("a", "b");
	Subscription s = new Subscription(null, 1, j, subscriber);
	j.addSubscription(s);
	
	assertEquals(0, j.findSubscription(subscriber));
	assertEquals(-1, j.findSubscription(new Corporation("c", "b")));
    }
    
    @Test
    public void testRemoving() {
	Individual subscriber = new Individual("a", "b");
	Subscription s = new Subscription(null, 1, j, subscriber);
	j.addSubscription(s);
	
	j.removeSubscription(subscriber);
	assertEquals(-1, j.findSubscription(subscriber));
    }
}
