package com.messageapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTextMessage;
    private Button btnSend, btnReceive;
    private RecyclerView recyclerViewMessages;
    private MessageAdapter messageAdapter;
    private List<String> messages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage = findViewById(R.id.editTextMessage);
        btnSend = findViewById(R.id.btnSend);
        btnReceive = findViewById(R.id.btnReceive);
        recyclerViewMessages = findViewById(R.id.recyclerViewMessages);

        messages = new ArrayList<>();
        messageAdapter = new MessageAdapter(messages);

        recyclerViewMessages.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewMessages.setAdapter(messageAdapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString().trim();
                if (!message.isEmpty()) {
                    messages.add("Sent: " + message);
                    messageAdapter.notifyDataSetChanged();
                    recyclerViewMessages.smoothScrollToPosition(messages.size() - 1);
                    editTextMessage.getText().clear();
                }
            }
        });

        btnReceive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editTextMessage.getText().toString().trim();
                if (!message.isEmpty()) {
                    messages.add("Received: " + message);
                    messageAdapter.notifyDataSetChanged();
                    recyclerViewMessages.smoothScrollToPosition(messages.size() - 1);
                    editTextMessage.getText().clear();
                }
            }
        });
    }
}