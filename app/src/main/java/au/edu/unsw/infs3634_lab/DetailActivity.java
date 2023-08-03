package au.edu.unsw.infs3634_lab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.concurrent.Executors;

import au.edu.unsw.infs3634_lab.api.Crypto;
import au.edu.unsw.infs3634_lab.api.CryptoService;
import au.edu.unsw.infs3634_lab.api.Datum;
import au.edu.unsw.infs3634_lab.api.db.CryptoDB;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DetailActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "intent_message";
    private static final String TAG = "Detail-Activity";
    private TextView detailMessage;
    private Button btnOpenUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // Set title for the activity
        setTitle("Detail Activity");

        TextView name = findViewById(R.id.CryptoName);
        TextView symbol = findViewById(R.id.CryptoSymbol);
        TextView value = findViewById(R.id.CryptoValue);
        TextView change1h = findViewById(R.id.CryptoChange1h);
        TextView rank = findViewById(R.id.CryptoRank);
        TextView change24h = findViewById(R.id.CryptoChange24h);
        TextView change7d = findViewById(R.id.CryptoChange7d);
        TextView volume = findViewById(R.id.CryptoVolume24h);
        TextView marketCap = findViewById(R.id.CryptoMarketCap);
        ImageView searchButton = findViewById(R.id.SearchButton);
        CheckBox FavouriteCheckbox = findViewById(R.id.FavouriteCheckbox);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(currentUser.getUid());



        // Get the intent that started this activity and extract the string
        Intent intentFromMain = getIntent();
        String message1 = intentFromMain.getStringExtra("message1");
        Log.d(TAG, message1);

        CryptoDB mDB = Room.databaseBuilder(getApplicationContext(), CryptoDB.class, "crypto-database-1").build();

        if (!message1.trim().isEmpty() && message1 != null) {

            Executors.newSingleThreadExecutor().execute(new Runnable() {
                @Override
                public void run() {
                    Datum crypto = mDB.cryptoDAO().GetByCryptoId(Integer.parseInt(message1));

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            name.setText(crypto.getName());
                            symbol.setText(crypto.getPriceUsd());
                            value.setText(crypto.getPercentChange1h());
                            change1h.setText(crypto.getPercentChange1h());
                            rank.setText(Integer.toString(crypto.getRank()));
                            change24h.setText(crypto.getPercentChange24h());
                            change7d.setText(crypto.getPercentChange7d());
                            volume.setText(String.format("%.2f", crypto.getVolume24()));
                            marketCap.setText("$" + crypto.getMarketCapUsd());
                            searchButton.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View view) {
                                    Intent searchCrypto = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q="));
                                    startActivity(searchCrypto);
                                }
                            });

                            FavouriteCheckbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                @Override
                                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                                    if (b) {



                                        myRef.setValue(crypto.getSymbol());
                                    } else {

                                        myRef.setValue("");

                                    }

                                }
                            });

                        }
                    });
                }
            });
        }




    }
}