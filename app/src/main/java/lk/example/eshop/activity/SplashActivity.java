package lk.example.eshop.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.GenericLifecycleObserver;

import com.squareup.picasso.Picasso;
import com.bumptech.glide.Glide;

import lk.example.eshop.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){

            getWindow().setDecorFitsSystemWindows(false);

            WindowInsetsController controller = getWindow().getInsetsController();

            if (controller != null){

                controller.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());

            }

        } else {

            getWindow().setFlags(

                    WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN

            );

        }

        ImageView imageView = findViewById(R.id.splashLogo);

//        imageView.setImageResource(R.drawable.ic_launcher_foreground);

//        Picasso.get()
//                .load(R.drawable.)
//                .resize(300 , 300)
//                .into(imageView);

        Glide.with(this)
                .asBitmap()
                .load(R.drawable.app_logo)
                .override(300)
                .into(imageView);

        new Handler (Looper.getMainLooper())
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        findViewById(R.id.splashProgressBar).setVisibility(View.VISIBLE);

                    }
                },1000 );

    new Handler (Looper.getMainLooper())
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        findViewById(R.id.splashProgressBar).setVisibility(View.INVISIBLE);
                        Intent intent = new Intent(SplashActivity.this , MainActivity.class);
                        startActivity(intent);
                        finish();

                    }
                },5000 );

    }
}