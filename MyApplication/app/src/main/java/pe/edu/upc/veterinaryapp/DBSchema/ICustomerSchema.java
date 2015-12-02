package pe.edu.upc.veterinaryapp.DBSchema;

public interface ICustomerSchema {

    String CUSTOMER_TABLE = "Customer";
    String COLUMN_ID = "idCustomer";
    String COLUMN_CUSTOMER_NAME = "name";
    String COLUMN_APELLIDO_PATERNO = "apellidoPaterno";
    String COLUMN_APELLIDO_MATERNO = "apellidoMaterno";
    String COLUMN_DNI= "dni";
    String COLUMN_TELEFONO_FIJO= "telefonoFijo";
    String COLUMN_TELEFONO_MOVIL= "telefonoMovil";



    String CUSTOMER_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + CUSTOMER_TABLE
            + " ("
            + COLUMN_ID
            + " INTEGER PRIMARY KEY, "
            + COLUMN_CUSTOMER_NAME
            + " TEXT, "
            + COLUMN_APELLIDO_PATERNO
            + " TEXT, "
            + COLUMN_APELLIDO_MATERNO
            + " TEXT, "
            + COLUMN_DNI
            + " TEXT,"
            + COLUMN_TELEFONO_FIJO
            + " TEXT,"
            + COLUMN_TELEFONO_MOVIL
            + " TEXT "  + ")";

    String[] CUSTOMER_COLUMNS = new String[] { COLUMN_ID,
            COLUMN_CUSTOMER_NAME, COLUMN_APELLIDO_PATERNO, COLUMN_APELLIDO_MATERNO, COLUMN_DNI,COLUMN_TELEFONO_FIJO,COLUMN_TELEFONO_MOVIL};


}
