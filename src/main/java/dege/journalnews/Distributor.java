package dege.journalnews;

import java.util.Hashtable;
import java.util.Vector;
import java.io.*;

public class Distributor implements java.io.Serializable {

    private static final long serialVersionUID = -4739748530631712123L;
    private Hashtable<String, Journal> journals = new Hashtable<>();
    private Vector<Subscriber> subscribers = new Vector<>();

    public Hashtable<String, Journal> getJournals() {
	return journals;
    }

    public void setJournals(Hashtable<String, Journal> journals) {
	this.journals = journals;
    }

    public Vector<Subscriber> getSubscribers() {
	return subscribers;
    }

    public void setSubscribers(Vector<Subscriber> subscribers) {
	this.subscribers = subscribers;
    }

    public boolean addJournal(Journal aJournal) {
	if (aJournal == null) {
	    return false;
	}
	journals.put(aJournal.getIssn(), aJournal);
	return true;
    }

    public Journal searchJournal(String issn) {
	return journals.get(issn);
    }

    public boolean addSubscriber(Subscriber aSubscriber) {
	if (aSubscriber == null) {
	    return false;
	}
	subscribers.add(aSubscriber);
	return true;
    }

    public Subscriber searchSubscriber(String name) {
	for (Subscriber aSubscriber : subscribers) {
	    if (name.equals(aSubscriber.getName())) {
		return aSubscriber;
	    }
	}
	return null;
    }

    public boolean addSubscription(String issn, Subscriber aSubscriber, Subscription newSubscription) {
	Journal aJournal = searchJournal(issn);
	if (aJournal == null || aSubscriber == null)
	    // aJournal or aSubscriber does not exist.
	    return false;
	
	else {
	    // Check existance of a subscription with the Subscriber.
	    int i = aJournal.findSubscription(aSubscriber);
	    
	    if (i == -1) {
		// If there is not, make a new subscription.
		aJournal.addSubscription(newSubscription);
	    }
	    
	    else {
		// Else, increase number of copies from existing subscription.
		int newCopiesNr = newSubscription.getCopies();
		Subscription oldSubscription = aJournal.getSubscriptions().get(i);
		oldSubscription.increaseCopies(newCopiesNr);
		aJournal.getSubscriptions().set(i, oldSubscription);
	    }
	    return true;
	}
    }

    public Hashtable<String, Vector<Subscriber>> listAllSendingOrders(int month, int year) {
	Hashtable<String, Vector<Subscriber>> journalsAndSubscribers = new Hashtable<>();
	
	for (String issn : journals.keySet()) {
	    journalsAndSubscribers.put(issn, listSendingOrders(issn, month, year));
	}
	
	return journalsAndSubscribers;
    }

    public Vector<Subscriber> listSendingOrders(String issn, int month, int year) {
	Journal aJournal = searchJournal(issn);
	Vector<Subscriber> subscribersToSend = new Vector<>();

	for (Subscription aSubscription : aJournal.getSubscriptions()) {
	    if (aSubscription.isSubscribed(month, year) && aSubscription.canSend(month)) {
		subscribersToSend.add(aSubscription.getSubscriber());
	    }
	}
	
	return subscribersToSend;
    }

    public Vector<Subscription> getAllSubscriptions() {
	Vector<Subscription> subscriptions = new Vector<>();
	for (String issn : journals.keySet()) {
	    subscriptions.addAll(searchJournal(issn).getSubscriptions());
	}
	return subscriptions;
    } 

    public Vector<Subscription> listIncompletePayments() {
	Vector<Subscription> incompleteSubscriptions = new Vector<>();
	
	for (Subscription aSubscription : getAllSubscriptions()) {
	    if (!aSubscription.isPaymentComplete()) {
		incompleteSubscriptions.add(aSubscription);
	    }
	}
	
	return incompleteSubscriptions;
    }

    public Vector<Subscription> listSubscriberSubscriptions(String SubscriberName) {
	Subscriber aSubscriber = searchSubscriber(SubscriberName);
	Vector<Subscription> subscriptionsOfSubscribers = new Vector<>();

	for (Subscription aSubscription : getAllSubscriptions()) {
	    if (aSubscriber == aSubscription.getSubscriber()) {
		subscriptionsOfSubscribers.add(aSubscription);
	    }
	}
	
	return subscriptionsOfSubscribers;
    }

    public Vector<Subscription> listIssnSubscriptions(String issn) {
	Journal aJournal = searchJournal(issn);
	Vector<Subscription> subscriptionsOfJournal = new Vector<>();
	
	for (Subscription aSubscription : aJournal.getSubscriptions()) {
	    subscriptionsOfJournal.add(aSubscription);
	}
	
	return subscriptionsOfJournal;
    }

    public synchronized void saveState(String filename) {
	try {
	    ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(filename));
	    writer.writeObject(this);
	    writer.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public synchronized void readState(String filename) {
	try {
	    ObjectInputStream reader = new ObjectInputStream(new FileInputStream(filename));
	    Distributor savedDistributor = (Distributor) reader.readObject();
	    setJournals(savedDistributor.getJournals());
	    setSubscribers(savedDistributor.getSubscribers());
	    reader.close();
	} catch (IOException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
    }
}
