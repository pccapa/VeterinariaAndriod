package pe.edu.upc.veterinaryapp.entities;

/**
 * Created by Angelica on 08/11/2015.
 */

import android.os.Parcel;
import android.os.Parcelable;

public class Usuario implements Parcelable {

    private int codUsuario;
    private String passowrd;


    public int getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(int codUsuario) {
        this.codUsuario = codUsuario;
    }



    public String getPassowrd() {
        return passowrd;
    }

    public void setPassowrd(String passowrd) {
        this.passowrd = passowrd;
    }




    protected Usuario(Parcel in) {
        codUsuario = in.readInt();

        passowrd = in.readString();

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(codUsuario);

        dest.writeString(passowrd);

    }

    @SuppressWarnings("unused")
    public static final Creator<Usuario> CREATOR = new Creator<Usuario>() {
        @Override
        public Usuario createFromParcel(Parcel in) {
            return new Usuario(in);
        }

        @Override
        public Usuario[] newArray(int size) {
            return new Usuario[size];
        }
    };
}