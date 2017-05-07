package de.dis2013.data;

/**
 * Created by nxirakia on 08.05.17.
 */
public class Apartment {
    private Contract contractid;
    private Owner ownerid;
    private Apartment apartmentid;
    private int floor;
    private int rent;
    private int rooms;
    private int kitchen;
    private int balcony;

    public int getBalcony() {
        return balcony;
    }

    public void setBalcony(int balcony) {
        this.balcony = balcony;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Apartment getApartmentid() {
        return apartmentid;
    }

    public void setApartmentid(Apartment apartmentid) {
        this.apartmentid = apartmentid;
    }

    public Owner getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Owner ownerid) {
        this.ownerid = ownerid;
    }

    public Contract getContractid() {
        return contractid;
    }

    public void setContractid(Contract contractid) {
        this.contractid = contractid;
    }
}
