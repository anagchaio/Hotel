package com.utn;

public enum RoomType {
    SIMPLE ("SIMPLE"),
    DOUBLE ("DOUBLE"),
    SUITE ("SUITE");

    private String type;

    RoomType (String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
