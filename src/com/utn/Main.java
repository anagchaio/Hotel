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

        if(employees.size()>1)
            Employee.setCounter(employees.size());

        if(reservations.size()>1)
            Reservation.setCounter(reservations.size());

        if(invoices.size()>1)
            Invoice.setCounter(invoices.size());



        /*int option;

        option = menu.enterOption();
        menu.cleanScreen();*/
        Administrator admin = new Administrator("admin","admin","123",22,"admin","admin");
        Recepcionist anagchaio = new Recepcionist("Ana","Gonzalez","34500998",32,"anagchaio","pass");
        employees.add(admin);
        employees.add(anagchaio);

        /* Menu Principal*/
        int option;
        do
        {
            menu.cleanScreen();
            System.out.println("\tBienvenidos");
            System.out.println("\n\t 1. Ingresar");
            System.out.println("\n\t 0. Guardar y salir");
            option = menu.enterNumber("la opcion");

            switch(option)
            {
                case 0:
                    menu.cleanScreen();
                    menu.printExitMessage();
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

                    if(user instanceof Administrator) {
                        do {
                            menu.cleanScreen();
                            System.out.println("Administracion");
                            System.out.println("\n\t 1. Empleados");
                            System.out.println("\n\t 2. Productos");
                            System.out.println("\n\t 3. Precios"); //Change Rooms prices & see invoices - total incomes
                            System.out.println("\n\t 4. Volver al menu anterior");
                            option = menu.enterNumber("la opcion");
                            switch(option) {
                                case 1:
                                    do {
                                        menu.cleanScreen();
                                        System.out.println("Administracion de Empleados");
                                        System.out.println("\n\t 1. Agregar Administrador");
                                        System.out.println("\n\t 2. Agregar Recepcionista");
                                        System.out.println("\n\t 3. Buscar Empleado");
                                        System.out.println("\n\t 4. Ver Empleados");
                                        System.out.println("\n\t 5. Volver");
                                        option = menu.enterNumber("la opcion");
                                        switch (option){
                                            case 1:
                                                menu.cleanScreen();
                                                menu.registerNewEmployee((Administrator) user,employees,UserType.ADMINISTRATOR);
                                                menu.pause();
                                                break;
                                            case 2:
                                                menu.cleanScreen();
                                                menu.registerNewEmployee((Administrator) user,employees,UserType.RECEPTIONIST);
                                                menu.pause();
                                                break;
                                            case 3:
                                                menu.cleanScreen();
                                                menu.findEmployeeByDni((Administrator) user,employees);
                                                menu.pause();
                                                break;
                                            case 4:
                                                menu.cleanScreen();
                                                user.showEmployees(employees);
                                                menu.pause();
                                                break;
                                        }
                                    } while (option != 5);
                                    break;
                                case 2:
                                    do {
                                        menu.cleanScreen();
                                        System.out.println("Administracion de Productos");
                                        System.out.println("\n\t 1. Agregar Producto");
                                        System.out.println("\n\t 2. Listado de Productos");
                                        System.out.println("\n\t 3. Volver al menu anterior");
                                        option = menu.enterNumber("la opcion");
                                        switch(option) {
                                            case 1:
                                                menu.cleanScreen();
                                                System.out.println("Proximamente");
                                                //menu.AddProduct();
                                                menu.pause();
                                                break;
                                            case 2:
                                                menu.cleanScreen();
                                                user.showProducts(products);
                                                menu.pause();
                                                break;
                                        }
                                    } while(option != 3);
                                    break;
                                case 3:
                                    do {
                                        menu.cleanScreen();
                                        System.out.println("Administracion de Precios");
                                        System.out.println("\n\t 1. Habitaciones: cambiar Costo");
                                        System.out.println("\n\t 2. Listado de Facturas");
                                        System.out.println("\n\t 3. Ingresos totales");
                                        System.out.println("\n\t 4. Volver al menu anterior");
                                        option = menu.enterNumber("la opcion");
                                        switch(option) {
                                            case 1:
                                                do {
                                                    menu.cleanScreen();
                                                    System.out.println("Cambio de precio");
                                                    System.out.println("\n\t 1. SIMPLE");
                                                    System.out.println("\n\t 2. DOUBLE");
                                                    System.out.println("\n\t 3. SUITE");
                                                    System.out.println("\n\t 4. Volver al menu anterior");
                                                    option = menu.enterNumber("la opcion");
                                                    switch(option) {
                                                        case 1:
                                                            menu.cleanScreen();
                                                            menu.changeRoomPrice((Administrator) user,rooms,RoomType.SIMPLE);
                                                            menu.pause();
                                                            break;
                                                        case 2:
                                                            menu.cleanScreen();
                                                            menu.changeRoomPrice((Administrator) user,rooms,RoomType.DOUBLE);
                                                            menu.pause();
                                                            break;
                                                        case 3:
                                                            menu.cleanScreen();
                                                            menu.changeRoomPrice((Administrator) user,rooms,RoomType.SUITE);
                                                            menu.pause();
                                                            break;
                                                    }
                                                } while(option != 4);
                                                menu.pause();
                                                break;
                                            case 2:
                                                menu.cleanScreen();
                                                ((Administrator) user).showInvoices(invoices);
                                                menu.pause();
                                                break;
                                            case 3:
                                                menu.cleanScreen();
                                                menu.showTotalIncomes((Administrator) user,invoices);
                                                menu.pause();
                                                break;
                                        }
                                    } while(option != 4);
                                    break;
                                default:
                                    menu.printIncorrectAnswer();
                            }
                        } while(option != 4);
                    }
                    if(user instanceof Recepcionist) {
                        do {
                            menu.cleanScreen();
                            System.out.println("Recepcion");
                            System.out.println("\n\t 1. Tomar Reservas");
                            System.out.println("\n\t 2. Cancelar Reserva");
                            System.out.println("\n\t 3. Check-In");
                            System.out.println("\n\t 4. Check-out");
                            System.out.println("\n\t 5. Mostrar Habitaciones");
                            System.out.println("\n\t 6. Servicio de Habitacion");
                            System.out.println("\n\t 7. Volver al menu anterior");
                            option = menu.enterNumber("la opcion");
                            switch(option) {
                                case 1:
                                    menu.cleanScreen();
                                    menu.registerNewReservation((Recepcionist) user,rooms,guests,reservations);
                                    menu.pause();
                                    break;
                                case 2:
                                    menu.cleanScreen();
                                    menu.cancelReservation((Recepcionist) user,reservations,rooms);
                                    menu.pause();
                                    break;

                                case 3:
                                    menu.cleanScreen();
                                    menu.checkIn((Recepcionist) user,reservations,rooms);
                                    menu.pause();
                                    break;
                                case 4:
                                    menu.cleanScreen();
                                    menu.checkOut((Recepcionist) user,rooms,invoices);
                                    menu.pause();
                                    break;
                                case 5:
                                    menu.cleanScreen();
                                    user.showRooms(rooms);
                                    menu.pause();
                                    break;
                                case 6:
                                    menu.cleanScreen();
                                    menu.roomService((Recepcionist) user, products, rooms);
                                    menu.pause();
                                    break;
                                default:
                                    menu.printIncorrectAnswer();
                            }
                        } while(option != 7);
                    }
                    break;

                default:
                    menu.printIncorrectAnswer();
            }
        } while(option != 0);
    }
}
