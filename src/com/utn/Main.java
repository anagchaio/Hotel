package com.utn;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Room> rooms = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        List<Reservation> reservations = new ArrayList<>();
        List<Guest> guests = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        Menu menu = new Menu();
        HotelManagement hotel = new HotelManagement(rooms,employees, guests, invoices);

        /*int option;

        option = menu.enterOption();
        menu.cleanScreen();*/
        Administrator admin = new Administrator("admin","admin","123",22,"admin","admin");

        employees.add(admin);

        /* Menu Principal*/
        int option;
        do
        {
            menu.cleanScreen();
            System.out.println("\tBienvenidos");
            System.out.println("\n\t 1. Ingresar");
            System.out.println("\n\t 0. Salir");
            option = menu.enterOption();

            switch(option)
            {
                case 0:
                    menu.cleanScreen();
                    menu.imprimirSalida();
                    break;
                case 1:
                    menu.cleanScreen();
                    Employee user = menu.login(employees);

                    if(user != null){
                        System.out.println(" -- Login exitoso --");
                    } else {
                        System.out.println("Usuario o Contraseña incorrecta");
                    }
                    menu.pause();
                    menu.cleanScreen();
                    ///menu admin o recep segun username del login
                    if(user instanceof Administrator) {
                        do {
                            ////imprimirCabecera(" Administracion");
                            System.out.println("\n\t 1. Empleados");
                            System.out.println("\n\t 2. Productos");
                            System.out.println("\n\t 3. Volver al menu anterior");
                            option = menu.enterOption();
                            switch(option) {
                                case 1:
                                    do {
                                        menu.cleanScreen();
                                        ////imprimirCabecera(" Empleados");
                                        System.out.println("\n\t 1. Alta");
                                        // ...
                                        option = menu.enterOption();
                                        switch (option){
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                        }
                                    } while (option != 4);
                                    break;
                                case 2:
                                    do {
                                        menu.cleanScreen();
                                        //imprimirCabecera("Administracion de Productos");
                                        System.out.println("\n\t 1. Alta");
                                        System.out.println("\n\t 2. Baja");
                                        System.out.println("\n\t 3. Modificacion");
                                        System.out.println("\n\t 4. Listado de Productos");
                                        System.out.println("\n\t 5. Consultas");
                                        System.out.println("\n\t 6. Volver al menu anterior");
                                        option = menu.enterOption();
                                        switch(option) {
                                            case 1:
                                                ///alta producto

                                                break;
                                            case 2:
                                                ///baja producto

                                                break;
                                            case 3:
                                                //modificar info productos

                                                break;
                                            case 4:
                                                //subprograma mostrar listado de productos
                                        }
                                    } while(option != 4);
                                    break;
                                case 3:
                                    menu.cleanScreen();
                                    break;
                                default:
                                    menu.printIncorrectAnwser();
                            }
                        } while(option != 3);
                    }
                    if(user instanceof Recepcionist) {
                        do {
                            ////imprimirCabecera(" Recepcion");
                            System.out.println("\n\t 1. Reservas");
                            System.out.println("\n\t 2. Productos");
                            System.out.println("\n\t 3. Volver al menu anterior");
                            option = menu.enterOption();
                            switch(option) {
                                case 1:
                                    do {
                                        menu.cleanScreen();
                                        ////imprimirCabecera(" Empleados");
                                        System.out.println("\n\t 1. Alta");
                                        // ...
                                        option = menu.enterOption();
                                        switch (option){
                                            case 1:
                                                break;
                                            case 2:
                                                break;
                                        }
                                    } while (option != 4);
                                    break;
                                case 2:
                                    do {
                                        menu.cleanScreen();
                                        //imprimirCabecera("Administracion de Productos");
                                        System.out.println("\n\t 1. Alta");
                                        System.out.println("\n\t 2. Baja");
                                        System.out.println("\n\t 3. Modificacion");
                                        System.out.println("\n\t 4. Listado de Productos");
                                        System.out.println("\n\t 5. Consultas");
                                        System.out.println("\n\t 6. Volver al menu anterior");
                                        option = menu.enterOption();
                                        switch(option) {
                                            case 1:
                                                ///alta producto

                                                break;
                                            case 2:
                                                ///baja producto

                                                break;
                                            case 3:
                                                //modificar info productos

                                                break;
                                            case 4:
                                                //subprograma mostrar listado de productos
                                        }
                                    } while(option != 4);
                                    break;
                                case 3:
                                    menu.cleanScreen();
                                    break;
                                default:
                                    menu.printIncorrectAnwser();
                            }
                        } while(option != 3);
                    }
                    break;

                default:
                    menu.printIncorrectAnwser();
            }
        } while(option != 0);




    }
}
