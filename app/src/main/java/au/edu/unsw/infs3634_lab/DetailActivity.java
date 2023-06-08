package au.edu.unsw.infs3634_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class DetailActivity extends AppCompatActivity {

    public static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("Detail Activity");

        Intent intentFromMain = getIntent();
        String message1 = intentFromMain.getStringExtra("message1");

        Log.d(TAG, message1);

        TextView textInDetail = findViewById(R.id.TextViewInDetail);
        textInDetail.setText(message1);

        Button buttonToYoutube = findViewById(R.id.ButtonToVideo);
        buttonToYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToYoutube = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=vPnk3aYDCpI&t=352s&ab_channel=BassEvents"));
                startActivity(intentToYoutube);

            }
        });
    }

}