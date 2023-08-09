package com.example.mobileuninga;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
private Button formButton;
private Button listButton;

        @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        formButton = findViewById(R.id.formButton);
        listButton = findViewById(R.id.listButton);

        formButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
                openFormActivity();
                }
});

        listButton.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View v) {
                openListActivity();
                }
 });
        }

        private void openFormActivity() {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
        }

        private void openListActivity() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
        }
}
