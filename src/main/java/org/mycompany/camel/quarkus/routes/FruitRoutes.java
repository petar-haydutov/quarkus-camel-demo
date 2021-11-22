package org.mycompany.camel.quarkus.routes;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.mycompany.camel.quarkus.exceptions.CustomException;
import org.mycompany.camel.quarkus.models.Fruit;

@ApplicationScoped
public class FruitRoutes extends RouteBuilder {

    public static final String ROTTEN_FOOD_PROCESSOR = "rottenFoodProcessor";
    public static final String FRESH_FOOD_PROCESSOR = "freshFoodProcessor";

    private final Set<Fruit> fruits = Collections.synchronizedSet(new LinkedHashSet<>());

    public FruitRoutes() {
        // Adding some initial fruits
        this.fruits.add(new Fruit("Apple", "Winter fruit", true));
        this.fruits.add(new Fruit("Pineapple", "Tropical fruit", true));
    }

    @Override
    public void configure() {
        restConfiguration().bindingMode(RestBindingMode.json);
         configureExceptionHandlingForRoute();
        configureFruitRoutes();
    }

    private void configureFruitRoutes() {
        rest("/fruits")
            .get()
            .type(Fruit.class)
            .route()
            .setBody(constant(fruits))
            .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(200))
            .endRest()

            .post()
            .type(Fruit.class)
            .route()
            .filter(e -> {
                Fruit fruit = (Fruit) e.getIn().getBody();
                return !fruit.isFresh();
            })
                .to("log:rottenFruit")
                .process(ROTTEN_FOOD_PROCESSOR)
                .stop().end()
            .to("log:freshFruit")
            .process().body(Fruit.class, fruits::add)
            .process(FRESH_FOOD_PROCESSOR)
            .endRest();
    }

    private void configureExceptionHandlingForRoute() {
        onException(CustomException.class)
            .process(exchange -> {
                Exception exception = (Exception) exchange.getProperty(Exchange.EXCEPTION_CAUGHT);
                log.error(exception.getMessage());
            });
    }
}
