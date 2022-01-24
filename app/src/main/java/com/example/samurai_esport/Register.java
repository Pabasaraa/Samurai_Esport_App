package com.example.samurai_esport;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

public class Register extends AppCompatActivity {

    Button signUp, alreadyMember;
    ImageView logo;
    TextView title, slogan;
    TextInputLayout name, username, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

//        HideNavBar();

        logo = findViewById(R.id.logoReg);
        title = findViewById(R.id.titleReg);
        slogan = findViewById(R.id.sloganReg);
        name = findViewById(R.id.nameReg);
        username = findViewById(R.id.usernameReg);
        email = findViewById(R.id.emailReg);
        password = findViewById(R.id.passwordReg);
        signUp = findViewById(R.id.signupBtnReg);
        alreadyMember = findViewById(R.id.signinBtnReg);

        alreadyMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);

                Pair[] pairs = new Pair[4];
//                pairs[0] = new Pair<View, String>(logo, "logo_img");
//                pairs[1] = new Pair<View, String>(title, "name");
//                pairs[2] = new Pair<View, String>(slogan, "slogan");
                pairs[0] = new Pair<View, String>(username, "username");
                pairs[1] = new Pair<View, String>(password, "password");
                pairs[2] = new Pair<View, String>(signUp, "signIn");
                pairs[3] = new Pair<View, String>(alreadyMember, "newUser");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Register.this, pairs);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent, options.toBundle());
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