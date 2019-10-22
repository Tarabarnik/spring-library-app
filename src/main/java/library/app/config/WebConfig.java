package library.app.config;

import library.app.entity.Book;
import library.app.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebMvc
@ComponentScan("library.app.controller")
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private BookService bookService;

    @PostConstruct
    public void inject() {
        Book book1 = new Book("book 1", 1995, 20.5);
        Book book2 = new Book("book 2", 1998, 15D);
        Book book3 = new Book("book 3", 2005, 20.5);
        Book book4 = new Book("book 4", 1836, 4.35);

        bookService.add(book1);
        bookService.add(book2);
        bookService.add(book3);
        bookService.add(book4);
    }

    @Bean
    public InternalResourceViewResolver resolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("index");
    }
}
