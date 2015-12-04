package pe.edu.upc.veterinaryapp.entities;

/**
 * Created by jcrosemberg on 04/12/2015.
 */

public class Food {
    private int idProduct;
    private String descripcion;
    private double price;
    private int idRace;
    public Food(){}

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
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

    public int getIdRace() {
        return idRace;
    }

    public void setIdRace(int idRace) {
        this.idRace = idRace;
    }


}
