package com.utn;

import java.util.ArrayList;
import java.util.List;

public class Room {
    private static int counter = 1;
    private int roomNumber;
    private RoomType type;
    private boolean isOccupied;
    private Double price;
    private List<Guest> roomGuests = new ArrayList<>();
    private List<Consumption> roomConsumptions = new ArrayList<>();

    public Room(int roomNumber, RoomType type, boolean isOccupied, Double price){
        this.type = type;
        this.isOccupied = isOccupied;
        this.price = price;
        this.roomNumber = counter++;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupation(boolean occupied) {
        isOccupied = occupied;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<Guest> getRoomGuests() {
        return roomGuests;
    }

    public void setRoomGuests(List<Guest> roomGuests) {
        this.roomGuests = roomGuests;
    }

    public List<Consumption> getRoomConsumptions() {
        return roomConsumptions;
    }

    public void setRoomConsumptions(List<Consumption> roomConsumptions) {
        this.roomConsumptions = roomConsumptions;
    }

}
