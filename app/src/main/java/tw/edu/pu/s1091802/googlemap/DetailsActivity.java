package tw.edu.pu.s1091802.googlemap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView markertxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        markertxt=findViewById(R.id.marker);
        //get data from our maps activity
        String title=getIntent().getStringExtra("title");
        markertxt.setText(title);
        //add internet permision in manifest.
    }
}