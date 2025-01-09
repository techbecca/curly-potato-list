package com.curlypotato;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller("/list-items")
public class ListController {

    List<String> items;

    {
        items = new ArrayList<>();
        items.add("item1");
        items.add("item2");
        items.add("item3");
    }

    @Get
    public HttpResponse<List<String>> index() {
        return HttpResponse.ok(items);
    }

    @Post("/add")
    public HttpResponse<List<String>> addItem(@Parameter final String item) {
        items.add(item);
        return HttpResponse.ok(items)
                .header("Access-Control-Allow-Origin", "http://localhost:5173")
                .header("Access-Control-Allow-Methods", "POST")
                .header("Access-Control-Allow-Headers", "Content-Type, Authorization");
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
