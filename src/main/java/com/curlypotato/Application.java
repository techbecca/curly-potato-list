package com.curlypotato;

import io.micronaut.runtime.Micronaut;

public class Application {

    public static void main(String[] args) {
        System.out.println("Starting Micronaut Application...");
        Micronaut.run(Application.class, args);
    }
}