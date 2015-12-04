package pe.edu.upc.veterinaryapp.entities;

/**
 * Created by Angelica on 04/12/2015.
 */
public class Appointment_Type {



    public int idAppointment_Type;
    public String descripcion;


    public Appointment_Type(){

    }

    public int getIdAppointment_Type() {
        return idAppointment_Type;
    }

    public void setIdAppointment_Type(int idAppointment_Type) {
        this.idAppointment_Type = idAppointment_Type;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
