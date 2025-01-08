package lk.example.activitylifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("LifeCycle 1", "onCreate");

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(i);
            }
        });

        Button button1 = findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView textView = findViewById(R.id.textView);
                textView.setText("hello");

            }
        });

    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle b) {
        super.onSaveInstanceState(b);
        TextView textView = findViewById(R.id.textView);
        b.putString("text1", textView.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle b) {
        super.onRestoreInstanceState(b);
        TextView textView = findViewById(R.id.textView);
        textView.setText(b.getString("text1"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("LifeCycle 1", "onStart");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("LifeCycle 1", "onResume");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("LifeCycle 1", "onPause");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("LifeCycle 1", "onStop");

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("LifeCycle 1", "onRestart");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("LifeCycle 1", "onDestroy");

    }

}