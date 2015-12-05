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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import pe.edu.upc.veterinaryapp.DataBase.Database;
import pe.edu.upc.veterinaryapp.entities.Hairdresser;
import pe.edu.upc.veterinaryapp.entities.HairdresserService;
import pe.edu.upc.veterinaryapp.entities.Mobility;
import pe.edu.upc.veterinaryapp.entities.Pet;

public class ConsultarServicio extends Fragment {

    private Spinner spPet;
    private ListView lv;
    public static Database mDb;
    private String[] listaCitas = { "COMIDA", "PELUQUERIA", "Cita3"};
    List<HairdresserService> hairdresserServiceList=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_consultar_servicio, container,
                false);

        mDb = new Database(getActivity());
        try {
            mDb.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Pet> petList=null;
        petList= Database.mPetDao.fetchAllPet();
        hairdresserServiceList= Database.mHairdresserServiceDao.fetchAllHairdresserService();

        spPet = (Spinner) view.findViewById(R.id.spPet);
        MySpinnerAdapterPet adapter2 = new MySpinnerAdapterPet(getActivity(),android.R.layout.simple_spinner_item ,petList );
        spPet.setAdapter(adapter2);
        spPet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        lv = (ListView) view.findViewById(R.id.listaCita);
        MySpinnerAdapterHairDresserService adapter = new MySpinnerAdapterHairDresserService(getActivity(), android.R.layout.simple_list_item_1, hairdresserServiceList);
        lv.setAdapter(adapter);
        lv.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //String tipo = (String) (parent.getItemAtPosition(position));
                //Pet pet=((Pet) spPet.getSelectedItem());

                  Fragment fragment = null;
                Bundle args = new Bundle();
                fragment = new DetallePeluqueriaActivity();
                args.putString("codigoServicio" , "1");


                fragment.setArguments(args);
                FragmentManager frgManager = getFragmentManager();
                frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                        .commit();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        return view;
    }

    /*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_servicio);

        spPet = (Spinner) findViewById(R.id.spPet);
        String []opciones2={"FIFO","LUCHITA"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, opciones2);
        spPet.setAdapter(adapter2);


        lv = (ListView) findViewById(R.id.listaCita);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, listaCitas);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {


                Intent intent = new Intent(ConsultarServicio.this, DetallePeluqueriaActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_consultar_servicio, menu);
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




class MySpinnerAdapterHairDresserService extends ArrayAdapter<HairdresserService>{

    private Context context;
    private List<HairdresserService> myObjs;

    public MySpinnerAdapterHairDresserService(Context context, int textViewResourceId,
                                       List<HairdresserService> myObjs) {
        super(context, textViewResourceId, myObjs);
        this.context = context;
        this.myObjs = myObjs;
    }

    public int getCount(){
        return myObjs.size();
    }
    public HairdresserService getItem(int position){
        return myObjs.get(position) ;
    }

    public long getItemId(int position){
        return position;
    }

    private class ViewHolder {
        TextView codigo;
        TextView nombre1;
        TextView nombre2;

    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        //LayoutInflater inflater =  activity.getLayoutInflater();

        if (convertView == null)
        {
            holder = new ViewHolder();
            holder.codigo.setText(myObjs.get(position).getIdHairService());
            holder.nombre1.setText(myObjs.get(position).getStateAppointment());
            holder.nombre2.setText(myObjs.get(position).getDateAppointment());
            convertView.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) convertView.getTag();
        }


        return convertView;
    }
    /*@Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs.get(position).getDescripcion());
        return label;
    }*/
}