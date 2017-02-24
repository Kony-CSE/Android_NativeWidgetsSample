package com.kony.nativewidgets;

import android.app.Activity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by KH2195 on 10/13/2016.
 */
public class CustomWebChromeClient extends WebChromeClient {

    Activity mActivity = null;
    public  CustomWebChromeClient(Activity pActivity) {
        mActivity = pActivity;
    }
    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
        mActivity.setProgress(newProgress*1000);
    }
}
