package com.utn;

import com.utn.Helpers.DateHelper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Reservation {
    private static int counter = 1;
    private int idReservation;
    private Room room;
    private List<Guest> Guests = new ArrayList<>();
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

    private String showState(){
        if(isActive){
            return "ACTIVE";
        } else {
            return "CANCELLED";
        }
    }
    @Override
    public String toString() {
        return "Reservation{" +
                "idReservation=" + idReservation +
                ", room=" + room +
                ", Guests=" + Guests +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", " + this.showState() +
                '}';
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

public boolean dateIsAvailable(String sDate) throws ParseException {
    Date pDate = DateHelper.stringToDate(sDate);
    System.out.println("search: "+ pDate.toString() + " between " + this.checkInDate + this.checkInDate.after(pDate)
            +" and "+ this.checkOutDate + this.checkOutDate.before(pDate));

    return this.checkInDate.before(pDate) && this.checkOutDate.after(pDate);
}
}