package pe.edu.upc.veterinaryapp.DBSchema;

public interface IUserSchema {

    String USER_TABLE = "User";
    String COLUMN_USER_ID = "idUser";
    String COLUMN_USER_NAME = "user_name";
    String COLUMN_USER_PASSWORD = "user_password";
    String COLUMN_ID_CUSTOMER = "idCustomer";



    String USER_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + USER_TABLE
            + " ("
            + COLUMN_USER_ID
            + " INTEGER PRIMARY KEY, "
            + COLUMN_USER_NAME
            + " TEXT, "
            + COLUMN_USER_PASSWORD
            + " TEXT, "
            + COLUMN_ID_CUSTOMER
            + " INTEGER, "
         //   + ")";
            + "FOREIGN KEY(" + COLUMN_ID_CUSTOMER +") REFERENCES Customer(" + COLUMN_ID_CUSTOMER +"))" ;

    String[] USER_COLUMNS = new String[] { COLUMN_USER_ID,
            COLUMN_USER_NAME, COLUMN_USER_PASSWORD, COLUMN_ID_CUSTOMER};


}
