package pe.edu.upc.veterinaryapp.DBSchema;


public interface IPetSchema {


    String PET_TABLE = "Pet";
    String COLUMN_PET_ID = "idPet";
    String COLUMN_PET_NAME = "name";
    String COLUMN_RACE_ID = "idRace";
    String COLUMN_RACE = "idRace";
    String COLUMN_PET_SEXO = "sexo";
    String COLUMN_PET_PHOTO = "photo";
    String COLUMN_ID_CUSTOMER = "idCustomer";


    String PET_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + PET_TABLE
            + " ("
            + COLUMN_PET_ID
            + " INTEGER PRIMARY KEY, "
            + COLUMN_PET_NAME
            + " TEXT, "
            + COLUMN_RACE_ID
            + " INTEGER, "
            + COLUMN_RACE
            + " TEXT, "
            + COLUMN_PET_SEXO
            + " TEXT, "
            + COLUMN_PET_PHOTO
            + " BLOB, "
            + COLUMN_ID_CUSTOMER
            + " INTEGER, "
            + "FOREIGN KEY(" + COLUMN_RACE_ID +") REFERENCES Race(" + COLUMN_RACE_ID +"),"
            + "FOREIGN KEY(" + COLUMN_ID_CUSTOMER +") REFERENCES Customer(" + COLUMN_ID_CUSTOMER +")" +
            ")" ;

    String[] USER_COLUMNS = new String[] { COLUMN_PET_ID,
            COLUMN_PET_NAME, COLUMN_RACE_ID, COLUMN_ID_CUSTOMER};

}
