package pe.edu.upc.veterinaryapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class DetallePeluqueriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_peluqueria);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle_peluqueria, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_cancelar) {

            Context context = getApplicationContext();
            Toast.makeText(context, "Servicio Cancelado: ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DetallePeluqueriaActivity.this,MenuActivity.class);

            startActivity(intent);
            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_update) {

            Context context = getApplicationContext();
            Toast.makeText(context, "Servicio Actualizado: ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DetallePeluqueriaActivity.this,MenuActivity.class);

            startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
