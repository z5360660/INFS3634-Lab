package au.edu.unsw.infs3634_lab.api.db;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import au.edu.unsw.infs3634_lab.api.Datum;
@Dao
public interface CryptoDAO {
    @Delete
    void DeleteAllCryptos(Datum... data);

    @Insert
    void InsertAllCryptos(Datum... data);

    @Query("SELECT * FROM Datum")
    List<Datum> GetAllCryptos();

    @Query("SELECT * FROM Datum WHERE Id == :cryptoId")
    Datum GetByCryptoId(Integer cryptoId);
}
