package pe.edu.upc.veterinaryapp.DBDAO;

import pe.edu.upc.veterinaryapp.DBProvider.DbContentProvider;


import android.content.ContentValues;
import android.database.Cursor;
import  android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.List;
import  pe.edu.upc.veterinaryapp.DBSchema.IAppointment_TypeSchema;
import pe.edu.upc.veterinaryapp.entities.Appointment_Type;
import pe.edu.upc.veterinaryapp.entities.Doctor;

/**
 * Created by Angelica on 04/12/2015.
 */
public class Appointment_TypeDao  extends DbContentProvider implements IAppointment_TypeSchema, IAppointment_TypeDao {



    private Cursor cursor;
    private ContentValues initialValues;

    private ContentValues getContentValue() {
        return initialValues;
    }

    private void setContentValue(Appointment_Type AppointmentType) {
        initialValues = new ContentValues();
        initialValues.put(COLUMN_APPOINTMENT_TYPE_ID, AppointmentType.idAppointment_Type);
        initialValues.put(COLUMN_APPOINTMENT_TYPE_DESCRIPCION, AppointmentType.descripcion);


    }




    public Appointment_TypeDao(SQLiteDatabase db) {
        super(db);
    }

    @Override
    protected Appointment_Type cursorToEntity(Cursor cursor) {

        Appointment_Type Apptype = new Appointment_Type();

        int idIndex;
        int AppTypeNameIndex;

        if (cursor != null) {
            if (cursor.getColumnIndex(COLUMN_APPOINTMENT_TYPE_ID) != -1) {
                idIndex = cursor.getColumnIndexOrThrow(COLUMN_APPOINTMENT_TYPE_ID);
                Apptype.idAppointment_Type = cursor.getInt(idIndex);
            }
            if (cursor.getColumnIndex(COLUMN_APPOINTMENT_TYPE_DESCRIPCION) != -1) {
                AppTypeNameIndex = cursor.getColumnIndexOrThrow(COLUMN_APPOINTMENT_TYPE_DESCRIPCION);
                Apptype.descripcion = cursor.getString(AppTypeNameIndex);
            }


        }


        return  Apptype;
    }

    @Override
    public List<Appointment_Type> fetchAllAppointment_Type() {
        List<Appointment_Type> typeList = new ArrayList<Appointment_Type>();
        cursor = super.query(APPOINTMENT_TYPE_TABLE, APPOINTMENT__TYPE_COLUMNS, null,
                null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Appointment_Type appType = cursorToEntity(cursor);
                typeList.add(appType);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return typeList;
    }
}
