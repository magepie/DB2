package de.dis2013.data;

/**
 * Created by nxirakia on 08.05.17.
 */
public class Apartment{
	private int id;
    private Contract contractid;
    private Owner ownerid;
    private int floor;
    private int rent;
    private int rooms;
    private int kitchen;
    private int balcony;
    
    private Estate estate;
    
    public Estate getEstate() {
		return estate;
	}

	public void setEstate(Estate estate) {
		this.estate = estate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Apartment(){
    	
    }

    public int getBalcony() {
        return balcony;
    }

    public void setBalcony(int balcony) {
        this.balcony = balcony;
    }

    public int getKitchen() {
        return kitchen;
    }

    public void setKitchen(int kitchen) {
        this.kitchen = kitchen;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public Owner getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Owner ownerid) {
        this.ownerid = ownerid;
    }

    public Contract getContractid() {
        return contractid;
    }

    public void setContractid(Contract contractid) {
        this.contractid = contractid;
    }

    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();

        result = prime * result + getFloor();
        result = prime * result + getRent();
        result = prime * result + getRooms();
        result = prime * result + getBalcony();
        result = prime * result + getKitchen();

        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof Apartment))
            return false;

        Apartment other = (Apartment) obj;

        if(
        		other.getEstate().getEstateid() != getEstate().getEstateid() ||
                other.getEstate().getEstateaddress() != getEstate().getEstateaddress() ||
                other.getEstate().getSquare_area() != getEstate().getSquare_area() ||
                getFloor() != other.getFloor() ||
                getRent() != other.getRent() ||
                getRooms() != other.getRooms() ||
                getBalcony() != other.getBalcony() ||
                getKitchen() != other.getKitchen())
        {
            return false;
        }

        return true;
    }
}

