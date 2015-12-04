package pe.edu.upc.veterinaryapp.adapter.spinner;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import pe.edu.upc.veterinaryapp.entities.Appointment_Type;

/**
 * Created by Angelica on 04/12/2015.
 */
public class SpinnerAdapterAppointmentType extends ArrayAdapter<Appointment_Type> {


    private Context context;
    private List<Appointment_Type> myObjs;

    public SpinnerAdapterAppointmentType(Context context, int textViewResourceId,
                                         List<Appointment_Type> myObjs) {
        super(context, textViewResourceId, myObjs);
        this.context = context;
        this.myObjs = myObjs;
    }

    public int getCount(){
        return myObjs.size();
    }
    public Appointment_Type getItem(int position){
        return myObjs.get(position) ;
    }

    public long getItemId(int position){
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs.get(position).descripcion);
        return label;
    }

    @Override
    public View getDropDownView(int position, View convertView,
                                ViewGroup parent) {
        TextView label = new TextView(context);
        label.setText(myObjs.get(position).descripcion);
        return label;
    }


}
