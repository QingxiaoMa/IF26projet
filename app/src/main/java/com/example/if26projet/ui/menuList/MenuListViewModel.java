package com.example.if26projet.ui.menuList;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.if26projet.AppRepository;
import com.example.if26projet.Plat;

import java.util.List;

public class MenuListViewModel extends ViewModel {
    private AppRepository appRepository;

    private LiveData<List<Plat>> plats;

    public MenuListViewModel (Application application) {
        appRepository = new AppRepository(application);
        plats = appRepository.getPlats();
    }

    LiveData<List<Plat>> getPlats() { return plats; }

    public void insert(Plat plat) { appRepository.insert(plat); }
}
