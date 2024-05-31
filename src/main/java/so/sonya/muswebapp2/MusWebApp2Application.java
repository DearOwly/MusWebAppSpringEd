package so.sonya.muswebapp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MusWebApp2Application {
    public static void main(String[] args) {
        SpringApplication.run(MusWebApp2Application.class, args);
    }
}
