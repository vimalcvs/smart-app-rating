package com.vimalcvs.smartrating;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.vimalcvs.ratingdialog.RatingDialog;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button =findViewById(R.id.dialog_button);
        button.setOnClickListener(view -> {
            RatingDialog ratingDialog = new RatingDialog(this);
            ratingDialog.show(MainActivity.this.getSupportFragmentManager(), ratingDialog.getTag());
        });
    }
}