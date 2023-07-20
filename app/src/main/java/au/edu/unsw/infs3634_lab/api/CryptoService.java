package au.edu.unsw.infs3634_lab.api;

import java.lang.reflect.Array;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CryptoService {
    @GET("tickers")
    Call<Response> GetCryptos();

    @GET("ticker")
    Call<ArrayList<Datum>> GetCryptoById(@Query("id") Integer id);


    Call<ArrayList<Datum>> GetCyrptoById(int parseInt);
}
