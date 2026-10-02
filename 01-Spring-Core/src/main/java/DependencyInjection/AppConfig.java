package DependencyInjection;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("DependencyInjection")
public class AppConfig {

    @Bean
    public List<String> addresses() {

        List<String> list = new ArrayList<>();

        list.add("Mumbai");
        list.add("Thane");
        list.add("Kolkata");

        return list;
    }
}