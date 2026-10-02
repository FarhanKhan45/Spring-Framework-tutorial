package looseCoupling;

public class Main {
	public static void main(String[] args) {
//		PaymentService service=new PaymentService();
//		
		Payment payment=new UPIPayment();
		PaymentService service = new PaymentService(payment);
		service.pay();
	}

}
