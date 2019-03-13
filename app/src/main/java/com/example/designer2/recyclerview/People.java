package com.example.designer2.recyclerview;

import com.google.gson.annotations.SerializedName;

public class People  {
    @SerializedName("name")
    private String name;
    @SerializedName("img")
    private String imgurl;

    public People() {
    }

    public People(String name, String imgurl) {
        this.name = name;
        this.imgurl = imgurl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }
}
