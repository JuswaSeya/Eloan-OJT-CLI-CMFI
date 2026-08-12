package com.example.eloan2ceajava;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class addDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_add_dashboard);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.addLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         ExecutorService executors = Executors.newSingleThreadExecutor();
        ProgressDialog dialog = new ProgressDialog(addDashboard.this);





        LinearLayout addButton;
        addButton=findViewById(R.id.addButton);



        addButton.setOnClickListener(view->{
            startActivity(new Intent(this, the_transaction.class));
//            executors.execute(()->{
//                runOnUiThread(()->{
//                    dialog.setMessage("Loading Please Wait");
//                    dialog.setCancelable(false);
//                    dialog.show();
//                    Toast.makeText(this, "Add Transaction", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(this, the_transaction.class));
//                });
//
//            });


        });
    }
}