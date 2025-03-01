package week2.day4;

public class Amazon extends CanaraBank{

	
	public static void main(String[] args) {
      Amazon amz = new Amazon();
      amz.cashOnDelivery();
      amz.upiPayments();
      amz.internetBanking();
      amz.cardPayments();
      amz.recordPaymentDetails();
	}

	@Override
	public void cashOnDelivery() {
		System.out.println("cashOnDelivery option available");
	}

	@Override
	public void upiPayments() {
		System.out.println("upiPayments option available");		
	}

	@Override
	public void internetBanking() {
		System.out.println("Internet Banking option available");		
	}

	@Override
	public void cardPayments() {
		System.out.println("cardPayments option available");		
	}

	@Override
	void recordPaymentDetails() {
		System.out.println("recordPayment option available");		
	}

}
