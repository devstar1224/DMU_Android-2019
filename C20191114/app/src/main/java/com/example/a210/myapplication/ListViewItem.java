package com.example.a210.myapplication;

import android.graphics.drawable.Drawable;

public class ListViewItem {
    private Drawable iconDrawable;
    private  String titleStr;
    private String descStr;
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Drawable getIcon() {
        return iconDrawable;
    }

    public void setIcon(Drawable iconDrawable) {
        this.iconDrawable = iconDrawable;
    }

    public String getTitle() {
        return titleStr;
    }

    public void setTitle(String titleStr) {
        this.titleStr = titleStr;
    }

    public String getDesc() {
        return descStr;
    }

    public void setDesc(String descStr) {
        this.descStr = descStr;
    }

    public void setData(Drawable ic, String title, String Desc, String Location){
        iconDrawable = ic;
        titleStr = title;
        descStr = Desc;
        location = Location;
    }
}
