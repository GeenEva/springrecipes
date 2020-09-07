package eva.recipes.chapter6Security4.library;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
@ComponentScan
public class LibrarySecurityConfig
        implements WebMvcConfigurer{

 /*   public LibrarySecurityConfig(){
        super(true);
    }*/


    protected void configure(HttpSecurity http) throws Exception {

        http
                .securityContext()
                .and().exceptionHandling()
                .and().servletApi()
                .and().httpBasic()
                .and().formLogin().loginPage("/login").defaultSuccessUrl("/books.html")
                .failureUrl("/login?error=true")
                .and().csrf()
                .and().logout()
                .and().headers()
                .and().anonymous().principal("guest").authorities("ROLE_GUEST")

        ;
    }
}
