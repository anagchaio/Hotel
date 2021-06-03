package com.utn;

import java.util.Date;

public class Invoice {
    private static int counter = 1;
    private int idInvoice;
    private Guest guest;
    private Date date;
    private Double price;

    public Invoice(Guest guest, Date date) {
        this.guest = guest;
        this.date = date;
        this.idInvoice = counter++;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Guest getGuest() {
        return guest;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price){
        this.price = price;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "idPayment=" + idInvoice +
                ", guest=" + guest +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
