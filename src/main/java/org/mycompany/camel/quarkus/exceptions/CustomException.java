package org.mycompany.camel.quarkus.exceptions;

import io.quarkus.runtime.annotations.RegisterForReflection;

@RegisterForReflection // Lets Quarkus register this class for reflection during the native build
public class CustomException extends Exception {

    public CustomException() {
        super();
    }

    public CustomException(String message) {
        super(message);
    }
}
