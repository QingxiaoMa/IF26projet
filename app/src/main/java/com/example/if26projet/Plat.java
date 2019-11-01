package com.example.if26projet;

public class Plat {
    String image;
    String nom;
    float prix;
    public Plat(String image, String nom, float prix){
        this.image = image;
        this.nom = nom;
        this.prix = prix;
    }

    public String getNom() {
        return nom;
    }

    public float getPrix() {
        return prix;
    }

    public String getImage() {
        return image;
    }
}
