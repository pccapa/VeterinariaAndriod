package pe.edu.upc.veterinaryapp.DBDAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.veterinaryapp.DBProvider.DbContentProvider;
import pe.edu.upc.veterinaryapp.DBSchema.IFoodSchema;
import pe.edu.upc.veterinaryapp.entities.Food;

/**
 * Created by jcrosemberg on 04/12/2015.
 */
public class FoodDao  extends DbContentProvider implements IFoodSchema, IFoodDao {
    private Cursor cursor;

    public FoodDao(SQLiteDatabase db) {
        super(db);
    }

    @Override
    protected Food cursorToEntity(Cursor cursor) {
        Food food =new Food();

        int idProductIndex;
        int foodDescripcionIndex;
        int foodPriceIndex;
        int idRaceIndex;


        if (cursor != null) {
            if (cursor.getColumnIndex(COLUMN_FOOD_ID) != -1) {
                idProductIndex = cursor.getColumnIndexOrThrow(COLUMN_FOOD_ID);
                food.setIdProduct(cursor.getInt(idProductIndex)); ;
            }
            if (cursor.getColumnIndex(COLUMN_FOOD_DESCRIPCION) != -1) {
                foodDescripcionIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_FOOD_DESCRIPCION);
                food.setDescripcion(cursor.getString(foodDescripcionIndex));
            }
            if (cursor.getColumnIndex(COLUMN_FOOD_PRICE) != -1) {
                foodPriceIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_FOOD_PRICE);
                food.setPrice(cursor.getDouble(foodPriceIndex));
            }

        }
        return food;
    }


    public List<Food> fetchAllFood() {
        List<Food> foodList = new ArrayList<Food>();
        cursor = super.query(FOOD_TABLE , FOOD_COLUMNS, null,
                null, COLUMN_FOOD_ID);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Food food = cursorToEntity(cursor);
                foodList.add(food);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return foodList;
    }
}