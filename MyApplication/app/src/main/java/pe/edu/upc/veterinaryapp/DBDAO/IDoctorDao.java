package pe.edu.upc.veterinaryapp.DBDAO;

import java.util.List;

import pe.edu.upc.veterinaryapp.entities.Doctor;

public interface IDoctorDao {


    List<Doctor> fetchAllDoctor();
}
