package com.utn;

import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
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
        System.out.println("Press Any Key To Continue...");
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
        System.out.print("\t Ingrese la edad: ");
        int age = new Scanner(System.in).nextInt();
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







    /********************************************************************************
     Pide por pantalla que se ingrese un valor correspondiente a la opcion deseada
     *********************************************************************************/
    public int enterOption() {
        System.out.print("\n\t Ingrese opcion: ");
        return scanner.nextInt();
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
