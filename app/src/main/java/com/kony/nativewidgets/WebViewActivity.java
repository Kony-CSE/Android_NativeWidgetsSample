package com.kony.nativewidgets;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by KH2195 on 10/12/2016.
 */
public class WebViewActivity extends Activity {

    WebView mWebView = null;
    String url = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        mWebView = (WebView) findViewById(R.id.webview);

        WebSettings webViewSettings =  mWebView.getSettings();
        webViewSettings.setJavaScriptEnabled(true);
        webViewSettings.setDomStorageEnabled(true);
        webViewSettings.setAllowFileAccess(true);
        webViewSettings.setAllowUniversalAccessFromFileURLs(true);
       final  Activity activity = this;
        mWebView.setWebChromeClient(new CustomWebChromeClient(activity));
        mWebView.setWebViewClient(new WebViewClient() {
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Toast.makeText(activity, "Oh no! " + description, Toast.LENGTH_SHORT).show();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String value = extras.getString("ContentType");
            url = extras.getString("URL");
            loadWebView(value);
        }
    }

    private void loadWebView(String value) {
        if(value.equalsIgnoreCase("StaticContent")) {
            Toast.makeText(getApplicationContext(),"Static Content it is",Toast.LENGTH_LONG).show();
        } else if(value.equalsIgnoreCase("DynamicContent")) {
           // Toast.makeText(getApplicationContext(),"Dynamic Content it is",Toast.LENGTH_LONG).show();
           // mWebView.loadUrl("http://10.10.3.98:8080/neo/ModifyCustomerDSD-StartPage.htm");
            mWebView.loadUrl(url);
        }
    }
}
