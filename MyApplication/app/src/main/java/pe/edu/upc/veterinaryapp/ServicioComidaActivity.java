package pe.edu.upc.veterinaryapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.sql.SQLException;
import java.util.List;

import pe.edu.upc.veterinaryapp.DataBase.Database;
import pe.edu.upc.veterinaryapp.adapter.spinner.SpinnerAdapterFood;
import pe.edu.upc.veterinaryapp.entities.Food;
import pe.edu.upc.veterinaryapp.entities.Pet;

public class ServicioComidaActivity extends Fragment {
    private Spinner spCantidad, spPet, spHora, spProducto;
    private TextView viewHora, viewCosto;
    private Button btGrabar;

    private EditText txtFecha;


    public static Database mDb;
    //List<HairdresserService> hairdresserServiceList = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_servicio_comida, container,
                false);
        viewHora = (TextView) view.findViewById(R.id.textView6);
        txtFecha = (EditText) view.findViewById(R.id.txtFecha);
        viewCosto = (TextView) view.findViewById(R.id.viewCosto);




        mDb = new Database(getActivity());
        try {
            mDb.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        List<Food> foodList = null;
        foodList = Database.mFoodDao.fetchAllFood();

        List<Pet> petList = null;
        petList = Database.mPetDao.fetchAllPet();



        //hairdresserServiceList = Database.mHairdresserServiceDao.fetchAllHairdresserService();

        spCantidad = (Spinner) view.findViewById(R.id.spCantidad);
        String[] cantidades1 = {"1", "2", "3", "4", "5"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, cantidades1);
        spCantidad.setAdapter(adapter1);
        spCantidad.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Pet pet = (Pet) (parent.getItemAtPosition(position));
                Food food = ((Food) spProducto.getSelectedItem());
                String cantidades2 = (String) spCantidad.getSelectedItem();
                Integer cantidades3 = Integer.parseInt(cantidades2);

                viewCosto.setText(String.valueOf(food.getPrice() * cantidades3));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spPet = (Spinner) view.findViewById(R.id.spPet);
        MySpinnerAdapterPet adapter2 = new MySpinnerAdapterPet(getActivity(), android.R.layout.simple_spinner_item, petList);
        spPet.setAdapter(adapter2);



        spProducto = (Spinner) view.findViewById(R.id.spProducto);
        SpinnerAdapterFood adapter3 = new SpinnerAdapterFood(getActivity(), android.R.layout.simple_spinner_item, foodList);
        spProducto.setAdapter(adapter3);
        spProducto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Pet pet = (Pet) (parent.getItemAtPosition(position));
                Food food = ((Food) spProducto.getSelectedItem());
                String cantidades2 = (String) spCantidad.getSelectedItem();
                Integer cantidades3 = Integer.parseInt(cantidades2);

                viewCosto.setText(String.valueOf(food.getPrice() * cantidades3));

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spHora = (Spinner) view.findViewById(R.id.spHora);
        String[] opciones4 = {"11:00", "12:00", "13:00", "14:00", "15:00", "16:00"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, opciones4);
        spHora.setAdapter(adapter4);

        btGrabar = (Button) view.findViewById(R.id.btGrabar);


        return view;
    }



}