package com.utn;

public enum RoomState {
    AVAILABLE ("AVAILABLE"),
    OCCUPIED ("OCCUPIED"),
    RESERVED ("RESERVED");

    private String state;

    RoomState (String state){
        this.state = state;
    }

    public String getState(){
        return this.state;
    }
}
