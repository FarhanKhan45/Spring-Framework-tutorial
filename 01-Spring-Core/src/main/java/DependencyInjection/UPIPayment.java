package DependencyInjection;

import org.springframework.stereotype.Component;


@Component
public class UPIPayment implements Payment {
	
	@Override
	public void makePayment() {
		System.out.println("Payment through upi");
		
	}

}
