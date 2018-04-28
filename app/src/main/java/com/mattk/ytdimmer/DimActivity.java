package com.mattk.ytdimmer;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class DimActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = getWindow();

        setContentView(R.layout.activity_dim);

        //Background of Dialog dimmed to 0x000000 with 1.0f
        WindowManager.LayoutParams layoutParams = window.getAttributes();

        //set this between 0.f and 1.f (1.f 100% dimmed, 0.f 0% dimmed)
        layoutParams.dimAmount = 1.f;

        window.setAttributes(layoutParams);

        //Hide statusbar
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    //Ignore any touch input, exit dimmed mode with backbutton
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    private boolean firstPressOccured = false;

    //2xBackPressed to close the activity
    @Override
    public void onBackPressed() {

        if(firstPressOccured) super.onBackPressed();
        else {

            firstPressOccured = true;

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(200);
                        firstPressOccured = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
