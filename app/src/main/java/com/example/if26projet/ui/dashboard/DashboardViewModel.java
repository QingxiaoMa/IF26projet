package com.example.if26projet.ui.dashboard;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.if26projet.AppRepository;
import com.example.if26projet.Commande;

import java.util.List;

public class DashboardViewModel extends ViewModel {
    private AppRepository appRepository;
    private LiveData<List<Commande>> commandes;


    public DashboardViewModel(@NonNull Application application) {
        appRepository = new AppRepository(application);
        commandes = appRepository.getCommandes();
    }

    public LiveData<List<Commande>> getCommandes() {
        return commandes;
    }
}