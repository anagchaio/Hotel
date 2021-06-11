package com.utn.Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public final class DateHelper {
    public static Date stringToDate(String sDate) throws ParseException {
        try{
            Date auxDate=new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
            System.out.println(sDate+"\t"+auxDate);
            return auxDate;
        }
        catch(ParseException e){
            e.printStackTrace();
            // log the exception
            throw new RuntimeException(e);
        }
    }

    public static String enterDate() {
        System.out.print("\n\t Ingrese fecha (dd/MM/yyyy)\n");
        Scanner scanner = new Scanner(System.in);
        String sDate = scanner.next();
        return sDate;
    }
}
