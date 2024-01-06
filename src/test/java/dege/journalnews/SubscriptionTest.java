/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dege.journalnews;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author deneg
 */
public class SubscriptionTest {
    
    private Subscription s;
    
    public SubscriptionTest() {
    }

    @Before
    public void setup() {
	s = new Subscription(
		new DateInfo(1, 1), 1, 
		new Journal("TEST", "1234", 1, 100),
		new Individual("TEST", "ADDR"));
    }
    
    @Test
    public void testCompletePayment() {
	assertEquals(100, s.getCompletePaymentAmount(), 0.001);
    }
    
    @Test
    public void testCalcDiscount() {
	assertEquals(0, (new Subscription(null, 1, null, null)).calculateDiscountRatio(), 0.001);
	assertEquals(5, (new Subscription(null, 10, null, null)).calculateDiscountRatio(), 0.001);
	assertEquals(10, (new Subscription(null, 20, null, null)).calculateDiscountRatio(), 0.001);
	assertEquals(20, (new Subscription(null, 30, null, null)).calculateDiscountRatio(), 0.001);
    }
    
    @Test
    public void testAcceptingPayment() {
	assertTrue(s.acceptPayment(50));
	assertEquals(50, s.getPayment().getReceivedPayment(), 0.001);
	assertFalse(s.acceptPayment(100));
	assertEquals(100, s.getPayment().getReceivedPayment(), 0.001);
	
	assertTrue(s.isPaymentComplete());
    }
    
    @Test
    public void testChangingNumOfCopies() {
	s.acceptPayment(40);
	s.setCopies(20);
	assertEquals(10, s.calculateDiscountRatio(), 0.001);
	assertEquals(40, s.getPayment().getReceivedPayment(), 0.001);
	
	s.increaseCopies(10);
	assertEquals(30, s.getCopies());
    }
    
    @Test
    public void testDiscountPrice() {
	s.setCopies(50);
	assertEquals(80, s.getIssuePriceWithDiscount(), 0.001);
    }
    
    @Test
    public void testAccess() {
	assertEquals(100.0/12, s.getMonthlyPrice(), 0.01);
	
	assertEquals(100.0/12 * 5, s.paymentForAccess(5), 0.01);
	assertEquals(100.0/12 * 10, s.paymentForAccess(10), 0.01);
	
	s.acceptPayment(30);
	assertTrue(s.canSend(2));
	assertFalse(s.canSend(9));
    }
    
    @Test
    public void testExpiration() {
	assertTrue(s.isExpired(1, 2));
	assertTrue(s.isExpired(10, 10));
	assertTrue(s.isExpired(0, 0));
	
	assertFalse(s.isExpired(1, 1));
	assertFalse(s.isExpired(5, 1));
    }
}
