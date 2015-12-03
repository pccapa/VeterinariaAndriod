package pe.edu.upc.veterinaryapp.DBDAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.veterinaryapp.DBProvider.DbContentProvider;
import pe.edu.upc.veterinaryapp.DBSchema.IHairdresserSchema;
import pe.edu.upc.veterinaryapp.entities.Hairdresser;


/**
 * Created by pablo on 02/12/15.
 */
public class HairdresserDao  extends DbContentProvider implements IHairdresserSchema, IHairdresserDao {
    private Cursor cursor;

    public HairdresserDao(SQLiteDatabase db) {
        super(db);
    }

    @Override
    protected Hairdresser cursorToEntity(Cursor cursor) {
        Hairdresser hairdresser =new Hairdresser();

         int idHairdresseIndex;
         int descripcionIndex;
         int passowrdIndex;
         int priceIndex;

        if (cursor != null) {
            if (cursor.getColumnIndex(COLUMN_HAIR_ID) != -1) {
                idHairdresseIndex = cursor.getColumnIndexOrThrow(COLUMN_HAIR_ID);
                hairdresser.setIdHairdresser(cursor.getInt(idHairdresseIndex)) ;
            }
            if (cursor.getColumnIndex(COLUMN_HAIR_DESCRIPCION) != -1) {
                descripcionIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_HAIR_DESCRIPCION);
                hairdresser.setDescripcion(cursor.getString(descripcionIndex));
            }
            if (cursor.getColumnIndex(COLUMN_HAIR_PRICE) != -1) {
                priceIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_HAIR_PRICE);
                hairdresser.setPrice(cursor.getDouble(priceIndex));
            }

        }
        return hairdresser;
    }

    @Override
    public List<Hairdresser> fetchAllHairdresser() {
        List<Hairdresser> hairdresserList = new ArrayList<Hairdresser>();
        cursor = super.query(HAIR_TABLE , HAIR_COLUMNS, null,
                null, COLUMN_HAIR_ID);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Hairdresser hair = cursorToEntity(cursor);
                hairdresserList.add(hair);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return hairdresserList;
    }
}
