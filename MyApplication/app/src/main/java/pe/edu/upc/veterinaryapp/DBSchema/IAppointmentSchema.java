package pe.edu.upc.veterinaryapp.DBSchema;


public interface IAppointmentSchema {

    String APPOINTMENT_TABLE = "Appointment";
    String COLUMN_APPOINTMENT_ID = "idAppointment";
    String COLUMN_APPOINTMENT_DATE = "dateAppointment";
    String COLUMN_APPOINTMENT_HOUR = "hourAppointment";
    String COLUMN_APPOINTMENT_DESCRIPCION = "descripcionAppointment";
    String COLUMN_APPOINTMENT_STATE = "stateAppointment";
    String COLUMN_ID_CUSTOMER = "idCustomer";
    String COLUMN_PET_ID = "idPet";
    String COLUMN_DOCTOR_ID = "idDoctor";
    String COLUMN_APPOINTMENT_TYPE_ID = "idAppointmentType";



    String APPOINTMENT_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + APPOINTMENT_TABLE
            + " ("
            + COLUMN_APPOINTMENT_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_APPOINTMENT_DATE
            + " TEXT, "
            + COLUMN_APPOINTMENT_HOUR
            + " TEXT, "
            + COLUMN_APPOINTMENT_DESCRIPCION
            + " TEXT, "
            + COLUMN_APPOINTMENT_STATE
            + " TEXT, "
            + COLUMN_ID_CUSTOMER
            + " INTEGER, "
            + COLUMN_PET_ID
            + " INTEGER, "
            + COLUMN_DOCTOR_ID
            + " INTEGER, "
            + COLUMN_APPOINTMENT_TYPE_ID
            + " INTEGER, "
            + "FOREIGN KEY(" + COLUMN_ID_CUSTOMER +") REFERENCES Customer (" + COLUMN_ID_CUSTOMER +"),"
            + "FOREIGN KEY(" + COLUMN_PET_ID +") REFERENCES Pet (" + COLUMN_PET_ID +"),"
            + "FOREIGN KEY(" + COLUMN_DOCTOR_ID +") REFERENCES Doctor (" + COLUMN_DOCTOR_ID +"),"
            + "FOREIGN KEY(" + COLUMN_APPOINTMENT_TYPE_ID +") REFERENCES Appointment_Type (" + COLUMN_APPOINTMENT_TYPE_ID +")" +
            ")" ;




    String[] APPOINTMENT_COLUMNS = new String[] { COLUMN_APPOINTMENT_ID,COLUMN_APPOINTMENT_DATE,COLUMN_APPOINTMENT_HOUR,
            COLUMN_APPOINTMENT_DESCRIPCION, COLUMN_APPOINTMENT_STATE, COLUMN_ID_CUSTOMER,COLUMN_PET_ID,COLUMN_DOCTOR_ID,COLUMN_APPOINTMENT_TYPE_ID};

}

