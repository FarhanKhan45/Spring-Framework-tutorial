package DependencyInjection;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PaymentService {
	

	@Value("10")
	private int id;
	
	
	@Qualifier("UPIPayment")
	@Autowired
	private Payment payment;
	
	private List<String> addresses;
	
	     @Autowired
	    public PaymentService(List<String> addresses) {
	        this.addresses = addresses;
	    }

	    public void pay() {
	    	System.out.println(id);
	        payment.makePayment();
	    }
	    
	    public void showAddresses() {
	        System.out.println("Addresses: " + addresses);
	    }

	    public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
	    }

	}

