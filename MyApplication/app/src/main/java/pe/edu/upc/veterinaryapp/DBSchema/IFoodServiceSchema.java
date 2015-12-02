package pe.edu.upc.veterinaryapp.DBSchema;


public interface IFoodServiceSchema {


    String FOOD_SERVICE_TABLE = "FoodService";
    String COLUMN_FOOD_SERVICE_ID = "idFoodService";
    String COLUMN_FOOD_ID = "idProduct";
	String COLUMN_ID_CUSTOMER = "idCustomer";
	String COLUMN_PET_ID = "idPet";
    String COLUMN_FOOD_SERVICE_DATE = "dateAppointment";
    String COLUMN_FOOD_SERVICE_HOUR = "hourAppointment";
    String COLUMN_FOOD_SERVICE_STATE = "stateAppointment";
	String COLUMN_FOOD_SERVICE_PRICE = "stateAppointment";

 


    String FOOD_SERVICE_TABLE_CREATE = "CREATE TABLE IF NOT EXISTS "
            + FOOD_SERVICE_TABLE
            + " ("
            + COLUMN_FOOD_SERVICE_ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_FOOD_ID
            + " INTEGER, "
            + COLUMN_ID_CUSTOMER
            + " INTEGER, "
            + COLUMN_PET_ID
            + " INTEGER, "
            + COLUMN_FOOD_SERVICE_DATE
            + " TEXT, "
		    + COLUMN_FOOD_SERVICE_HOUR
            + " TEXT, "
			+ COLUMN_FOOD_SERVICE_STATE
            + " TEXT, "
		    + COLUMN_FOOD_SERVICE_PRICE
            + " REAL, "
			+ "FOREIGN KEY(" + COLUMN_FOOD_ID +") REFERENCES Food (" + COLUMN_FOOD_ID +"),"
            + "FOREIGN KEY(" + COLUMN_ID_CUSTOMER +") REFERENCES Customer (" + COLUMN_ID_CUSTOMER +"),"
            + "FOREIGN KEY(" + COLUMN_PET_ID +") REFERENCES Pet (" + COLUMN_PET_ID +")" +
            ")" ;
			
			
			

    String[] FOOD_SERVICE_COLUMNS = new String[] { COLUMN_FOOD_SERVICE_ID,COLUMN_FOOD_ID,COLUMN_ID_CUSTOMER,
            COLUMN_PET_ID, COLUMN_FOOD_SERVICE_DATE, COLUMN_FOOD_SERVICE_HOUR,COLUMN_FOOD_SERVICE_STATE,COLUMN_FOOD_SERVICE_PRICE};

}
