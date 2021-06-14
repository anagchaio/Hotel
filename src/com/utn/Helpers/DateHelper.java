package com.utn.Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public final class DateHelper {
    public static Date stringToDate(String frase) {
        try{
            System.out.print("\n\t Ingrese fecha " + frase + " (dd/MM/yyyy): ");
            Scanner scanner = new Scanner(System.in);
            String sDate = scanner.next();
            Date auxDate = new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            return auxDate;
        }
        catch(ParseException e){
            System.out.println("\t Debe ingresar datos con el formato indicado.");
            return stringToDate(frase);
        }
    }

    public static boolean validateCheckInDate(Date checkIn){
        if(checkIn.before(java.sql.Date.valueOf(LocalDate.now()))){
            return false;
        }
        return true;
    }

    public static boolean validateCheckOutDate(Date checkIn, Date checkOut){
        if(checkOut.before(checkIn)) {
            return false;
        }
        return true;
    }
}
