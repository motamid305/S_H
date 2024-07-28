package com.example.myapp;

import android.os.Bundle;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class AdminActivity extends AppCompatActivity {

    private ListView transactionListView;
    private TransactionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        transactionListView = findViewById(R.id.transaction_list);

        AppDatabase db = AppDatabase.getDatabase(getApplicationContext());
        TransactionDao transactionDao = db.transactionDao();

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Transaction> transactions = transactionDao.getAll();
                runOnUiThread(() -> {
                    adapter = new TransactionAdapter(AdminActivity.this, transactions);
                    transactionListView.setAdapter(adapter);
                });
            }
        }).start();
    }
}
