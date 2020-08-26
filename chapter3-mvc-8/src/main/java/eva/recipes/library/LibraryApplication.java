package eva.recipes.library;

import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@SpringBootApplication
public class LibraryApplication implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		return new LocaleChangeInterceptor();
	}

	@Bean
	public LocaleResolver localeResolver() {
		return new CookieLocaleResolver();
	}

	@Bean
	public TomcatServletWebServerFactory tomcatServletWebServerFactory(){
		var factory = new TomcatServletWebServerFactory();
		factory.addAdditionalTomcatConnectors((httpConnector()));
		factory.addContextCustomizers(securityCustomizer());
		return factory;
	}


	private Connector httpConnector() {
		var connector = new Connector(TomcatServletWebServerFactory.DEFAULT_PROTOCOL);
		connector.setScheme("http");
		connector.setPort(8080);
		connector.setSecure(false);
		connector.setRedirectPort(8443);
		return connector;
	}

	private TomcatContextCustomizer securityCustomizer() {
		return context -> {
			var securityConstraint = new SecurityConstraint();

			securityConstraint.setUserConstraint("CONFIDENTIAL");
			var collection = new SecurityCollection();
			collection.addPattern("/*");
			securityConstraint.addCollection(collection);
			context.addConstraint(securityConstraint);
		};
	}

	@Bean
	public ApplicationRunner booksInitializer(BookService bookService) {
		return args -> {
			bookService.create(new Book("9780061120084", "To Kill a Mockingbird", "Harper Lee"));
			bookService.create(new Book("9780451524935", "1984", "George Orwell"));
			bookService.create(new Book("9780618260300", "The Hobbit", "J.R.R. Tolkien"));
		};
	}
}

