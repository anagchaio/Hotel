package com.utn;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room {
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
        this.roomNumber = roomNumber;
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

    public Double getRoomTotalPrice(){
        Double totalPrice = this.price;
        for(Consumption consumption:this.roomConsumptions){
            totalPrice += consumption.getTotalPrice();
        }
        return  totalPrice;
    }

    private String showVacancy(){
        if(isOccupied){
            return "OCCUPIED";
        } else {
            return "FREE";
        }
    }

    @Override
    public String toString() {
        return "Room{" +
                "roomNumber=" + roomNumber +
                ", type=" + type +
                "," + this.showVacancy() +
                ", price=" + price +
                ", roomGuests=" + roomGuests +
                ", roomConsumptions=" + roomConsumptions +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        Room room = (Room) o;
        return getRoomNumber() == room.getRoomNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRoomNumber());
    }

}
