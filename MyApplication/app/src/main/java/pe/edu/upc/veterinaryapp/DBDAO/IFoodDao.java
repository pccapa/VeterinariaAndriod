package pe.edu.upc.veterinaryapp.DBDAO;

import java.util.List;

import pe.edu.upc.veterinaryapp.entities.Food;

/**
 * Created by jcrosemberg on 04/12/2015.
 */
public interface IFoodDao {
    List<Food> fetchAllFood();
}
