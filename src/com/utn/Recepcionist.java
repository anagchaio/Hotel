package com.utn;

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

    public boolean checkIn(int reservationId, List<Reservation> reservations, List<Room> rooms){
        for(Reservation reservation:reservations){
            if(reservation.getIdReservation() == reservationId){
                Room reservedRoom = reservation.getRoom();
                reservations.remove(reservation);
                for(Room room:rooms){
                    if(reservedRoom.equals(room)){
                        room.setRoomState(RoomState.OCCUPIED);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkOut(int roomNumber, List<Room> rooms){
        try{
            for(Room room:rooms){
                if(room.getRoomNumber() == roomNumber){
                    room.setRoomState(RoomState.AVAILABLE);
                    room.getRoomGuests().removeAll(room.getRoomGuests());
                    room.getRoomConsumptions().removeAll(room.getRoomConsumptions());
                    return true;
                }
            }
        }
        catch (NullPointerException e) {
            System.out.println("Exception thrown : " + e);
        }
        return false;
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
