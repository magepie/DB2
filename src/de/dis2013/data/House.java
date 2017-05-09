package de.dis2013.data;

import de.dis2013.util.Helper;

/**
 * Created by nxirakia on 08.05.17.
 */
public class House extends Estate{
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

    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + getFloors();
        result = prime * result + getGarden();
        result = prime * result + getPrice();
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (obj == null || !(obj instanceof House))
            return false;

        House other = (House) obj;

        if( other.getFloors() != getFloors()||
                other.getGarden() != getGarden()||
                other.getPrice() != getPrice())
        {
            return false;
        }

        return true;
    }
}
