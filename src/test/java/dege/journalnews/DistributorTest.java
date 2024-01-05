/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package dege.journalnews;

import java.util.Hashtable;
import java.util.Vector;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deneg
 */
public class DistributorTest {
    
    public DistributorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getJournals method, of class Distributor.
     */
    @Test
    public void testGetJournals() {
	System.out.println("getJournals");
	Distributor instance = new Distributor();
	Hashtable<String, Journal> expResult = null;
	Hashtable<String, Journal> result = instance.getJournals();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of setJournals method, of class Distributor.
     */
    @Test
    public void testSetJournals() {
	System.out.println("setJournals");
	Hashtable<String, Journal> journals = null;
	Distributor instance = new Distributor();
	instance.setJournals(journals);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getSubscribers method, of class Distributor.
     */
    @Test
    public void testGetSubscribers() {
	System.out.println("getSubscribers");
	Distributor instance = new Distributor();
	Vector<Subscriber> expResult = null;
	Vector<Subscriber> result = instance.getSubscribers();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of setSubscribers method, of class Distributor.
     */
    @Test
    public void testSetSubscribers() {
	System.out.println("setSubscribers");
	Vector<Subscriber> subscribers = null;
	Distributor instance = new Distributor();
	instance.setSubscribers(subscribers);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of addJournal method, of class Distributor.
     */
    @Test
    public void testAddJournal() {
	System.out.println("addJournal");
	Journal aJournal = null;
	Distributor instance = new Distributor();
	boolean expResult = false;
	boolean result = instance.addJournal(aJournal);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of searchJournal method, of class Distributor.
     */
    @Test
    public void testSearchJournal() {
	System.out.println("searchJournal");
	String issn = "";
	Distributor instance = new Distributor();
	Journal expResult = null;
	Journal result = instance.searchJournal(issn);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of addSubscriber method, of class Distributor.
     */
    @Test
    public void testAddSubscriber() {
	System.out.println("addSubscriber");
	Subscriber aSubscriber = null;
	Distributor instance = new Distributor();
	boolean expResult = false;
	boolean result = instance.addSubscriber(aSubscriber);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of searchSubscriber method, of class Distributor.
     */
    @Test
    public void testSearchSubscriber() {
	System.out.println("searchSubscriber");
	String name = "";
	Distributor instance = new Distributor();
	Subscriber expResult = null;
	Subscriber result = instance.searchSubscriber(name);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of addSubscription method, of class Distributor.
     */
    @Test
    public void testAddSubscription() {
	System.out.println("addSubscription");
	String issn = "";
	Subscriber aSubscriber = null;
	Subscription aSubscription = null;
	Distributor instance = new Distributor();
	boolean expResult = false;
	boolean result = instance.addSubscription(issn, aSubscriber, aSubscription);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of listAllSendingOrders method, of class Distributor.
     */
    @Test
    public void testListAllSendingOrders() {
	System.out.println("listAllSendingOrders");
	int month = 0;
	int year = 0;
	Distributor instance = new Distributor();
	instance.listAllSendingOrders(month, year);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of listSendingOrders method, of class Distributor.
     */
    @Test
    public void testListSendingOrders() {
	System.out.println("listSendingOrders");
	String issn = "";
	int month = 0;
	int year = 0;
	Distributor instance = new Distributor();
	instance.listSendingOrders(issn, month, year);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getAllSubscriptions method, of class Distributor.
     */
    @Test
    public void testGetAllSubscriptions() {
	System.out.println("getAllSubscriptions");
	Distributor instance = new Distributor();
	Vector<Subscription> expResult = null;
	Vector<Subscription> result = instance.getAllSubscriptions();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of listIncompletePayments method, of class Distributor.
     */
    @Test
    public void testListIncompletePayments() {
	System.out.println("listIncompletePayments");
	Distributor instance = new Distributor();
	instance.listIncompletePayments();
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of listSubscriberSubscriptions method, of class Distributor.
     */
    @Test
    public void testListSubscriberSubscriptions() {
	System.out.println("listSubscriberSubscriptions");
	String SubscriberName = "";
	Distributor instance = new Distributor();
	instance.listSubscriberSubscriptions(SubscriberName);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of listIssnSubscriptions method, of class Distributor.
     */
    @Test
    public void testListIssnSubscriptions() {
	System.out.println("listIssnSubscriptions");
	String issn = "";
	Distributor instance = new Distributor();
	instance.listIssnSubscriptions(issn);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of saveState method, of class Distributor.
     */
    @Test
    public void testSaveState() {
	System.out.println("saveState");
	String filename = "test.save";
	Distributor instance = new Distributor();
	instance.saveState(filename);
	
    }

    /**
     * Test of readState method, of class Distributor.
     */
    @Test
    public void testReadState() {
	System.out.println("readState");
	String filename = "";
	Distributor instance = new Distributor();
	instance.readState(filename);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }
    
}
