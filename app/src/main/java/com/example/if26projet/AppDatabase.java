package com.example.if26projet;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {User.class,Plat.class, Commande.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static volatile AppDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static AppDatabase getInstance(final Context context) {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE =
                            Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "app.db")
                                    .addCallback(sRoomDatabaseCallback)
                                    .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final UserDAO userDAO;
        private final PlatDAO platDAO;
        private final CommandeDAO commandeDAO;

        PopulateDbAsync(AppDatabase db) {
            userDAO = db.userDAO();
            platDAO = db.platDAO();
            commandeDAO = db.commandeDAO();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            userDAO.insert(new User("ma","chiristelle","1111","123"));
            platDAO.insert(new Plat("E1","salade",5.3,7,"ENTREE"));
            platDAO.insert(new Plat("E2","potage",6.3,2,"ENTREE"));
            platDAO.insert(new Plat("D1","glace",3.8,1,"DESSERT"));
            platDAO.insert(new Plat("D2","gauffre",5.3,3,"DESSERT"));
            platDAO.insert(new Plat("A1","riz",3.5,5,"ACCOMPAGNEMENT"));
            platDAO.insert(new Plat("A2","nouilles",3.5,4,"ACCOMPAGNEMENT"));
            platDAO.insert(new Plat("B1","biere",3.2,5,"BOISSON"));
            platDAO.insert(new Plat("B1","jus d'orange",3.2,1,"BOISSON"));
            commandeDAO.insert(new Commande("salade",0,"EN_COURS",5.3));
            commandeDAO.insert(new Commande("jus d'orange",0,"ENVOYE",3.2));

            return  null;
        }
    }
    public abstract UserDAO userDAO();
    public abstract PlatDAO platDAO();
    public abstract CommandeDAO commandeDAO();

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}