package com.utn;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public Menu() {
    }

    /******************************************************************
     Imprime visualizacion de inicio
     ******************************************************************/

    public void startMenu(){
        System.out.println("\n o88                o88                o88                                  oooo");
        System.out.println("\n oooo  oo oooooo    oooo    ooooooo    oooo    ooooooo   oo oooooo     ooooo888    ooooooo");
        System.out.println("\n  888   888   888    888  888     888   888    ooooo888   888   888  888    888  888     888");
        System.out.println("\n  888   888   888    888  888           888  888    888   888   888  888    888  888     888");
        System.out.println("\n o888o o888o o888o  o888o   88ooo888   o888o  88ooo88 8o o888o o888o   88ooo888o   88ooo88");
        for(int i = 0; i<3; i++)
        {
            System.out.println("\tOoO");
        }
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
    public int enterNumber(String phase) {
        try{
            System.out.print("\n\t Ingrese " + phase + ": ");
            return new Scanner(System.in).nextInt();
        } catch (InputMismatchException e){
            System.out.print("\n\t Error - Debe ingresar un numero.");
            return this.enterNumber(phase);
        }
    }

    /********************************************************************************
     No esta funcionando :(
     *********************************************************************************/
    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void cleanScreen() {
        for(int i = 0; i< 14; ++i)
            System.out.println("");

        System.out.flush();
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

    public void changeRoomPrice(Administrator user, List<Room> rooms, RoomType type){
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
        Invoice invoice;
        roomNumber = this.enterNumber("el numero de habitacion");
        invoice = user.checkOut(roomNumber,rooms);

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
        System.out.println("\nIngresar datos del huesped");
        System.out.print("\n\t Ingrese el dni: ");
        dni = new Scanner(System.in).nextLine();
        guest = user.findGuestByDni(guests,dni);
        if(guest != null){
            System.out.println("\nEl DNI ingresado ya pertenece a un huesped.");
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

    public void registerNewReservation(Recepcionist user, List<Room> rooms, List<Guest> guests, List<Reservation> reservations){
        int roomNumber;
        Reservation reservation;
        if(user.checkVacancy(rooms)){
            user.showAvailableRooms(rooms);
            try{
                roomNumber = this.enterNumber("el numero de habitacion");
                Room room = user.findRoom(roomNumber,rooms);
                if(room != null){
                    Guest guest = this.registerGuest(user,guests);
                    List<Guest> roomGuests = new ArrayList<>();
                    roomGuests.add(guest);
                    reservation = user.roomReservation(rooms,roomNumber,roomGuests);
                    room.setRoomState(RoomState.RESERVED);
                    reservations.add(reservation);
                    System.out.println("\nLa reserva se realizo con exito. La habitacion nro. " + roomNumber + " ha sido reservada." );
                } else {
                    System.out.println("\nEl numero de habitacion no existe o no esta disponible");
                }
            } catch (InputMismatchException e){
                System.out.print("\n\t Error - Debe ingresar un numero.\n\t");
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
        for(Room room:rooms){
            if(room.getRoomNumber() == roomNumber && room.getRoomState().equals(RoomState.OCCUPIED)){
                List<Product> selectedProducts = new ArrayList<>();
                byte option = 's';
                do {
                    System.out.println("\n\tProductos:");
                    user.showProducts(products);
                    int productId;
                    productId = this.enterNumber("el id del producto que desea cargar a la habitacion");
                    Product product = user.findProductById(productId,products);
                    if(product != null){
                        selectedProducts.add(product);
                        System.out.println("\nEl producto " + product.toString() + " ha sido agregado");
                    } else {
                        System.out.println("\nEl id seleccionado no corresponde a un producto.");
                    }
                    System.out.println("\nPresione 's' si desea seguir agregando productos.");
                    option = new Scanner(System.in).nextByte();
                }while(option == 's' || option == 'S');
                room.getRoomConsumptions().add(new Consumption(selectedProducts));
            } else {
                System.out.println("\nEl numero de habitacion es incorrecto.");
            }
        }
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
        System.out.println("\n\n\n\n\n\n");
    }
    
}
