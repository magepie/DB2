package de.dis2013.data;

import de.dis2013.util.Helper;

/**
 * Created by nxirakia on 08.05.17.
 */
public class PurchaseContract extends Contract{
    private int numberofinstallments;
    private double interestrate;
    private House house;

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public double getInterestrate() {
        return interestrate;
    }

    public void setInterestrate(double interestrate) {
        this.interestrate = interestrate;
    }

    public int getNumberofinstallments() {
        return numberofinstallments;
    }

    public void setNumberofinstallments(int numberofinstallments) {
        this.numberofinstallments = numberofinstallments;
    }

    public PurchaseContract(){super();}

    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + getNumberofinstallments();
        result = (int) (prime * result + getInterestrate());

        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof PurchaseContract))
            return false;

        PurchaseContract other = (PurchaseContract)obj;

        if(other.getContractid() != getContractid()||
                !Helper.compareObjects(this.getContractdate(), other.getContractdate()) ||
                !Helper.compareObjects(this.getSettelmentplace(), other.getSettelmentplace()) ||
                other.getNumberofinstallments() != getNumberofinstallments() ||
                other.getInterestrate() != getInterestrate())
        {
            return false;
        }

        return true;
    }
}
