package pe.edu.upc.veterinaryapp.DBDAO;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.List;

import pe.edu.upc.veterinaryapp.DBProvider.DbContentProvider;
import pe.edu.upc.veterinaryapp.DBSchema.ICustomerSchema;
import pe.edu.upc.veterinaryapp.entities.Customer;
import pe.edu.upc.veterinaryapp.entities.User;


public class CustomerDao  extends DbContentProvider implements ICustomerSchema, ICustomerDao {
    private Cursor cursor;
    private ContentValues initialValues;

    private ContentValues getContentValue() {
        return initialValues;
    }

    private void setContentValue(Customer customer) {
        initialValues = new ContentValues();
        initialValues.put(COLUMN_ID, customer.idCustomer);
        initialValues.put(COLUMN_CUSTOMER_NAME, customer.nombres);
        initialValues.put(COLUMN_APELLIDO_PATERNO, customer.apellidoPaterno);
        initialValues.put(COLUMN_APELLIDO_MATERNO, customer.apellidoMaterno);
        initialValues.put(COLUMN_DNI, customer.dni);
        initialValues.put(COLUMN_TELEFONO_FIJO, customer.telefonoFijo);
        initialValues.put(COLUMN_TELEFONO_MOVIL, customer.telefonoMovil);



    }
    @Override
    protected Customer cursorToEntity(Cursor cursor) {
        return null;
    }

    public CustomerDao(SQLiteDatabase db) {
        super(db);
    }



    @Override
    public List<Customer> fetchAllCustomers() {
        return null;
    }

    @Override
    public boolean addCustomer(Customer customer) {
        // set values
        setContentValue(customer);
        try {
            return super.insert(CUSTOMER_TABLE, getContentValue()) > 0;
        } catch (SQLiteConstraintException ex){
            Log.w("Database", ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean addCustomers(List<Customer> customer) {
        return false;
    }

    @Override
    public boolean deleteAllCustomers() {
        return false;
    }

    @Override
    public Customer fetchCustomerById(int idCustomer) {
        final String selectionArgs[] = { String.valueOf(idCustomer) };
        final String selection = COLUMN_ID + " = ?";
        Customer customer = new Customer();
        cursor = super.query(CUSTOMER_TABLE, CUSTOMER_COLUMNS, selection,
                selectionArgs, COLUMN_ID);
        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                customer = cursorToEntity(cursor);
                cursor.moveToNext();
            }
            cursor.close();
        }

        return customer;
    }
}
