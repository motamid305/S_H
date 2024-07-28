package com.example.myapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ReceiveActivity extends AppCompatActivity {

    private EditText receiptCodeEditText;
    private RadioGroup receiptMethodsGroup;
    private Button receiveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive);

        receiptCodeEditText = findViewById(R.id.receipt_code);
        receiptMethodsGroup = findViewById(R.id.receipt_methods);
        receiveButton = findViewById(R.id.receive_button);

        receiveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                processReceipt();
            }
        });
    }

    private void processReceipt() {
        String receiptCode = receiptCodeEditText.getText().toString();
        int selectedMethodId = receiptMethodsGroup.getCheckedRadioButtonId();
        RadioButton selectedMethod = findViewById(selectedMethodId);
        String method = selectedMethod.getText().toString();

        // Here you can add code to handle receipt processing

        Toast.makeText(ReceiveActivity.this, "Received using: " + method, Toast.LENGTH_SHORT).show();
    }
}
