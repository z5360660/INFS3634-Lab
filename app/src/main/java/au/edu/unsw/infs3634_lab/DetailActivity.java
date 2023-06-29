package au.edu.unsw.infs3634_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import au.edu.unsw.infs3634_lab.api.Crypto;

public class DetailActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "Symbol";
    private static final String TAG= "Detail-Activity";
    private TextView detailMessage;
    private Button btnOpenUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // Set title for the activity
        setTitle("Detail Activity");

        // Get the intent that started this activity and extract the string
        Intent intent = getIntent();
        if (intent.hasExtra(INTENT_MESSAGE)) {
            String message = intent.getStringExtra(INTENT_MESSAGE);
            Log.d(TAG, "Intent Message = " + message);

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

            Crypto crypto = Crypto.getBySymbol(message);
            if (crypto != null) {
                name.setText((crypto.getName()));
                symbol.setText(crypto.getSymbol());
                value.setText("$" + crypto.getPriceUsd());
                change1h.setText(crypto.getPercentChange1h() + "%");
                rank.setText(Integer.toString(crypto.getRank()));
                change24h.setText(crypto.getPercentChange24h() + "%");
                change7d.setText(crypto.getPercentChange7d() + "%");
                volume.setText(String.format("%.2f", crypto.getVolume24()));
                marketCap.setText(crypto.getMarketCapUsd());
            }
            searchButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent searchCrypto = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q"));
                            startActivity(searchCrypto);
                }
            });


        }


    }

    // Called when user taps on open url button
    public void openUrl(String url){
        // Create an ACTION_VIEW intent
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }

}