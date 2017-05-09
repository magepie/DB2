package de.dis2013.data;

/**
 * Created by nxirakia on 08.05.17.
 */
public class TenancyContract extends Contract {

    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
