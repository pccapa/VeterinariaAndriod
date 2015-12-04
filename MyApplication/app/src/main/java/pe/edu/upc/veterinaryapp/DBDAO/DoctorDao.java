package pe.edu.upc.veterinaryapp.DBDAO;

import pe.edu.upc.veterinaryapp.DBProvider.DbContentProvider;
import pe.edu.upc.veterinaryapp.DBSchema.IDoctorSchema;

import android.content.ContentValues;
import android.database.Cursor;
import  android.database.sqlite.SQLiteDatabase;

import pe.edu.upc.veterinaryapp.entities.Customer;
import  pe.edu.upc.veterinaryapp.entities.Doctor;
import pe.edu.upc.veterinaryapp.entities.User;

import java.util.List;
import android.database.sqlite.SQLiteConstraintException;
import android.util.Log;
import java.util.ArrayList;

/**
 * Created by Angelica on 03/12/2015.
 */
public class DoctorDao  extends DbContentProvider implements IDoctorSchema, IDoctorDao {



    private Cursor cursor;
    private ContentValues initialValues;

    private ContentValues getContentValue() {
        return initialValues;
    }

    private void setContentValue(Doctor doctor) {
        initialValues = new ContentValues();
        initialValues.put(COLUMN_DOCTOR_ID, doctor.idDoctor);
        initialValues.put(COLUMN_DOCTOR_NAME, doctor.doctorName);
        initialValues.put(COLUMN_DOCTOR_LASTNAME, doctor.doctorName);


    }



    public DoctorDao(SQLiteDatabase db) {
        super(db);
    }



    @Override
    public List<Doctor> fetchAllDoctor() {

        List<Doctor> doctorList = new ArrayList<Doctor>();
        cursor = super.query(DOCTOR_TABLE, DOCTOR_COLUMNS, null,
                null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Doctor doctor = cursorToEntity(cursor);
                doctorList.add(doctor);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return doctorList;
    }

    @Override
    protected Doctor cursorToEntity(Cursor cursor) {
        Doctor doctor = new Doctor();

        int idIndex;
        int doctorNameIndex;
        int doctorLastNameIndex;

        if (cursor != null) {
            if (cursor.getColumnIndex(COLUMN_DOCTOR_ID) != -1) {
                idIndex = cursor.getColumnIndexOrThrow(COLUMN_DOCTOR_ID);
                doctor.idDoctor = cursor.getInt(idIndex);
            }
            if (cursor.getColumnIndex(COLUMN_DOCTOR_NAME) != -1) {
                doctorNameIndex = cursor.getColumnIndexOrThrow(COLUMN_DOCTOR_NAME);
                doctor.doctorName = cursor.getString(doctorNameIndex);
            }
            if (cursor.getColumnIndex(COLUMN_DOCTOR_LASTNAME) != -1) {
                doctorLastNameIndex = cursor.getColumnIndexOrThrow(COLUMN_DOCTOR_LASTNAME);
                doctor.doctorLastName = cursor.getString(doctorLastNameIndex);
            }


        }


        return  doctor;
    }
}
