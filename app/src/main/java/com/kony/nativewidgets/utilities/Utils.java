package com.kony.nativewidgets.utilities;

/**
 * Created by KH2195 on 10/4/2016.
 */

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by johnvinodhtalluri on 31/07/16.
 */
public class Utils {
    private Context mContext = null;

    public Utils(Context pContext) {
        mContext = pContext;
    }

    /**
     * convert input stream to string
     *
     * @param inputStream Inputstream from server
     * @return the string
     */
    public static String convertInputStreamToString(InputStream inputStream) throws IOException
    {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String res = "";

        while ((line = bufferedReader.readLine()) != null) {
            res += line;
        }

        inputStream.close();
        return res;
    }
}
