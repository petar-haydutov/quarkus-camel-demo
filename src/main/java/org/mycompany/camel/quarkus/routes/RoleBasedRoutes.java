//package org.mycompany.camel.quarkus.routes;
//
//import javax.enterprise.context.ApplicationScoped;
//
//import org.apache.camel.Endpoint;
//import org.apache.camel.Predicate;
//import org.apache.camel.builder.RouteBuilder;
//
/* The configure method of this class should be finished
*  with the implementation of the route/routes. */
//@ApplicationScoped
//public class RoleBasedRoutes extends RouteBuilder {
//
//    public static final String ROLE_BASED_ROUTE = "direct:roleBasedRoute";
//
//    Endpoint roleBasedRoute = endpoint(ROLE_BASED_ROUTE);
//    Predicate isAdmin = header("admin").isEqualTo(true);
//
//    @Override
//    public void configure() {
//    }
//}
