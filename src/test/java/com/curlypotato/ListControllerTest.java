package com.curlypotato;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.json.JsonMapper;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@MicronautTest
public class ListControllerTest {

    @Inject
    @Client("/")
    HttpClient httpClient;

    @Inject
    JsonMapper jsonMapper;

    @Test
    public void sendsList() throws IOException {
        String expectedBody = "[\"item1\", \"item2\", \"item3\"]";
        final List<String> expectedList = jsonMapper.readValue(expectedBody, Argument.LIST_OF_STRING);

        // given
        final HttpRequest<?> request = HttpRequest.GET("/list-items").accept(MediaType.APPLICATION_JSON, MediaType.TEXT_JSON);

        // when
        final String body = httpClient.toBlocking().retrieve(request);

        // then
        assertNotNull(body);
        final List<String> actualList = jsonMapper.readValue(body, Argument.LIST_OF_STRING);
        assertIterableEquals(expectedList, actualList);
    }

}
