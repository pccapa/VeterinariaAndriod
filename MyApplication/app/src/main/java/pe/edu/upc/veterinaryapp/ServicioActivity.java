package pe.edu.upc.veterinaryapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ServicioActivity extends Fragment {
    private Button btMenu1,btMenu2,btMenu3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_servicio, container,
                false);

        btMenu1 = (Button) view.findViewById(R.id.btMenu1);
        btMenu1.setOnClickListener(btMenu1OnClickListener);

        btMenu2 = (Button) view.findViewById(R.id.btMenu2);
        btMenu2.setOnClickListener(btMenu2OnClickListener);

        btMenu3 = (Button) view.findViewById(R.id.btMenu3);
        btMenu3.setOnClickListener(btMenu3OnClickListener);

        return view;
    }

    /*
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
    }*/

    //PELUQUERIA
    View.OnClickListener btMenu1OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Fragment fragment = null;
            fragment = new ServicioPeluqueriaActivity();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();

        }
    };

    //COMIDA
    View.OnClickListener btMenu2OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Fragment fragment = null;
            fragment = new ServicioComidaActivity();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();

        }
    };

    //Consultar servicio
    View.OnClickListener btMenu3OnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Fragment fragment = null;
            fragment = new ConsultarServicio();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();
        }
    };
/*
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
    }*/
}
