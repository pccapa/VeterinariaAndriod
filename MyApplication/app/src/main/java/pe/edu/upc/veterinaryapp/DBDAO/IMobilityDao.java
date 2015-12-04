package pe.edu.upc.veterinaryapp.DBDAO;

import java.util.List;

import pe.edu.upc.veterinaryapp.entities.Mobility;

/**
 * Created by Pablo on 03/12/2015.
 */
public interface IMobilityDao {
    List<Mobility> fetchAllMobility();
}
