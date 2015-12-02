package pe.edu.upc.veterinaryapp.DBSchema;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataBaseHelper extends SQLiteOpenHelper {

    private static int version = 1;
    private static String name = "VeterinariaDb" ;
    private static CursorFactory factory = null;

    private Context contexto;
    private DataBaseHelper dbHelper;
    public SQLiteDatabase db;

    public DataBaseHelper(Context context)
    {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        CrearTabla(db);
        inicializarDatos(db);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS  Customer");
        db.execSQL("DROP TABLE IF EXISTS  User");
        db.execSQL("DROP TABLE IF EXISTS  Doctor");
        onCreate(db);
    }


    @Override
    public synchronized void close() {

        if(db != null)
            db.close();

        super.close();

    }


    public void CrearTabla(SQLiteDatabase db){

        Log.i(this.getClass().toString(), "Creando base de datos");

        db.execSQL("CREATE TABLE Customer(" +
                " idCliente INTEGER PRIMARY KEY," +
                " nombres TEXT NOT NULL, " +
                " apellidoPaterno TEXT, " +
                " apellidoMaterno TEXT," +
                " dni TEXT," +
                " telefonoFijo TEXT," +
                " telefonoMovil TEXT)");

        db.execSQL( "CREATE TABLE User(" +
                " idUser INTEGER PRIMARY KEY," +
                " nomUser TEXT, " +
                " password TEXT, " +
                " idCliente INTEGER," +
                "FOREIGN KEY(idCliente) REFERENCES Customer(idCliente))" );

        db.execSQL("CREATE TABLE Doctor(" +
                " idDoctor INTEGER PRIMARY KEY," +
                " nombres TEXT NOT NULL, " +
                " apellidoPaterno TEXT, " +
                " apellidoMaterno TEXT," +
                " dni TEXT)");




        Log.i(this.getClass().toString(), "Tabla Customer creada");
        Log.i(this.getClass().toString(), "Tabla User creada");
        Log.i(this.getClass().toString(), "Tabla Doctor creada");

    }

    public void inicializarDatos(SQLiteDatabase db){

        db.execSQL("INSERT INTO Customer(idCliente, nombres,apellidoPaterno,apellidoMaterno,dni,telefonoFijo,telefonoMovil) " +
                   "VALUES(1,'Jorge Efrain','Bedoya','Flores','12345678','3234578','991433678')");
        db.execSQL("INSERT INTO User(idUser, nomUser,password,idCliente) " +
                   "VALUES(1,'jbedoya','123',1)");


        db.execSQL("INSERT INTO Doctor(idDoctor, nombres,apellidoPaterno,apellidoMaterno) " +
                "VALUES(1,'Pedro','Lopez','Garcia')");

        db.execSQL("INSERT INTO Doctor(idDoctor, nombres,apellidoPaterno,apellidoMaterno) " +
                "VALUES(2,'Ana','Jimenez','Suarez')");


        db.execSQL("INSERT INTO Doctor(idDoctor, nombres,apellidoPaterno,apellidoMaterno) " +
                "VALUES(3,'Jose','Torres','Caballero')");

        Log.i(this.getClass().toString(), "Datos iniciales Veterinaria insertados");
        Log.i(this.getClass().toString(), "Base de datos creada");
    }
}