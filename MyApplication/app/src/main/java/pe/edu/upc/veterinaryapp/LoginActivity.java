package pe.edu.upc.veterinaryapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.ArrayList;

import pe.edu.upc.veterinaryapp.entities.User;

import pe.edu.upc.veterinaryapp.entities.Customer;

import  android.util.Log;
import pe.edu.upc.veterinaryapp.DataBase.Database;

public class LoginActivity extends  AppCompatActivity {


    private TextInputLayout tilUser, tilPassword;
    private EditText etUser, etPassword;
    private Button btEnter;


    private ArrayList<Customer> mLstCustomer;

    public static final String TAG = LoginActivity.class.getSimpleName();
    public static Database mDb;
    User user = null;
    Customer customer = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mDb = new Database(this);
        try {
            mDb.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        mLstCustomer = new ArrayList<>();
        tilUser = (TextInputLayout) findViewById(R.id.tilUser);
        tilPassword = (TextInputLayout) findViewById(R.id.tilPassword);

        etUser = (EditText) findViewById(R.id.etUser);
        etPassword = (EditText) findViewById(R.id.etPassword);


        btEnter = (Button) findViewById(R.id.btEnter);
        btEnter.setOnClickListener(btEnterOnClickListener);




    }


    View.OnClickListener btEnterOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            boolean isComplete = true;

            tilUser.setErrorEnabled(false);
            tilPassword.setErrorEnabled(false);


            if (etUser.getText().toString().trim().length() <= 0) {
                tilUser.setErrorEnabled(true);
                tilUser.setError("Ingrese usuario");
                isComplete = false;
            }

            if (etPassword.getText().toString().trim().length() <= 0) {
                tilPassword.setErrorEnabled(true);
                tilPassword.setError("Ingrese password");
                isComplete = false;
            }


            if (isComplete) {

                boolean existe = false;

                try {
                    user = Database.mUserDao.findUser( etUser.getText().toString(),etPassword.getText().toString()) ;
                    customer = Database.mCustomerDao.fetchCustomerById(user.getIdCustomer());
                    existe = true;
                } catch (Exception e) {
                    e.printStackTrace();
                }


                if(existe){
                    Log.i(TAG, "Existe");
//                    Log.i(TAG,   customer.getNombres().toString() + " " + customer.getApellidoMaterno());
                    //  intent.putExtra("NOMBRES", customer.getNombres());
                    //   intent.putExtra("APELLIDOS", customer.apellidoPaterno + " " + customer.apellidoMaterno);

                    Intent intent = new Intent(LoginActivity.this, NavegacionActivity.class);
                  //   intent.putExtra("ID", customer.getIdCustomer().);
                   //  intent.putExtra("NOMBRES", customer.getNombres());
                  //   intent.putExtra("APELLIDOS", customer.apellidoPaterno + " " + customer.apellidoMaterno);

                    startActivity(intent);
                    finish();
                }

                else {

                    Log.i(TAG, "No Existe");
                    etUser.setText("");
                    etPassword.setText("");
                    Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_LONG).show();

                }


            }
        }
    };




/*
    private boolean consultarUsuario(String nomUser,String password) {

        boolean valor;
        Cursor fila = null;
        try {
              fila = db.rawQuery("select password  from User where password=" + password, null);
              if (fila.moveToFirst())
                  valor = true;

             else
                  valor = false;

        } catch (Exception ex) {
                ex.printStackTrace();
                valor = false;
        } finally {
                if (fila != null)
                    fila.close();

        }

                return  valor;

    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
