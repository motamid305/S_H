package com.example.myapp;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "transaction_table")
public class Transaction {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String firstName;
    public String lastName;
    public String cardNumber;
    public String expirationDate;
    public String cvv;
    public String receiptCode;
}
