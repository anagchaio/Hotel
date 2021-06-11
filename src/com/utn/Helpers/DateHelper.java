package com.utn.Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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

}
