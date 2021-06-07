package com.utn;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Recepcionist extends Employee {
    private String schedule;

    public Recepcionist(){
        super();
    }

    public Recepcionist(String name, String surname, String dni, Integer age, String userName, String password) {
        super(name, surname, dni, age, userName, password);
    }

    public String getSchedule() {
        return schedule;
    }

    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }

    public Room checkIn(int reservationId, List<Reservation> reservations, List<Room> rooms){
        for(Reservation reservation:reservations){
            if(reservation.getIdReservation() == reservationId){
                Room reservedRoom = reservation.getRoom();
                reservations.remove(reservation);
                for(Room room:rooms){
                    if(reservedRoom.equals(room)){
                        room.setRoomState(RoomState.OCCUPIED);
                        return room;
                    }
                }
            }
        }
        return null;
    }

    public Invoice checkOut(int roomNumber, List<Room> rooms){
        Invoice invoice;
        try{
            for(Room room:rooms){
                if(room.getRoomNumber() == roomNumber){
                    invoice = new Invoice(room.getRoomGuests().get(0), Date.valueOf(LocalDate.now()),this.getRoomTotalPrice(room));
                    room.setRoomState(RoomState.AVAILABLE);
                    room.getRoomGuests().removeAll(room.getRoomGuests());
                    room.getRoomConsumptions().removeAll(room.getRoomConsumptions());
                    return invoice;
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("Exception thrown : " + e);
        }
        return null;
    }

    public Double getRoomTotalPrice(Room room){
        Double totalPrice = room.getPrice();
        for(Consumption consumption: room.getRoomConsumptions()){
            totalPrice += consumption.getTotalPrice();
        }
        return  totalPrice;
    }

    public void loadConsumptions(Room room){

    }

    public void cancelConsumptions(Room room){

    }

    public void roomReservation(List<Room> rooms, List<Reservation> reservations) {

    }

    public void roomCancellation(List<Room> rooms, List<Reservation> reservations) {

    }
}
