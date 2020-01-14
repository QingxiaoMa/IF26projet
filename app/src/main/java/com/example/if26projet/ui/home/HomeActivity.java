package com.example.if26projet.ui.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.if26projet.ListAdapter;
import com.example.if26projet.Plat;
import com.example.if26projet.SecondActivity;
import com.example.if26projet.R;
import com.example.if26projet.ui.dashboard.DashboardActivity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    String categorie;
    ListView lvSummary;
    TextView tvTotal;
    Double Total=0d;
    ArrayList<Plat> productOrders = new ArrayList<>();
    private ArrayList<String> lOrderItems = new ArrayList<>();
    private String orderItems="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);

        final Button bt1 = findViewById(R.id.bu1);
        bt1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SecondActivity.class);
                categorie = getResources().getString(R.string.bu1);
                intent.putExtra("cat", categorie);
                startActivity(intent);
            }
        });
        final Button bt2 = findViewById(R.id.bu2);
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SecondActivity.class);
                categorie = getResources().getString(R.string.bu2);
                String prix = tvTotal.getText().toString();
                intent.putExtra("prix",prix);
                intent.putExtra("cat", categorie);
                startActivity(intent);
            }
        });
        final Button bt3 = findViewById(R.id.bu3);
        bt3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SecondActivity.class);
                categorie = getResources().getString(R.string.bu3);
                String prix = tvTotal.getText().toString();
                intent.putExtra("prix",prix);
                intent.putExtra("cat", categorie);
                startActivity(intent);
            }
        });
        final Button bt4 = findViewById(R.id.bu4);
        bt4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SecondActivity.class);
                categorie = getResources().getString(R.string.bu4);
                String prix = tvTotal.getText().toString();
                intent.putExtra("prix",prix);
                intent.putExtra("cat", categorie);
                startActivity(intent);
            }
        });

        lvSummary = findViewById(R.id.lvSummary);
        tvTotal = findViewById(R.id.tvTotal);
        getOrderItemData();

        final Button back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showMessage("Vous pouvez aller payer un total de\t"+tvTotal.getText().toString()+"\t$");
                Intent intent = new Intent(HomeActivity.this, DashboardActivity.class);
                intent.putExtra("prixTo", tvTotal.getText().toString());
                startActivity(intent);
            }
        });
        final Button delete = findViewById(R.id.delete);
        delete.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                lvSummary.setAdapter(null);
                tvTotal.setText("0");
                showMessage("votre commande est annulee");
            }
        });

    }

    private void getOrderItemData() {
        Bundle extras = getIntent().getExtras();
        if(extras!=null) {
            String newOrder = extras.getString("orderItems");
            String prixPrecedant = extras.getString("prixPrecedant");
            if (newOrder.length() > 0 && newOrder != null) {
                orderItems = newOrder;
                try {
                    JSONArray jsonOrderItems = new JSONArray(orderItems);
                    for (int i = 0; i < jsonOrderItems.length(); i++) {
                        JSONObject jsonObject = new JSONObject(jsonOrderItems.getString(i));
                        Plat product = new Plat(
                                jsonObject.getString("ProductId"),
                                jsonObject.getString("ProductName")
                                , jsonObject.getDouble("ProductPrice")
                                , jsonObject.getInt("ProductImage"),
                                jsonObject.getString("ProductCat"),
                                jsonObject.getInt("CartQuantity")
                        );
                        int cartQuantity = jsonObject.getInt("CartQuantity");
                        /* Calculate Total */
                        Total = Total + (cartQuantity * product.getPrix());
                        productOrders.add(product);
                    }

                    if (productOrders.size() > 0) {
                        ListAdapter listAdapter = new ListAdapter(this, productOrders);
                        lvSummary.setAdapter(listAdapter);
                        if(prixPrecedant!=null && prixPrecedant.length()>0) {
                            Total = Total + Double.parseDouble(prixPrecedant);
                        }
                        tvTotal.setText(Total.toString());

                    } else {
                        showMessage("Vide");
                    }
                } catch (Exception e) {
                    showMessage(e.toString());
                }
            }
        }
    }

    public void showMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }


}
