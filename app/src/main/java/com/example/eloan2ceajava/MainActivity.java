package com.example.eloan2ceajava;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

private Button btnLogin;


ExecutorService executor = Executors.newSingleThreadExecutor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        btnLogin=findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            executor.execute(() -> {
                runOnUiThread(() -> {
                    dialog.setTitle("Logging in...");
                    dialog.setCancelable(false);
                    dialog.show();

                    startActivity(new Intent(MainActivity.this, bottom_navigation_dashboard.class));

                });



            });

        });

    }
}