package pe.edu.upc.veterinaryapp.entities;

/**
 * Created by proyecto on 14/11/2015.
 */
public class Productos {
    Integer co_producto;
    String no_producto;

    public Integer getCo_producto() {
        return co_producto;
    }

    public void setCo_producto(Integer co_producto) {
        this.co_producto = co_producto;
    }

    public String getNo_producto() {
        return no_producto;
    }

    public void setNo_producto(String no_producto) {
        this.no_producto = no_producto;
    }

    public String getNo_marca() {
        return no_marca;
    }

    public void setNo_marca(String no_marca) {
        this.no_marca = no_marca;
    }

    String no_marca;
}
