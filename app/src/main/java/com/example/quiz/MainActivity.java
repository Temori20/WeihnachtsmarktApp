package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener {
    Button bBesucher;
    Button bStandbesitzer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bBesucher = (Button) findViewById(R.id.bBesucher);
        bBesucher.setOnClickListener(this);
        bStandbesitzer = (Button) findViewById(R.id.bStandbesitzer);
        bStandbesitzer.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.bBesucher:
                Intent intentBesucher = new Intent(this, Besucher2Activity.class);
                startActivity(intentBesucher);
                this.finish();
                break;
            case R.id.bStandbesitzer:
                Intent intentStandbesitzer = new Intent(this, Registrierung.class);
                startActivity(intentStandbesitzer);
                this.finish();
                break;
        }
    }
}
