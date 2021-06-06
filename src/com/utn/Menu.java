package com.utn;

import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    public Menu() {
    }

    /******************************************************************
     Imprime visualizacion de inicio - simulacion de carga
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

    public void printIncorrectAnwser(){
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
     imprime por pantalla un arreglo de caracteres con un recuadro
     ****************************************************************************/
    /*void imprimirCabecera(char cabecera[])
    {
        int i;
        //system("cls");
        System.out.println("\t%c", 201);
        for(i=0; i<50; i++)
        {
            System.out.println("%c",205);
        }
        System.out.println("%c\n", 187);
        System.out.println("\t%c%32s%19c\n", 186,cabecera,186);
        System.out.println("\t%c", 200);
        for(i=0; i<50; i++)
        {
            System.out.println("%c",205);
        }
        System.out.println("%c", 188);
        System.out.println("\n\n");
    }*/

    /********************************************************************************
     Pide por pantalla que se ingrese un valor correspondiente a la opcion deseada
     *********************************************************************************/
    public int enterOption() {
        System.out.print("\n\t Ingrese opcion: ");
        return scanner.nextInt();
    }

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
    void imprimirSalida()
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
