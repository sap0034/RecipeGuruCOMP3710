package edu.auburn.eng.csse.comp3710.a2b2b.recipeguruapplication.util;

import android.content.ContextWrapper;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;

public class PhoneCallListener extends PhoneStateListener {
ContextWrapper context;
        private boolean isPhoneCalling = false;

        // needed for logging
        String TAG = "PhoneCallListener";

        @Override
        public void onCallStateChanged(int state, String incomingNumber) {

            if (TelephonyManager.CALL_STATE_RINGING == state) {
                // phone ringing
                Log.i(TAG, "RINGING, number: " + incomingNumber);
            }

            if (TelephonyManager.CALL_STATE_OFFHOOK == state) {
                // active
                Log.i(TAG, "OFFHOOK");

                isPhoneCalling = true;
            }

            if (TelephonyManager.CALL_STATE_IDLE == state) {
                // run when class initial and phone call ended,
                // need detect flag from CALL_STATE_OFFHOOK
                Log.i(TAG, "IDLE");

                if (isPhoneCalling) {

                    Log.i(TAG, "restart app");

                    // restart call application
                    Intent i = context.getBaseContext().getPackageManager()
                            .getLaunchIntentForPackage(
                                    context.getBaseContext().getPackageName());
                    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK
                            | Intent.FLAG_ACTIVITY_CLEAR_TOP
                            | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                    context.startActivity(i);

                    isPhoneCalling = false;
                }

            }


        }
    }

