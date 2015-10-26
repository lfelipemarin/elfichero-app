package co.org.elfichero.appelfichero.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

import elfichero.org.co.appelfichero.R;

/**
 * Created by dorian.jaramillo on 22/10/15.
 */

public class Carga extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carga);

        new CountDownTimer(1000, 1000) {
            public void onTick(long millisUntilFinished) {
            }
            public void onFinish() {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
            }
        }.start();
    }

}
