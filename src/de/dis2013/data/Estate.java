package de.dis2013.data;

/**
 * Created by nxirakia on 08.05.17.
 */
public class Estate {
    private int estateid;
    private double square_area;
    private String estateaddress;
    private Makler agent;

    public Makler getAgent() {
        return agent;
    }

    public void setAgent(Makler agent) {
        this.agent = agent;
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

    public int getEstateid() {
        return estateid;
    }

    public void setEstateid(int estateid) {
        this.estateid = estateid;
    }
}
