package de.dis2013.data;

/**
 * Created by nxirakia on 08.05.17.
 */
public class ApartmentRent extends Contract {

    private Owner owner;
    private Estate estate;


    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
