package com.example.chenbb.personalproject1_finaltask;

import java.io.Serializable;

public class Collection implements Serializable{
    private String type;
    private String name;
    private String longType;
    private String nutrition;
    private String color;
    private boolean isCollected;


    public Collection() {
        type = "饮";
        name = "牛奶";
        isCollected = false;
        longType = "饮品";
        nutrition = "富含 钙";
        color = "#4469B0";
    }

    public Collection(String _type, String _name, String _longType, String _nutrition, String _color, boolean _isCollected) {
        type = _type;
        name = _name;
        longType = _longType;
        nutrition = _nutrition;
        color = _color;
        isCollected = _isCollected;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLongType() { return longType;}

    public String getNutrition() { return nutrition;}

    public String getColor() { return color;}

    public boolean getIsCollected() { return isCollected;}

    public void setCollected(boolean _isCollected) {isCollected = _isCollected;}

}
