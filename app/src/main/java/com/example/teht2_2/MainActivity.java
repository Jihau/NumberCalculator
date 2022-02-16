package com.example.teht2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Counter2 hitCounter;
    Counter2 viewCounter;
    Counter2 creationCounter;

    private String lastCreateSaved;
    private String lastVisibleSaved;
    private String lastHitSaved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("check", "Creating");

        SharedPreferences prefGet = getSharedPreferences("savedInfo",Activity.MODE_PRIVATE);
        String lastCreationSaved = prefGet.getString("myCreation", "0");
        String lasHit = prefGet.getString("myHit", "0");
        String lastVisibilitySaved = prefGet.getString("myVisible", "0");

        creationCounter = new Counter2(Integer.valueOf(lastCreationSaved), 100, -100, 1);
        hitCounter = new Counter2(Integer.valueOf(lasHit), 100, -100, 1);
        viewCounter = new Counter2(Integer.valueOf(lastVisibilitySaved), 100, -100, 1);

        String createNumber = Integer.toString(creationCounter.getValue());
        String hitNumber = Integer.toString(hitCounter.getValue());
        String visibleNumber = Integer.toString(viewCounter.getValue());

        TextView tvCreate = findViewById(R.id.textViewCreate);
        TextView tvHit = findViewById(R.id.textViewHit);
        TextView tvVisible = findViewById(R.id.textViewVisible);

        creationCounter.getPlus();
        String creation = Integer.toString(creationCounter.getValue());
        tvCreate.setText(creation);
        tvHit.setText(lasHit);
        tvVisible.setText(lastVisibilitySaved);
    }
    public void onStart() {
        super.onStart();
        Log.d("check", "Starting");
        viewCounter.getPlus();
        TextView tvVisible = findViewById(R.id.textViewVisible);
        String visibleNumber = Integer.toString(viewCounter.getValue());
        tvVisible.setText(visibleNumber);
    }

    public void onResume() {
        super.onResume();
        Log.d("check", "Resuming");
    }

    public void onPause() {
        super.onPause();
        lastHitSaved = Integer.toString(hitCounter.getValue());
        lastCreateSaved = Integer.toString(creationCounter.getValue());
        lastVisibleSaved = Integer.toString(viewCounter.getValue());
        SharedPreferences prefPut = getSharedPreferences("savedInfo", Activity.MODE_PRIVATE);
        SharedPreferences.Editor prefEditor = prefPut.edit();
        prefEditor.putString("myHit", lastHitSaved);
        prefEditor.putString("myCreation", lastCreateSaved);
        prefEditor.putString("myVisible", lastVisibleSaved);
        prefEditor.commit();
        Log.d("check", "Pausing");
    }

    public void onStop() {
        super.onStop();
        Log.d("check", "Stopping");
    }

    public void onRestart() {
        super.onRestart();
        Log.d("check", "Restarting");
    }

    public void onDestroy() {
        super.onDestroy();
        Log.d("check", "Destroying everything");
    }

    public void OnClick(View v) {
        TextView tvHit = findViewById(R.id.textViewHit);
        String hitNumber;
        switch (v.getId()) {
            case R.id.hitButton:
                hitCounter.getPlus();
                hitNumber = Integer.toString(hitCounter.getValue());
                tvHit.setText(hitNumber);
                break;
            case R.id.resetbutton:
                hitCounter.getReset();
                viewCounter.getReset();
                creationCounter.getReset();
                TextView tvCreate = findViewById(R.id.textViewCreate);
                String createNumber = Integer.toString(creationCounter.getValue());
                tvCreate.setText(createNumber);
                TextView tvVisible = findViewById(R.id.textViewVisible);
                String visibleNumber = Integer.toString(viewCounter.getValue());
                tvVisible.setText(visibleNumber);
                hitNumber = Integer.toString(hitCounter.getValue());
                tvHit.setText(hitNumber);
                break;
        }
    }
}


