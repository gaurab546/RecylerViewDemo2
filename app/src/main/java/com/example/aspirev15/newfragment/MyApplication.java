package com.example.aspirev15.newfragment;

import android.app.Application;
import android.graphics.Typeface;

/**
 * Created by Aspire V15 on 12/11/2016.
 */

public class MyApplication extends Application {
   public static Typeface font;
    @Override
    public void onCreate() {
        super.onCreate();
        initfont();
    }

    private void initfont(){
        font=Typeface.createFromAsset(getAssets(),"font/green_avocado.ttf");
    }
}
