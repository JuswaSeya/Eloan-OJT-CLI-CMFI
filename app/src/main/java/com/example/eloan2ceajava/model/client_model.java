package com.example.eloan2ceajava.model;

public class client_model {
    private String name;
    private String contact;
    private String loanStatus;
    private String loanType; // Add this field
    private Double balance;

    public client_model(String name, String contact, String loanStatus, Double balance) {
        this(name, contact, loanStatus, "Personal Loan", balance);
    }

    public client_model(String name, String contact, String loanStatus, String loanType, Double balance) {
        this.name = name;
        this.contact = contact;
        this.loanStatus = loanStatus;
        this.loanType = loanType;
        this.balance = balance;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public String getLoanStatus() { return loanStatus; }
    public void setLoanStatus(String loanStatus) { this.loanStatus = loanStatus; }

    public String getLoanType() { return loanType; }
    public void setLoanType(String loanType) { this.loanType = loanType; }

    public Double getBalance() { return balance; }
    public void setBalance(Double balance) { this.balance = balance; }
}