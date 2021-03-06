package com.utn;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Invoice implements Serializable {
    private static final long serialVersionUID = 7970889473436230100L;

    private static int counter = 1; //se setea con la lenth de la lista obtenida del archivo (si el lenth es 0 -> el counter vale 1)
    private int idInvoice;
    private Guest guest;
    private Date date;
    private Double price;

    public Invoice(Guest guest, Date date, Double price) {
        this.guest = guest;
        this.date = date;
        this.price = price;
        this.idInvoice = counter++;
    }


    public static void setCounter(int counter) {
        Invoice.counter = counter;
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

    public void setGuest(Guest  guests) {
        this.guest = guests;
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
        return "Nro Factura: " + idInvoice +
                ",\n Huesped: " + guest +
                ",\n Fecha: " + date +
                ",\n Precio total: $" + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Invoice)) return false;
        Invoice invoice = (Invoice) o;
        return getIdInvoice() == invoice.getIdInvoice();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdInvoice());
    }
}
