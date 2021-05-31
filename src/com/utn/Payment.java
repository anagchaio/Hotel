package com.utn;

import java.util.Date;

public class Payment {
    private static int counter = 1;
    private int idPayment;
    private Guest guest;
    private Date date;

    public Payment(Guest guest, Date date) {
        this.guest = guest;
        this.date = date;
        this.idPayment = counter++;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "idPayment=" + idPayment +
                ", guest=" + guest +
                ", date=" + date +
                '}';
    }
}
