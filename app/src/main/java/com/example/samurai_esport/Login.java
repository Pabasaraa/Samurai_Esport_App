package com.example.samurai_esport;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Login extends AppCompatActivity {

    Button newUserLI, forgotPwLI, signInLI;
    ImageView logoLI;
    TextView nameLI, sloganLI;
    TextInputLayout usernameLI, passwordLI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        HideNavBar();

        newUserLI = findViewById(R.id.newUserBtnLI);
        forgotPwLI = findViewById(R.id.forgotPwBtnLI);
        signInLI = findViewById(R.id.signInBtnLI);
        logoLI = findViewById(R.id.logoLI);
        nameLI = findViewById(R.id.welcome_textLI);
        sloganLI = findViewById(R.id.sign_inLI);
        usernameLI = findViewById(R.id.usernameLI);
        passwordLI = findViewById(R.id.passwordLI);


        newUserLI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Register.class);
                Pair[] pairs = new Pair[7];
                pairs[0] = new Pair<View, String>(logoLI, "logo_img");
                pairs[1] = new Pair<View, String>(nameLI, "name");
                pairs[2] = new Pair<View, String>(sloganLI, "slogan");
                pairs[3] = new Pair<View, String>(usernameLI, "username");
                pairs[4] = new Pair<View, String>(passwordLI, "password");
                pairs[5] = new Pair<View, String>(signInLI, "signIn");
                pairs[6] = new Pair<View, String>(newUserLI, "newUser");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
                startActivity(intent, options.toBundle());
//                startActivity(intent);
            }
        });

        signInLI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this, Dashboard.class);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(intent);
            }
        });
    }

//    @Override
//    protected void onResume() {
//        super.onResume();
//        HideNavBar();
//    }
//
//    public void HideNavBar() {
//        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
//    }
}