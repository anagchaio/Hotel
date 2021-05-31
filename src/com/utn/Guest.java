package com.utn;

public class Guest extends Person implements Reservations {
    private static int counter = 1;
    private int id;
    private Integer roomNumber;

    public Guest(String name, String surname, String dni, Integer age, Integer id) {
        super(name, surname, dni, age);
        this.id = counter++;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public void payRoom(){

    }

    public void orderConsumption(){

    }

    public void payConsumption(){

    }

    @Override
    public void roomReservation() {

    }

    @Override
    public void roomCancellation() {

    }
}
