package pe.edu.upc.veterinaryapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;
import android.view.Gravity;
import android.content.Context;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.veterinaryapp.DataBase.Database;
import pe.edu.upc.veterinaryapp.entities.Doctor;
import pe.edu.upc.veterinaryapp.adapter.spinner.SpinnerAdapterDoctor;
import pe.edu.upc.veterinaryapp.entities.Pet;
import pe.edu.upc.veterinaryapp.adapter.spinner.SpinnerAdapterPet;


public class ReservarCitaActivity extends Fragment {

    private Spinner spDoctor,spPet,spType,spHora;
    private Button btGrabar;
    List<Doctor> doctorList = new ArrayList<Doctor>();
    List<Pet> petList = new ArrayList<Pet>();

    public static final String TAG = ReservarCitaActivity.class.getSimpleName();
    public static Database mDb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Context context = inflater.getContext();
        mDb = new Database(context);



        View view = inflater.inflate(R.layout.activity_reservar_cita , container,
                false);


        try {
          int var =1;
           doctorList = Database.mDoctorDao.fetchAllDoctor();
            petList = Database.mPetDao.fetchAllPetbyIdCustumer(1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Log.i(TAG, "doctorList : " + doctorList.size());




        spDoctor = (Spinner) view.findViewById(R.id.spDoctor);
        SpinnerAdapterDoctor adapter1 = new SpinnerAdapterDoctor(getActivity(),android.R.layout.simple_spinner_item,doctorList);
        spDoctor.setAdapter(adapter1);



       /* String []opciones1={"ANA COTRINA","GUSTAVO SALAZAR","RODRIGO  MEDINA"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, opciones1);
        spDoctor.setAdapter(adapter1);*/

        spPet = (Spinner) view.findViewById(R.id.spPet);
        SpinnerAdapterPet adapter2 = new SpinnerAdapterPet(getActivity(),android.R.layout.simple_spinner_item,petList);
        spPet.setAdapter(adapter2);

       /* String []opciones2={"FIFO","LUCHITA"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, opciones2);
        spPet.setAdapter(adapter2);*/



        spType = (Spinner) view.findViewById(R.id.spType);
        String []opciones3={"DOMICILIO","CLINICA"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, opciones3);
        spType.setAdapter(adapter3);

        spHora = (Spinner) view.findViewById(R.id.spHora);
        String []opciones4={"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item, opciones4);
        spHora.setAdapter(adapter4);

        btGrabar = (Button) view.findViewById(R.id.btGrabar);

        btGrabar.setOnClickListener(btGrabarOnClickListener);

        return view;
    }

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar_cita);
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

        btGrabar = (Button) findViewById(R.id.btGrabar);

        btGrabar.setOnClickListener(btGrabarOnClickListener);

    }
*/

    View.OnClickListener btGrabarOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Context context = getActivity().getApplicationContext();
            Toast.makeText(context , "Reserva Exitosa: ", Toast.LENGTH_SHORT).show();

            Fragment fragment = null;
            fragment = new CitaActivity();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();
           /* Intent intent = new Intent(ReservarCitaActivity.this, MenuActivity.class);
            startActivity(intent);*/

        }
    };

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_reservar_cita, menu);
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
