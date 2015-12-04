package pe.edu.upc.veterinaryapp.DBDAO;

import java.util.List;

import pe.edu.upc.veterinaryapp.entities.HairdresserService;

/**
 * Created by Pablo on 03/12/2015.
 */
public interface IHairdresserServiceDao {
    List<HairdresserService> fetchAllHairdresserService();
}
