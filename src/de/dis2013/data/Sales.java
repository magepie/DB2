package de.dis2013.data;

/**
 * Created by nxirakia on 08.05.17.
 */
public class Sales {
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

    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((getEstate() == null) ? 0 : getEstate().hashCode());
        result = prime * result + ((getOwner() == null) ? 0 : getOwner().hashCode());

        return result;
    }
}
