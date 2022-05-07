package com.util;

import com.beans.Repo_Details;
import com.google.gson.Gson;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JSONReader {


    public static void create_JSON(List<Repo_Details> repo_details)
    {
        JSONObject repo_detail = new JSONObject();

        repo_detail.put("repo_details", new Gson().toJson(repo_details));

        //Write JSON file
        try (FileWriter file = new FileWriter("data_file.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(repo_detail.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SuppressWarnings("unchecked")
    public static void main( String[] args )
    {
        //First Employee
        JSONObject repo_detail = new JSONObject();
        List<Repo_Details> repo_details= new ArrayList<>();
        Repo_Details repo_details1= new Repo_Details("name","login","created_at",new ArrayList<>(Arrays.asList(new String[]{"branch"})));
        repo_details.add(repo_details1);
        create_JSON(repo_details);

        //Write JSON file
        try (FileWriter file = new FileWriter("employees.json")) {
            //We can write any JSONArray or JSONObject instance to the file
            file.write(repo_detail.toJSONString());
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
