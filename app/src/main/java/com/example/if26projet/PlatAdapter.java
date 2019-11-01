package com.example.if26projet;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PlatAdapter extends ArrayAdapter {
    ArrayList<Plat> plats;
    int resource;
    Context c;

    public PlatAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Plat> plats) {
        super(context, resource, plats);
        this.plats = plats;
        this.resource = resource;
        this.c = context;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) c).getLayoutInflater();
        View v = inflater.inflate(resource, parent, false);
        Plat plat = plats.get(position);

        TextView nom_tv = (TextView) v.findViewById(R.id.plat_nom);
        TextView prix_tv = (TextView) v.findViewById(R.id.plat_prix);
        TextView nombre_tv = (TextView) v.findViewById(R.id.plat_nombre);
        Button plus_bt = (Button) v.findViewById(R.id.plus_bt);
        Button moin_bt = (Button) v.findViewById(R.id.moin_bt);

        nom_tv.setText(plat.getNom());
        prix_tv.setText(String.valueOf(plat.getPrix()));
        nombre_tv.setText(plat.getNom());
        return v;
    }
}
