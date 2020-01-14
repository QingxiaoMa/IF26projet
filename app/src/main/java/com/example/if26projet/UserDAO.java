package com.example.if26projet;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

@Dao
    public interface UserDAO {
            @Query("SELECT * FROM user")
            LiveData<List<User>> getAll();

            @Query("SELECT * FROM user WHERE id IN (:userId)")
            List<User> loadAllByIds(int userId);

            @Query("SELECT * FROM user WHERE nom LIKE :nom AND " +
                   "prenom LIKE :prenom LIMIT 1")
            User findByName(String nom, String prenom);

            @Insert(onConflict = OnConflictStrategy.IGNORE)
            void insert(User user);

            @Delete
            void delete(User user);
        }
