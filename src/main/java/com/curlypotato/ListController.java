package com.curlypotato;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

import java.util.List;

@Controller("/list-items")
public class ListController {
    
    @Get
    public HttpResponse<List<String>> index() {
        final List<String> items = List.of("item1", "item2", "item3");
        return HttpResponse.ok(items);
    }


}
