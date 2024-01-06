package dege.journalnews;

public class Subscription implements java.io.Serializable{

    private final DateInfo dates;
    private PaymentInfo payment;
    private int copies;
    private final Journal journal;
    private final Subscriber subscriber;

    public Subscription(DateInfo dates, int copies, Journal journal, Subscriber subscriber) {
	this.dates = dates;
	this.copies = copies;
	this.journal = journal;
	this.subscriber = subscriber;

	double discount = calculateDiscountRatio();
	this.payment = new PaymentInfo(discount);
    }

    public DateInfo getDates() {
	return dates;
    }

    public Journal getJournal() {
	return journal;
    }

    public Subscriber getSubscriber() {
	return subscriber;
    }

    public PaymentInfo getPayment() {
	return payment;
    }

    public int getCopies() {
	return copies;
    }
    
    public void setCopies(int amount) {
	this.copies = amount;
	
	// Update payment info.
	double received = payment.getReceivedPayment();
	double discount = calculateDiscountRatio();
	this.payment = new PaymentInfo(discount);
	this.payment.increasePayment(received);
    }
    
    public void increaseCopies(int amount) {
	setCopies(amount + this.copies);
    }

    public double calculateDiscountRatio() {
	if (copies > 20) {
	    return 20.0;
	} else if (20 >= copies && copies > 10) {
	    return 10.0;
	} else if (10 >= copies && copies > 5) {
	    return 5.0;
	}
	return 0.0;
    }

    public double getIssuePriceWithDiscount() {
	return journal.getIssuePrice() * ((100.0 - calculateDiscountRatio()) / 100.0);
    }

    public boolean acceptPayment(double amount) {
	if (getCompletePaymentAmount() > payment.getReceivedPayment()) {
	    payment.increasePayment(amount);
	    return true;
	} else {
	    return false;
	}
    }

    public boolean canSend(int issueMonth) {
	int NormalizedMonth = issueMonth - dates.getStartMonth() + 1;
	if (NormalizedMonth < 1) {
	    NormalizedMonth += 12;
	}
	return payment.getReceivedPayment() >= (NormalizedMonth * getMonthlyPrice());
    }
    
    public double getMonthlyPrice() {
	return getCompletePaymentAmount() / 12;
    }

    public boolean isExpired(int month, int year) {
	int endDateNr = dates.getEndMonth() + (dates.getEndYear() - dates.getStartYear()) * 12;
	int currentDateNr = month + (year - dates.getStartYear()) * 12;
	return endDateNr < currentDateNr;
    }

    public double getCompletePaymentAmount() {
	return getIssuePriceWithDiscount() * journal.getFrequency() * copies;
    }

    public boolean isPaymentComplete() {
	if (payment.getReceivedPayment() == getCompletePaymentAmount()) {
	    return true;
	}
	return false;
    }

    @Override
    public String toString() {
	return "Subscription [dates=" + dates + ", payment=" + payment + ", copies=" + copies + ", journal=" + journal
		+ ", subscriber=" + subscriber + "]";
    }
}
