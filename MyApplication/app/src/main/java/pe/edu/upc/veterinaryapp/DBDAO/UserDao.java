package pe.edu.upc.veterinaryapp.DBDAO;

import pe.edu.upc.veterinaryapp.DBProvider.DbContentProvider;
import pe.edu.upc.veterinaryapp.DBSchema.IUserSchema;

import android.content.ContentValues;
import android.database.Cursor;
import  android.database.sqlite.SQLiteDatabase;
import  pe.edu.upc.veterinaryapp.entities.User;
import java.util.List;
import android.database.sqlite.SQLiteConstraintException;
import android.util.Log;
import java.util.ArrayList;
public class UserDao extends DbContentProvider implements IUserSchema, IUserDao {


    private Cursor cursor;
    private ContentValues initialValues;
    public UserDao(SQLiteDatabase db) {
        super(db);
    }
    @Override
    protected User cursorToEntity(Cursor cursor) {
        User user = new User();

        int idIndex;
        int userNameIndex;
        int passwordIndex;
        int idCustomer;

        if (cursor != null) {
            if (cursor.getColumnIndex(COLUMN_USER_ID) != -1) {
                idIndex = cursor.getColumnIndexOrThrow(COLUMN_USER_ID);
                user.idUser = cursor.getInt(idIndex);
            }
            if (cursor.getColumnIndex(COLUMN_USER_NAME) != -1) {
                userNameIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_USER_NAME);
                user.userName = cursor.getString(userNameIndex);
            }
            if (cursor.getColumnIndex(COLUMN_USER_PASSWORD) != -1) {
                passwordIndex = cursor.getColumnIndexOrThrow(
                        COLUMN_USER_PASSWORD);
                user.passowrd = cursor.getString(passwordIndex);
            }
            if (cursor.getColumnIndex(COLUMN_ID_CUSTOMER) != -1) {
                idCustomer = cursor.getColumnIndexOrThrow(COLUMN_ID_CUSTOMER);
                user.idCustomer = cursor.getInt(idCustomer);
            }

        }


        return  user;
    }

    @Override
    public User fetchUserById(int userId) {
        final String selectionArgs[] = { String.valueOf(userId) };
        final String selection = COLUMN_USER_ID + " = ?";
        User user = new User();
        cursor = super.query(USER_TABLE, USER_COLUMNS, selection,
                selectionArgs, COLUMN_USER_ID);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                user = cursorToEntity(cursor);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return user;
    }

    @Override
    public User findUser(String name, String password) {

      //  db.query(DB_TABLE, new String[] {KEY_ROWID,Source,Dest}, DestStn + "=" + t +" and "+Source + "=" +tt,null, null, null, null, null);
       // Cursor c = db.query("Usuarios", campos, "usuario=?", args, null, null, null);

        User user = new User();
        cursor = super.query(USER_TABLE, USER_COLUMNS,"user_name = " + "'" + name + "'" + " and  user_password =" + password,null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                user = cursorToEntity(cursor);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return user;
    }

    @Override
    public List<User> fetchAllUsers() {
        List<User> userList = new ArrayList<User>();
        cursor = super.query(USER_TABLE, USER_COLUMNS, null,
                null, COLUMN_USER_ID);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                User user = cursorToEntity(cursor);
                userList.add(user);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return userList;
    }

    private ContentValues getContentValue() {
        return initialValues;
    }

    private void setContentValue(User user) {
        initialValues = new ContentValues();
        initialValues.put(COLUMN_USER_ID, user.idUser);
        initialValues.put(COLUMN_USER_NAME, user.userName);
        initialValues.put(COLUMN_USER_PASSWORD, user.passowrd);
        initialValues.put(COLUMN_ID_CUSTOMER, user.idCustomer);
    }

    @Override
    public boolean addUser(User user) {
        // set values
        setContentValue(user);
        try {
            return super.insert(USER_TABLE, getContentValue()) > 0;
        } catch (SQLiteConstraintException ex){
            Log.w("Database", ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean addUsers(List<User> users) {
        return false;
    }

    @Override
    public boolean deleteAllUsers() {
        return false;
    }
}
