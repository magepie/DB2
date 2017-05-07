package de.dis2013.data;

/**
 * Created by nxirakia on 08.05.17.
 */
public class ApartmentRent {
    private Contract contractid;
    private Owner ownerid;
    private Apartment apartmentid;

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
