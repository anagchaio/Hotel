package com.utn;

import java.util.List;

public class Administrator extends Employee {
    public Administrator(String name, String surname, String dni, Integer age, String userName, String password) {
        super(name, surname, dni, age, userName, password);
    }

    //TO DO
    public void backUp() {

    }

    //create a system user / Employee, dependending on the UserType
    //en el main luego de crearlo, lo agrega a la lista de empleados
    //Este metodo es llamado por un metodo de menu, en el cual se piden los datos y se hacen las validaciones
    public Employee createEmployee(UserType type, String name, String surname, String dni, Integer age, String userName, String password){
        Employee newEmployee;
        if(type == UserType.ADMINISTRATOR){
            newEmployee = new Administrator(name,surname,dni,age, userName,password);
        } else {
            newEmployee = new Recepcionist(name,surname,dni,age, userName,password);
        }
        return newEmployee;
    }

    //Este metodo se llama desde el menu, el cual tiene un metodo que pide los datos
    public void changeRoomsPrice(List<Room> rooms, RoomType type, Double newPrice) {
        for (Room room : rooms){
            if(room.getType() == type){
                room.setPrice(newPrice);
            }
        }
    }

    public Double calculateTotalIncomes(List<Invoice> invoices) {
        Double incomes = 0.00;
        for (Invoice invoice: invoices){
            incomes += invoice.getPrice();
        }
        return incomes;
    }
}
