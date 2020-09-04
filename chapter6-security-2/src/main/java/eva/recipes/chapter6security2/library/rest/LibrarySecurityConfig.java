package eva.recipes.chapter6security2.library.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LibrarySecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer{

    public LibrarySecurityConfig(){
        super(true);
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }

    @Override
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
        ;
    }
}
