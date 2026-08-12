package com.example.eloan2ceajava;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private ProgressDialog progressDialog;
    private ExecutorService executor = Executors.newSingleThreadExecutor();

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

        // Initialize ProgressDialog
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setTitle("Logging in...");
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false); // Prevent back button from dismissing

        btnLogin = findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> {
            // Show dialog before starting background task
            progressDialog.show();

            executor.execute(() -> {
                try {
                    // Simulate login process (e.g., network call, database check)
                    Thread.sleep(1500); // Simulate network delay

                    // Success - navigate to dashboard
                    runOnUiThread(() -> {
                        // Hide dialog before starting new activity
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }

                        // Start dashboard activity
                        Intent intent = new Intent(MainActivity.this, bottom_navigation_dashboard.class);
                        startActivity(intent);

                        Toast.makeText(MainActivity.this, "Login successful!", Toast.LENGTH_SHORT).show();
                    });

                } catch (Exception e) {
                    // Failure - handle error
                    runOnUiThread(() -> {
                        // Hide dialog on error
                        if (progressDialog.isShowing()) {
                            progressDialog.dismiss();
                        }

                        Toast.makeText(MainActivity.this, "Login failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                    });
                }
            });
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Clean up executor to prevent memory leaks
        if (executor != null && !executor.isShutdown()) {
            executor.shutdown();
        }

        // Dismiss dialog if still showing
        if (progressDialog != null && progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }
}