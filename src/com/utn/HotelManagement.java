package com.utn;

import java.util.ArrayList;
import java.util.List;

public class HotelManagement {
    private List<Room> rooms = new ArrayList<>();
    private List<Employee> employees = new ArrayList<>();
    private List<Guest> guests = new ArrayList<>();
    private List<Invoice> invoices = new ArrayList<>();

    public HotelManagement(List<Room> rooms, List<Employee> employees, List<Guest> guests, List<Invoice> invoices) {
        this.rooms = rooms;
        this.employees = employees;
        this.guests = guests;
        this.invoices = invoices;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    //Estos metodos podrian ser de Employee (todos pueden ver la info)
    public void showRooms(){
        for(Room room:this.rooms){
            System.out.println(room.toString());
        }
    }

    public void showEmployees(){
        for(Employee employee:this.employees){
            System.out.println(employee.toString());
        }
    }

    public void showGuests(boolean isActive){
        if(isActive == true){
            for(Guest guest:this.guests){
                if(guest.isActive() == true){
                    System.out.println(guest.toString());
                }
            }
        } else {
            for(Guest guest:this.guests){
                if(guest.isActive() == false){
                    System.out.println(guest.toString());
                }
            }
        }
    }







}
