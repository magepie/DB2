package de.dis2013.data;

/**
 * Created by nxirakia on 08.05.17.
 */
public class TenancyContract {

    private int id;
    private String startDate;
    private int duration;
    private double extracharges;
    private Contract contract;
    private Contract contractid;

    public Contract getContractid() {
        return contractid;
    }

    public void setContractid(Contract contractid) {
        this.contractid = contractid;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public double getExtracharges() {
        return extracharges;
    }

    public void setExtracharges(double extracharges) {
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
