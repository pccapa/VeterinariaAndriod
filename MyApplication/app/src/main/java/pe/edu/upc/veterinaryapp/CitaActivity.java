package pe.edu.upc.veterinaryapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class CitaActivity extends Fragment {

    private Button btReservaCita,btConsultarCita;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_cita, container,
                false);

        btReservaCita = (Button) view.findViewById(R.id.btReservaCita);
        btReservaCita.setOnClickListener(btReservaCitaOnClickListener);

        btConsultarCita = (Button) view.findViewById(R.id.btConsultarCita);
        btConsultarCita.setOnClickListener(btConsultarCitaOnClickListener);

        return view;
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);

        btReservaCita = (Button) findViewById(R.id.btReservaCita);
        btReservaCita.setOnClickListener(btReservaCitaOnClickListener);

        btConsultarCita = (Button) findViewById(R.id.btConsultarCita);
        btConsultarCita.setOnClickListener(btConsultarCitaOnClickListener);
    }*/


    //RESERVAR CITA
    View.OnClickListener btReservaCitaOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Fragment fragment = null;
            fragment = new ReservarCitaActivity();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();

            /*Intent intent = new Intent(CitaActivity.this, ReservarCitaActivity.class);

            startActivity(intent);*/
        }
    };

    //CONSULTAR CITAS
    View.OnClickListener btConsultarCitaOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Fragment fragment = null;
            fragment = new ConsultarCitaActivity();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();
           /* Intent intent = new Intent(CitaActivity.this, ConsultarCitaActivity.class);

            startActivity(intent);*/
        }
    };

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cita, menu);
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
    }*/
}
