package pe.edu.upc.veterinaryapp.DBSchema;


public interface IHairdresserServiceSchema {


    String HAIR_SERVICE_TABLE = "HairdresserService";
    String COLUMN_HAIR_SERVICE_ID = "idHairService";
    String COLUMN_HAIR_ID = "idHairdresser";
	String COLUMN_ID_CUSTOMER = "idCustomer";
	String COLUMN_PET_ID = "idPet";
	String COLUMN_MOBILITY_ID = "idMobility";

	
	
    String COLUMN_HAIR_SERVICE_DATE = "dateAppointment";
    String COLUMN_HAIR_SERVICE_HOUR = "hourAppointment";
    String COLUMN_HAIR_SERVICE_STATE = "stateAppointment";
	String COLUMN_HAIR_SERVICE_PRICE = "priceAppointment";

 


    String HAIR_SERVICE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + HAIR_SERVICE_TABLE
            + " ("
            + COLUMN_HAIR_SERVICE_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_HAIR_ID
            + " INTEGER, "
            + COLUMN_ID_CUSTOMER
            + " INTEGER, "
            + COLUMN_PET_ID
            + " INTEGER, "
            + COLUMN_MOBILITY_ID
            + " INTEGER, "
            + COLUMN_HAIR_SERVICE_DATE
            + " TEXT, "
		    + COLUMN_HAIR_SERVICE_HOUR
            + " TEXT, "
			+ COLUMN_HAIR_SERVICE_STATE
            + " TEXT, "
		    + COLUMN_HAIR_SERVICE_PRICE
            + " REAL, "
			+ "FOREIGN KEY(" + COLUMN_HAIR_ID +") REFERENCES Hairdresser (" + COLUMN_HAIR_ID +"),"
            + "FOREIGN KEY(" + COLUMN_ID_CUSTOMER +") REFERENCES Customer (" + COLUMN_ID_CUSTOMER +"),"
            + "FOREIGN KEY(" + COLUMN_PET_ID +") REFERENCES Pet (" + COLUMN_PET_ID +"),"
            + "FOREIGN KEY(" + COLUMN_MOBILITY_ID +") REFERENCES Mobility (" + COLUMN_MOBILITY_ID +")" +
            ")" ;
			
			
			

    String[] HAIR_SERVICE_COLUMNS = new String[] { COLUMN_HAIR_SERVICE_ID,COLUMN_HAIR_ID,COLUMN_ID_CUSTOMER,
            COLUMN_PET_ID, COLUMN_MOBILITY_ID, COLUMN_HAIR_SERVICE_DATE,COLUMN_HAIR_SERVICE_HOUR,COLUMN_HAIR_SERVICE_STATE,COLUMN_HAIR_SERVICE_PRICE};

}
