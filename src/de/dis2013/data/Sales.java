package de.dis2013.data;

/**
 * Created by nxirakia on 08.05.17.
 */
public class Sales  extends Contract{
    private Estate estate;
    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Estate getEstate() {
        return estate;
    }

    public void setEstate(Estate estate) {
        this.estate = estate;
    }

    public Sales(){}

}
