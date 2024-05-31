package so.sonya.muswebapp2.security.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import so.sonya.muswebapp2.security.configurers.JsonLoginConfigurer;
import so.sonya.muswebapp2.security.details.CustomOAuth2UserService;
import so.sonya.muswebapp2.security.details.CustomOidcUserService;

import static so.sonya.muswebapp2.security.util.Constants.*;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig {
    private final CustomOAuth2UserService oauth2UserService;
    private final CustomOidcUserService oidcUserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                   .csrf(AbstractHttpConfigurer::disable)
                   .authorizeHttpRequests(auth -> {
                       auth.requestMatchers("/").permitAll()
                           .requestMatchers(LOGIN_PROCESSING_URL).permitAll()
                           .requestMatchers(SIGNUP_URL).permitAll()
                           .anyRequest().authenticated();
                   })
                   .oauth2Login(oauth2 -> {
                       oauth2.userInfoEndpoint(info -> {
                           info.userService(oauth2UserService)
                               .oidcUserService(oidcUserService);
                       });
                       oauth2.loginPage(LOGIN_PAGE_URL)
                           .loginProcessingUrl(OAUTH2_LOGIN_PROCESSING_URL);
                   })
                   .with(new JsonLoginConfigurer<>(), json -> {
                       json.usernameParameter("email")
                           .passwordParameter("password")
                           .loginPage(LOGIN_PAGE_URL)
                           .loginProcessingUrl(LOGIN_PROCESSING_URL);
                   })
                   .logout(logout -> {
                       logout.logoutSuccessUrl("/");
                   })
                   .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
