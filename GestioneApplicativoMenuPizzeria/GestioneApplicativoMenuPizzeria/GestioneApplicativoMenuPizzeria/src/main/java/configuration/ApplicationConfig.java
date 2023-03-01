package configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pizzeriaDomain.Menu;
import pizzeriaDomain.MenuItem;
import pizzeriaDomain.TableOrder;
import pizzeriaDomain.OrderItem;


@Configuration
public class ApplicationConfig {

    @Bean
    Menu menu() {
        return new Menu();
    }

    @Bean
    public MenuItem menuItem() {
        return new MenuItem();
    }

    @SuppressWarnings("rawtypes")
    @Bean
    TableOrder order() {
        return new TableOrder();
    }

    @Bean
    public OrderItem orderItem() {
        return new OrderItem(null, null, null, 0);
    }

    // altre definizioni di bean per le altre classi di dominio
}
