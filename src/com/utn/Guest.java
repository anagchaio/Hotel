package com.utn;

import java.io.Serializable;

public class Guest extends Person implements Serializable {

    /*private Integer roomNumber;*/
    private boolean isActive;

    public Guest(String name, String surname, String dni, Integer age) {
        super(name, surname, dni, age);
        this.isActive = true;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    /* public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }*/




}
