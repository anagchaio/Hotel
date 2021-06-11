package com.utn;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Recepcionist extends Employee {

    public Recepcionist(){
        super();
    }

    public Recepcionist(String name, String surname, String dni, Integer age, String userName, String password) {
        super(name, surname, dni, age, userName, password);
    }

    public boolean checkVacancy(List<Room> rooms){
        for(Room room:rooms){
            if(room.getRoomState().equals(RoomState.AVAILABLE)){
                return true;
            }
        }
        return false;
    }

    public void showAvailableRooms(List<Room> rooms){
        for(Room room:rooms){
            if(room.getRoomState().getState() == RoomState.AVAILABLE.getState()){
                System.out.println(room.toString());
            }
        }
    }

    public Room findRoom(int roomNumber, List<Room> rooms){
        for(Room room:rooms){
            if(room.getRoomNumber() == roomNumber && room.getRoomState().getState() == RoomState.AVAILABLE.getState()){
                return room;
            }
        }
        return null;
    }

    public Reservation roomReservation(List<Room> rooms, int roomNumber, List<Guest> guests) {
        Reservation reservation;
        for(Room room:rooms){
            if(room.getRoomNumber() == roomNumber && room.getRoomState().getState() == RoomState.AVAILABLE.getState()){
                room.setRoomState(RoomState.RESERVED);
                //reservation = new Reservation() //faltan las fechas
                //guests.add(reservation.getGuests());
            }
        }
        return null;
    }

    public boolean roomCancellation(List<Room> rooms, List<Reservation> reservations, int reservationId) {
        for (Reservation reservation: reservations){
            if(reservation.getIdReservation() == reservationId){
                reservation.setActive(false);
                for(Room room: rooms){
                    if(room.equals( reservation.getRoom())){
                        room.setRoomState(RoomState.AVAILABLE);
                    }
                }
                return true;
            }
        }
        return  false;
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

    public Invoice checkOut(int roomNumber, List<Room> rooms) throws NullPointerException {
        Invoice invoice;
        try{
            for(Room room:rooms){
                if(room.getRoomNumber() == roomNumber && room.getRoomState().getState() == RoomState.OCCUPIED.getState()){
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

    public Guest findGuestByDni(List<Guest> guests, String dni){
        for(Guest guest:guests){
            if(guest.getDni().equals(dni)){
                return guest;
            }
        }
        return null;
    }

    public Product findProductById(int productId, List<Product> products) {
        for (Product product:products){
            if(product.getIdProduct() == productId){
                return product;
            }
        }
        return null;
    }




}
