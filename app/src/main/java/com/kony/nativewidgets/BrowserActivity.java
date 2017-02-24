package com.kony.nativewidgets;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class BrowserActivity extends Activity {
    private String LOG_TAG="Kony";
    Intent mIntent = null;
    EditText mEditText = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browser);
        mEditText = (EditText) findViewById(R.id.ed_url);
        mEditText.setText("http://www.plus2net.com/html_tutorial/html_calendar.php"); //http://docs.google.com/gview?embedded=true&url=file:///android_asset/DailyStatus.docx
        //gdocs https://docs.google.com/gview?url=http://www.dbs.com.hk/iwov-resources/pdf/en/terms.pdf&embedded=true
    }

    public void onBtnStaticContentBrowserClick(View v) {
        mIntent = new Intent(getApplicationContext(),WebViewActivity.class);
        mIntent.putExtra("ContentType","StaticContent");
        mIntent.putExtra("URL","");
        startActivity(mIntent);

    }

    public void onBtnDynamicContentBrowserClick(View v) {
        mIntent = new Intent(getApplicationContext(),WebViewActivity.class);
        mIntent.putExtra("ContentType","DynamicContent");
        startActivity(mIntent);
    }

    public void onBtnGoClick(View v) {
       String text =  mEditText.getText().toString();
    /*    try {
            URL url = new URL(text);
            Log.i(LOG_TAG,"URL Validation :: "+url.toURI());

        } catch (MalformedURLException e) {
            Log.i(LOG_TAG,"MalformedURLException :: "+e.getMessage());
        } catch (URISyntaxException e) {
            Log.i(LOG_TAG,"URISyntaxException :: "+e.getMessage());
        }*/
        if(text!=null && !text.isEmpty()) {
            mIntent = new Intent(getApplicationContext(), WebViewActivity.class);
            mIntent.putExtra("ContentType", "DynamicContent");
            mIntent.putExtra("URL", text);
            startActivity(mIntent);
        } else {
            Toast.makeText(getApplicationContext(),"Empty Text is not allowed ",Toast.LENGTH_LONG).show();
        }
    }
}
