package org.mycompany.camel.quarkus;

import static java.lang.Long.parseLong;
import static java.lang.System.getenv;

import io.quarkus.runtime.Quarkus;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.Injector;
import org.mycompany.camel.quarkus.routes.FruitRoutes;

//This class is used to illustrate how to run an apache camel application without the Quarkus framework
public class Main {

    // Starting the camel routes without any dependency injection
//    public static void main(String[] args) throws Exception {
//        try (CamelContext camelContext = new DefaultCamelContext()) {
//
//            // Adding routes to the camelContext.
//            FruitRoutes fruitRoutes = new FruitRoutes();
//            camelContext.addRoutes(fruitRoutes);
//
//            //Note that routes can also be added as an anonymous inner class
//            camelContext.addRoutes(new RouteBuilder() {
//                @Override
//                public void configure() {
//                    from("timer:foo")
//                        .log("Hello Camel");
//                }
//            });
//
//            // start() is a non-blocking operation
//            camelContext.start();
//
//            // run for 20 seconds
//            Thread.sleep(20_000);
//
//            // and then stop the camel routes
//            camelContext.stop();
//        }
//    }

    // Starting the camel routes with some kind of dependency injection
//    public static void main(String[] args) throws Exception {
//        try (CamelContext camelContext = new DefaultCamelContext()) {
//
//            Injector injector = Guice.createInjector();
//
//            camelContext.addRoutes(injector.getInstance(FruitRoutes.class));
//            camelContext.addRoutes(injector.getInstance(SomeOtherRoutes.class));
//
//            camelContext.start();
//
//            //Modify the camelContext configurations
//            camelContext
//                .getShutdownStrategy()
//                .setTimeout(30);
//
//            camelContext.stop();
//        }
//    }

    // Starting the camel routes with Quarkus
//    public static void main(String[] args) throws Exception {
//        Quarkus.run(args);
//    }
}
