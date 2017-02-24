package com.kony.nativewidgets;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by KH2195 on 1/23/2017.
 */
public class AlertActivity extends Activity {
    String message = "Hi Kony WelcometoKonyLabsHyderabadAndhraPradeshJohnhereTest";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
    }

    public void onBtnAlertNeutralClick(View v) {
        AlertDialog alertDialog = new AlertDialog.Builder(AlertActivity.this).create();
        alertDialog.setTitle("Native");
        alertDialog.setMessage(message);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        /*Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();*/
                    }
                });

        alertDialog.show();
    }
}
