package com.utn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reservation {
    private static int counter = 1;
    private int idReservation;
    private Room room;
    private List<Guest> Guests = new ArrayList<>();
    private Date checkInDate;
    private Date checkOutDate;

    public Reservation(Room room, List<Guest> guests, Date checkInDate, Date checkOutDate) {
        this.room = room;
        Guests = guests;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.idReservation = counter++;
    }

    public int getIdReservation() {
        return idReservation;
    }

    public Room getRoom() {
        return room;
    }

    public List<Guest> getGuests() {
        return Guests;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }
}
