package com.controller;

import com.util.Config;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestCall implements Rest_Interface {
    @Override
    public Response get(String url) {
//        RestAssured.baseURI = Config.getInstanse().base_url;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, url);
        return  response;
    }

    @Override
    public Response post() {
        return null;
    }

    @Override
    public Response put() {
        return null;
    }

    @Override
    public Response delete() {
        return null;
    }
}
