package de.dis2013.data;

/**
 * Created by nxirakia on 08.05.17.
 */
public class PurchaseContract extends Contract{
    private int id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
