package pe.edu.upc.veterinaryapp.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import pe.edu.upc.veterinaryapp.DBDAO.CustomerDao;
import pe.edu.upc.veterinaryapp.DBDAO.HairdresserDao;
import pe.edu.upc.veterinaryapp.DBDAO.HairdresserServiceDao;
import pe.edu.upc.veterinaryapp.DBDAO.MobilityDao;
import pe.edu.upc.veterinaryapp.DBDAO.PetDao;
import pe.edu.upc.veterinaryapp.DBDAO.UserDao;
import java.sql.SQLException;

import pe.edu.upc.veterinaryapp.DBSchema.ICustomerSchema;
import pe.edu.upc.veterinaryapp.DBSchema.IUserSchema;
import pe.edu.upc.veterinaryapp.DBSchema.IDoctorSchema;
import pe.edu.upc.veterinaryapp.DBSchema.IHairdresserSchema;
import pe.edu.upc.veterinaryapp.DBSchema.IMobilitySchema;
import pe.edu.upc.veterinaryapp.DBSchema.IRaceSchema;
import pe.edu.upc.veterinaryapp.DBSchema.IFoodSchema;
import pe.edu.upc.veterinaryapp.DBSchema.IAppointment_TypeSchema;
import pe.edu.upc.veterinaryapp.DBSchema.IPetSchema;
import pe.edu.upc.veterinaryapp.DBSchema.IAppointmentSchema;
import pe.edu.upc.veterinaryapp.DBSchema.IFoodServiceSchema;
import pe.edu.upc.veterinaryapp.DBSchema.IHairdresserServiceSchema;

public class Database {

    private static final String TAG = "MyDatabase";
    private static final String DATABASE_NAME = "veterianariaDB.db";
    private DatabaseHelper mDbHelper;
    // Increment DB Version on any schema change
    private static final int DATABASE_VERSION = 1;
    private final Context mContext;
    public static UserDao mUserDao;
    public static CustomerDao mCustomerDao;
    public static HairdresserDao mHairdresserDao;
    public static PetDao mPetDao;
    public static MobilityDao mMobilityDao;
    public static HairdresserServiceDao mHairdresserServiceDao;


    public Database open() throws SQLException {
        mDbHelper = new DatabaseHelper(mContext);
        SQLiteDatabase mDb = mDbHelper.getWritableDatabase();

        mUserDao = new UserDao(mDb);
        mCustomerDao = new CustomerDao(mDb);
        mHairdresserDao =new HairdresserDao(mDb);
        mPetDao =new PetDao(mDb);
        mMobilityDao =new MobilityDao(mDb);
        mHairdresserServiceDao =new HairdresserServiceDao(mDb);
        return this;
    }

    public void close() {
        mDbHelper.close();
    }

    public Database(Context context) {
        this.mContext = context;
    }


    private static class DatabaseHelper extends SQLiteOpenHelper {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL(IUserSchema.USER_TABLE_CREATE);
            db.execSQL(ICustomerSchema.CUSTOMER_TABLE_CREATE);
            db.execSQL(IDoctorSchema.DOCTOR_TABLE_CREATE);
            db.execSQL(IHairdresserSchema.HAIR_TABLE_CREATE);
            db.execSQL(IMobilitySchema.MOBILITY_TABLE_CREATE);
            db.execSQL(IRaceSchema.RACE_TABLE_CREATE);
            db.execSQL(IFoodSchema.FOOD_TABLE_CREATE);
            db.execSQL(IAppointment_TypeSchema.APPOINTMENT_TYPE_TABLE_CREATE);
            db.execSQL(IPetSchema.PET_TABLE_CREATE);
            db.execSQL(IAppointmentSchema.APPOINTMENT_TABLE_CREATE);
            db.execSQL(IFoodServiceSchema.FOOD_SERVICE_TABLE_CREATE);
            db.execSQL(IHairdresserServiceSchema.HAIR_SERVICE_TABLE_CREATE);



            //Inicializando Datos
            db.execSQL("INSERT INTO Customer(idCustomer, name,apellidoPaterno,apellidoMaterno,dni,telefonoFijo,telefonoMovil) " +
                       "VALUES(1,'Jorge Efrain','Bedoya','Flores','12345678','3234578','991433678')");

            db.execSQL("INSERT INTO User(idUser, user_name,user_password,idCustomer) " +
                       "VALUES(1,'jbedoya','123',1)");

            db.execSQL("INSERT INTO Doctor(idDoctor, name,lastName) " +
                       "VALUES(1,'Ana Maria','Rosas Medrano')");

            db.execSQL("INSERT INTO Doctor(idDoctor, name,lastName) " +
                       "VALUES(2,'Eduardo Jose','Choy Garcia')");


            db.execSQL("INSERT INTO Hairdresser(idHairdresser, descripcion,price) " +
                    "VALUES(1,'BAÑO',30)");

            db.execSQL("INSERT INTO Hairdresser(idHairdresser, descripcion,price) " +
                    "VALUES(2,'BAÑO Y CORTE',50)");

            db.execSQL("INSERT INTO Mobility(idMobility, descripcion,price) " +
                    "VALUES(1,'NINGUNO',0)");

            db.execSQL("INSERT INTO Mobility(idMobility, descripcion,price) " +
                    "VALUES(2,'RECOJO',10)");

            db.execSQL("INSERT INTO Mobility(idMobility, descripcion,price) " +
                    "VALUES(3,'RECOJO Y ENVIO',20)");



            db.execSQL("INSERT INTO Race(idRace, descripcion) " +
                    "VALUES(1,'PERRO'");

            db.execSQL("INSERT INTO Race(idRace, descripcion) " +
                    "VALUES(2,'GATO')");




            db.execSQL("INSERT INTO Food(idProduct, descripcion,price,idRace) " +
                    "VALUES(1,'EUKANUBA ADULTO SMALL BREED',45,1)");


            db.execSQL("INSERT INTO Food(idProduct, descripcion,price,idRace) " +
                    "VALUES(2,'ROYAL CANIN MINI ADULTO 3 KG',25,1)");


            db.execSQL("INSERT INTO Food(idProduct, descripcion,price,idRace) " +
                    "VALUES(3,'ROYAL CANIN MAXI LIGHT 15 KG',115,1)");


            db.execSQL("INSERT INTO Food(idProduct, descripcion,price,idRace) " +
                    "VALUES(4,'ROYAL CANIN FELINE FIT 4 KG',30,2)");


            db.execSQL("INSERT INTO Food(idProduct, descripcion,price,idRace) " +
                    "VALUES(5,'HILLS  FELINO METABOLIC LATA 156 GRS',7,2)");


            db.execSQL("INSERT INTO Food(idProduct, descripcion,price,idRace) " +
                    "VALUES(6,'PROPLAN CAT 1 KG',7,2)");



            db.execSQL("INSERT INTO Appointment_Type(idAppointmentType, descripcion) " +
                    "VALUES(1,'DOMICILIO'");

            db.execSQL("INSERT INTO Appointment_Type(idAppointmentType, descripcion) " +
                    "VALUES(2,'CLINICA')");

            db.execSQL("INSERT INTO Pet (idPet, name,idRace,race,sexo,photo,idCustomer) " +
                    "VALUES(1,'RAMBO',1,'BOXER','MACHO',null,1)");

            db.execSQL("INSERT INTO Pet (idPet, name,idRace,race,sexo,photo,idCustomer) " +
                    "VALUES(2,'FIDO',1,'PERRO','MACHO',null,1)");


        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion,
                              int newVersion) {
            Log.w(TAG, "Upgrading database from version "
                    + oldVersion + " to "
                    + newVersion + " which destroys all old data");

            db.execSQL("DROP TABLE IF EXISTS " + IUserSchema.USER_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + ICustomerSchema.CUSTOMER_TABLE);
            db.execSQL("DROP TABLE IF EXISTS " + IDoctorSchema.DOCTOR_TABLE_CREATE);
            db.execSQL("DROP TABLE IF EXISTS " + IHairdresserSchema.HAIR_TABLE_CREATE);
            db.execSQL("DROP TABLE IF EXISTS " + IMobilitySchema.MOBILITY_TABLE_CREATE);
            db.execSQL("DROP TABLE IF EXISTS " + IRaceSchema.RACE_TABLE_CREATE);
            db.execSQL("DROP TABLE IF EXISTS " + IFoodSchema.FOOD_TABLE_CREATE);
            db.execSQL("DROP TABLE IF EXISTS " + IAppointment_TypeSchema.APPOINTMENT_TYPE_TABLE_CREATE);
            db.execSQL("DROP TABLE IF EXISTS " + IPetSchema.PET_TABLE_CREATE);
            db.execSQL("DROP TABLE IF EXISTS " + IAppointmentSchema.APPOINTMENT_TABLE_CREATE);
            db.execSQL("DROP TABLE IF EXISTS " + IFoodServiceSchema.FOOD_SERVICE_TABLE_CREATE);
            db.execSQL("DROP TABLE IF EXISTS " + IHairdresserServiceSchema.HAIR_SERVICE_TABLE_CREATE);


            onCreate(db);

        }
    }

}
