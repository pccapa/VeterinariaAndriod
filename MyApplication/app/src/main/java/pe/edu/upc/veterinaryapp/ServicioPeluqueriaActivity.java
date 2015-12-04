package pe.edu.upc.veterinaryapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.DateTimeKeyListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import pe.edu.upc.veterinaryapp.DataBase.Database;
import pe.edu.upc.veterinaryapp.entities.Hairdresser;
import pe.edu.upc.veterinaryapp.entities.HairdresserService;
import pe.edu.upc.veterinaryapp.entities.Mobility;
import pe.edu.upc.veterinaryapp.entities.Pet;

public class ServicioPeluqueriaActivity extends Fragment {

    private Spinner spMovilidad,spPet,spHora,spServicio;
private TextView viewHora;
    private Button btGrabar;
    public static Database mDb;
    List<HairdresserService> hairdresserServiceList=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_servicio_peluqueria, container,
                false);
        viewHora = (TextView) view.findViewById(R.id.textView6);

        mDb = new Database(getActivity());
        try {
            mDb.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Hairdresser > hairdresserList=null;
        hairdresserList= Database.mHairdresserDao.fetchAllHairdresser();
        List<Pet > petList=null;
        petList= Database.mPetDao.fetchAllPet();
        List<Mobility > mobilityList=null;
        mobilityList= Database.mMobilityDao.fetchAllMobility();
        hairdresserServiceList= Database.mHairdresserServiceDao.fetchAllHairdresserService();



        spPet = (Spinner) view.findViewById(R.id.spPet);
        MySpinnerAdapterPet adapter2 = new MySpinnerAdapterPet(getActivity(),android.R.layout.simple_spinner_item ,petList );
        spPet.setAdapter(adapter2);


        spMovilidad = (Spinner) view.findViewById(R.id.spMovilidad);
        MySpinnerAdapterMobility adapter1 = new MySpinnerAdapterMobility(getActivity(),android.R.layout.simple_spinner_item,mobilityList);
        spMovilidad.setAdapter(adapter1);
        spMovilidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Mobility mobilidad= (Mobility) (parent.getItemAtPosition(position));
                if( mobilidad.getDescripcion()=="NINGUNO" ){
                    spHora.setVisibility(View.GONE);
                    viewHora.setVisibility(View.GONE);
                }
                else{
                    spHora.setVisibility(View.VISIBLE);
                    viewHora.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        spServicio = (Spinner) view.findViewById(R.id.spServicio);
        MySpinnerAdapterHairDresser adapter3 = new MySpinnerAdapterHairDresser(getActivity(),android.R.layout.simple_spinner_item,hairdresserList);
        spServicio.setAdapter(adapter3);

        spHora = (Spinner) view.findViewById(R.id.spHora);
        String []opciones4={"11:00","12:00","13:00","14:00","15:00","16:00"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, opciones4);
        spHora.setAdapter(adapter4);

        btGrabar = (Button) view.findViewById(R.id.btGrabar);
        btGrabar.setOnClickListener(btGrabarOnClickListener);

        return view;
    }



    View.OnClickListener btGrabarOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            //hairdresserServiceList
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            int contar=0;

            ////primera validacion
            for ( HairdresserService lista:  hairdresserServiceList ){
                Date fechaToday = new Date();
                fechaToday.setHours(0);
                fechaToday.setMinutes(0);
                fechaToday.setSeconds(0);

                Date fechaServicio=null;
                try {
                    fechaServicio =dateFormat.parse(lista.getDateAppointment());
                }
                catch (ParseException ex){ System.out.println(ex.getMessage()); }

                System.out.println(fechaToday.getDate());
                System.out.println(fechaServicio.getDate());

                if(fechaToday.equals(fechaServicio) || fechaToday.after(fechaServicio) ){
                    contar=1;
                    break;
                }
            }
            if (contar ==1 ){
                Toast.makeText(getActivity().getApplicationContext(), "El registro de servicio se hace con un día de anticipación.", Toast.LENGTH_SHORT).show();
                return;
            }

            ////segunda  validacion
            for ( HairdresserService lista:  hairdresserServiceList ){
                if(lista.getIdPet() ==(( Pet ) spPet.getSelectedItem()).getIdPet()  ){
                    contar=1;
                    break;
                }
            }
            if (contar ==1 ){
                Toast.makeText(getActivity().getApplicationContext(), "Ya solicitó servicio de peluquería  para " + (( Pet ) spPet.getSelectedItem()).getIdPet()  +". El estado de servicio estará pendiente de atención hasta la fecha de servicio de atención.", Toast.LENGTH_SHORT).show();
                return;
            }

            double costo=0;

            if(((Mobility)spMovilidad.getSelectedItem()).getDescripcion() != "NINGUNO"   )
                costo = Double.parseDouble(spHora.getSelectedItem().toString());

            Toast.makeText(getActivity().getApplicationContext(), "Grabación Exitosa, Costo Total :S/" +String.valueOf(costo) , Toast.LENGTH_SHORT).show();


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


 class MySpinnerAdapterPet extends ArrayAdapter<Pet>{

    private Context context;
    private List<Pet> myObjs;

    public MySpinnerAdapterPet(Context context, int textViewResourceId,
                            List<Pet> myObjs) {
        super(context, textViewResourceId, myObjs);
        this.context = context;
        this.myObjs = myObjs;
    }

    public int getCount(){
        return myObjs.size();
    }
    public Pet getItem(int position){
        return myObjs.get(position) ;
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs.get(position).getName());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs.get(position).getName());
        return label;
    }
}


class MySpinnerAdapterMobility extends ArrayAdapter<Mobility>{

    private Context context;
    private List<Mobility> myObjs;

    public MySpinnerAdapterMobility(Context context, int textViewResourceId,
                               List<Mobility> myObjs) {
        super(context, textViewResourceId, myObjs);
        this.context = context;
        this.myObjs = myObjs;
    }

    public int getCount(){
        return myObjs.size();
    }
    public Mobility getItem(int position){
        return myObjs.get(position) ;
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs.get(position).getDescripcion());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs.get(position).getDescripcion());
        return label;
    }
}

class MySpinnerAdapterHairDresser extends ArrayAdapter<Hairdresser>{

    private Context context;
    private List<Hairdresser> myObjs;

    public MySpinnerAdapterHairDresser(Context context, int textViewResourceId,
                                    List<Hairdresser> myObjs) {
        super(context, textViewResourceId, myObjs);
        this.context = context;
        this.myObjs = myObjs;
    }

    public int getCount(){
        return myObjs.size();
    }
    public Hairdresser getItem(int position){
        return myObjs.get(position) ;
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs.get(position).getDescripcion());
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs.get(position).getDescripcion());
        return label;
    }
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