package com.tyler.tlock.tlock.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tyler.tlock.tlock.R;

public class LockActivity extends AppCompatActivity implements LockView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lock);
    }
}
