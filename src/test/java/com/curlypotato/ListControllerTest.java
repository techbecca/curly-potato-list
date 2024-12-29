package com.curlypotato;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


@MicronautTest
public class ListControllerTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Test
    public void saysHello(){
        final HttpRequest<?> request = HttpRequest.GET("/hello").accept(MediaType.TEXT_PLAIN);

        final String body = httpClient.toBlocking().retrieve(request);
        assertNotNull(body);
        assertEquals("Hello World!", body);
    }

}
