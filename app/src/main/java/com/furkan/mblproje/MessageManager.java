package com.furkan.mblproje;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class MessageManager {
    private static final String BASE_URL = "https://api.example.com/"; // API'nin kök URL'i

    private ApiService apiService;

    public MessageManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        apiService = retrofit.create(ApiService.class);
    }

    public void fetchNotificationsAndSend() {
        Call<List<Notification>> call = apiService.getNotifications();
        call.enqueue(new Callback<List<Notification>>() {
            @Override
            public void onResponse(Call<List<Notification>> call, Response<List<Notification>> response) {
                if (response.isSuccessful()) {
                    List<Notification> notifications = response.body();
                    if (notifications != null) {
                        for (Notification notification : notifications) {
                            sendNotification(notification.getTitle(), notification.getMessage());
                        }
                    }
                } else {
                    // API isteği başarısız oldu
                }
            }

            @Override
            public void onFailure(Call<List<Notification>> call, Throwable t) {
                // API isteği başarısız oldu
            }
        });
    }

    private void sendNotification(String title, String message) {
        // Bildirim gönderme işlemleri
        // ...
    }
}
