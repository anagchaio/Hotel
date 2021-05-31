package com.utn;

public class Recepcionist extends Employee {
    private String schedule;

    public Recepcionist(String name, String surname, String dni, Integer age, String userName, String password, String schedule) {
        super(name, surname, dni, age, userName, password);
        this.schedule = schedule;
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public void checkIn(){

    }

    public void checkOut(){

    }

    public void loadConsumptions(){

    }

    public void cancelConsumptions(){

    }

    public void roomReservation() {

    }


    public void roomCancellation() {

    }
}
