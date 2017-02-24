package com.kony.nativewidgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by KH2195 on 10/12/2016.
 */
public class AdvanceWidgetsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advance_widgets);
    }

    public void onBtnBrowserClick(View v) {
        Intent intent = new Intent(getApplicationContext(),BrowserActivity.class);
        startActivity(intent);
    }

    public void onBtnMapClick(View v) {
        Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
        startActivity(intent);
    }
}
