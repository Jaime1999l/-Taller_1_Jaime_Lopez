package com.example.taller1.model;

import android.app.Application;
import android.content.SharedPreferences;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class UserViewModel extends AndroidViewModel {

    private MutableLiveData<String> userName;
    private SharedPreferences sharedPreferences;

    public UserViewModel(Application application) {
        super(application);
        sharedPreferences = application.getSharedPreferences("MyAppPrefs", application.MODE_PRIVATE);
        userName = new MutableLiveData<>();
        loadUserName();
    }

    public LiveData<String> getUserName() {
        return userName;
    }

    public void saveUserName(String name) {
        userName.setValue(name);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("userName", name);
        editor.apply();
    }

    private void loadUserName() {
        String name = sharedPreferences.getString("userName", "");
        userName.setValue(name);
    }
}

