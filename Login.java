package tw.edu.pu.s1091802.googlemap;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import androidx.annotation.Nullable;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;


public class Login extends AppCompatActivity
{

    public static final String TAG = Login.class.getSimpleName() + "My";
    private GoogleSignInClient mGoogleSignInClient;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       Button nextPageBtn = (Button)findViewById(R.id.button2);

        // [START config_signin]
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("222107848046-kl8v2hsib3m3ubuki24lk11pok6evo3m.apps.googleusercontent.com")
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this , gso);
        // [END config_signin]

        SignInButton btSighIn = findViewById(R.id.button_SignIn);
        btSighIn.setOnClickListener(v->{
            startActivityForResult(mGoogleSignInClient.getSignInIntent() , 200);
        });
        nextPageBtn.setOnClickListener(new View.OnClickListener()

              {
                  public void onClick(View v)
                   {
                   Intent intent = new Intent();
                       intent.setClass(Login.this, MapsActivity.class);  //從主畫面跳到搜尋畫面
                       startActivity(intent);
                }
              }
        );
    }

    // [START onactivityresult]
    @Override
    public void onActivityResult(int requestCode , int resultCode , Intent data)
    {
        super.onActivityResult(requestCode , resultCode , data);

        if (requestCode == 200)
        {
            /*FirebaseAuth mAuth = FirebaseAuth.getInstance();
            FirebaseUser user = mAuth.getCurrentUser();

            if (user != null) {
                String displayName = user.getDisplayName(); // 获取用户显示名称
                String email = user.getEmail(); // 获取用户电子邮件地址
                String uid = user.getUid(); // 获取用户唯一标识符

                // 将帐户信息打包成一个 Bundle
                Bundle userInfoBundle = new Bundle();
                userInfoBundle.putString("displayName", displayName);
                userInfoBundle.putString("email", email);
                userInfoBundle.putString("uid", uid);

                Intent intent = new Intent();
                intent.setClass(Login.this, AccountPageActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString();

            } else {

            }*/

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try
            {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                String result = "登入成功\nEmail：" + account.getEmail() + "\nGoogle名稱：" + account.getDisplayName();
                Log.d(TAG , "Token: " + account.getIdToken());
                TextView tvResult = findViewById(R.id.textView_Result);
                tvResult.setText(result);

                Intent intent = new Intent(Login.this , MapsActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("Email",account.getEmail());
                bundle.putString("UserName",account.getDisplayName());
                intent.putExtras(bundle);
                startActivity(intent);

            }
            catch (ApiException e)
            {
                Log.w(TAG , "Google sign in failed" , e);
            }
        }
    }
}