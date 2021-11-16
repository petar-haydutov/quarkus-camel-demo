package org.mycompany.camel.quarkus.processors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

@Named
@ApplicationScoped
public class FreshFoodProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getMessage().setBody("Your food item is fresh and will be saved.");
        exchange.getMessage().setHeader(Exchange.HTTP_RESPONSE_CODE, 201);
    }
}
