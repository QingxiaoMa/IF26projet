package com.example.if26projet;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.sql.Time;

@Entity(tableName = "Commande"
        /** foreignKeys = @ForeignKey(entity = User.class,
        parentColumns = "id",
        childColumns = "clientId")*/)
public class Commande {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "listePlat")
    private String listePlat;
    @ColumnInfo(name = "clientId")
    private int clientId;
    @ColumnInfo(name = "statut")
    private String statut;
    @Ignore
    private Time tempDePreparation;
    @ColumnInfo(name = "prixTotal")
    private double prixTotal;

    public Commande(String listePlat, int clientId, String statut, double prixTotal) {
        this.listePlat = listePlat;
        this.clientId = clientId;
        this.statut = statut;
        this.prixTotal = prixTotal;
    }

    enum Statut{
        A_PAYER,
        EN_COURS,
        PRET_A_LIVRER,
        LIVREE;

        @Override
        public String toString() {
            return "Statut{}";
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getListePlat() {
        return listePlat;
    }

    public void setListePlat(String listePlat) {
        this.listePlat = listePlat;
    }


    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public Statut getUnStatut(String statut) {
        Statut s = Enum.valueOf(Statut.class, statut);
        return s;
    }

    public Time getTempDePreparation() {
        return tempDePreparation;
    }

    public void setTempDePreparation(Time tempDePreparation) {
        this.tempDePreparation = tempDePreparation;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(double prixTotal) {
        this.prixTotal = prixTotal;
    }
}
