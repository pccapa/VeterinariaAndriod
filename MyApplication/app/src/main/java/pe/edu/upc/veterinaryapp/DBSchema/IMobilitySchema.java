package pe.edu.upc.veterinaryapp.DBSchema;

/**
 * Created by Angelica on 02/12/2015.
 */
public interface IMobilitySchema {

    String MOBILITY_TABLE = "Mobility";
    String COLUMN_MOBILITY_ID = "idMobility";
    String COLUMN_MOBILITY_DESCRIPCION = "descripcion";
    String COLUMN_MOBILITY_PRICE = "price";



    String MOBILITY_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + MOBILITY_TABLE
            + " ("
            + COLUMN_MOBILITY_ID
            + " INTEGER PRIMARY KEY, "
            + COLUMN_MOBILITY_DESCRIPCION
            + " TEXT, "
            + COLUMN_MOBILITY_PRICE
            + " REAL "
            + ")";


    String[] MOBILITY_COLUMNS = new String[] { COLUMN_MOBILITY_ID, COLUMN_MOBILITY_DESCRIPCION, COLUMN_MOBILITY_PRICE};
}
