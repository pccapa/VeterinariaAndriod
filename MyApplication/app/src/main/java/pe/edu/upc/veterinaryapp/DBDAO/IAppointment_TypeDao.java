package pe.edu.upc.veterinaryapp.DBDAO;

import java.util.List;

import pe.edu.upc.veterinaryapp.entities.Appointment_Type;

/**
 * Created by Angelica on 04/12/2015.
 */
public interface IAppointment_TypeDao {


    List<Appointment_Type> fetchAllAppointment_Type();
}
