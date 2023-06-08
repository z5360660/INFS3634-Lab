package au.edu.unsw.infs3634_lab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    Button button_da;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_da=(Button) findViewById(R.id.buttonda);

        button_da.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent lauchdetail=new Intent(MainActivity.this,DetailActivity.class);
                lauchdetail.putExtra("message1", "This is my first message");
                lauchdetail.putExtra("message2", "This is another message");
                startActivity(lauchdetail);
            }
        });
    }
}