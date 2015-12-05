package pe.edu.upc.veterinaryapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import pe.edu.upc.veterinaryapp.R;
import android.content.Intent;
import android.widget.Toast;

public class DetalleCitaActivity extends Fragment {

    private Spinner spDoctor,spPet,spType,spHora;
    private Button btModificarCita,btEliminarCita;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_detalle_cita , container,
                false);

        spDoctor = (Spinner) view.findViewById(R.id.spDoctor);
        String []opciones1={"ANA COTRINA","GUSTAVO SALAZAR","RODRIGO  MEDINA"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, opciones1);
        spDoctor.setAdapter(adapter1);

        spPet = (Spinner) view.findViewById(R.id.spPet);
        String []opciones2={"PACO","LUCHITA"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, opciones2);
        spPet.setAdapter(adapter2);

        spType = (Spinner) view.findViewById(R.id.spType);
        String []opciones3={"DOMICILIO","CLINICA"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, opciones3);
        spType.setAdapter(adapter3);

        spHora = (Spinner) view.findViewById(R.id.spHora);
        String []opciones4={"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, opciones4);
        spHora.setAdapter(adapter4);

        btModificarCita = (Button) view.findViewById(R.id.btModificarCita);
        btEliminarCita = (Button) view.findViewById(R.id.btEliminarCita);
        btModificarCita.setOnClickListener(btModificarCitaCitaOnClickListener);
        btEliminarCita.setOnClickListener(btEliminarCitaOnClickListener);
        return view;
    }


    View.OnClickListener btModificarCitaCitaOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Toast.makeText(getActivity().getApplicationContext(),"Reserva Actualizada ", Toast.LENGTH_SHORT).show();
            Fragment fragment = null;
            fragment = new CitaActivity();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
           // Intent intent = new Intent(getActivity().this, MenuActivity.class);
            //startActivityForResult(intent, REQUEST_CODE);
        }
    };


    View.OnClickListener btEliminarCitaOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Toast.makeText(getActivity().getApplicationContext(),"Reserva Eliminada ", Toast.LENGTH_SHORT).show();
            Fragment fragment = null;
            fragment = new CitaActivity();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
            // Intent intent = new Intent(getActivity().this, MenuActivity.class);
            //startActivityForResult(intent, REQUEST_CODE);
        }
    };

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cita);

        spDoctor = (Spinner) findViewById(R.id.spDoctor);
        String []opciones1={"ANA COTRINA","GUSTAVO SALAZAR","RODRIGO  MEDINA"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones1);
        spDoctor.setAdapter(adapter1);

        spPet = (Spinner) findViewById(R.id.spPet);
        String []opciones2={"FIFO","LUCHITA"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones2);
        spPet.setAdapter(adapter2);

        spType = (Spinner) findViewById(R.id.spType);
        String []opciones3={"DOMICILIO","CLINICA"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones3);
        spType.setAdapter(adapter3);

        spHora = (Spinner) findViewById(R.id.spHora);
        String []opciones4={"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones4);
        spHora.setAdapter(adapter4);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detalle_cita, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_cancelar) {

            Context context = getActivity().getApplicationContext();
            Toast.makeText(context, "Reserva Cancelada: ", Toast.LENGTH_SHORT).show();

            Fragment fragment = null;
            fragment = new CitaActivity();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();
            return true;
        }


        //noinspection SimplifiableIfStatement
        if (id == R.id.action_update) {

            Context context = getActivity().getApplicationContext();
            Toast.makeText(context, "Reserva Actualizada: ", Toast.LENGTH_SHORT).show();

            Fragment fragment = null;
            fragment = new CitaActivity();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();
            //Intent intent = new Intent(DetalleCitaActivity.this,MenuActivity.class);

            //startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
