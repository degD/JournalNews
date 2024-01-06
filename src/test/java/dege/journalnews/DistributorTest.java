/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dege.journalnews;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author deneg
 */
public class DistributorTest {
    
    private Distributor d;
    private Journal j1 = new Journal("jou1", "1234", 12, 36);
    private Journal j2 = new Journal("jou2", "2345", 6, 60);
    private Subscriber s1 = new Individual("i", "addr");
    private Subscriber s2 = new Corporation("c", "cat");
    
    public DistributorTest() {
    }
    
    @Before
    public void setup() {
	d = new Distributor();
	d.addJournal(j1);
	d.addJournal(j2);
	d.addSubscriber(s1);
	d.addSubscriber(s2);
    }

    @Test
    public void testAddSubscription() {
	assertTrue("A new subscription.", 
		d.addSubscription(j1.getIssn(), s1, new Subscription(null, 1, j1, s1)));
	assertTrue("An existing subscription.",
		d.addSubscription(j1.getIssn(), s1, new Subscription(null, 2, j1, s1)));
	
	assertEquals("Should increase number of copies.", 
		3, d.listIssnSubscriptions(j1.getIssn()).get(0));
	
	assertTrue("With null values.", d.addSubscription(null, null, null));
    }
    
    @Test
    public void testListingIncomplete() {
	d.addSubscription("1234", s1, new Subscription(new DateInfo(1, 1), 1, j1, s1));
	assertEquals(1, d.listIncompletePayments().size());
	
	d.listIncompletePayments().get(0).acceptPayment(1000);
	assertEquals(0, d.listIncompletePayments().size());
    }
    
    @Test
    public void testListingSendingOrders() {
	d.addSubscription("1234", s1, new Subscription(new DateInfo(1, 1), 1, j1, s1));
	assertEquals(0, d.listAllSendingOrders(1, 1).size());
	
	d.listIncompletePayments().get(0).acceptPayment(1000);
	assertEquals(1, d.listAllSendingOrders(1, 1).size());
	assertEquals(1, d.listAllSendingOrders(4, 1).size());
	assertEquals(0, d.listAllSendingOrders(4, 1).size());
    }
    
    @Test
    public void testFileIO() {
	d.saveState("test.save");
	assertTrue((new File("test.save")).exists());
	
	Distributor x = new Distributor();
	x.readState("test.save");
	assertEquals(d, x);
    }
    
    @AfterClass
    public void cleanup() {
	try {
	    Files.deleteIfExists((new File("test.save").toPath()));
	} catch (IOException ex) {
	    Logger.getLogger(DistributorTest.class.getName()).log(Level.SEVERE, null, ex);
	}
    }
}
