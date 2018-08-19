package com.birdpeek.myapplication;

import android.Manifest;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.multidex.MultiDex;
import android.util.Log;

//import com.newtronlabs.easypermissions.EasyPermissions;
//import com.newtronlabs.easypermissions.listener.IPermissionsListener;

import com.newtronlabs.easypermissions.EasyPermissions;
import com.newtronlabs.easypermissions.listener.IPermissionsListener;

import java.util.List;
import java.util.Set;


public class MyApp extends Application implements IPermissionsListener {
//public class MyApp extends Application implements EasyPermissions.PermissionCallbacks{
    private final static String TAG = "allMy";
    private static final int RC_SMS_PERM = 122;
    private static final int RC_CAMERA_AND_LOCATION = 123;
    String[] perms = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.CAMERA,
            Manifest.permission.CALL_PHONE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
    };

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

//    @AfterPermissionGranted(RC_CAMERA_AND_LOCATION)
    @Override
    public void onCreate() {
        super.onCreate();
        // Request as many permissions as you like.
        // Make sure that these permissions are in your Manifest as well.
        EasyPermissions.getInstance().requestPermissions(this, this,
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.CAMERA,
                Manifest.permission.CALL_PHONE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
/*        if (!EasyPermissions.hasPermissions(getApplicationContext(), perms)) {
            // Request one permission
            *//*EasyPermissions.requestPermissions((Activity) getApplicationContext(), getString(R.string.rationale_question),
                    RC_SMS_PERM, Manifest.permission.READ_SMS);*//*
            EasyPermissions.requestPermissions(
                    new PermissionRequest.Builder((Activity) getApplicationContext(), RC_CAMERA_AND_LOCATION, perms)
                            .setRationale(R.string.rationale_question)
                            .setPositiveButtonText(R.string.rationale_ask_ok)
                            .setNegativeButtonText(R.string.rationale_ask_cancel)
                            .setTheme(R.style.Theme_Design_Light)
                            .build());
        }*/
    }


    @Override
    public void onRequestSent(Set<String> set) {
        Log.d(TAG, "onRequestSent: ");
    }

    @Override
    public void onFailure() {
        Log.d(TAG, "onFailure: ");
    }

    @Override
    public void onCompleted(Set<String> set, Set<String> set1) {
        Log.d(TAG, "onCompleted: ");

    }
}
