package de.dis2013.data;

import de.dis2013.util.Helper;

/**
 * Created by nxirakia on 08.05.17.
 */
public class TenancyContract extends Contract {
    private String startDate;
    private int duration;
    private int extracharges;
    private Apartment apartment;


    public void setApartment(Apartment apartment){this.apartment=apartment;}

    public Apartment getApartment(){return apartment;}

    public int getExtracharges() {
        return extracharges;
    }

    public void setExtracharges(int extracharges) {
        this.extracharges = extracharges;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public TenancyContract(){}

    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + getExtracharges();
        result = prime * result + getDuration();
        result = prime * result + ((getStartDate() == null) ? 0 : getStartDate().hashCode());


        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof TenancyContract))
            return false;

        TenancyContract other = (TenancyContract) obj;

        if(!Helper.compareObjects(this.getContractdate(), other.getContractdate()) ||
                !Helper.compareObjects(this.getSettelmentplace(), other.getSettelmentplace()) ||
                other.getStartDate() != getStartDate() ||
                other.getDuration() != getDuration() ||
                other.getExtracharges() != getExtracharges())

        {
            return false;
        }

        return true;
    }
}
