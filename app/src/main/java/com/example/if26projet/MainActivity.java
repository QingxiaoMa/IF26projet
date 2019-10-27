package com.example.if26projet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Plat> plats = new ArrayList<Plat>();
        PlatAdapter adapter = new PlatAdapter(
                this,
                R.layout.plat,
                plats
        );
        ListView lv = (ListView) findViewById(R.id.menu_lv);
        lv.setAdapter(adapter);
    }
}
