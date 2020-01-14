package com.example.if26projet;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface PlatDAO{

    @Query( "UPDATE Plat SET id = (:platId) WHERE prix = (:prix)")
    void updatePrix(int platId, float prix);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Plat plat);

    @Query("SELECT * FROM plat WHERE categorie IN (:categorie)")
    List<Plat> loadAllByCategorie(String categorie);

    @Query("SELECT * from plat ORDER BY id ASC")
    LiveData<List<Plat>> getAllPlats();

    @Delete
    void delete(Plat plat);
}

