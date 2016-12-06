package com.example.jvelez.pricecrash;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashPriceCrash extends AwesomeSplash {

//DO NOT OVERRIDE onCreate()!
    //if you need to start some services do it in initSplash()!


    public static final String LOGO = "M 16.50,200.02\n" +
            "           C 22.91,191.48 21.08,188.11 21.00,178.00\n" +
            "             21.00,178.00 21.00,61.00 21.00,61.00\n" +
            "             21.00,61.00 21.00,39.00 21.00,39.00\n" +
            "             21.00,39.00 20.15,26.60 20.15,26.60\n" +
            "             21.36,24.62 25.96,25.00 28.00,25.00\n" +
            "             28.00,25.00 35.00,25.00 35.00,25.00\n" +
            "             33.75,32.88 31.06,29.10 31.00,40.00\n" +
            "             30.94,51.31 29.57,64.34 33.41,75.00\n" +
            "             34.51,78.05 35.60,82.38 38.22,84.40\n" +
            "             39.85,85.65 49.47,87.55 52.00,88.00\n" +
            "             52.00,88.00 52.00,79.00 52.00,79.00\n" +
            "             51.86,67.59 47.24,59.29 61.00,54.00\n" +
            "             61.00,54.00 61.00,52.00 61.00,52.00\n" +
            "             61.00,52.00 49.00,50.00 49.00,50.00\n" +
            "             50.55,46.10 54.48,43.83 58.53,45.99\n" +
            "             60.30,46.94 61.51,49.74 63.88,48.06\n" +
            "             67.02,45.84 67.31,36.03 74.04,32.14\n" +
            "             77.86,29.93 84.63,29.29 89.00,28.72\n" +
            "             106.88,26.39 105.12,26.39 123.00,28.72\n" +
            "             127.24,29.27 135.45,30.04 138.81,32.58\n" +
            "             142.98,35.73 145.69,44.04 147.00,49.00\n" +
            "             152.15,46.54 159.26,40.85 161.00,51.00\n" +
            "             161.00,51.00 150.00,51.00 150.00,51.00\n" +
            "             153.31,56.33 158.61,55.21 160.61,64.00\n" +
            "             161.66,68.61 160.18,75.24 159.58,80.00\n" +
            "             159.34,81.93 158.82,84.78 160.60,86.27\n" +
            "             162.08,87.37 164.33,86.62 166.00,86.27\n" +
            "             174.93,84.89 174.73,83.34 177.51,75.00\n" +
            "             181.43,63.24 180.08,50.29 180.00,38.00\n" +
            "             179.93,28.09 177.17,32.10 176.00,25.00\n" +
            "             176.00,25.00 192.00,25.00 192.00,25.00\n" +
            "             191.20,32.81 190.02,29.85 190.00,40.00\n" +
            "             190.00,40.00 190.00,96.00 190.00,96.00\n" +
            "             190.00,96.00 190.00,185.00 190.00,185.00\n" +
            "             190.01,192.58 191.05,195.85 196.04,201.86\n" +
            "             198.57,204.90 200.51,204.32 202.00,208.00\n" +
            "             192.93,207.37 187.38,206.27 178.00,208.00\n" +
            "             178.00,208.00 177.00,205.00 177.00,205.00\n" +
            "             180.72,202.51 179.99,200.15 180.00,196.00\n" +
            "             180.00,196.00 180.00,176.00 180.00,176.00\n" +
            "             180.00,176.00 180.00,91.00 180.00,91.00\n" +
            "             180.00,91.00 163.11,93.60 163.11,93.60\n" +
            "             162.11,94.01 161.43,94.47 160.74,95.31\n" +
            "             157.66,99.06 160.69,103.60 157.60,106.01\n" +
            "             155.05,108.00 144.68,107.00 141.00,107.00\n" +
            "             141.00,104.05 141.43,98.81 139.26,96.60\n" +
            "             137.65,94.95 135.13,95.04 133.00,95.00\n" +
            "             133.00,95.00 105.00,95.00 105.00,95.00\n" +
            "             102.98,95.01 100.15,94.87 98.42,96.02\n" +
            "             96.19,97.50 95.30,101.09 94.84,103.58\n" +
            "             93.21,112.18 96.08,119.20 106.00,119.00\n" +
            "             106.00,119.00 111.00,123.00 111.00,123.00\n" +
            "             111.00,123.00 111.73,108.06 111.73,108.06\n" +
            "             112.56,102.31 119.33,105.11 119.18,109.09\n" +
            "             119.06,112.26 115.01,115.28 114.00,123.00\n" +
            "             115.82,122.10 121.15,118.92 122.19,122.33\n" +
            "             122.77,124.22 120.76,128.13 120.06,130.00\n" +
            "             118.99,132.88 116.50,143.25 116.81,146.00\n" +
            "             116.81,146.00 124.00,177.00 124.00,177.00\n" +
            "             124.00,177.00 127.04,194.00 127.04,194.00\n" +
            "             127.04,194.00 127.04,203.00 127.04,203.00\n" +
            "             127.04,203.00 129.00,210.00 129.00,210.00\n" +
            "             129.00,210.00 125.00,210.00 125.00,210.00\n" +
            "             125.00,210.00 120.18,197.00 120.18,197.00\n" +
            "             117.59,189.00 115.31,174.37 109.11,169.00\n" +
            "             106.88,177.74 109.10,178.36 109.11,186.00\n" +
            "             109.11,186.00 109.11,195.00 109.11,195.00\n" +
            "             109.35,203.89 111.02,208.46 100.00,209.00\n" +
            "             101.00,207.42 102.74,205.69 103.12,203.87\n" +
            "             103.12,203.87 101.09,189.00 101.09,189.00\n" +
            "             101.09,189.00 100.00,168.00 100.00,168.00\n" +
            "             100.00,168.00 99.34,158.00 99.34,158.00\n" +
            "             99.34,158.00 100.00,145.00 100.00,145.00\n" +
            "             100.00,145.00 102.23,127.10 102.23,127.10\n" +
            "             101.56,124.79 99.22,123.33 97.59,121.65\n" +
            "             92.31,116.20 90.15,115.26 87.00,108.00\n" +
            "             87.00,108.00 88.00,107.00 88.00,107.00\n" +
            "             88.00,107.00 92.00,108.00 92.00,108.00\n" +
            "             92.00,108.00 91.00,104.00 91.00,104.00\n" +
            "             91.00,104.00 94.00,101.00 94.00,101.00\n" +
            "             94.00,101.00 90.00,103.00 90.00,103.00\n" +
            "             90.00,103.00 89.00,102.00 89.00,102.00\n" +
            "             89.00,102.00 95.00,96.01 95.00,96.01\n" +
            "             91.13,95.06 76.43,93.94 73.31,96.01\n" +
            "             69.88,98.31 71.87,103.01 69.98,105.40\n" +
            "             68.25,107.58 61.68,107.04 59.00,107.00\n" +
            "             57.04,106.96 54.53,107.15 53.17,105.43\n" +
            "             51.03,102.70 53.14,97.41 50.40,94.74\n" +
            "             48.33,92.71 44.66,93.19 42.00,92.74\n" +
            "             34.80,91.53 31.03,88.25 31.00,101.00\n" +
            "             31.00,101.00 31.00,205.00 31.00,205.00\n" +
            "             31.00,205.00 35.00,205.00 35.00,205.00\n" +
            "             32.54,208.26 29.88,207.04 26.00,207.00\n" +
            "             19.43,206.94 16.53,206.85 10.00,208.00\n" +
            "             10.00,208.00 9.00,205.00 9.00,205.00\n" +
            "             13.50,204.25 13.79,203.62 16.50,200.02 Z\n" +
            "           M 137.56,34.88\n" +
            "           C 133.20,31.19 119.74,30.21 114.00,29.96\n" +
            "             114.00,29.96 105.00,29.08 105.00,29.08\n" +
            "             98.75,29.08 79.82,31.02 75.10,34.56\n" +
            "             70.50,38.02 67.58,46.44 67.00,52.00\n" +
            "             80.57,49.53 94.21,47.98 108.00,48.00\n" +
            "             108.00,48.00 129.00,49.43 129.00,49.43\n" +
            "             134.57,50.23 139.37,51.91 145.00,51.00\n" +
            "             144.17,46.40 141.17,37.93 137.56,34.88 Z\n" +
            "           M 54.20,66.00\n" +
            "           C 54.32,67.64 54.91,69.04 56.31,69.98\n" +
            "             58.34,71.33 63.50,71.00 66.00,71.00\n" +
            "             68.18,71.00 71.85,71.21 73.69,69.98\n" +
            "             77.04,67.73 75.85,62.40 71.89,60.17\n" +
            "             69.22,58.67 65.92,59.02 63.00,59.29\n" +
            "             58.89,59.99 53.80,60.48 54.20,66.00 Z\n" +
            "           M 158.12,64.13\n" +
            "           C 156.96,60.04 147.69,58.68 144.00,59.16\n" +
            "             136.87,60.09 135.79,67.75 138.60,69.98\n" +
            "             140.07,71.15 143.19,70.99 145.00,71.00\n" +
            "             145.00,71.00 149.00,71.00 149.00,71.00\n" +
            "             153.21,70.95 153.95,70.73 158.12,70.00\n" +
            "             158.19,68.41 158.70,65.61 158.12,64.13 Z\n" +
            "           M 92.00,112.00\n" +
            "           C 92.00,112.00 93.00,113.00 93.00,113.00\n" +
            "             93.00,113.00 93.00,112.00 93.00,112.00\n" +
            "             93.00,112.00 92.00,112.00 92.00,112.00 Z";


    @Override
    public void initSplash(ConfigSplash configSplash) {
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

            /* you don't have to override every property */

        //Customize Circular Reveal
        configSplash.setBackgroundColor(R.color.primary_darker); //any color you want form colors.xml
        configSplash.setAnimCircularRevealDuration(1000); //int ms
        configSplash.setRevealFlagX(Flags.REVEAL_LEFT);  //or Flags.REVEAL_RIGHT
        configSplash.setRevealFlagY(Flags.REVEAL_BOTTOM); //or Flags.REVEAL_TOP

        //Choose LOGO OR PATH; if you don't provide String value for path it's logo by default

        //Customize Logo
        /*
        configSplash.setLogoSplash(R.mipmap.ic_launcher); //or any other drawable
        configSplash.setAnimLogoSplashDuration(1000); //int ms
        configSplash.setAnimLogoSplashTechnique(Techniques.Bounce); //choose one form Techniques (ref: https://github.com/daimajia/AndroidViewAnimations)
        */

        //Customize Path
        configSplash.setPathSplash(LOGO); //set path String
        //configSplash.setPathSplash(SyncStateContract.Constants.DATA); //set path String
        //configSplash.setOriginalHeight(190); //in relation to your svg (path) resource--OUR_LOGO
        //configSplash.setOriginalWidth(297); //in relation to your svg (path) resource--OUR_LOGO
        configSplash.setOriginalHeight(200); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(200); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(2000);
        configSplash.setPathSplashStrokeSize(3); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.yellowlight); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(3000);
        configSplash.setPathSplashFillColor(R.color.beige); //path object filling color


        //Customize Title
        configSplash.setTitleSplash("pricecrash");
        configSplash.setTitleTextColor(R.color.beige);
        configSplash.setTitleTextSize(40f); //float value
        configSplash.setAnimTitleDuration(2000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
        //configSplash.setTitleFont("fonts/DINPro-Light_13935.ttf"); //provide string to your font located in assets/fonts/

    }

    @Override
    public void animationsFinished() {

        //transit to another activity here or do whatever you want
        if (checkIfLogged()){
            Intent intent = new Intent(SplashPriceCrash.this,QuoteActivity.class);
            startActivity(intent);
        }else {
            Intent intent = new Intent(SplashPriceCrash.this,Login.class);
            startActivity(intent);
        }
    }

    private boolean checkIfLogged() {
        boolean valueToReturn = false;
        SharedPreferences sharedPreferences = getSharedPreferences("infoapp", Context.MODE_PRIVATE);
        String str = sharedPreferences.getString("logged","");
        if (str.equals("true")){
            valueToReturn = true;
        }

        return valueToReturn;
    }
}
