package looseCoupling;

public class PaymentService {
	private Payment payment;
//	
//	private UPIPayment payment=new UPIPayment();
//	
	public PaymentService(Payment payment) {
		this.payment=payment;
		
	}
	
	public void pay() {
		payment.makePayment();
	}

}
