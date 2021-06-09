package com.utn.Helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateHelper {
    public static Date stringToDate(String sDate) throws ParseException {
        Date auxDate=new SimpleDateFormat("dd/MM/yyyy").parse(sDate);
        System.out.println(sDate+"\t"+auxDate);
        return auxDate;
    }

}
