package com.example.appbotica;

public class Products {
    private String nameproduct;
    private long price;
    private String dateexpiration;
    private String namebotica;
    private String directionbotica;

    public Products() {
    }

    public Products(String nameproduct, long price, String dateexpiration, String namebotica, String directionbotica) {

        this.nameproduct = nameproduct;
        this.price = price;
        this.dateexpiration = dateexpiration;
        this.namebotica = namebotica;
        this.directionbotica = directionbotica;
    }

    public String getNameproduct()
    {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct)
    {
        this.nameproduct = nameproduct;
    }

    public long getPrice()
    {
        return price;
    }

    public void setPrice(long price)
    {
        this.price = price;
    }

    public String getDateexpiration()
    {
        return dateexpiration;
    }

    public void setDateexpiration(String dateexpiration)
    {
        this.dateexpiration = dateexpiration;
    }

    public String getNamebotica()
    {
        return namebotica;
    }

    public void setNamebotica(String namebotica)
    {
        this.namebotica = namebotica;
    }

    public String getDirectionbotica()
    {
        return directionbotica;
    }

    public void setDirectionbotica(String directionbotica)
    {
        this.directionbotica = directionbotica;
    }

}
