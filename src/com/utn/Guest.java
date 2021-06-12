package com.utn;

import java.io.Serializable;

public class Guest extends Person implements Serializable {
    private static final long serialVersionUID = 7970889473436230100L;

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




}
