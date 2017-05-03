package de.dis2013.data;
import java.util.Set;

import de.dis2013.util.Helper;
/**
 * Created by nxirakia on 03.05.17.
 */
public class Contract {
    //contract info

    private int contractid= -1;

    public int getContractid() {
        return contractid;
    }

    public void setContractid(int contractid) {
        this.contractid = contractid;
    }

    private String contractdate;
    private String settelmentplace;

    public String getSettelmentplace() {
        return settelmentplace;
    }

    public void setSettelmentplace(String settelmentplace) {
        this.settelmentplace = settelmentplace;
    }

    private int contractType;
    private int installments;
    private double interestrate;
    private String startDate;
    private int duration;
    private double extracosts;
    private int houseid;
    private int apartmentid;

    public Contract(){}

    public int getContractID() {
        return contractid;
    }

    public void setContractID(int contractid) {
        this.contractid = contractid;
    }

    public String getContractdate(){return contractdate; }

    public void setContractdate(String date){

        this.contractdate = date;

    }

    public String getSettelmentPlace(){ return settelmentplace;}

    public void setSettlemtnPlace(String settlemtnplace) {this.settelmentplace =settlemtnplace;}

    public int getContractType(){return contractType;}

    public void setContractType(int contractType){this.contractType=contractType;}

    public int getInstallments(){return installments;}

    public void setInstallments(int installments){this.installments= installments;}

    public double getInterestrate(){return interestrate;}

    public void setInterestrate(double interestrate){this.interestrate=interestrate;}

    public String getStartDate(){return startDate;}

    public void setStartDate(String startDate){this.startDate=startDate;}

    public int getDuration(){return duration;}

    public void setDuration(int duration){this.duration= duration;}

    public double getExtracosts(){return extracosts;}

    public void setExtracosts(double extracosts){this.extracosts=extracosts;}

    public int getHouseid(){return houseid;}

    public void setHouseid(int houseid){this.houseid= houseid;}

    public int getApartmentid(){return apartmentid;}

    public void setApartmentid(int apartmentid){this.apartmentid= apartmentid;}

    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((getContractdate() == null) ? 0 : getContractdate().hashCode());
        result = prime * result + ((getSettelmentPlace() == null) ? 0 : getSettelmentPlace().hashCode());

        return result;
    }


}


