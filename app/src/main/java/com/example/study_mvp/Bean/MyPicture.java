package com.example.study_mvp.Bean;

public class MyPicture {
    private String Name;
    private String Score;
    private String Baikeurl;
    private String Imageurl;
    private String Description;
    public String getName(){
        return Name;
    }
    public void setName(String name){
        Name=name;
    }
    public String getScore(){
        return Score;
    }
    public void setScore(String score){
        Score=score;
    }
    public String getBaikeurl(){
        return Baikeurl;
    }
    public void setBaikeurl(String baikeurl){
        Baikeurl=baikeurl;
    }
    public String getImageurl(){
        return Imageurl;
    }
    public void setImageurl(String imageurl){
        Imageurl=imageurl;
    }
    public String getDescription(){
        return Description;
    }
    public void setDescription(String description){
        Description=description;
    }
    @Override
    public String toString() {
        return this.getName() + "\n" +
                this.getScore() + "\n" +
                this.getBaikeurl() + "\n" +
                this.getImageurl() + "\n" +
                this.getDescription() + "\n";
    }
}
