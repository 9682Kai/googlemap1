package tw.edu.pu.s1091802.googlemap;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AccountPageActivity extends AppCompatActivity {

    private ImageView profileImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_page);

        Bundle bundle = this.getIntent().getExtras();

        if(bundle != null) {

            String email = bundle.getString("Email");
            String username = bundle.getString("UserName");

            TextView emailtext = findViewById(R.id.mail);
            TextView usernametext = findViewById(R.id.username);

            emailtext.setText(email);
            usernametext.setText(username);

        }
    }
}