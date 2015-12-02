package pe.edu.upc.veterinaryapp.DBSchema;

/**
 * Created by Angelica on 02/12/2015.
 */
public interface IRaceSchema {

    String RACE_TABLE = "Race";
    String COLUMN_RACE_ID = "idRace";
    String COLUMN_RACE_DESCRIPCION = "descripcion";



    String RACE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + RACE_TABLE
            + " ("
            + COLUMN_RACE_ID
            + " INTEGER PRIMARY KEY, "
            + COLUMN_RACE_DESCRIPCION
            + " TEXT "
            + ")";


    String[] RACE_COLUMNS = new String[] { COLUMN_RACE_ID, COLUMN_RACE_DESCRIPCION};
}
