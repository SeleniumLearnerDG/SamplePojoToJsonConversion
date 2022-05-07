package com.controller;

import io.restassured.response.Response;

public interface Rest_Interface {

     Response get(String url);
    Response post();
    Response put();
    Response delete();
}
