package com.kony.nativewidgets;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.kony.nativewidgets.utilities.HTTPAsyncTask;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutionException;

public class BasicWidgetsActivity extends Activity {
    Intent mIntent = null;
    EditText edServiceURL=null;
    private String LOG_TAG="Kony";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_widgets);
        edServiceURL = (EditText) findViewById(R.id.ed_surl);

    }

    public void onServiceCallClick(View v) {

        HTTPAsyncTask mHttpAsyncTask = new HTTPAsyncTask(null,true,"servicecall");
        String url = edServiceURL.getText().toString();
       // String url = "https://28e6e8be.ngrok.io/api/v1/getTAndC?language={name:English(India),language:en,country:IN}&language={name:English(India),language:en,country:IN}";
        //String url2 = "https://api.myjson.com/bins/r8qm";
        if(url!=null &&!url.isEmpty()) {
            try {
                String response = mHttpAsyncTask.execute(new URL(url)).get();
                Toast.makeText(getApplicationContext(), "Response :: " + response, Toast.LENGTH_LONG).show();
            } catch (MalformedURLException e) {
                Log.e(LOG_TAG,"MalformedURLException :: "+e.getMessage());
                Toast.makeText(getApplicationContext(),"MalformedURLException :: "+e.getMessage(), Toast.LENGTH_LONG).show();
            } catch (InterruptedException e) {
                Log.e(LOG_TAG,"InterruptedException :: "+e.getMessage());
                Toast.makeText(getApplicationContext(),"InterruptedException :: "+e.getMessage(), Toast.LENGTH_LONG).show();
            } catch (ExecutionException e) {
                Log.e(LOG_TAG,"ExecutionException :: "+e.getMessage());
                Toast.makeText(getApplicationContext(),"ExecutionException :: "+e.getMessage(), Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "A Service Call Can't be done on a Empty URL", Toast.LENGTH_LONG).show();
        }
    }

    public void onBtnButtonClick(View v) {
        mIntent = new Intent(getApplicationContext(),ButtonActivity.class);
        startActivity(mIntent);
    }

    public void onBtnEditTexClick(View v) {
        mIntent = new Intent(getApplicationContext(),EditTextActivity.class);
        startActivity(mIntent);
    }

    public void onBtnTextViewClick(View v) {
        mIntent = new Intent(getApplicationContext(),TextViewActivity.class);
        startActivity(mIntent);
    }

    public void onBtnCheckBoxClick(View v) {
        mIntent = new Intent(getApplicationContext(),CheckBoxActivity.class);
        startActivity(mIntent);
    }

    public void onBtnCalendarClick(View v) {
        mIntent = new Intent(getApplicationContext(),CalendarActivity.class);
        startActivity(mIntent);
    }

    public void onBtnToggleButtonClick(View v) {
        mIntent = new Intent(getApplicationContext(),ToggleButtonActivity.class);
        startActivity(mIntent);
    }

    public void onBtnSpinnerClick(View v) {
        mIntent = new Intent(getApplicationContext(),SpinnerActivity.class);
        startActivity(mIntent);
    }

    public void onBtnLinkClick(View v) {
        mIntent = new Intent(getApplicationContext(),LinkActivity.class);
        startActivity(mIntent);
    }

    public void onBtnTableLayoutClick(View v) {
        mIntent = new Intent(getApplicationContext(),TableLayoutActivity.class);
        startActivity(mIntent);
    }

    public void onBtnAlertClick(View view) {
        mIntent = new Intent(getApplicationContext(),AlertActivity.class);
        startActivity(mIntent);
    }
}
