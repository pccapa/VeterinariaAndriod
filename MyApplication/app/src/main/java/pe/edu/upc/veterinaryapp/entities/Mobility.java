package pe.edu.upc.veterinaryapp.entities;

/**
 * Created by Pablo on 03/12/2015.
 */
public class Mobility {

    private int  idMobility;
    private String descripcion;
    private double price;

    public Mobility(){}

    public int getIdMobility() {
        return idMobility;
    }

    public void setIdMobility(int idMobility) {
        this.idMobility = idMobility;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
