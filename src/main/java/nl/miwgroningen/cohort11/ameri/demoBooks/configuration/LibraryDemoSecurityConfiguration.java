package nl.miwgroningen.cohort11.ameri.demoBooks.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Mohammed Alameri on 02/06/2023.
 * @project Opdracht
 */
@Configuration
@EnableWebSecurity
public class LibraryDemoSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((authorize) -> authorize
                .antMatchers("/css/**", "/webjars/**").permitAll()
                .antMatchers("/", "/book/all").permitAll()
                .anyRequest().authenticated()
        )
                .formLogin().and()
                .logout().logoutSuccessUrl("/book/all");
        return httpSecurity.build();
    }
}
