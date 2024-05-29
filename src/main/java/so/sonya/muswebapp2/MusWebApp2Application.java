package so.sonya.muswebapp2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import so.sonya.muswebapp2.dto.ThreadDto;
import so.sonya.muswebapp2.service.impl.ThreadServiceImpl;
import so.sonya.muswebapp2.service.impl.UserServiceImpl;

import java.util.UUID;

@SpringBootApplication
@EnableJpaRepositories
public class MusWebApp2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MusWebApp2Application.class, args);
//        UserDto dto = UserDto.builder()
//                .id(UUID.fromString("0205d5d1-24aa-44a8-a16c-18aca7649475"))
//                .email("0")
////                .password("djhvkjsd")
//                .nickname("dkvklsd")
//                .build();
        UserServiceImpl userService = context.getBean(UserServiceImpl.class);
//        userService.deleteById(UUID.fromString("1ee88313-424a-49d0-b80b-f30c5d793d6a"));
//        userService.findByNickname("DearOwly");
        ThreadServiceImpl threadService = context.getBean(ThreadServiceImpl.class);
        ThreadDto thread = ThreadDto.builder()
                .description("hui")
                .authorId(UUID.fromString("1ee88313-424a-49d0-b80b-f30c5d793d6a"))
                .title("pizda")
                .build();
        threadService.save(thread);
    }

}
