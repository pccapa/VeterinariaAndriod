package pe.edu.upc.veterinaryapp.DBSchema;


public interface IFoodSchema {


    String FOOD_TABLE = "Food";
    String COLUMN_FOOD_ID = "idProduct";
    String COLUMN_FOOD_DESCRIPCION = "descripcion";
    String COLUMN_FOOD_PRICE = "price";
    String COLUMN_RACE_ID = "idRace";



    String FOOD_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + FOOD_TABLE
            + " ("
            + COLUMN_FOOD_ID
            + " INTEGER PRIMARY KEY, "
            + COLUMN_FOOD_DESCRIPCION
            + " TEXT, "
            + COLUMN_FOOD_PRICE
            + " REAL ,"
            + COLUMN_RACE_ID
            + " INTEGER, "
            + "FOREIGN KEY(" + COLUMN_RACE_ID +") REFERENCES Race(" + COLUMN_RACE_ID +"))" ;


    String[] FOOD_COLUMNS = new String[] { COLUMN_FOOD_ID, COLUMN_FOOD_DESCRIPCION, COLUMN_FOOD_PRICE,COLUMN_RACE_ID};
}
