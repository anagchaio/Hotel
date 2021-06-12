package com.utn;

import java.io.Serializable;
import java.util.List;

public class Administrator extends Employee implements Serializable {

    private static final long serialVersionUID = 7970889473436230100L;

    public Administrator(){
        super();
    }

    public Administrator(String name, String surname, String dni, Integer age, String userName, String password) {
        super(name, surname, dni, age, userName, password);
    }

    //TO DO
    public void backUp() {

    }


    public Employee createEmployee(UserType type, String name, String surname, String dni, Integer age, String userName, String password){
        Employee newEmployee;
        if(type == UserType.ADMINISTRATOR){
            newEmployee = new Administrator(name,surname,dni,age, userName,password);
        } else {
            newEmployee = new Recepcionist(name,surname,dni,age, userName,password);
        }
        return newEmployee;
    }

    public boolean verifyEmployeeDni(String dni, List<Employee> employees){
        for(Employee employee: employees){
            if(employee.getDni() == dni){
                return true;
            }
        }
        return false;
    }

    public boolean verifySystemUsername(String username, List<Employee> employees){
        for(Employee employee: employees){
            if(employee.getUserName().equals(username)){
                return true;
            }
        }
        return false;
    }

    public Employee findEmployee(String dni, List<Employee> employees) {
        for(Employee employee: employees){
            if(employee.getDni().equals(dni)){
                return employee;
            }
        }
        return null;
    }

    public void showInvoices(List<Invoice> invoices){
        for(Invoice invoice:invoices){
            System.out.println(invoice.toString());
        }
    }

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
