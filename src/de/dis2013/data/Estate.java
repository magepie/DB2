package de.dis2013.data;

import de.dis2013.util.Helper;

/**
 * Created by nxirakia on 08.05.17.
 */
public class Estate {
    private double square_area;
    private String estateaddress;
    private Makler agent;
    private int estateid=-1;
    private Apartment Apartment;
    private House House;

    public House getHouse() {
        return House;
    }

    public void setHouse(House house) {
        House = house;
    }

    public Apartment getApartment() {
        return Apartment;
    }

    public void setApartment(Apartment apartment) {
        Apartment = apartment;
    }

    public int getEstateid() {
        return estateid;
    }

    public void setEstateid(int estateid) {
        this.estateid = estateid;
    }

    public Makler getAgent() {
        return agent;
    }

    public void setAgent(Makler agent) {
        this.agent = agent;
    }

    public Estate(){
    }

    public String getEstateaddress() {
        return estateaddress;
    }

    public void setEstateaddress(String estateaddress) {
        this.estateaddress = estateaddress;
    }

    public double getSquare_area() {
        return square_area;
    }

    public void setSquare_area(double square_area) {
        this.square_area = square_area;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = (int) (prime * result + getSquare_area());
        result = prime * result + ((getEstateaddress() == null) ? 0 : getEstateaddress().hashCode());

        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Estate))
            return false;

        Estate other = (Estate) obj;

        if( other.getSquare_area() != getSquare_area()||
                !Helper.compareObjects(this.getEstateaddress(), other.getEstateaddress()))

        {
            return false;
        }

        return true;
    }

}
