package pe.edu.upc.veterinaryapp.entities;

/**
 * Created by Angelica on 03/12/2015.
 */
public class Doctor {

    public int idDoctor;
    public String doctorName;
    public String doctorLastName;

    public Doctor(int idDoctor,String doctorName,String doctorLastName){
        this.idDoctor = idDoctor;
        this.doctorName= doctorName;
        this.doctorLastName= doctorLastName;
    }


    public Doctor(){

    }

    public int getIdDoctor() {
        return idDoctor;
    }

    public void setIdDoctor(int idDoctor) {
        this.idDoctor = idDoctor;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDoctorLastName() {
        return doctorLastName;
    }

    public void setDoctorLastName(String doctorLastName) {
        this.doctorLastName = doctorLastName;
    }


}
