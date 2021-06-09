package com.utn.Helpers;

import com.utn.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

public class Helpers {
    public static void main(String[] args) throws ParseException {
        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Guest> guests = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();

        rooms.add(new Room(111, RoomType.SIMPLE, 50.0));
        rooms.add(new Room(111, RoomType.DOUBLE, 50.0));
        rooms.add(new Room(111, RoomType.SIMPLE, 50.0));

        guests.add(new Guest("111", "111", "111",111));
        guests.add(new Guest("222", "222", "222",222));
        guests.add(new Guest("333", "333", "333",333));


        try {
            reservations.add(new Reservation(rooms.get(0) ,
                    guests,
                    DateHelper.stringToDate("11/12/2020"),
                    DateHelper.stringToDate("17/12/2020")));

            reservations.add(new Reservation(rooms.get(0) ,
                    guests,
                    DateHelper.stringToDate("02/12/2020"),
                    DateHelper.stringToDate("08/12/2020")));

            reservations.add(new Reservation(rooms.get(2) ,
                    guests,
                    DateHelper.stringToDate("03/11/2020"),
                    DateHelper.stringToDate("01/12/2020")));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Room available = SearchHelper.searchAvailableRoom( RoomType.SIMPLE ,rooms, reservations, "05/12/2020");

        System.out.println(available.toString());
    }
}
