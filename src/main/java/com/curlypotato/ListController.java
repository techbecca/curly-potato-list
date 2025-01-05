package com.curlypotato;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Options;

import java.util.List;

@Controller("/list-items")
public class ListController {
    
    @Get
    public HttpResponse<List<String>> index() {
        final List<String> items = List.of("item1", "item2", "item3");
        return HttpResponse.ok(items);
    }

    // Handle OPTIONS (preflight) requests for CORS
    @Options
    public HttpResponse<?> options() {
        return HttpResponse.ok()
                .header("Access-Control-Allow-Origin", "*")
                .header("Access-Control-Allow-Methods", "GET, POST, OPTIONS")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization");
    }


}
