package com.example.if26projet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.if26projet.ui.dashboard.DashboardActivity;
import com.example.if26projet.ui.home.HomeActivity;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText viewNom = findViewById(R.id.editText);
        final EditText viewPassword = findViewById(R.id.editText2);
        final TextView tx = (TextView)findViewById(R.id.result);
        //Intent intent = getIntent();
        //String result = intent.getIntExtra("com",0);
        String Info = "Merci de choisir de commander sur notre plateforme !";
        tx.setText(Info);
        final Button bt = findViewById(R.id.button1);
        bt.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nom = viewNom.getText().toString();
                String password = viewPassword.getText().toString();
                if(nom==null||nom.equals("")||password==null||password.equals("")){
                    initForm(tx, viewNom, viewPassword);
                }else {
                    //User user=getUser(nom,password);
                    //if (user!=null){
                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                    //Bundle bundle = new Bundle();
                    // bundle.putSerializable("user",user);
                    //intent.putExtra("nom", nom);
                    // intent.putExtras(bundle);
                    startActivity(intent);
                    //}else {
                    //initForm(tx, viewNom, viewPassword);
                }
            }});

        final Button bt2 = findViewById(R.id.button2);
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nom = viewNom.getText().toString();
                String password = viewPassword.getText().toString();
                if(nom==null||nom.equals("")||password==null||password.equals("")) {
                    initForm(tx, viewNom, viewPassword);
                }else{
                    Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    intent.putExtra("nom", nom);
                    startActivity(intent);
                }
                /**Intent intent = new Intent(MainActivity.this, HomeFragment.class);
                 Bundle bundle = new Bundle();
                 bundle.putSerializable("user",user);
                 intent.putExtra("nom", nom);
                 intent.putExtras(bundle);
                 startActivity(intent);
                 }else {
                 initForm(tx, viewNom, viewPassword);
                 }*/
            } });

    }

    private void initForm(TextView tx, EditText viewNom, EditText viewPassword) {
        tx.setText("Erruer saisie des données");
        viewNom.setText("");
        viewPassword.setText("");
    }



}