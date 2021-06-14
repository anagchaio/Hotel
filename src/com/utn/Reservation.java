package com.utn;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;


public class Reservation implements Serializable {
    private static final long serialVersionUID = 7970889473436230100L;

    private static int counter = 1;
    private int idReservation;
    private Room room;
    private List<Guest> Guests;
    private Date checkInDate;
    private Date checkOutDate;
    private boolean isActive;

    public Reservation(Room room, List<Guest> guests, Date checkInDate, Date checkOutDate) {
        this.room = room;
        Guests = guests;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        isActive = true;
        this.idReservation = counter++;
    }

    public static void setCounter(int counter) {
        Reservation.counter = counter;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    private String showState(){
        if(isActive){
            return "ACTIVA";
        } else {
            return "CANCELADA";
        }
    }
    @Override
    public String toString() {
        return  "Reservation ID:" + idReservation +
                ",\n " + room +
                ",\n List of Guests:" + Guests +
                ",\n checkIn Date: " + checkInDate +
                ",\n checkOut Date: " + checkOutDate +
                ",\n " + this.showState();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;
        Reservation that = (Reservation) o;
        return getIdReservation() == that.getIdReservation();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdReservation());
    }

    public boolean dateIsAvailable(Date date) {
        return this.checkInDate.before(date) && this.checkOutDate.after(date);
    }
}