package pe.edu.upc.veterinaryapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
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
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import pe.edu.upc.veterinaryapp.DataBase.Database;
import pe.edu.upc.veterinaryapp.entities.Hairdresser;

public class ServicioPeluqueriaActivity extends Fragment {

    private Spinner spMovilidad,spPet,spHora,spServicio;

    private Button btGrabar;
    public static Database mDb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_servicio_peluqueria, container,
                false);

        mDb = new Database(getActivity());
        try {
            mDb.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Hairdresser > hairdresserList=null;
        hairdresserList= Database.mHairdresserDao.fetchAllHairdresser();


        spPet = (Spinner) view.findViewById(R.id.spPet);
        String []opciones2={"FIFO","LUCHITA"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, opciones2);
        spPet.setAdapter(adapter2);

        spMovilidad = (Spinner) view.findViewById(R.id.spMovilidad);
        String []opciones1={"RECOJO Y ENVIO","ENVIO"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, opciones1);
        spMovilidad.setAdapter(adapter1);

        spServicio = (Spinner) view.findViewById(R.id.spServicio);
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item);
        for (Hairdresser hairdresser :hairdresserList) {
            adapter3.add(hairdresser.getDescripcion());
        }
        spServicio.setAdapter(adapter3);

        spHora = (Spinner) view.findViewById(R.id.spHora);
        String []opciones4={"09:00","10:00","11:00","12:00","13:00","14:00","15:00","16:00","17:00","18:00","19:00","20:00"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, opciones4);
        spHora.setAdapter(adapter4);

        btGrabar = (Button) view.findViewById(R.id.btGrabar);

        btGrabar.setOnClickListener(btGrabarOnClickListener);

        return view;
    }


    /*
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
*/
    View.OnClickListener btGrabarOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {

            Context context =getActivity().getApplicationContext();
            Toast.makeText(context, "Grabacion Exitosa: ", Toast.LENGTH_SHORT).show();


            Fragment fragment = null;
            fragment = new ServicioActivity();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();
        }
    };
/*
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
    }*/
}
