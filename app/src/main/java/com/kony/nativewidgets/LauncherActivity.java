package com.kony.nativewidgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LauncherActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    public void onBtnBasicWidgetsClick(View v) {
        Intent intent = new Intent(getApplicationContext(),BasicWidgetsActivity.class);
        startActivity(intent);
    }

    public void onBtnAdvanceWidgetsClick(View v) {
        Intent intent = new Intent(getApplicationContext(),AdvanceWidgetsActivity.class);
        startActivity(intent);
    }
}
