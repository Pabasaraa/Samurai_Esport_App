package com.example.samurai_esport;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {

    Animation topAnim, bottomAnim;
    ImageView logo;
    TextView name, slogan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        HideNavBar();

        //Hooks
        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
        logo = findViewById(R.id.imageView);
        name = findViewById(R.id.name);
        slogan = findViewById(R.id.slogan);

        logo.setAnimation(topAnim);
        name.setAnimation(bottomAnim);
        slogan.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, Login.class);
                //Normal fade in & out transition
//                startActivity(intent);
//                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View, String>(logo, "logo_img");
                pairs[1] = new Pair<View, String>(name, "name");
                pairs[2] = new Pair<View, String>(slogan, "slogan");
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this, pairs);
                startActivity(intent, options.toBundle());
                finish();
            }
        }, 5000);
    }
    @Override
    protected void onResume() {
        super.onResume();
        HideNavBar();
    }

    public void HideNavBar() {
        this.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
    }

}