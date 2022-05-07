package com.test;

import com.beans.Branch_Detail;
import com.beans.Repo_Details;
import com.beans.Root;
import com.beans.USER_Detail;
import com.controller.RestCall;
import com.util.Config;
import com.util.JSONConvertor;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.util.JSONReader.create_JSON;

public class Task {

    public static void main(String[] args) {
        //problem 1
        String userId="pankaj2014";
       Response response= new RestCall().get(Config.getInstanse().getUserDetail(userId));
        System.out.println(response.getBody().asString());
        USER_Detail user_detail= (USER_Detail)JSONConvertor.ConverJsonToBeanClass(response,USER_Detail.class.getName());
        System.out.println(user_detail.getReposUrl());

        Response Repo_response= new RestCall().get(user_detail.getReposUrl());
        System.out.println(Repo_response.getBody().asString());
        System.out.println(Repo_response.getBody().jsonPath().get("name").toString());

        String[] names=Repo_response.getBody().jsonPath().get("name").toString().replace("[","").replace("]","").split(",");
        String[] created_at=Repo_response.getBody().jsonPath().get("created_at").toString().replace("[","").replace("]","").split(",");
        String[] owner_login=Repo_response.getBody().jsonPath().get("owner.login").toString().replace("[","").replace("]","").split(",");
        System.out.println("created_at"+ Arrays.toString(created_at));
        System.out.println("owner_login"+ Arrays.toString(owner_login));
        List<Repo_Details> repo_details= new ArrayList<>();
        for(int i=0;i<names.length;i++) {

            System.out.println(Config.getInstanse().getBranch_Detail(userId, names[i].trim()));
            Response response_repo = new RestCall().get(Config.getInstanse().getBranch_Detail(userId, names[i].trim()));
            String[] names_branch=response_repo.getBody().jsonPath().get("name").toString().replace("[","").replace("]","").split(",");
            System.out.println("names_branch"+ Arrays.toString(names_branch));
            Repo_Details repo_details_Obj= new Repo_Details(names[i].trim(),owner_login[i].trim(),created_at[i].trim(), null);
            System.out.println("I:"+i+" " +response_repo.getBody().asString());
            repo_details.add(repo_details_Obj);
        }

        create_JSON(repo_details);

//        JsonNode jsonNode = JsonPath.parse(json).read(jsonPathExpression, JsonNode.class);
//        Branch_Detail branch_detail=(Branch_Detail)JSONConvertor.ConverJsonToBeanClass(Repo_response,Branch_Detail.class.getName());
//        System.out.println(branch_detail.getName());

    }
}
