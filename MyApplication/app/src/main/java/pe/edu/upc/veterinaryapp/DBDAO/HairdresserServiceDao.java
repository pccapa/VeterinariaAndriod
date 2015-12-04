package pe.edu.upc.veterinaryapp.DBDAO;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.veterinaryapp.DBProvider.DbContentProvider;
import pe.edu.upc.veterinaryapp.DBSchema.IHairdresserServiceSchema;
import pe.edu.upc.veterinaryapp.entities.HairdresserService;
import pe.edu.upc.veterinaryapp.entities.Pet;
import pe.edu.upc.veterinaryapp.entities.User;

/**
 * Created by Pablo on 03/12/2015.
 */
public class HairdresserServiceDao extends DbContentProvider implements IHairdresserServiceDao,IHairdresserServiceSchema {

    private Cursor cursor;
    private ContentValues initialValues;
    public HairdresserServiceDao(SQLiteDatabase db) {
        super(db);
    }

    @Override
    protected HairdresserService cursorToEntity(Cursor cursor) {
        HairdresserService hairdresserService =new HairdresserService();

        int idHairServiceIndex;
        int idHairdresserIndex;
        int idCustomerIndex;
        int idPetIndex;
        int idMobilityIndex;
        int dateAppointmentIndex;
        int hourAppointmentIndex;
        int stateAppointmentIndex;
        int priceAppointmentIndex;

        if (cursor != null) {
            if (cursor.getColumnIndex(COLUMN_HAIR_SERVICE_ID) != -1) {
                idHairServiceIndex = cursor.getColumnIndexOrThrow(COLUMN_HAIR_SERVICE_ID);
                hairdresserService.setIdHairService(cursor.getInt(idHairServiceIndex)); ;
            }
            if (cursor.getColumnIndex(COLUMN_HAIR_ID) != -1) {
                idHairdresserIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_HAIR_ID);
                hairdresserService.setIdHairdresser(cursor.getInt(idHairdresserIndex));
            }
            if (cursor.getColumnIndex(COLUMN_ID_CUSTOMER) != -1) {
                idCustomerIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_ID_CUSTOMER);
                hairdresserService.setIdCustomer(cursor.getInt(idCustomerIndex));
            }
            if (cursor.getColumnIndex(COLUMN_PET_ID) != -1) {
                idPetIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_PET_ID);
                hairdresserService.setIdPet(cursor.getInt(idPetIndex));
            }
            if (cursor.getColumnIndex(COLUMN_MOBILITY_ID) != -1) {
                idMobilityIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_MOBILITY_ID);
                hairdresserService.setIdMobility(cursor.getInt(idMobilityIndex));
            }
            if (cursor.getColumnIndex(COLUMN_HAIR_SERVICE_DATE) != -1) {
                dateAppointmentIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_HAIR_SERVICE_DATE);
                hairdresserService.setDateAppointment(cursor.getString(dateAppointmentIndex));
            }
            if (cursor.getColumnIndex(COLUMN_HAIR_SERVICE_HOUR) != -1) {
                hourAppointmentIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_HAIR_SERVICE_HOUR);
                hairdresserService.setHourAppointment(cursor.getString(hourAppointmentIndex));
            }
            if (cursor.getColumnIndex(COLUMN_HAIR_SERVICE_STATE) != -1) {
                stateAppointmentIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_HAIR_SERVICE_STATE);
                hairdresserService.setStateAppointment(cursor.getString(stateAppointmentIndex));
            }
            if (cursor.getColumnIndex(COLUMN_HAIR_SERVICE_PRICE) != -1) {
                priceAppointmentIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_HAIR_SERVICE_PRICE);
                hairdresserService.setPriceAppointment(cursor.getDouble(priceAppointmentIndex));
            }
        }
        return hairdresserService;
    }

    @Override
    public List<HairdresserService> fetchAllHairdresserService() {
        List<HairdresserService> hairdresserServiceList = new ArrayList<HairdresserService>();
        cursor = super.query(HAIR_SERVICE_TABLE , HAIR_SERVICE_COLUMNS, null,
                null, COLUMN_HAIR_SERVICE_ID);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                HairdresserService hairdresserService = cursorToEntity(cursor);
                hairdresserServiceList.add(hairdresserService);
                cursor.moveToNext();
            }
            cursor.close();
        }
        return hairdresserServiceList;
    }

    private ContentValues getContentValue() {
        return initialValues;
    }
    private void setContentValue(HairdresserService hairdresserService) {
        initialValues = new ContentValues();
        //initialValues.put(COLUMN_HAIR_SERVICE_ID, hairdresserService.getIdHairService());
        initialValues.put(COLUMN_HAIR_ID, hairdresserService.getIdHairdresser());
        initialValues.put(COLUMN_ID_CUSTOMER, hairdresserService.getIdCustomer());
        initialValues.put(COLUMN_PET_ID, hairdresserService.getIdPet());
        initialValues.put(COLUMN_MOBILITY_ID, hairdresserService.getIdMobility());
        initialValues.put(COLUMN_HAIR_SERVICE_DATE, hairdresserService.getStateAppointment());
        initialValues.put(COLUMN_HAIR_SERVICE_HOUR, hairdresserService.getHourAppointment());
        initialValues.put(COLUMN_HAIR_SERVICE_STATE, hairdresserService.getStateAppointment());
        initialValues.put(COLUMN_HAIR_SERVICE_PRICE, hairdresserService.getPriceAppointment());
    }

    @Override
    public boolean addHairdresserService(HairdresserService hairdresserService) {
        // set values
        setContentValue(hairdresserService);
        try {
            return super.insert(HAIR_SERVICE_TABLE, getContentValue()) > 0;
        } catch (SQLiteConstraintException ex){
            Log.w("Database", ex.getMessage());
            return false;
        }
    }

}
