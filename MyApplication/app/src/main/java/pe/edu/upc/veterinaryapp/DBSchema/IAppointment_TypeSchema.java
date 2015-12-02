package pe.edu.upc.veterinaryapp.DBSchema;


public interface IAppointment_TypeSchema {

    String APPOINTMENT_TYPE_TABLE = "Appointment_Type";
    String COLUMN_APPOINTMENT_TYPE_ID = "idAppointmentType";
    String COLUMN_APPOINTMENT_TYPE_DESCRIPCION = "descripcion";



    String APPOINTMENT_TYPE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + APPOINTMENT_TYPE_TABLE
            + " ("
            + COLUMN_APPOINTMENT_TYPE_ID
            + " INTEGER PRIMARY KEY, "
            + COLUMN_APPOINTMENT_TYPE_DESCRIPCION
            + " TEXT "
            + ")";


    String[] APPOINTMENT__TYPE_COLUMNS = new String[] { COLUMN_APPOINTMENT_TYPE_ID, COLUMN_APPOINTMENT_TYPE_DESCRIPCION};
}
