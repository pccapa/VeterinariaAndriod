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
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.SQLException;
import java.util.List;

import pe.edu.upc.veterinaryapp.DataBase.Database;
import pe.edu.upc.veterinaryapp.entities.Hairdresser;
import pe.edu.upc.veterinaryapp.entities.HairdresserService;
import pe.edu.upc.veterinaryapp.entities.Mobility;
import pe.edu.upc.veterinaryapp.entities.Pet;

public class DetallePeluqueriaActivity extends Fragment {
    private Spinner spMovilidad,spPet,spHora,spServicio;
private EditText txtCosto,txtFecha;

    private int codigoServicio=0;
    public static Database mDb;
    List<HairdresserService> hairdresserServiceList=null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_detalle_peluqueria, container,
                false);

        txtFecha = (EditText) view.findViewById(R.id.txtFecha);
        txtCosto = (EditText) view.findViewById(R.id.txtCosto);

        Bundle bundle = this.getArguments();
        codigoServicio= Integer.parseInt(bundle.get("codigoServicio").toString());
        System.out.println(bundle.get("codigoServicio").toString());

        mDb = new Database(getActivity());
        try {
            mDb.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        hairdresserServiceList= Database.mHairdresserServiceDao.fetchAllHairdresserService();
        HairdresserService item= new HairdresserService();
        for (HairdresserService hairdresserService: hairdresserServiceList  ){
            if(hairdresserService.getIdHairService() == codigoServicio   ){
                item = hairdresserService;
                break;
            }
        }

       /* Bundle data = new Bundle();
        data.putString("name",value);
Fragment fragment = new nameOfFragment();
fragment.setArguments(data);*/


        List<Hairdresser> hairdresserList=null;
        hairdresserList= Database.mHairdresserDao.fetchAllHairdresser();
        List<Pet> petList=null;
        petList= Database.mPetDao.fetchAllPet();
        List<Mobility> mobilityList=null;
        mobilityList= Database.mMobilityDao.fetchAllMobility();


        spPet = (Spinner) view.findViewById(R.id.spPet);
        MySpinnerAdapterPet adapter2 = new MySpinnerAdapterPet(getActivity(),android.R.layout.simple_spinner_item ,petList );
        spPet.setAdapter(adapter2);

        spMovilidad = (Spinner) view.findViewById(R.id.spMovilidad);
        MySpinnerAdapterMobility adapter1 = new MySpinnerAdapterMobility(getActivity(),android.R.layout.simple_spinner_item,mobilityList);
        spMovilidad.setAdapter(adapter1);

        spServicio = (Spinner) view.findViewById(R.id.spServicio);
        MySpinnerAdapterHairDresser adapter3 = new MySpinnerAdapterHairDresser(getActivity(),android.R.layout.simple_spinner_item,hairdresserList);
        spServicio.setAdapter(adapter3);

        spHora = (Spinner) view.findViewById(R.id.spHora);
        String []opciones4={"11:00","12:00","13:00","14:00","15:00","16:00"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item, opciones4);
        spHora.setAdapter(adapter4);

        txtFecha.setText(item.getDateAppointment());
        txtCosto.setText(item.getHourAppointment());
        for (int i=0;i<adapter4.getCount();i++){
            if (adapter4.getItem(i).equals(item.getHourAppointment())   ){
                spHora.setSelection(i);
                break;
            }
        }


        for (int i=0;i<adapter3.getCount();i++){
            if (adapter3.getItem(i).getIdHairdresser() == item.getIdHairdresser()    ){
                spServicio.setSelection(i);
                break;
            }
        }
        for (int i=0;i<adapter2.getCount();i++){
            if (adapter2.getItem(i).getIdPet() == item.getIdPet()    ){
                spPet.setSelection(i);
                break;
            }
        }
        for (int i=0;i<adapter1.getCount();i++){
            if (adapter1.getItem(i).getIdMobility() == item.getIdMobility()    ){
                spMovilidad.setSelection(i);
                break;
            }
        }


        return view;
    }

    /*
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
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_cancelar) {

            Context context =getActivity().getApplicationContext();
            Toast.makeText(context, "Servicio Cancelado: ", Toast.LENGTH_SHORT).show();

            Fragment fragment = null;
            fragment = new ServicioActivity();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();

            return true;
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_update) {

            Context context = getActivity().getApplicationContext();
            Toast.makeText(context, "Servicio Actualizado: ", Toast.LENGTH_SHORT).show();

            Fragment fragment = null;
            fragment = new ServicioActivity();

            FragmentManager frgManager = getFragmentManager();
            frgManager.beginTransaction().replace(R.id.content_frame, fragment)
                    .commit();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}


