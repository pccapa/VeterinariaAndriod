package pe.edu.upc.veterinaryapp.DBSchema;


public interface IHairdresserSchema {


    String HAIR_TABLE = "Hairdresser";
    String COLUMN_HAIR_ID = "idHairdresser";
    String COLUMN_HAIR_DESCRIPCION = "descripcion";
    String COLUMN_HAIR_PRICE = "price";



    String HAIR_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + HAIR_TABLE
            + " ("
            + COLUMN_HAIR_ID
            + " INTEGER PRIMARY KEY, "
            + COLUMN_HAIR_DESCRIPCION
            + " TEXT, "
            + COLUMN_HAIR_PRICE
            + " REAL "
            + ")";


    String[] HAIR_COLUMNS = new String[] { COLUMN_HAIR_ID, COLUMN_HAIR_DESCRIPCION, COLUMN_HAIR_PRICE};
}
