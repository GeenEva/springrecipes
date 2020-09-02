package eva.recipes.chapter6security2.library.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class LibrarySecurityConfig extends WebSecurityConfigurerAdapter {

    public LibrarySecurityConfig(){
        super(true);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.securityContext()
                .and()
                .exceptionHandling();

    }
}
