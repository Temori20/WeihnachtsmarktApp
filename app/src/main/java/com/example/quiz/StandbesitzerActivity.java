package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StandbesitzerActivity extends AppCompatActivity implements View.OnClickListener {
    Button bAnmelden;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standbesitzer);

        bAnmelden = (Button) findViewById(R.id.bAnmelden);
        bAnmelden.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.bAnmelden:
                Intent intentAnmelden = new Intent(this, MainActivity.class);
                startActivity(intentAnmelden);
                this.finish();
                break;
        }
    }
}
