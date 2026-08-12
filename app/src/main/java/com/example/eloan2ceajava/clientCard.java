package com.example.eloan2ceajava;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eloan2ceajava.adapter.Client_adapter;
import com.example.eloan2ceajava.model.client_model;
import com.google.android.material.button.MaterialButton;
import java.util.ArrayList;
import java.util.List;

public class clientCard extends AppCompatActivity {

    private RecyclerView recyclerClients;
    private Client_adapter adapter;
    private List<client_model> clientList;
    private TextView txtTotalClients;
    private EditText etSearchClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_card);

        // Initialize views
        initViews();

        // Setup RecyclerView
        setupRecyclerView();

        // Load sample data
        loadSampleData();

        // Setup search functionality
        setupSearch();

        // Setup add button
        setupAddButton();
    }

    private void initViews() {
        recyclerClients = findViewById(R.id.recyclerClients);
        txtTotalClients = findViewById(R.id.txtTotalClients);
        etSearchClient = findViewById(R.id.etSearchClient);
    }

    private void setupRecyclerView() {
        clientList = new ArrayList<>();
        adapter = new Client_adapter(clientList);

        recyclerClients.setLayoutManager(new LinearLayoutManager(this));
        recyclerClients.setAdapter(adapter);

        // Set item click listener
        adapter.setOnItemClickListener(position -> {
            client_model client = clientList.get(position);
            // Handle click - show client details
            // Toast.makeText(this, "Clicked: " + client.getName(), Toast.LENGTH_SHORT).show();
        });
    }

    private void loadSampleData() {
        // Add sample clients
        clientList.add(new client_model("Juan Dela Cruz", "0912 345 6789", "Active", 25000.0));
        clientList.add(new client_model("Maria Santos", "0921 234 5678", "Active", 50000.0));
        clientList.add(new client_model("Pedro Reyes", "0933 456 7890", "Pending", 75000.0));
        clientList.add(new client_model("Ana Garcia", "0944 567 8901", "Completed", 15000.0));
        clientList.add(new client_model("Luis Martinez", "0955 678 9012", "Active", 30000.0));

        adapter.updateData(clientList);
        updateClientCount();
    }

    private void updateClientCount() {
        int count = clientList.size();
        txtTotalClients.setText(count + " client" + (count > 1 ? "s" : ""));
    }

    private void setupSearch() {
        etSearchClient.addTextChangedListener(new android.text.TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(android.text.Editable s) {
                filterClients(s.toString());
            }
        });
    }

    private void filterClients(String searchText) {
        List<client_model> filteredList = new ArrayList<>();

        if (searchText.isEmpty()) {
            filteredList.addAll(clientList);
        } else {
            String lowerCaseSearch = searchText.toLowerCase();
            for (client_model client : clientList) {
                if (client.getName().toLowerCase().contains(lowerCaseSearch) ||
                        client.getContact().contains(searchText)) {
                    filteredList.add(client);
                }
            }
        }

        adapter.updateData(filteredList);
        int count = filteredList.size();
        txtTotalClients.setText(count + " client" + (count > 1 ? "s" : ""));
    }

    private void setupAddButton() {
        MaterialButton btnAddClient = findViewById(R.id.btnAddClient);
        btnAddClient.setOnClickListener(v -> {
            // Add new client
            client_model newClient = new client_model(
                    "New Client " + (clientList.size() + 1),
                    "0900 123 4567",
                    "Active",
                    10000.0
            );

            clientList.add(newClient);
            adapter.updateData(clientList);
            updateClientCount();
            recyclerClients.smoothScrollToPosition(clientList.size() - 1);
        });
    }
}