package pe.edu.upc.veterinaryapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ServicioActivity extends AppCompatActivity {
    private Button btMenu1,btMenu2,btMenu3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio);

        btMenu1 = (Button) findViewById(R.id.btMenu1);

        btMenu1.setOnClickListener(btMenu1OnClickListener);

        btMenu2 = (Button) findViewById(R.id.btMenu2);

        btMenu2.setOnClickListener(btMenu2OnClickListener);

        btMenu3 = (Button) findViewById(R.id.btMenu3);

        btMenu3.setOnClickListener(btMenu3OnClickListener);
    }

    //PELUQUERIA
    View.OnClickListener btMenu1OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(ServicioActivity.this, ServicioPeluqueriaActivity.class);

            startActivity(intent);
        }
    };

    //COMIDA
    View.OnClickListener btMenu2OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Intent intent = new Intent(ServicioActivity.this, ServicioActivity.class);

            startActivity(intent);

        }
    };

    //MI MASCOTA
    View.OnClickListener btMenu3OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {


            Intent intent = new Intent(ServicioActivity.this, ConsultarServicio.class);

            startActivity(intent);
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_servicio, menu);
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
