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
public class PaymentInfoTest {
    
    public PaymentInfoTest() {
    }

    @Test
    public void testPayment() {
	PaymentInfo p = new PaymentInfo(0);
	p.increasePayment(100);
	assertEquals(100, p.getReceivedPayment(), 0.001);
    }
    
    @Test
    public void testDiscount() {
	PaymentInfo p = new PaymentInfo(50);
	assertEquals(50, p.getDiscountRatio(), 0.001);
    }
}
