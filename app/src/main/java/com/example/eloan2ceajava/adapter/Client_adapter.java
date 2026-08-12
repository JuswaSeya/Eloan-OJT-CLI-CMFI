package com.example.eloan2ceajava.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.eloan2ceajava.R;
import com.example.eloan2ceajava.model.client_model;
import java.util.List;

public class Client_adapter extends RecyclerView.Adapter<Client_adapter.ClientViewHolder> {

    private List<client_model> clientList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public Client_adapter(List<client_model> clientList) {
        this.clientList = clientList;
    }


    @NonNull
    @Override
    public ClientViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_client_card, parent, false);
        return new ClientViewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull ClientViewHolder holder, int position) {
        client_model client = clientList.get(position);
        holder.bind(client);
    }

    @Override
    public int getItemCount() {
        return clientList != null ? clientList.size() : 0;
    }

    // Update data method
    public void updateData(List<client_model> newClients) {
        this.clientList = newClients;
        notifyDataSetChanged();
    }

    static class ClientViewHolder extends RecyclerView.ViewHolder {
        private TextView txtClientInitial, txtClientName, txtClientContact,
                txtClientLoan, txtClientLoanType, txtClientBalance;

        public ClientViewHolder(@NonNull View itemView, OnItemClickListener listener) {
            super(itemView);

            txtClientInitial = itemView.findViewById(R.id.txtClientInitial);
            txtClientName = itemView.findViewById(R.id.txtClientName);
            txtClientContact = itemView.findViewById(R.id.txtClientContact);
            txtClientLoan = itemView.findViewById(R.id.txtClientLoan);
            txtClientLoanType = itemView.findViewById(R.id.txtClientLoanType);
            txtClientBalance = itemView.findViewById(R.id.txtClientBalance);

            itemView.setOnClickListener(v -> {
                if (listener != null) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        listener.onItemClick(position);
                    }
                }
            });
        }

        public void bind(client_model client) {
            // Set initials (first letter of first and last name)
            String initials = "";
            if (client.getName() != null) {
                String[] nameParts = client.getName().split(" ");
                if (nameParts.length > 0) {
                    initials += nameParts[0].charAt(0);
                }
                if (nameParts.length > 1) {
                    initials += nameParts[1].charAt(0);
                }
            }
            txtClientInitial.setText(initials.toUpperCase());

            txtClientName.setText(client.getName());
            txtClientContact.setText(client.getContact());
            txtClientLoan.setText(client.getLoanStatus());
            txtClientLoanType.setText("Personal Loan"); // You can add this field to model
            txtClientBalance.setText("₱" + String.format("%,.0f", client.getBalance()));
        }
    }
}