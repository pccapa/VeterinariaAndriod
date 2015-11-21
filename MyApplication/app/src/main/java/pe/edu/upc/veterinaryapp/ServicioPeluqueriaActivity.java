package pe.edu.upc.veterinaryapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ServicioPeluqueriaActivity extends AppCompatActivity {

    private Spinner spMovilidad,spPet,spHora,spServicio;

    private Button btGrabar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servicio_peluqueria);




        spPet = (Spinner) findViewById(R.id.spPet);
        String []opciones2={"FIFO","LUCHITA"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones2);
        spPet.setAdapter(adapter2);

        spMovilidad = (Spinner) findViewById(R.id.spMovilidad);
        String []opciones1={"RECOJO Y ENVIO","ENVIO"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones1);
        spMovilidad.setAdapter(adapter1);

        spServicio = (Spinner) findViewById(R.id.spServicio);
        String []opciones3={"BAÑO Y CORTE","CORTE"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones3);
        spServicio.setAdapter(adapter3);

        spHora = (Spinner) findViewById(R.id.spHora);
        String []opciones4={"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones4);
        spHora.setAdapter(adapter4);

        btGrabar = (Button) findViewById(R.id.btGrabar);

        btGrabar.setOnClickListener(btGrabarOnClickListener);
    }

    View.OnClickListener btGrabarOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Context context = getApplicationContext();
            Toast.makeText(context, "Grabacion Exitosa: ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ServicioPeluqueriaActivity.this, MenuActivity.class);
            startActivity(intent);

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_servicio_peluqueria, menu);
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
