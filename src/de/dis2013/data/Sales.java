package de.dis2013.data;

import java.io.Serializable;

/**
 * Created by nxirakia on 08.05.17.
 */
public class Sales  extends Contract implements Serializable{
    private Estate estate;
    private Owner owner;
    private Contract contract;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

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
