package pe.edu.upc.veterinaryapp;

import android.view.View;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends  AppCompatActivity {


    private TextInputLayout tilUser, tilPassword;
    private EditText etUser, etPassword;
    private Button btEnter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



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
                Intent intent = new Intent(LoginActivity.this, NavegacionActivity.class);
                intent.putExtra("NOMBRES", etUser.getText().toString() );
                        intent.putExtra("APELLIDOS", etPassword.getText().toString());
                startActivity(intent);
                finish();
            }
        }
    };

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
