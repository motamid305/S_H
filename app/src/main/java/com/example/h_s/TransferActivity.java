package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TransferActivity extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText cardNumberEditText;
    private EditText expirationDateEditText;
    private EditText cvvEditText;
    private Button transferButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transfer);

        firstNameEditText = findViewById(R.id.first_name);
        lastNameEditText = findViewById(R.id.last_name);
        cardNumberEditText = findViewById(R.id.card_number);
        expirationDateEditText = findViewById(R.id.expiration_date);
        cvvEditText = findViewById(R.id.cvv);
        transferButton = findViewById(R.id.transfer_button);

        transferButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveTransaction();
                Toast.makeText(TransferActivity.this, "Amount is under review", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void saveTransaction() {
        String firstName = firstNameEditText.getText().toString();
        String lastName = lastNameEditText.getText().toString();
        String cardNumber = cardNumberEditText.getText().toString();
        String expirationDate = expirationDateEditText.getText().toString();
        String cvv = cvvEditText.getText().toString();

        AppDatabase db = AppDatabase.getDatabase(getApplicationContext());
        TransactionDao transactionDao = db.transactionDao();

        Transaction transaction = new Transaction();
        transaction.firstName = firstName;
        transaction.lastName = lastName;
        transaction.cardNumber = cardNumber;
        transaction.expirationDate = expirationDate;
        transaction.cvv = cvv;

        new Thread(new Runnable() {
            @Override
            public void run() {
                transactionDao.insert(transaction);
            }
        }).start();
    }
}
