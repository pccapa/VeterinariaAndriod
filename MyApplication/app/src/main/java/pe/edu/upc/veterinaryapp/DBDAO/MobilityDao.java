package pe.edu.upc.veterinaryapp.DBDAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.veterinaryapp.DBProvider.DbContentProvider;
import pe.edu.upc.veterinaryapp.DBSchema.IMobilitySchema;
import pe.edu.upc.veterinaryapp.entities.Mobility;

/**
 * Created by Pablo on 03/12/2015.
 */
public class MobilityDao extends DbContentProvider implements IMobilityDao, IMobilitySchema {

    private Cursor cursor;

    public MobilityDao(SQLiteDatabase db) {
        super(db);
    }


    @Override
    protected Mobility cursorToEntity(Cursor cursor) {
        Mobility mobility =new Mobility();

        int idMobilityIndex;
        int descripcionIndex;
        int priceIndex;

        if (cursor != null) {
            if (cursor.getColumnIndex(COLUMN_MOBILITY_ID) != -1) {
                idMobilityIndex = cursor.getColumnIndexOrThrow(COLUMN_MOBILITY_ID);
                mobility.setIdMobility(cursor.getInt(idMobilityIndex)); ;
            }
            if (cursor.getColumnIndex(COLUMN_MOBILITY_DESCRIPCION) != -1) {
                descripcionIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_MOBILITY_DESCRIPCION);
                mobility.setDescripcion(cursor.getString(descripcionIndex));
            }
            if (cursor.getColumnIndex(COLUMN_MOBILITY_PRICE) != -1) {
                priceIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_MOBILITY_PRICE);
                mobility.setPrice(cursor.getDouble(priceIndex));
            }

        }
        return mobility;
    }

    @Override
    public List<Mobility> fetchAllMobility() {
        List<Mobility> mobilityList = new ArrayList<Mobility>();
        cursor = super.query(MOBILITY_TABLE , MOBILITY_COLUMNS, null,
                null, COLUMN_MOBILITY_ID);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Mobility mobility = cursorToEntity(cursor);
                mobilityList.add(mobility);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return mobilityList;
    }



}
