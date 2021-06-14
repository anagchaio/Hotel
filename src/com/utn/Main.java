package com.utn;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class Main {

    public static void main(String[] args) throws Exception {
        List<Room> rooms = new ArrayList<>();
        List<Employee> employees = new ArrayList<>();
        List<Reservation> reservations = new ArrayList<>();
        List<Guest> guests = new ArrayList<>();
        List<Invoice> invoices = new ArrayList<>();
        List<Product> products = new ArrayList<>();


        /* Carga de Archivos */
        ToFile<Employee> employeeFile = new ToFile<>("employees.dat");
        employees = employeeFile.load();
        if (employees.size() >= 1) {
            Employee.setCounter(employees.size()+1);
        }

        ToFile<Room> roomFile = new ToFile<>("rooms.dat");
        rooms = roomFile.load();


        ToFile<Reservation> reservationFile = new ToFile<>("reservations.dat");
        reservations = reservationFile.load();

        for (Reservation reservation:reservations){
            System.out.println(reservation.toString());
        }
        if(reservations.size() >= 1)
            Reservation.setCounter(reservations.size()+1);

        ToFile<Guest> guestFile = new ToFile<>("guests.dat");
        guests = guestFile.load();

        ToFile<Invoice> invoiceFile = new ToFile<>("invoices.dat");
        invoices = invoiceFile.load();
        if(invoices.size() >= 1)
            Invoice.setCounter(invoices.size()+1);

        ToFile<Product> productFile = new ToFile<>("products.dat");
        products = productFile.load();
        if(products.size() >= 1)
            Product.setCounter(products.size()+1);

        /* Menu Principal*/
        Menu menu = new Menu();

        int option;
        do
        {
            menu.cleanScreen();
            menu.printHeader("\t\t BIENVENIDOS");
            System.out.println("\n\t 1. Ingresar");
            System.out.println("\n\t 0. Guardar y salir");
            option = menu.enterNumber("la opcion");

            switch(option)
            {
                case 0:
                    menu.cleanScreen();
                    roomFile.save(rooms);
                    employeeFile.save(employees);
                    reservationFile.save(reservations);
                    guestFile.save(guests);
                    invoiceFile.save(invoices);
                    productFile.save(products);
                    System.out.println("* Todos los cambios fueron guardados *\n\n\n");
                    menu.printExitMessage();
                    break;
                case 1:
                    menu.cleanScreen();
                    menu.printHeader("\t INGRESO AL SISTEMA");
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
                            menu.printHeader("\t\t ADMINISTRACION");
                            System.out.println("\n\t 1. Empleados");
                            System.out.println("\n\t 2. Productos");
                            System.out.println("\n\t 3. Precios");
                            System.out.println("\n\t 4. Volver al menu anterior");
                            option = menu.enterNumber("la opcion");
                            switch(option) {
                                case 1:
                                    do {
                                        menu.cleanScreen();
                                        menu.printHeader("ADMINISTRACION: Empleados");
                                        System.out.println("\n\t 1. Agregar Administrador");
                                        System.out.println("\n\t 2. Agregar Recepcionista");
                                        System.out.println("\n\t 3. Buscar Empleado");
                                        System.out.println("\n\t 4. Ver Empleados");
                                        System.out.println("\n\t 5. Volver");
                                        option = menu.enterNumber("la opcion");
                                        switch (option){
                                            case 1:
                                                menu.cleanScreen();
                                                menu.printHeader("INGRESOS DE DATOS");
                                                menu.registerNewEmployee((Administrator) user,employees,UserType.ADMINISTRATOR);
                                                menu.pause();
                                                break;
                                            case 2:
                                                menu.cleanScreen();
                                                menu.printHeader("INGRESOS DE DATOS");
                                                menu.registerNewEmployee((Administrator) user,employees,UserType.RECEPTIONIST);
                                                menu.pause();
                                                break;
                                            case 3:
                                                menu.cleanScreen();
                                                menu.printHeader("BUSQUEDA POR DNI");
                                                menu.findEmployeeByDni((Administrator) user,employees);
                                                menu.pause();
                                                break;
                                            case 4:
                                                menu.cleanScreen();
                                                menu.printHeader("LISTADO DE EMPLEADOS");
                                                user.showEmployees(employees);
                                                menu.pause();
                                                break;
                                        }
                                    } while (option != 5);
                                    break;
                                case 2:
                                    do {
                                        menu.cleanScreen();
                                        menu.printHeader("ADMINISTRACION: Productos");
                                        System.out.println("\n\t 1. Agregar Producto");
                                        System.out.println("\n\t 2. Listado de Productos");
                                        System.out.println("\n\t 3. Volver al menu anterior");
                                        option = menu.enterNumber("la opcion");
                                        switch(option) {
                                            case 1:
                                                menu.cleanScreen();
                                                menu.printHeader("INGRESOS DE DATOS");
                                                menu.addProduct(products);
                                                menu.pause();
                                                break;
                                            case 2:
                                                menu.cleanScreen();
                                                menu.printHeader("LISTADO DE PRODUCTOS");
                                                user.showProducts(products);
                                                menu.pause();
                                                break;
                                        }
                                    } while(option != 3);
                                    break;
                                case 3:
                                    do {
                                        menu.cleanScreen();
                                        menu.printHeader("ADMINISTRACION: Precios");
                                        System.out.println("\n\t 1. Habitaciones: cambiar Costo");
                                        System.out.println("\n\t 2. Listado de Facturas");
                                        System.out.println("\n\t 3. Ingresos totales");
                                        System.out.println("\n\t 4. Volver al menu anterior");
                                        option = menu.enterNumber("la opcion");
                                        switch(option) {
                                            case 1:
                                                do {
                                                    menu.cleanScreen();
                                                    menu.printHeader("HABITACIONES - Precios");
                                                    System.out.println("\n\t 1. SIMPLE");
                                                    System.out.println("\n\t 2. DOUBLE");
                                                    System.out.println("\n\t 3. SUITE");
                                                    System.out.println("\n\t 4. Volver al menu anterior");
                                                    option = menu.enterNumber("la opcion");
                                                    switch(option) {
                                                        case 1:
                                                            menu.cleanScreen();
                                                            menu.printHeader("HABITACION SIMPLE");
                                                            menu.changeRoomPrice((Administrator) user,rooms,RoomType.SIMPLE);
                                                            menu.pause();
                                                            break;
                                                        case 2:
                                                            menu.cleanScreen();
                                                            menu.printHeader("HABITACION DOUBLE");
                                                            menu.changeRoomPrice((Administrator) user,rooms,RoomType.DOUBLE);
                                                            menu.pause();
                                                            break;
                                                        case 3:
                                                            menu.cleanScreen();
                                                            menu.printHeader("HABITACION SUITE");
                                                            menu.changeRoomPrice((Administrator) user,rooms,RoomType.SUITE);
                                                            menu.pause();
                                                            break;
                                                    }
                                                } while(option != 4);
                                                menu.pause();
                                                break;
                                            case 2:
                                                menu.cleanScreen();
                                                menu.printHeader("LISTADO DE FACTURAS");
                                                ((Administrator) user).showInvoices(invoices);
                                                menu.pause();
                                                break;
                                            case 3:
                                                menu.cleanScreen();
                                                menu.printHeader("INGRESOS HOTEL");
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
                            menu.printHeader("RECEPCION");
                            System.out.println("\n\t 1. Tomar Reservas");
                            System.out.println("\n\t 2. Cancelar Reserva");
                            System.out.println("\n\t 3. Mostrar Reservas");
                            System.out.println("\n\t 4. Check-In");
                            System.out.println("\n\t 5. Check-out");
                            System.out.println("\n\t 6. Mostrar Habitaciones");
                            System.out.println("\n\t 7. Servicio de Habitacion");
                            System.out.println("\n\t 8. Volver al menu anterior");
                            option = menu.enterNumber("la opcion");
                            switch(option) {
                                case 1:
                                    menu.cleanScreen();
                                    menu.printHeader("RECEPCION: Crear Reserva");
                                    menu.registerNewReservation((Recepcionist) user,rooms,guests,reservations);
                                    menu.pause();
                                    break;
                                case 2:
                                    menu.cleanScreen();
                                    menu.printHeader("RECEPCION: Cancelar Reserva");
                                    menu.cancelReservation((Recepcionist) user,reservations,rooms);
                                    menu.pause();
                                    break;
                                case 3:
                                    menu.cleanScreen();
                                    menu.printHeader("RECEPCION: Listado de Reservas");
                                    user.showReservations(reservations);
                                    menu.pause();
                                    break;

                                case 4:
                                    menu.cleanScreen();
                                    menu.printHeader("RECEPCION: Check-In");
                                    menu.checkIn((Recepcionist) user,reservations,rooms);
                                    menu.pause();
                                    break;
                                case 5:
                                    menu.cleanScreen();
                                    menu.printHeader("RECEPCION: Check-out");
                                    menu.checkOut((Recepcionist) user,rooms,invoices);
                                    menu.pause();
                                    break;
                                case 6:
                                    menu.cleanScreen();
                                    menu.printHeader("LISTADO DE HABITACIONES");
                                    user.showRooms(rooms);
                                    menu.pause();
                                    break;
                                case 7:
                                    menu.cleanScreen();
                                    menu.printHeader("RECEPCION: Servicio a Habitacion");
                                    menu.roomService((Recepcionist) user, products, rooms);
                                    menu.pause();
                                    break;
                                default:
                                    menu.printIncorrectAnswer();
                            }
                        } while(option != 8);
                    }
                    break;

                default:
                    menu.printIncorrectAnswer();
            }
        } while(option != 0);
    }
}
