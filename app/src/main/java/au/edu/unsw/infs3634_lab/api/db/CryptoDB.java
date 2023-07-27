package au.edu.unsw.infs3634_lab.api.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import au.edu.unsw.infs3634_lab.api.Datum;

@Database(entities = {Datum.class}, version = 1)
public abstract class CryptoDB extends RoomDatabase {
    public abstract CryptoDAO cryptoDAO();

}


