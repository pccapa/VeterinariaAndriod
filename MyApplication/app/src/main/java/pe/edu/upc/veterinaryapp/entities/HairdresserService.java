package pe.edu.upc.veterinaryapp.entities;

/**
 * Created by Pablo on 03/12/2015.
 */
public class HairdresserService {

    private int idHairService;
    private int  idHairdresser;
    private  int idCustomer;
    private int idPet;
    private  int idMobility;
    private String dateAppointment;
    private String hourAppointment;
    private String stateAppointment;
    private double priceAppointment;


public HairdresserService(  int  idHairdresser, int idCustomer,int idPet,int idMobility,String dateAppointment,String hourAppointment
                            , String stateAppointment, double priceAppointment ){
    this.idHairdresser=idHairdresser;
    this.idCustomer=idCustomer;
    this.idPet=idPet;
    this.idMobility=idMobility;
    this.dateAppointment=dateAppointment;
    this.hourAppointment=hourAppointment;
    this.stateAppointment=stateAppointment;
    this.priceAppointment=priceAppointment;
}
    public HairdresserService(){}

    public int getIdHairService() {
        return idHairService;
    }

    public void setIdHairService(int idHairService) {
        this.idHairService = idHairService;
    }

    public int getIdHairdresser() {
        return idHairdresser;
    }

    public void setIdHairdresser(int idHairdresser) {
        this.idHairdresser = idHairdresser;
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

    public int getIdMobility() {
        return idMobility;
    }

    public void setIdMobility(int idMobility) {
        this.idMobility = idMobility;
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

    public String getStateAppointment() {
        return stateAppointment;
    }

    public void setStateAppointment(String stateAppointment) {
        this.stateAppointment = stateAppointment;
    }

    public double getPriceAppointment() {
        return priceAppointment;
    }

    public void setPriceAppointment(double priceAppointment) {
        this.priceAppointment = priceAppointment;
    }
}
