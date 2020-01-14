package com.example.if26projet;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import org.json.JSONObject;

import java.util.EnumMap;


@Entity(tableName = "Plat")
public class Plat implements TypeNourriture{

    @NonNull
    @PrimaryKey
    private String id;
    @Ignore
    private Bitmap image;
    @ColumnInfo(name = "nom")
    private String nom;
    @ColumnInfo(name = "prix")
    private double prix;
    @ColumnInfo(name = "categorie")
    private String categorie;
    @Ignore
    int    ProductImage;
    @Ignore
    int    CartQuantity;

    public enum Categorie{
        ENTREE,
        PLAT,
        ACCOMPAGNEMENT,
        DESSERT,
        BOISSON;

        @Override
        public String toString() {
            return "Categorie{}";
        }
    }


    private final EnumMap categorieNom(){
        EnumMap<Categorie,String> enumMap=new EnumMap<>(Categorie.class);
        enumMap.put(Categorie.ACCOMPAGNEMENT,"A");
        enumMap.put(Categorie.BOISSON, "B");
        enumMap.put(Categorie.DESSERT, "D");
        enumMap.put(Categorie.ENTREE,"E");
        enumMap.put(Categorie.PLAT, "P");
        return enumMap;
    }

    public Plat() {
    }

    public Plat(String id, String nom, double prix, int productImage, String categorie, int cartQuantity){
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        ProductImage = productImage;
        this.categorie = categorie;
        CartQuantity = cartQuantity;
    }

    public Plat(@NonNull String id, String nom, double prix, int productImage, String categorie) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        ProductImage = productImage;
    }

    public String getJsonObject() {
        JSONObject cartItems = new JSONObject();
        try
        {
            cartItems.put("ProductId",getId());
            cartItems.put("ProductName", getNom());
            cartItems.put("ProductPrice", getPrix());
            cartItems.put("ProductImage",ProductImage);
            cartItems.put("ProductCat",getCategorie());
            cartItems.put("CartQuantity",CartQuantity);
        }
        catch (Exception e) {}
        return cartItems.toString();
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Categorie getUneCategorie(String categorie) {
        Categorie c = Enum.valueOf(Categorie.class, categorie);
        return c;
    }
    public Plat setUnPlat(String viande, String legume, String sauce){
        //TypeNourriture.Viande.valueOf(viande).
        this.setPrix((Double) Viande.PrixMapViande().get(Viande.valueOf(viande)));
        this.setNom(viande+"avec"+legume+sauce);
        this.setCategorie("PLAT");
        return this;
    }

}
