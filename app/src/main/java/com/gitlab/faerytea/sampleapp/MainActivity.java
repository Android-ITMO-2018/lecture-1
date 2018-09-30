package com.gitlab.faerytea.sampleapp;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("SetTextI18n")
public class MainActivity extends AppCompatActivity {
    private static String LOG_TAG = "MainActivity";
    private static String CNT = MainActivity.class.getName() + ".cnt";
    private static String USER = MainActivity.class.getName() + ".usr";

    private EditText name;
    private EditText age;
    private TextView inc;
    private TextView dec;

    private int cnt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView result = findViewById(R.id.result);

        name = findViewById(R.id.name);
        age = findViewById(R.id.age);

        inc = findViewById(R.id.inc);
        dec = findViewById(R.id.dec);

        result.setOnClickListener(v -> {
            inc.setText(name.getText());
            dec.setText(age.getText());
        });

        inc.setOnClickListener(v -> result.setText(Integer.toString(++cnt)));

        dec.setOnClickListener(v -> result.setText(Integer.toString(--cnt)));


        if (savedInstanceState != null) {
            cnt = savedInstanceState.getInt(CNT);
            result.setText(Integer.toString(cnt));
            User user = savedInstanceState.getParcelable(USER);
            if (user != null) {
                inc.setText(user.name);
                dec.setText(Integer.toString(user.age));
            }
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(CNT, cnt);
        try {
            outState.putParcelable(USER, new User(Integer.parseInt(age.getText().toString()), name.getText().toString()));
        } catch (NumberFormatException ignored) {
            // ignore
        }

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "onStart: ");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "onPause: ");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(LOG_TAG, "onRestart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "onDestroy: ");
    }
}
