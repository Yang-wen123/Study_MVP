package com.example.study_mvp.Bean;

public class Girl {
    private String name;
    private String url;
    public Girl(String name, String url) {
        super();
        this.name=name;
        this.url=url;
    }
    public String getName(){
        this.name=name;
        return name;
    }
    public String getUrl(){
        this.url=url;
        return url;
    }
}
