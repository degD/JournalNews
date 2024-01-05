package dege.journalnews;

import java.util.Vector;

public class Journal implements java.io.Serializable {

    private final String name, issn;
    private final int frequency;
    private final double issuePrice;
    private Vector<Subscription> subscriptions = new Vector<>();

    public Journal(String name, String issn, int frequency, double issuePrice) {
	this.name = name;
	this.issn = issn;
	this.frequency = frequency;
	this.issuePrice = issuePrice;
    }

    public void addSubscription(Subscription aSubscriber) {
	subscriptions.add(aSubscriber);
    }

    public String getName() {
	return name;
    }

    public String getIssn() {
	return issn;
    }

    public int getFrequency() {
	return frequency;
    }

    public double getIssuePrice() {
	return issuePrice;
    }

    public Vector<Subscription> getSubscriptions() {
	return subscriptions;
    }

    public void setSubscriptions(Vector<Subscription> subscriptions) {
	this.subscriptions = subscriptions;
    }
    
    /**
     * Return the first subscription with subscriber aSubscriber.
     * Return -1 if does not exist.
     * @param aSubscriber
     * @return 
     */
    public int findSubscription(Subscriber aSubscriber) {
	for (int i = 0; i < subscriptions.size(); i++) {
	    if (subscriptions.get(i).getSubscriber() == aSubscriber) {
		return i;
	    }
	}
	return -1;
    }

    @Override
    public String toString() {
	return "Journal [name=" + name + ", issn=" + issn + ", frequency=" + frequency + ", issuePrice=" + issuePrice
		+ "]";
    }

    public String fancyToString() {
	return "Journal" + "\nName: " + name + "\nISSN: " + issn + "\nFrequency: " + frequency + "\nPrice: " + issuePrice;
    }
}
