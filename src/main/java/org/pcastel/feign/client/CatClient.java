package org.pcastel.feign.client;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.List;

@Headers("Content-Type: application/json")
public interface CatClient {

    @RequestLine("GET /cat")
    List<Cat> findAll();

    @RequestLine("GET /cat/{id}")
    Cat findById(@Param("id") String id);

    @RequestLine("POST /cat")
    Cat create(Cat newCat);

    @RequestLine("DELETE /cat/{id}")
    Cat delete(@Param("id") String id);
}
