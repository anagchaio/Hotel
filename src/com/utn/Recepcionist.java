package com.utn;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class Recepcionist extends Employee {

    public Recepcionist(){
        super();
    }

    public Recepcionist(String name, String surname, String dni, Integer age, String userName, String password) {
        super(name, surname, dni, age, userName, password);
    }

    public Room checkVacancy(List<Room> rooms){
        for(Room room:rooms){
            if(room.getRoomState().equals(RoomState.AVAILABLE)){
                return room;
            }
        }
        return null;
    }

/*    public Reservation roomReservation(List<Room> rooms, Room room2, List<Guest> guests) {
        Reservation reservation;
        for(Room room:rooms){
            if(room.equals(room2){
                room.setRoomState(RoomState.RESERVED);
            }
        }
        reservation = new Reservation()

        return null;
    }*/

    public void roomCancellation(List<Room> rooms, List<Reservation> reservations) {

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
                if(room.getRoomNumber() == roomNumber && room.getRoomState().equals(RoomState.OCCUPIED)){
                    invoice = new Invoice(room.getRoomGuests().get(0), Date.valueOf(LocalDate.now()),this.getRoomTotalPrice(room));
                    room.getRoomGuests().removeAll(room.getRoomGuests());
                    room.getRoomConsumptions().removeAll(room.getRoomConsumptions());
                    room.setRoomState(RoomState.AVAILABLE);
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

    public void loadConsumptions(int roomNumber, List<Room> rooms){

    }

    public void cancelConsumptions(int roomNumber, List<Room> rooms){

    }


}
