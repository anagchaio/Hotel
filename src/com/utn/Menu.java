package com.utn;

import com.utn.Helpers.DateHelper;

import java.util.*;
import java.util.Date;

public class Menu {

    public Menu() {
    }

    public void printHeader(String header){
        System.out.println("***************************************");
        System.out.println("\t " + header);
        System.out.println("***************************************");
    }

    public void cleanScreen() {
        for(int i = 0; i< 30; ++i)
            System.out.println("");

        System.out.flush();
    }

    public void printIncorrectAnswer(){
        System.out.println("\n\t--- Opcion incorrecta ---\n\n");
    }

    public void pause(){
        System.out.print("\nPresione cualquier tecla para continuar...");
        new Scanner(System.in).nextLine();
    }

    public Employee login(List<Employee> employees) {
        System.out.print("Usuario: ");
        String username = new Scanner(System.in).nextLine();
        for(Employee employee: employees){
            if(employee.getUserName().equals(username)){
                System.out.print("Password: ");
                String password = new Scanner(System.in).nextLine();
                if(employee.getPassword().equals(password)){
                    return employee;
                }
            }
        }
        return null;
    }


    /********************************************************************************
     Pide por pantalla que se ingrese un valor entero correspondiente a la opcion deseada
     *********************************************************************************/
    public int enterNumber (String phase) throws InputMismatchException {
        try{
            System.out.print("\n\t Ingrese " + phase + ": ");
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e){
            System.out.print("\n\t Error - Debe ingresar un numero.");
            return this.enterNumber(phase);
        }
    }

    public Double enterDouble (String phase) throws InputMismatchException {
        try{
            System.out.print("\n\t Ingrese " + phase + ": ");
            return new Scanner(System.in).nextDouble();
        } catch (InputMismatchException e){
            System.out.print("\n\t Error - Debe ingresar un numero.");
            return this.enterDouble(phase);
        }
    }



    /****************************************************************************
     Funcionalidades del usuario Administrador
     ****************************************************************************/
    public void registerNewEmployee(Administrator user, List<Employee> employees, UserType userType){
        boolean flag;
        String dni;
        do{
            System.out.print("\t Ingrese el dni: ");
            dni = new Scanner(System.in).nextLine();
            flag = user.verifyEmployeeDni(dni,employees);
            if(flag){
                System.out.println("El DNI ingresado ya pertenece a un empleado. Vuelva a Intentar...");
            }
        } while (flag);
        System.out.print("\t Ingrese el nombre: ");
        String name = new Scanner(System.in).nextLine();
        System.out.print("\t Ingrese el apellido: ");
        String surname = new Scanner(System.in).nextLine();
        int age = this.enterNumber("la edad");
        String username;
        do{
            System.out.print("\t Ingrese el username: ");
            username = new Scanner(System.in).nextLine();
            flag = user.verifySystemUsername(username,employees);
            if(flag){
                System.out.println("Ese usuario ya esta registrado. Vuelva a Intentar...");
            }
        } while (flag);
        System.out.print("\t Ingrese el password: ");
        String password = new Scanner(System.in).nextLine();

        Employee employee = user.createEmployee(userType,name,surname,dni,age,username,password);
        employees.add(employee);
    }

    public void findEmployeeByDni(Administrator user, List<Employee> employees){
        System.out.print("Ingrese el DNI del empleado: ");
        String dni = new Scanner(System.in).nextLine();
        Employee employee = user.findEmployee(dni,employees);
        if(employee == null){
            System.out.println("El DNI no pertenece a ningun empleado");
        } else {
            System.out.println("El empleado fue encontrado: ");
            System.out.println(employee.toString());
        }
    }

    public void changeRoomPrice(Administrator user, List<Room> rooms, RoomType type) throws InputMismatchException{
        try{
            System.out.print("\n\t Ingrese el valor del nuevo precio: $");
            Double newPrice = new Scanner(System.in).nextDouble();
            user.changeRoomsPrice(rooms,type,newPrice);
            System.out.println("\nEl precio de la habitacion "+type.getType()+" fue cambiado a $"+newPrice);
        } catch (InputMismatchException e){
            System.out.print("\n\t Error - Debe ingresar un numero.");
        }
    }

    public void showTotalIncomes(Administrator user, List<Invoice> invoices){
        System.out.println("Los ingresos totales son: $" + user.calculateTotalIncomes(invoices));
    }

    /**********************************************************************
     Funcionalidades de Menu - login Recepcionist
     ***********************************************************************/


    public void checkIn(Recepcionist user, List<Reservation> reservations, List<Room> rooms){
        int reservationId;
        Room room;
        reservationId = this.enterNumber("el numero de Reserva");
        room = user.checkIn(reservationId,reservations,rooms);
        if(room != null){
            System.out.println("\nEl check-in fue exitoso. Pueden ocupar la habitacion Nro. "+room.getRoomNumber());
        } else {
            System.out.println("\nEl numero de reserva no se encuentra en el sistema.");
        }
    }

    public void checkOut(Recepcionist user, List<Room> rooms, List<Invoice> invoices){
        int roomNumber;
        roomNumber = this.enterNumber("el numero de habitacion");
        Invoice invoice = user.checkOut(roomNumber,rooms);

        if(invoice != null){
            System.out.println("El check-out fue exitoso. La habitacion Nro. "+roomNumber+" fue liberada.");
            System.out.println("Esta es la factura: \n\t" + invoice.toString());
            invoices.add(invoice);
        } else {
            System.out.println("El numero de habitacion no esta ocupada o no se encuentra en el sistema.");
        }
    }

    public Guest registerGuest(Recepcionist user, List<Guest> guests){
        String dni;
        Guest guest;
        System.out.println("\n\t Ingresar datos del huesped");
        System.out.print("\n\t Ingrese el dni: ");
        dni = new Scanner(System.in).nextLine();
        guest = user.findGuestByDni(guests,dni);
        if(guest != null){
            System.out.println("\n\t El DNI ingresado ya pertenece a un huesped.");
            return guest;
        } else {
            System.out.print("\n\t Ingrese el nombre: ");
            String name = new Scanner(System.in).nextLine();
            System.out.print("\n\t Ingrese el apellido: ");
            String surname = new Scanner(System.in).nextLine();
            int age = this.enterNumber("la edad");
            return new Guest(name,surname,dni,age);
        }
    }

    public List<Guest> registerRoomGuests(Recepcionist user, List<Guest> guests){
        List<Guest> roomGuest = new ArrayList<>();
        char option = 's';
        do {
            System.out.println("\n\tCarga de Huespedes:");
            Guest newGuest = this.registerGuest(user,guests);
            if(newGuest != null){
                roomGuest.add(newGuest);
                System.out.println("\nEl huesped " + newGuest.toString() + " ha sido agregado a la reserva.");
            } else {
                System.out.println("\nNo se ha podido agregar al huesped.");
            }
            System.out.println("\nPresione 's' si desea seguir agregando huespedes.");
            option = new Scanner(System.in).next().charAt(0);
        }while(option == 's' || option == 'S');
        return roomGuest;
    }

    public RoomType selectRoomType(){
        RoomType roomType = null;
        System.out.print("\n\t Tipo de habitaciones\n");
        System.out.print("\t 1. Simple\n");
        System.out.print("\t 2. Double\n");
        System.out.print("\t 3. Suite\n");
        int number = this.enterNumber("el numero segun el tipo de habitacion");

        switch (number){
            case 1:
                roomType = RoomType.SIMPLE;
                break;
            case 2:
                roomType = RoomType.DOUBLE;
                break;
            case 3:
                roomType = RoomType.SUITE;
                break;
            default:
                System.out.print("\n\tNo es un valor valido. Ingrese otro.\n");
                selectRoomType();
                break;
        }
        return roomType;
    }

    public Date addCheckInDate () {
        System.out.println();
        Date checkInDate = null;
        boolean flag = false;
        while(!flag) {
            checkInDate = DateHelper.stringToDate("para el Check-In");
            if(!DateHelper.validateCheckInDate(checkInDate)){
                System.out.println("La fecha debe ser posterior a la fecha actual");
            } else {
                flag = true;
            }
        }
        return checkInDate;
    }

    public Date addCheckOutDate (Date checkInDate) {
        System.out.println();
        Date checkOutDate = null;
        boolean flag = false;
        while(!flag) {
            checkOutDate = DateHelper.stringToDate("para el Check-Out");
            if(!DateHelper.validateCheckOutDate(checkInDate,checkOutDate)){
                System.out.println("La fecha debe ser posterior a la fecha del check-In");
            } else {
                flag = true;
            }
        }
        return checkOutDate;
    }

    public void registerNewReservation(Recepcionist user, List<Room> rooms, List<Guest> guests, List<Reservation> reservations) {
        RoomType roomType = this.selectRoomType();

        if(user.checkVacancy(user.filterRooms(roomType,rooms))){
           user.showAvailableRooms(user.filterRooms(roomType,rooms));
           int roomNumber = this.enterNumber("el numero de habitacion");
           Room room = user.findRoom(roomNumber,rooms);
            if(room != null){
                List<Guest> roomGuests = registerRoomGuests(user, guests);
                Date checkInDate = this.addCheckInDate();
                Date checkOutDate = this.addCheckOutDate(checkInDate);
                Reservation reservation = new Reservation(room,roomGuests,checkInDate,checkOutDate);
                room.setRoomState(RoomState.RESERVED);
                room.setRoomGuests(roomGuests);
                guests.addAll(roomGuests);
                reservations.add(reservation);
                System.out.println("\nLa reserva se realizo con exito. La habitacion nro. " + room.getRoomNumber() + " ha sido reservada." );
            } else {
                System.out.println("\nEl numero de habitacion no existe o no esta disponible");
            }
        } else {
            System.out.println("\nNo hay habitaciones disponibles");
        }
    }

    public void cancelReservation(Recepcionist user, List<Reservation> reservations, List<Room> rooms){
        int reservationId;
        reservationId = this.enterNumber("el numero de reserva");
        if(user.roomCancellation(rooms,reservations,reservationId)){
            System.out.println("\nLa reserva nro. " + reservationId + "ha sido cancelada.");
        } else {
            System.out.println("\nEl nro no corresponde a una reserva vigente.");
        }
    }

    public void roomService(Recepcionist user, List<Product> products, List<Room> rooms) {
        int roomNumber;
        roomNumber = this.enterNumber("el numero de habitacion");
        int i = 0;
        boolean flag = false;
        while(!flag && rooms.size()>i){
            if(rooms.get(i).getRoomNumber() == roomNumber && rooms.get(i).getRoomState() == RoomState.OCCUPIED){
                flag = true;
                List<Product> selectedProducts = new ArrayList<>();
                char option = 's';
                do {
                    System.out.println("\n\tProductos:");
                    user.showProducts(products);
                    int productId;
                    productId = this.enterNumber("el nro del producto que desea cargar a la habitacion");
                    Product product = user.findProductById(productId,products);
                    if(product != null){
                        selectedProducts.add(product);
                        System.out.println("\nEl producto " + product.toString() + " ha sido agregado");
                    } else {
                        System.out.println("\nEl nro seleccionado no corresponde a un producto.");
                    }
                    System.out.println("\nPresione 's' si desea seguir agregando productos.");
                    try {
                        option = new Scanner(System.in).next().charAt(0);
                    } catch (InputMismatchException e){
                        System.out.println("Valor incorrecto. ingrese un caracter");
                    }
                } while(option == 's' || option == 'S');
                rooms.get(i).getRoomConsumptions().add(new Consumption(selectedProducts));
            }
            i++;
        }
        if(flag == false) {
            System.out.println("\nEl numero de habitacion es incorrecto.");
        }
    }

    public void addProduct(List<Product> products) throws InputMismatchException {
        String name;
        String description;
        System.out.println("\nIngresar datos del Producto");
        System.out.print("\n\t Ingrese el nombre: ");
        name = new Scanner(System.in).nextLine();
        System.out.print("\n\t Ingrese la descripcion: ");
        description = new Scanner(System.in).nextLine();
        Double price = enterDouble("el precio: $");
        Product newProduct = new Product(name,description,price);
        products.add(newProduct);
    }

    /**********************************************************************
     Funcion que muestra mensaje de despedida
     ***********************************************************************/
    public void printExitMessage()
    {
        System.out.println("\t  _   _           _          _                             ");
        System.out.println("\t | | | |         | |        | |                            ");
        System.out.println("\t | |_| | __ _ ___| |_ __ _  | |    _   _  ___  __ _  ___   ");
        System.out.println("\t |  _  |/ _` / __| __/ _` | | |   | | | |/ _ \\/ _` |/ _ \\  ");
        System.out.println("\t | | | | (_| \\__ \\ || (_| | | |___| |_| |  __/ (_| | (_) | ");
        System.out.println("\t \\_| |_/\\__,_|___/\\__\\__,_| \\_____/\\__,_|\\___|\\__, |\\___/");
        System.out.println("\t                                               __/ |       ");
        System.out.println("\t                                              |___/        ");
        System.out.println(" ");
    }
    
}
