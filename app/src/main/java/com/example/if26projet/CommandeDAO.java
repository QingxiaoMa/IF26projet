package com.example.if26projet;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

import static androidx.room.OnConflictStrategy.IGNORE;
import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
public interface CommandeDAO {


    @Query("SELECT * FROM commande WHERE id IN (:clientId)")
    List<Commande> getCommandeDunClient(int clientId);

    @Query("SELECT * FROM commande WHERE statut IN (:statut)")
    List<Commande> getCommandeDunStatut(String statut);

    @Insert(onConflict = REPLACE)
    void insert(Commande commande);

    @Query( "UPDATE Commande SET listePlat = (:listPlat) AND prixTotal =(:prixTotal) WHERE id = (:commandeId)")
    void updateCommande(int commandeId, String listPlat,double prixTotal);

    @Query("SELECT * FROM commande")
    LiveData<List<Commande>> getAll();

    @Delete
    void delete(Commande commande);
}

