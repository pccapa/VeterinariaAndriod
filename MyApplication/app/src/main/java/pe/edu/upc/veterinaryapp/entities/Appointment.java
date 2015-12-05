package pe.edu.upc.veterinaryapp.entities;

/**
 * Created by Angelica on 04/12/2015.
 */
public class Appointment {


    public int           idAppointment;
    public String        dateAppointment;
    public String        hourAppointment;
    public String        descripcionAppointment;
    public String        stateAppointment;
    public int           idCustomer;
    public int           idPet;
    public int           idDoctor;
    public int           idAppointmentType;

    public Appointment() {
    }

    public int getIdAppointment() {
        return idAppointment;
    }

    public void setIdAppointment(int idAppointment) {
        this.idAppointment = idAppointment;
    }

    public String getDateAppointment() {
        return dateAppointment;
    }

    public void setDateAppointment(String dateAppointment) {
        this.dateAppointment = dateAppointment;
    }

    public String getHourAppointment() {
        return hourAppointment;
    }

    public void setHourAppointment(String hourAppointment) {
        this.hourAppointment = hourAppointment;
    }

    public String getDescripcionAppointment() {
        return descripcionAppointment;
    }

    public void setDescripcionAppointment(String descripcionAppointment) {
        this.descripcionAppointment = descripcionAppointment;
    }

    public String getStateAppointment() {
        return stateAppointment;
    }

    public void setStateAppointment(String stateAppointment) {
        this.stateAppointment = stateAppointment;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdPet() {
        return idPet;
    }

    public void setIdPet(int idPet) {
        this.idPet = idPet;
    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public int getIdAppointmentType() {
        return idAppointmentType;
    }

    public void setIdAppointmentType(int idAppointmentType) {
        this.idAppointmentType = idAppointmentType;
    }
}
