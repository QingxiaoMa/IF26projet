package com.example.if26projet;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AppRepository {
    private LiveData<List<Plat>> plats;
    private PlatDAO platDAO;
    private LiveData<List<User>> users;
    private UserDAO userDAO;
    private LiveData<List<Commande>> commandes;
    private CommandeDAO commandeDAO;

    public AppRepository(Application application) {
        AppDatabase db = AppDatabase.getInstance(application);
        platDAO = db.platDAO();
        plats = platDAO.getAllPlats();
        userDAO = db.userDAO();
        users = userDAO.getAll();
        commandeDAO = db.commandeDAO();
        commandes = commandeDAO.getAll();
    }

    public LiveData<List<Plat>> getPlats() {
        return plats;
    }

    public void setPlats(LiveData<List<Plat>> plats) {
        this.plats = plats;
    }

    public PlatDAO getPlatDAO() {
        return platDAO;
    }

    public void setPlatDAO(PlatDAO platDAO) {
        this.platDAO = platDAO;
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }

    public void setUsers(LiveData<List<User>> users) {
        this.users = users;
    }

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public LiveData<List<Commande>> getCommandes() {
        return commandes;
    }

    public void setCommandes(LiveData<List<Commande>> commandes) {
        this.commandes = commandes;
    }

    public CommandeDAO getCommandeDAO() {
        return commandeDAO;
    }

    public void setCommandeDAO(CommandeDAO commandeDAO) {
        this.commandeDAO = commandeDAO;
    }

    public void insert (Plat plat){
        new insertAsyncTask(platDAO).execute(plat);

    }

    public void delete(Plat plat){
        new deleteAsyncTask(platDAO).execute(plat);
    }

    private static class insertAsyncTask extends AsyncTask<Plat, Void, Void> {

        private PlatDAO mAsyncTaskDao;

        insertAsyncTask(PlatDAO dao) {
            mAsyncTaskDao = dao;
        }


        protected Void doInBackground(final Plat... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<Plat, Void, Void> {

        private PlatDAO mAsyncTaskDao;

        deleteAsyncTask(PlatDAO dao) {
            mAsyncTaskDao = dao;
        }


        protected Void doInBackground(final Plat... params) {
            mAsyncTaskDao.delete(params[0]);

            return null;
        }

    }
}
