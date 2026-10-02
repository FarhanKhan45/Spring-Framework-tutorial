package DependencyInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        PaymentService service1 =
                context.getBean(PaymentService.class);

        service1.pay();

        service1.showAddresses();
        

PaymentService service2 =
        context.getBean(PaymentService.class);

service2.setId(20);
 service1.pay();

System.out.println(service1==service2);
        
    }
}