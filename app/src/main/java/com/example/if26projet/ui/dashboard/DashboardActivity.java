package com.example.if26projet.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.if26projet.Commande;
import com.example.if26projet.R;
import com.example.if26projet.ui.home.HomeActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DashboardActivity extends AppCompatActivity {
    private DashboardViewModel dashboardViewModel;
    private List<Commande> listeCommande= new ArrayList<>();
    private List<String> liste= new ArrayList<>();
    private TextView text_dashboard;
    private String bienvenu="";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_dashboard);
        Intent intent = getIntent();
        bienvenu = intent.getStringExtra("nom");
        String prixFin = intent.getStringExtra("prixTo");
        text_dashboard = findViewById(R.id.text_dashboard);
        text_dashboard.setText("Bienvenue\t\t"+ bienvenu+"\t!");
        //dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        listeCommande.add(new Commande("salade",0,"EN_COURS",5.3));
        listeCommande.add(new Commande("jus d'orange",0,"ENVOYE",3.2));
        for(Commande c:listeCommande){
            liste.add("une commande de\t\t"+c.getPrixTotal()+"$\n"+c.getStatut());
        }
        if(prixFin!=null){
            liste.add("une commande de\t\t"+prixFin+"$\n"+"EN_COURS");
        }

        ListAdapter adapter = new ListAdapter(
                this,
                R.layout.commande,
                liste
        );

        ListView lv = (ListView) findViewById(R.id.list_commandes);
        lv.setAdapter(adapter);
        final Button commander = findViewById(R.id.commander);
        commander.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(DashboardActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}
