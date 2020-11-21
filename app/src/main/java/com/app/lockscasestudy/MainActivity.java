package com.app.lockscasestudy;


import static com.app.lockscasestudy.ThreadColor.ANSI_BLUE;
import static com.app.lockscasestudy.ThreadColor.ANSI_RED;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Worker worker1 = new Worker("John", true, ANSI_BLUE);
        Worker worker2 = new Worker("Mary", true, ANSI_RED);

        SharedResource sharedResource = new SharedResource(worker1);

        new Thread(new Runnable() {
            @Override
            public void run() {
                worker1.work(sharedResource, worker2, getApplicationContext());
            }
        }).start();

        new Thread(new Runnable(){
            @Override
            public void run(){
                worker2.work(sharedResource, worker1, getApplicationContext());
            }
        }).start();

    }
}

