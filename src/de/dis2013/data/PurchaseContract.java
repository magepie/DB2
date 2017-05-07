package de.dis2013.data;

/**
 * Created by nxirakia on 08.05.17.
 */
public class PurchaseContract {
    private int id;
    private int numberofinstallments;
    private double interestrate;
    private Contract contract;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
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
