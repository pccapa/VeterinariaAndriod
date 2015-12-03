package pe.edu.upc.veterinaryapp.entities;

/**
 * Created by pablo on 02/12/15.
 */
public class Hairdresser {

    private int idHairdresser;
    private String descripcion;
    private String passowrd;
    private double price;

    public Hairdresser(){}

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getIdHairdresser() {
        return idHairdresser;
    }

    public void setIdHairdresser(int idHairdresser) {
        this.idHairdresser = idHairdresser;
    }
}
