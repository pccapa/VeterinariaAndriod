package pe.edu.upc.veterinaryapp.DBSchema;


public interface  IDoctorSchema {

    String DOCTOR_TABLE = "Doctor";
    String COLUMN_DOCTOR_ID = "idDoctor";
    String COLUMN_DOCTOR_NAME = "name";
    String COLUMN_DOCTOR_LASTNAME= "lastName";



    String DOCTOR_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + DOCTOR_TABLE
            + " ("
            + COLUMN_DOCTOR_ID
            + " INTEGER PRIMARY KEY, "
            + COLUMN_DOCTOR_NAME
            + " TEXT, "
            + COLUMN_DOCTOR_LASTNAME
            + " TEXT "
            + ")";


    String[] DOCTOR_COLUMNS = new String[] { COLUMN_DOCTOR_ID, COLUMN_DOCTOR_NAME, COLUMN_DOCTOR_LASTNAME};
}
