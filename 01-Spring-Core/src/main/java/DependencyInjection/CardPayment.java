package DependencyInjection;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


@Primary
@Component
public class CardPayment implements Payment {

    @Override
    public void makePayment() {
        System.out.println("Payment through Card");
    }
}