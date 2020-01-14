package com.example.if26projet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.if26projet.ui.home.HomeActivity;

import org.json.JSONArray;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity implements TypeNourriture{

    private ListView listView;
    private ListAdapter listAdapter;
    ArrayList<Plat> products = new ArrayList<>();
    ArrayList<Plat> plats = new ArrayList<>();
    Button btnPlaceOrder;
    ArrayList<Plat> productOrders = new ArrayList<>();
    private ArrayList<String> lOrderItems = new ArrayList<>();
    private String prix="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getProduct();
        Intent intent = getIntent();
        prix = intent.getStringExtra("prix");
        String categorie = intent.getStringExtra("cat");
        for(Plat plat:products) {
            if (plat.getCategorie().equals(categorie)) {
                plats.add(plat);
            }
        }

        listView = (ListView) findViewById(R.id.customListView);

        listAdapter = new ListAdapter(this,plats);
        listView.setAdapter(listAdapter);
        btnPlaceOrder = (Button) findViewById(R.id.btnPlaceOrder);
        btnPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                placeOrder();
            }
        });
    }

    private void placeOrder()
    {
        lOrderItems.clear();
        //productOrders.clear();
        for(int i=0;i<listAdapter.products.size();i++)
        {
            if(listAdapter.products.get(i).CartQuantity > 0)
            {
                Plat products = new Plat(
                        listAdapter.products.get(i).getId(),
                        listAdapter.products.get(i).getNom()
                        ,listAdapter.products.get(i).getPrix()
                        ,listAdapter.products.get(i).ProductImage,
                        listAdapter.products.get(i).getCategorie(),
                        listAdapter.products.get(i).CartQuantity
                );
                productOrders.add(products);
                /* Create a JSON Object and store it in String ArrayList */
                lOrderItems.add(products.getJsonObject());
            }
        }
        showMessage("Nombre produit: "+productOrders.size());
        /* Convert String ArrayList into JSON Array */
        JSONArray jsonArray = new JSONArray(lOrderItems);
        /* Open Summary with JSONArray String */
        openSummary(jsonArray.toString());
    }

    public void showMessage(String message)
    {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
    public void openSummary(String newOrder)
    {
        Intent summaryIntent = new Intent(this, HomeActivity.class);
        summaryIntent.putExtra("orderItems",newOrder);
        summaryIntent.putExtra("prixPrecedant",prix);
        startActivity(summaryIntent);
    }

    public void getProduct() {
        products.add(new Plat("E1","salade",5.3,R.drawable.ic_restaurant_black_24dp,"ENTREE",0));
        products.add(new Plat("E2","potage",6.3,R.drawable.ic_restaurant_black_24dp,"ENTREE",0));
        products.add(new Plat("D1","glace",3.8,R.drawable.ic_cake_black_24dp,"DESSERT",0));
        products.add(new Plat("D2","gauffre",5.3,R.drawable.ic_cake_black_24dp,"DESSERT",0));
        products.add(new Plat("A1","riz",3.5,R.drawable.ic_room_service_black_24dp,"ACCOMPAGNEMENT",0));
        products.add(new Plat("A2","nouilles",3.5,R.drawable.ic_room_service_black_24dp,"ACCOMPAGNEMENT",0));
        products.add(new Plat("B1","biere",3.2,R.drawable.ic_free_breakfast_black_24dp,"BOISSON",0));
        products.add(new Plat("B2","jus d'orange",3.2,R.drawable.ic_free_breakfast_black_24dp,"BOISSON",0));
        products.add(new Plat("V1","poulet",11.8,R.drawable.ic_restaurant_menu_black_24dp,"PLAT",0));
        products.add(new Plat("V2","porc",11.8,R.drawable.ic_restaurant_menu_black_24dp,"PLAT",0));
        products.add(new Plat("V3","canard",13.8,R.drawable.ic_restaurant_menu_black_24dp,"PLAT",0));
        products.add(new Plat("V4","boeuf",12.8,R.drawable.ic_restaurant_menu_black_24dp,"PLAT",0));
        products.add(new Plat("L1","onions",1,R.drawable.ic_restaurant_menu_black_24dp,"PLAT",0));
        products.add(new Plat("L2","choux",1,R.drawable.ic_restaurant_menu_black_24dp,"PLAT",0));
        products.add(new Plat("L3","poivrons",1,R.drawable.ic_restaurant_menu_black_24dp,"PLAT",0));
        products.add(new Plat("S1","sauce sate",0,R.drawable.ic_restaurant_menu_black_24dp,"PLAT",0));
        products.add(new Plat("S2","sauce huile",0,R.drawable.ic_restaurant_menu_black_24dp,"PLAT",0));
        products.add(new Plat("S3","curry",0,R.drawable.ic_restaurant_menu_black_24dp,"PLAT",0));
    }
}
