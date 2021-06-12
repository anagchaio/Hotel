package com.utn;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Recepcionist extends Employee implements Serializable {

    private static final long serialVersionUID = 7970889473436230100L;

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
                    invoice = new Invoice(room.getRoomGuests(), java.sql.Date.valueOf(LocalDate.now()),this.getRoomTotalPrice(room));
                    if(room.getRoomGuests() != null){
                        room.getRoomGuests().removeAll(room.getRoomGuests());
                    }
                    if(room.getRoomConsumptions() != null){
                        room.getRoomConsumptions().removeAll(room.getRoomConsumptions());
                    }
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

    public Room searchAvailableRoom(RoomType roomType, List<Room> rooms, List<Reservation> reservations, java.util.Date date) {
        rooms = this.filterRooms(roomType, rooms);
        for (Room room:rooms ) {
            reservations = filterReservationsByRoom(reservations, room);
            for(Reservation reservation: reservations){
                if(reservation.dateIsAvailable(date) && room.getRoomState().getState() == RoomState.AVAILABLE.getState()){
                    return room;
                }
            }
        }
        return null;
    }

    public List<Room> filterRooms(RoomType roomType, List<Room> rooms){
        ArrayList<Room> filteredRooms = new ArrayList<>();
        for (Room room: rooms) {
            if (room.getType()==roomType){
                filteredRooms.add(room);
            }
        }
        return filteredRooms;
    }

    public static List<Reservation> filterReservationsByRoom(List<Reservation> reservations, Room room){
        ArrayList<Reservation> filteredReservations = new ArrayList<>();
        for (Reservation res:reservations) {
            if (res.getRoom().equals(room)){
                filteredReservations.add(res);
            }
        }
        return filteredReservations;
    }


}
