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
	if (getCompletePaymentAmount() > (payment.getReceivedPayment() + amount)) {
	    payment.increasePayment(amount);
	    return true;
	} else {
	    payment.increasePayment(getCompletePaymentAmount() - payment.getReceivedPayment());
	    return false;
	}
    }
    
    public boolean isPaymentComplete() {
	return getCompletePaymentAmount() == payment.getReceivedPayment();
    }

    public boolean canSend(int issueMonth) {
	return payment.getReceivedPayment() >= paymentForAccess(issueMonth);
    }
    
    public double paymentForAccess(int issueMonth) {
	int NormalizedMonth = issueMonth - dates.getStartMonth() + 1;
	if (NormalizedMonth < 1) {
	    NormalizedMonth += 12;
	}
	return (NormalizedMonth * getMonthlyPrice());
    }
    
    public double getMonthlyPrice() {
	return getCompletePaymentAmount() / 12;
    }

    public boolean isExpired(int month, int year) {
	int endDateNr = dates.getEndMonth() + (dates.getEndYear() - dates.getStartYear()) * 12;
	int currentDateNr = month + (year - dates.getStartYear()) * 12;
	
	// Return false only if 'startDate <= DATE <= endDate'
	return (endDateNr < currentDateNr) || (currentDateNr < endDateNr-12);
    }

    public double getCompletePaymentAmount() {
	return getIssuePriceWithDiscount() * journal.getFrequency() * copies;
    }

    @Override
    public String toString() {
	return "Subscription [dates=" + dates + ", payment=" + payment + ", copies=" + copies + ", journal=" + journal
		+ ", subscriber=" + subscriber + "]";
    }
}
