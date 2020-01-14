package com.example.if26projet.ui.dashboard;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.if26projet.R;

import java.util.List;

public class ListAdapter extends ArrayAdapter {

    List<String> stringList;
    int resource;
    Context c;

    public ListAdapter(Context context, int resource, List<String> objects){
        super(context, resource, objects);
        this.c = context;
        this.resource = resource;
        this.stringList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) c).getLayoutInflater();
        View v = inflater.inflate(resource, parent, false);
        String sigle = stringList.get(position);
        TextView tv = (TextView) v.findViewById(R.id.sigle_tv);
        tv.setText(sigle);
        return v;
    }
}
