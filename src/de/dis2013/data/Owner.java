package de.dis2013.data;

/**
 * Created by nxirakia on 05.05.17.
 */
public class Owner {
    //owner info
    private int ownerid = -1;
    private String ownername;
    private String ownersurname;
    private String address;

    //get/set owner info

    public String getOwnersurname() {
        return ownersurname;
    }

    public void setOwnersurname(String ownersurname) {
        this.ownersurname = ownersurname;
    }

    public String getOwnername() {
        return ownername;
    }

    public void setOwnername(String ownername) {
        this.ownername = ownername;
    }

    public int getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(int ownerid) {
        this.ownerid = ownerid;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((getOwnername() == null) ? 0 : getOwnername().hashCode());
        result = prime * result + ((getOwnersurname() == null) ? 0 : getOwnersurname().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());

        return result;
    }

}
