package au.edu.unsw.infs3634_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import au.edu.unsw.infs3634_lab.api.Crypto;

public class MainActivity extends AppCompatActivity implements CryptoAdapter.ClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView cryptoRecyclerView = findViewById(R.id.cryptoRecycler);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        cryptoRecyclerView.setLayoutManager(layoutManager);

        CryptoAdapter adapter = new CryptoAdapter(Crypto.getCryptoCurrencies(), new CryptoAdapter.ClickListener() {
            @Override
            public void onRowCLick(String symbol) {
                Intent toDetail = new Intent(MainActivity.this, DetailActivity.class);
                toDetail.putExtra("Symbol", symbol);

                startActivity(toDetail);
            }
        });
        cryptoRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onRowCLick(String symbol) {
        Intent toDetail = new Intent(MainActivity.this, DetailActivity.class);
        toDetail.putExtra("Symbol", symbol);

        startActivity(toDetail);
    }
}
