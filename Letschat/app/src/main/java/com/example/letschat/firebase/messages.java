package com.example.letschat.firebase;

import androidx.annotation.NonNull;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.Objects;

public class messages extends FirebaseMessagingService {

    @Override
    public void onNewToken(@NonNull String token){
        super.onNewToken(token);
    }

    public void onMessageReceived(@NonNull RemoteMessage remoteMessage){
        super.onMessageReceived(remoteMessage);
    }

}