package com.util;

import com.google.gson.Gson;
import io.restassured.response.Response;

import java.lang.reflect.Type;

import static org.assertj.core.api.Assertions.assertThat;

public class JSONConvertor {

    public  static  Object ConverJsonToBeanClass(Response response, String dtoClassName)
    {
        Object convertedObject=null;
        try {
            convertedObject = Class.forName(dtoClassName).newInstance();
            assertThat(convertedObject).isNotNull().describedAs("Failed to load the target class for Class Name: " + dtoClassName);
            convertedObject = new Gson().fromJson(response.getBody().asString(), convertedObject.getClass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    return convertedObject;
    }

}
