package pe.edu.upc.veterinaryapp.DBDAO;

import java.util.List;

import pe.edu.upc.veterinaryapp.entities.Hairdresser;

/**
 * Created by pablo on 02/12/15.
 */
public interface IHairdresserDao {
    List<Hairdresser> fetchAllHairdresser();
}
