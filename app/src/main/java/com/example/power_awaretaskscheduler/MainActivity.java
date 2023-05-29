package com.example.power_awaretaskscheduler;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set up a button click listener
        Button myButton = findViewById(R.id.startButton);
        myButton.setOnClickListener(v -> {
            // Code to execute when the button is clicked
            showToast("Button Clicked!");
        });
    }

    // Display a Toast message
    private void showToast(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    // Handle the permission request result
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Permission is granted
                // Perform necessary actions
                showToast("Permission Granted!");
            } else {
                // Permission is denied
                // Handle accordingly
                showToast("Permission Denied!");
            }
        }
    }
}
