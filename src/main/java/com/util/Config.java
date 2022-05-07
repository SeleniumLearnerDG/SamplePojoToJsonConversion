package com.util;

public class Config {

    final public static String base_url="https://api.github.com/";

    private static Config config=null;


    public static Config getInstanse()
    {
        if(config==null)
            config= new Config();
        return config;
    }
    public String getUserDetail(String user)
    {
        return base_url+APIMapper.user_Detail.getEndPoint().replace("{userId}", user);
    }

    public String getBranch_Detail(String userId, String repo)
    {
        return base_url+APIMapper.branch_Detail.getEndPoint().replace("{userId}", userId).replace("{repo_name}",repo );
    }


    public static void main(String[] args) {
        System.out.println(getInstanse().getUserDetail("pankaj2014"));
        System.out.println(getInstanse().getBranch_Detail("pankaj2014","sdet_interview"));
    }

}
