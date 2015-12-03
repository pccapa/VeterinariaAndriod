package pe.edu.upc.veterinaryapp.DBDAO;

import java.util.List;

import pe.edu.upc.veterinaryapp.entities.Pet;

/**
 * Created by Pablo on 03/12/2015.
 */
public interface IPetDao {
    List<Pet> fetchAllPet();
}
