package pe.edu.upc.veterinaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    public final static String ARG_NOMBRE = "arg_nombre";
    public final static String ARG_APELLIDO = "arg_apellido";


    private Button btMenu1,btMenu2,btMenu3;
    private TextView txtWelcome;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        txtWelcome = (TextView) findViewById(R.id.txtWelcome);

        String nombre = getIntent().getStringExtra("NOMBRES");
        String apellidos = getIntent().getStringExtra("APELLIDOS");

        txtWelcome.setText("BIENVENIDO  " + nombre + " " + apellidos);

        btMenu1 = (Button) findViewById(R.id.btMenu1);

        btMenu1.setOnClickListener(btMenu1OnClickListener);

        btMenu2 = (Button) findViewById(R.id.btMenu2);

        btMenu2.setOnClickListener(btMenu2OnClickListener);

        btMenu3 = (Button) findViewById(R.id.btMenu3);

        btMenu3.setOnClickListener(btMenu3OnClickListener);

    }

     //CITAS
    View.OnClickListener btMenu1OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MenuActivity.this, CitaActivity.class);

            startActivity(intent);
        }
    };

    //SERVICIOS
    View.OnClickListener btMenu2OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(MenuActivity.this, ServicioActivity.class);

            startActivity(intent);

        }
    };

    //MI MASCOTA
    View.OnClickListener btMenu3OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {


            Intent intent = new Intent(MenuActivity.this, MascotaActivity.class);

            startActivity(intent);
        }
    };


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
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
