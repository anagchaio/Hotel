package com.utn;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Room implements Serializable {
    private static final long serialVersionUID = 7970889473436230100L;

    private int roomNumber;
    private RoomType type;
    private RoomState roomState;
    private Double price;
    private List<Guest> roomGuests = new ArrayList<>();
    private List<Consumption> roomConsumptions = new ArrayList<>();

    public Room(int roomNumber, RoomType type, Double price){
        this.type = type;
        this.roomState = RoomState.AVAILABLE;
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

    public RoomState getRoomState() {
        return roomState;
    }

    public void setRoomState(RoomState roomState) {
        this.roomState = roomState;
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

    @Override
    public String toString() {
        return  "Room Number: " + roomNumber +
                ", Tipo: " + type.getType() +
                "," + roomState.getState() +
                ", Precio: $" + price;
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
