package sg.edu.np.mad.IntoTheUnknown;

import androidx.annotation.MainThread;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        countDownTimer();
    }

    //create timer of time 2 seconds, after 2 seconds user to view searchPage class
    private void countDownTimer(){
        CountDownTimer cdt = new CountDownTimer(2000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(MainActivity.this, searchPage.class);
                startActivity(intent);
                finish();
            }
        };
        cdt.start();
    }
}
//To Do:
//create timer of time 2 seconds, after 2 seconds user to view searchPage class