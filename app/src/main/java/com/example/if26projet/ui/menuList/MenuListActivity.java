package com.example.if26projet.ui.menuList;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.if26projet.Plat;
import com.example.if26projet.R;

import java.util.List;

public class MenuListActivity extends AppCompatActivity {


    private MenuListViewModel menuListViewModel;
    private RecyclerView recyclerView;
    private List<String> mStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_list_fragment);
        menuListViewModel = new ViewModelProvider(this).get(MenuListViewModel.class);
        ListView listView = (ListView)findViewById(R.id.list);

        //Intent intent = getIntent();
        //String categorie = intent.getStringExtra("categorie");

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment1,MenuListFragment.newInstance());

        menuListViewModel.getPlats().observe(this, new Observer<List<Plat>>() {
            @Override
            public void onChanged(@Nullable final List<Plat> plats) {
                Intent intent = getIntent();
                String categorie = intent.getStringExtra("categorie");
                List<String> nomPlats = null;
                for (Plat plat:plats){
                    if(plat.getCategorie().equals(categorie)){
                        nomPlats.add(plat.getNom());
                    }
                }
            }
        });


        getSupportFragmentManager().beginTransaction()
                .add(R.id.list, new MenuListFragment()).commit();

    }
}
