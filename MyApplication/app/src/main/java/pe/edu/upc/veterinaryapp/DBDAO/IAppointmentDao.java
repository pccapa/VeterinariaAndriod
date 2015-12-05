package pe.edu.upc.veterinaryapp.DBDAO;

import java.util.List;

import pe.edu.upc.veterinaryapp.entities.Appointment;
import pe.edu.upc.veterinaryapp.entities.User;

/**
 * Created by Angelica on 04/12/2015.
 */
public interface IAppointmentDao {

    boolean addAppointment(Appointment appointment);

    List<Appointment> fetchAllAppointmentPending();
}
