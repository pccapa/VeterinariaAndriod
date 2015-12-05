package pe.edu.upc.veterinaryapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.content.Intent;
import android.widget.AdapterView.OnItemClickListener;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upc.veterinaryapp.DataBase.Database;
import pe.edu.upc.veterinaryapp.adapter.spinner.SpinnerAdapterPet;
import pe.edu.upc.veterinaryapp.entities.Appointment;
import pe.edu.upc.veterinaryapp.entities.Pet;
import pe.edu.upc.veterinaryapp.adapter.listview.LVPrincipalAdapterCita;

public class ConsultarCitaActivity extends Fragment {

    private Spinner  spPet;
    private ListView  lv;
    private String[] listaCitas = { "Cita1", "Cita2", "Cita3"};
    public static final String TAG = ConsultarCitaActivity.class.getSimpleName();
    public static Database mDb;
    List<Appointment>  appList = new ArrayList<Appointment>();
    List<Pet>    petList    = new ArrayList<Pet>();
    Integer codDoctor,codPet,codCustomer,codAppType;
    ArrayList<String> mLstCita = new ArrayList<>();
    private LVPrincipalAdapterCita  mLVPrincipalAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_consultar_cita, container,
                false);

        Context context = inflater.getContext();

        mDb = new Database(context);
        try {
            mDb.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //List<Appointment> appList

        try {
            petList = Database.mPetDao.fetchAllPetbyIdCustumer(1);
            appList = Database.mAppointmentDao.fetchAllAppointmentPending();
            Log.i(TAG, "appList : " + appList.size());
        } catch (Exception e) {
            e.printStackTrace();
        }




        spPet = (Spinner) view.findViewById(R.id.spPet);
        SpinnerAdapterPet adapter2 = new SpinnerAdapterPet(getActivity(),android.R.layout.simple_spinner_item,petList);
        spPet.setAdapter(adapter2);
        spPet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Pet pet = (Pet) (parent.getItemAtPosition(position));
                Log.i(TAG, "getIdPet : " + pet.getIdPet());
                mLVPrincipalAdapter.clear();
                codPet = pet.getIdPet();
                appList = Database.mAppointmentDao.fetchAllAppointmentPending();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        for(int i=0;i<appList.size();i++) {
            mLstCita.add(appList.get(i).getDescripcionAppointment());
        }

        lv = (ListView) view.findViewById(R.id.listaCita);


        mLVPrincipalAdapter = new LVPrincipalAdapterCita(this.getActivity(), new ArrayList<Appointment>());


        ArrayAdapter adapter = new ArrayAdapter(this.getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, mLstCita);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {

                Fragment fragment = null;
                fragment = new DetalleCitaActivity();

                FragmentManager frgManager = getFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();

                /*Intent intent = new Intent(ConsultarCitaActivity.this, DetalleCitaActivity.class);
                startActivity(intent);*/
            }
        });
        return view;
    }
    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_cita);


        spPet = (Spinner) findViewById(R.id.spPet);
        String []opciones2={"FIFO","LUCHITA"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones2);
        spPet.setAdapter(adapter2);


        lv = (ListView) findViewById(R.id.listaCita);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, listaCitas);



        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {


                Intent intent = new Intent(ConsultarCitaActivity.this, DetalleCitaActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consultar_cita, menu);
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
