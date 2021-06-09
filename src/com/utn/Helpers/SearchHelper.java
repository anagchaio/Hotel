package com.utn.Helpers;

import com.utn.Reservation;
import com.utn.Room;
import com.utn.RoomType;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class SearchHelper {
    public static Room searchAvailableRoom(
        RoomType roomType,
        ArrayList<Room> rooms,
        ArrayList<Reservation> reservations,
        String date
    ) throws ParseException {
        rooms = filterRooms(roomType, rooms);
        for (Room r:rooms ) {
            reservations = filterResevationsByRoom(reservations, r);
            for(Reservation res: reservations){
                if(res.dateIsAvailable(date)){
                    return r;
                }
            }
        }
        return null;
    }

    public static ArrayList<Room> filterRooms(
            RoomType roomType,
            ArrayList<Room> rooms
    ){
        ArrayList<Room> filteredRooms = new ArrayList<Room>();
        for (Room r: rooms) {
            if (r.getType()==roomType){
                filteredRooms.add(r);
            }
        }
        return filteredRooms;
    }

    public static ArrayList<Reservation> filterResevationsByRoom(
            ArrayList<Reservation> reservations,
            Room room
    ){
        ArrayList<Reservation> filteredReservations = new ArrayList<>();
        for (Reservation res:reservations) {
            if (res.getRoom().equals(room)){
                filteredReservations.add(res);
            }
        }
        return filteredReservations;
    }
}
