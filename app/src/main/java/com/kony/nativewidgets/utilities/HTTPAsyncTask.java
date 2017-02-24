package com.kony.nativewidgets.utilities;

import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by KH2195 on 10/4/2016.
 */

public class HTTPAsyncTask extends AsyncTask<URL,Void,String> {


    private String mData = "",
            mResult = "",
            mReqMethod = "",
            mServiceCall = "",
            LOG_TAG="HTTPAsyncTask";
    private HttpURLConnection mConnection = null;
    private InputStream mInStream = null;
    private int mRespCode = 0;

    public HTTPAsyncTask(String pData,boolean pIsGet, String pServiceCall) {
        mData = pData;
        mServiceCall = pServiceCall;
        mReqMethod = pIsGet? "GET" :"POST";
    }


    @Override
    protected String doInBackground(URL... urls) {

        try {
            mConnection = (HttpURLConnection)urls[0].openConnection();
            mConnection.setReadTimeout(60000);
            mConnection.setConnectTimeout(60000);

            if(mReqMethod.equalsIgnoreCase("POST")) {
                mConnection.setDoOutput(true);
            } else {
                mConnection.setDoInput(true);
            }
            mConnection.setRequestMethod(mReqMethod);
            mConnection.setRequestProperty("Connection", "Keep-Alive");
            mConnection.setRequestProperty("Content-Type", "application/json");

            if(mData !=null && !mData.isEmpty() && mReqMethod.equalsIgnoreCase("POST")) {
                OutputStream os = mConnection.getOutputStream();
                os.write(mData.getBytes());
                os.flush();
            }
            mRespCode = mConnection.getResponseCode();
            mInStream = (mRespCode == 200 || mRespCode == 201) ? mConnection.getInputStream(): mConnection.getErrorStream();
            mResult = Utils.convertInputStreamToString(mInStream);
            Log.i("Kony","Response :: "+mResult);
        } catch(MalformedURLException me) {
            Log.i(LOG_TAG, "MalformedURLException :: " + me.getMessage());
        } catch (IOException e) {
            Log.i(LOG_TAG,"IOException :: "+e.getMessage());
        } catch(Exception e) {
            Log.i(LOG_TAG, "Generic exception :: " + e.getMessage());
        } finally {

            if (mConnection != null) {
                mConnection.disconnect();
            }
        }
        return mResult;
    }

    @Override
    protected void onPostExecute(String pResult) {

    }
}

