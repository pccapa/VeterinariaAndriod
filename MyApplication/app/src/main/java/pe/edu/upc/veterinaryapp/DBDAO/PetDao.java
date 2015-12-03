package pe.edu.upc.veterinaryapp.DBDAO;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.veterinaryapp.DBProvider.DbContentProvider;
import pe.edu.upc.veterinaryapp.DBSchema.IPetSchema;
import pe.edu.upc.veterinaryapp.entities.Hairdresser;
import pe.edu.upc.veterinaryapp.entities.Pet;

/**
 * Created by Pablo on 03/12/2015.
 */
public class PetDao extends DbContentProvider implements IPetSchema, IPetDao {
    private Cursor cursor;
    public PetDao(SQLiteDatabase db) {
        super(db);
    }

    @Override
    protected Pet cursorToEntity(Cursor cursor) {
        Pet pet =new Pet();

        int idPetIndex;
        int nameIndex;
        int idRaceIndex;
        int RaceIndex;
        int sexoIndex;
        //int photoIndex;
        int idCustomerIndex;

        if (cursor != null) {
            if (cursor.getColumnIndex(COLUMN_PET_ID) != -1) {
                idPetIndex = cursor.getColumnIndexOrThrow(COLUMN_PET_ID);
                pet.setIdPet(cursor.getInt(idPetIndex)); ;
            }
            if (cursor.getColumnIndex(COLUMN_PET_NAME) != -1) {
                nameIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_PET_NAME);
                pet.setName(cursor.getString(nameIndex));
            }
            if (cursor.getColumnIndex(COLUMN_RACE_ID) != -1) {
                idRaceIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_RACE_ID);
                pet.setIdRace(cursor.getInt(idRaceIndex));
            }
            if (cursor.getColumnIndex(COLUMN_RACE) != -1) {
                RaceIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_RACE);
                pet.setRace(cursor.getString(RaceIndex));
            }
            if (cursor.getColumnIndex(COLUMN_PET_SEXO) != -1) {
                sexoIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_PET_SEXO);
                pet.setSexo(cursor.getString(sexoIndex));
            }
            /*if (cursor.getColumnIndex(COLUMN_PET_SEXO) != -1) {
                sexoIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_PET_SEXO);
                pet.setSexo(cursor.getString(sexoIndex));
            }*/
            if (cursor.getColumnIndex(COLUMN_ID_CUSTOMER) != -1) {
                idCustomerIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_ID_CUSTOMER);
                pet.setIdCustomer(cursor.getInt(idCustomerIndex));
            }
        }
        return pet;
    }

    @Override
    public List<Pet> fetchAllPet() {
        List<Pet> PetList = new ArrayList<Pet>();
        cursor = super.query(PET_TABLE , USER_COLUMNS, null,
                null, COLUMN_PET_ID);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Pet pet = cursorToEntity(cursor);
                PetList.add(pet);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return PetList;
    }

}
