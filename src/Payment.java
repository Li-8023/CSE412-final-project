public class Payment {
	private int paymentId = 0;
    private String cardNum = "";
    private int amount = 0;

    Payment(int paymentId, int amount, String cardNum) {
    	this.paymentId = paymentId;
        this.amount = amount;
        this.cardNum = cardNum;
    }

    int getAmount() {
        return this.amount;
    }

    String getCardNum() {
        return this.cardNum;
    }
    
    int getPaymentId()
    {
    	return this.paymentId;
    }
}
