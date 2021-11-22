package org.mycompany.camel.quarkus;

import javax.inject.Inject;

import io.quarkus.test.junit.QuarkusTest;
import org.apache.camel.CamelContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@QuarkusTest
public class RestJsonTest {

    @Inject
    CamelContext camelContext;

//     @Test
//     public void fruits() {
//
//     /* Assert the initial fruits are there */
//     given().when().get("/fruits").then().statusCode(200).body("$.size()", is(2), "name",
//     containsInAnyOrder("Apple", "Pineapple"), "description",
//     containsInAnyOrder("Winter fruit", "Tropical fruit"));
//
//     /* Add a new fruit */
//     given().body("{\"name\": \"Pear\", \"description\": \"Winter fruit\"}")
//     .header("Content-Type", "application/json").when().post("/fruits").then().statusCode(200)
//     .body("$.size()", is(3), "name", containsInAnyOrder("Apple", "Pineapple", "Pear"), "description",
//     containsInAnyOrder("Winter fruit", "Tropical fruit", "Winter fruit"));
//     }

//    @Test
//    public void testShutdownHook() {
//        Assertions.assertEquals(20, camelContext.getShutdownStrategy().getTimeout());
//    }

}
