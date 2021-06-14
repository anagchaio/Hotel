package com.utn.Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public final class DateHelper {
    public static Date stringToDate(String sDate)  {
        try{
            Date auxDate=new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
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
