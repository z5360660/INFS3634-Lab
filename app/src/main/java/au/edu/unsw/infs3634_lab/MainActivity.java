package au.edu.unsw.infs3634_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import au.edu.unsw.infs3634_lab.api.Crypto;
import au.edu.unsw.infs3634_lab.api.CryptoService;
import au.edu.unsw.infs3634_lab.api.Datum;
import au.edu.unsw.infs3634_lab.api.Response;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements CryptoAdapter.ClickListener {

    CryptoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView cryptoRecyclerView = findViewById(R.id.cryptoRecycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        cryptoRecyclerView.setLayoutManager(layoutManager);


        adapter = new CryptoAdapter(new ArrayList<>(), MainActivity.this);
        cryptoRecyclerView.setAdapter(adapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.coinlore.net/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CryptoService service = retrofit.create(CryptoService.class);
        Call<Response> responseCall = service.GetCryptos();

       responseCall.enqueue(new Callback<Response>() {
           @Override
           public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
               adapter.SetData(response.body().getData());

           }

           @Override
           public void onFailure(Call<Response> call, Throwable t) {

           }
       });
    }


    @Override
    public void onRowCLick(String symbol) {
        Intent toDetail = new Intent(MainActivity.this, DetailActivity.class);
        toDetail.putExtra("Symbol", symbol);


        startActivity(toDetail);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                adapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.sort_name:
                adapter.Sort(1);
                return true;
            case R.id.sort_price:
                adapter.Sort(2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
