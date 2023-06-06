package com.furkan.mblproje;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;

public class acil extends AppCompatActivity {

    private MessageManager messageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageManager = new MessageManager();

        // Bildirimleri çek ve gönder
        messageManager.fetchNotificationsAndSend();
    }
}
