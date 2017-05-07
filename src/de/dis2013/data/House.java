package de.dis2013.data;

/**
 * Created by nxirakia on 08.05.17.
 */
public class House {
    private int houseid;
    private int floors;
    private int price;
    private int garden;

    public int getGarden() {
        return garden;
    }

    public void setGarden(int garden) {
        this.garden = garden;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getHouseid() {
        return houseid;
    }

    public void setHouseid(int houseid) {
        this.houseid = houseid;
    }
}
