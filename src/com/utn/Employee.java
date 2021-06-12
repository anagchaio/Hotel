package com.utn;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public abstract class Employee extends Person implements Serializable {
    private static final long serialVersionUID = 7970889473436230100L;

    private static Integer counter = 1;
    protected Integer id;
    protected String userName;
    protected String password;

    public Employee(){
        super();
    }

    public Employee(String name, String surname, String dni, Integer age, String userName, String password) {
        super(name, surname, dni, age);
        this.userName = userName;
        this.password = password;
        this.id = counter++;
    }

    public static void setCounter(Integer counter) {
        Employee.counter = counter;
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }


    public void showRooms(List<Room> rooms){
        for(Room room:rooms){
            System.out.println(room.toString());
            if(room.getRoomState() != RoomState.AVAILABLE){
                room.getRoomGuests();
                room.getRoomConsumptions();
            }
        }
    }

    public void showEmployees(List<Employee> employees){
        for(Employee employee:employees){
            System.out.println(employee.toString());
        }
    }

    public void showProducts(List<Product> products){
        for(Product product:products){
            System.out.println(product.toString());
        }
    }

    public void showReservations(List<Reservation> reservations){
        for (Reservation reservation: reservations){
            if(reservation.isActive() == true){
                System.out.println(reservation.toString());
            }
        }
    }

    public void showGuests(List<Guest> guests, boolean isActive){
        if(isActive){
            for(Guest guest:guests){
                if(guest.isActive()){
                    System.out.println(guest.toString());
                }
            }
        } else {
            for(Guest guest:guests){
                if(!guest.isActive()){
                    System.out.println(guest.toString());
                }
            }
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", " + super.toString() +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getId(), employee.getId()) && Objects.equals(getUserName(), employee.getUserName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getUserName());
    }
}
