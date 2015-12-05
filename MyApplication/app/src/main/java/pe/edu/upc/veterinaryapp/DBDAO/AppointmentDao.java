package pe.edu.upc.veterinaryapp.DBDAO;

import pe.edu.upc.veterinaryapp.entities.Appointment;

import pe.edu.upc.veterinaryapp.DBProvider.DbContentProvider;
import pe.edu.upc.veterinaryapp.DBSchema.IAppointmentSchema;

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
 * Created by Angelica on 04/12/2015.
 */
public class AppointmentDao extends DbContentProvider implements IAppointmentSchema, IAppointmentDao{

private Cursor cursor;
private ContentValues initialValues;

        private ContentValues getContentValue() {
            return initialValues;
        }

        private void setContentValue(Appointment appointment) {
            initialValues = new ContentValues();
            initialValues.put(COLUMN_APPOINTMENT_ID, appointment.idAppointment);
            initialValues.put(COLUMN_APPOINTMENT_DATE, appointment.dateAppointment);
            initialValues.put(COLUMN_APPOINTMENT_HOUR, appointment.hourAppointment);
            initialValues.put(COLUMN_APPOINTMENT_DESCRIPCION, appointment.descripcionAppointment);
            initialValues.put(COLUMN_APPOINTMENT_STATE, appointment.stateAppointment);
            initialValues.put(COLUMN_ID_CUSTOMER, appointment.idCustomer);
            initialValues.put(COLUMN_PET_ID, appointment.idPet);
            initialValues.put(COLUMN_DOCTOR_ID, appointment.idDoctor);
            initialValues.put(COLUMN_APPOINTMENT_TYPE_ID, appointment.idAppointmentType);


        }

        public AppointmentDao(SQLiteDatabase db) {
            super(db);
        }

        @Override
        protected Appointment cursorToEntity(Cursor cursor) {
            Appointment app = new Appointment();

            int idIndex;
            int dateAppointmentIndex;
            int hourAppointmentIndex;
            int descripcionAppointmentIndex;
            int stateAppointmentIndex;
            int doctorIndex;
            int customerIndex;
            int petIndex;
            int appTypeIndex;


            if (cursor != null) {
                if (cursor.getColumnIndex(COLUMN_APPOINTMENT_ID) != -1) {
                    idIndex = cursor.getColumnIndexOrThrow(COLUMN_APPOINTMENT_ID);
                    app.idAppointment = cursor.getInt(idIndex);
                }
                if (cursor.getColumnIndex(COLUMN_APPOINTMENT_DATE) != -1) {
                    dateAppointmentIndex = cursor.getColumnIndexOrThrow(COLUMN_APPOINTMENT_DATE);
                    app.dateAppointment = cursor.getString(dateAppointmentIndex);
                }
                if (cursor.getColumnIndex(COLUMN_APPOINTMENT_HOUR) != -1) {
                    hourAppointmentIndex = cursor.getColumnIndexOrThrow(COLUMN_APPOINTMENT_HOUR);
                    app.hourAppointment = cursor.getString(hourAppointmentIndex);
                }

                if (cursor.getColumnIndex(COLUMN_APPOINTMENT_DESCRIPCION) != -1) {
                    descripcionAppointmentIndex = cursor.getColumnIndexOrThrow(COLUMN_APPOINTMENT_DESCRIPCION);
                    app.descripcionAppointment = cursor.getString(descripcionAppointmentIndex);
                }

                if (cursor.getColumnIndex(COLUMN_APPOINTMENT_STATE) != -1) {
                    stateAppointmentIndex = cursor.getColumnIndexOrThrow(COLUMN_APPOINTMENT_STATE);
                    app.stateAppointment = cursor.getString(stateAppointmentIndex);
                }

                if (cursor.getColumnIndex(COLUMN_ID_CUSTOMER) != -1) {
                    customerIndex = cursor.getColumnIndexOrThrow(COLUMN_ID_CUSTOMER);
                    app.idCustomer = cursor.getInt(customerIndex);
                }


                if (cursor.getColumnIndex(COLUMN_PET_ID) != -1) {
                    petIndex = cursor.getColumnIndexOrThrow(COLUMN_PET_ID);
                    app.idPet = cursor.getInt(petIndex);
                }

                if (cursor.getColumnIndex(COLUMN_DOCTOR_ID) != -1) {
                    doctorIndex = cursor.getColumnIndexOrThrow(COLUMN_DOCTOR_ID);
                    app.idDoctor = cursor.getInt(doctorIndex);
                }

                if (cursor.getColumnIndex(COLUMN_APPOINTMENT_TYPE_ID) != -1) {
                    appTypeIndex = cursor.getColumnIndexOrThrow(COLUMN_APPOINTMENT_TYPE_ID);
                    app.idAppointmentType = cursor.getInt(appTypeIndex);
                }


            }


            return  app;
        }


        @Override
        public boolean addAppointment(Appointment appointment) {
            setContentValue(appointment);
            try {
                return super.insert(APPOINTMENT_TABLE, getContentValue()) > 0;


            } catch (SQLiteConstraintException ex){
                Log.w("Database", ex.getMessage());
                return false;
            }
        }

    @Override
    public List<Appointment> fetchAllAppointmentPending() {
        String value = "PENDIENTE";
        List<Appointment>  appList = new ArrayList<Appointment>();
        cursor = super.query(APPOINTMENT_TABLE, APPOINTMENT_COLUMNS, "stateAppointment = " + "'" + value + "'", null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Appointment user = cursorToEntity(cursor);
                appList.add(user);
                cursor.moveToNext();
            }
            cursor.close();
        }


        return appList;
    }

}
