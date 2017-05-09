package de.dis2013.data;
import java.util.Set;

import de.dis2013.util.Helper;
/**
 * Created by nxirakia on 03.05.17.
 */
public abstract class Contract {
    //contract info

    private int contractid= -1;
    private String contractdate;
    private String settelmentplace;
    private Makler agent;
    private Owner owner;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
    public Makler getAgent() {
        return agent;
    }

    public void setAgent(Makler agent) {
        this.agent = agent;
    }

    public int getContractid() {
        return contractid;
    }

    public void setContractid(int contractid) {
        this.contractid = contractid;
    }

    public String getSettelmentplace() {
        return settelmentplace;
    }

    public void setSettelmentplace(String settelmentplace) {
        this.settelmentplace = settelmentplace;
    }

    public String getContractdate(){return contractdate; }

    public void setContractdate(String date){

        this.contractdate = date;

    }

    public Contract(){}

    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((getContractdate() == null) ? 0 : getContractdate().hashCode());
        result = prime * result + ((getSettelmentplace() == null) ? 0 : getSettelmentplace().hashCode());

        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Contract))
            return false;

        Contract other = (Contract) obj;

        if(!Helper.compareObjects(this.getContractdate(), other.getContractdate()) ||
                !Helper.compareObjects(this.getSettelmentplace(), other.getSettelmentplace()))
        {
            return false;
        }

        return true;
    }
}


