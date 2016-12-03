package com.example.jvelez.pricecrash;

import android.content.Intent;
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

import com.daimajia.androidanimations.library.Techniques;
import com.viksaa.sssplash.lib.activity.AwesomeSplash;
import com.viksaa.sssplash.lib.cnst.Flags;
import com.viksaa.sssplash.lib.model.ConfigSplash;

public class SplashPriceCrash extends AwesomeSplash {

//DO NOT OVERRIDE onCreate()!
    //if you need to start some services do it in initSplash()!


    public static final String OUR_LOGO = "M 187.00,112.00\n" +
            "           C 187.00,112.00 186.00,128.00 186.00,128.00\n" +
            "             178.28,127.57 176.24,124.77 173.09,124.84\n" +
            "             169.10,124.93 163.93,134.43 163.57,138.00\n" +
            "             163.41,139.69 163.84,141.43 164.48,142.98\n" +
            "             167.69,150.73 173.08,146.41 176.40,149.02\n" +
            "             178.44,150.62 178.15,155.16 178.81,157.58\n" +
            "             179.84,161.38 182.22,162.63 183.41,166.00\n" +
            "             184.20,168.25 184.00,172.50 184.00,175.00\n" +
            "             186.59,172.41 191.34,168.05 193.00,165.00\n" +
            "             193.00,165.00 195.00,160.13 195.00,160.13\n" +
            "             196.54,157.57 198.99,156.65 199.89,154.74\n" +
            "             201.87,149.58 189.07,137.83 199.89,134.52\n" +
            "             201.03,134.38 201.96,134.28 203.00,134.52\n" +
            "             204.79,134.52 206.38,135.32 208.00,136.00\n" +
            "             208.67,128.60 213.24,119.88 221.00,117.72\n" +
            "             224.01,116.98 226.06,118.22 230.00,117.72\n" +
            "             230.00,117.72 240.00,115.09 240.00,115.09\n" +
            "             240.00,115.09 263.00,115.09 263.00,115.09\n" +
            "             265.07,115.00 268.08,114.89 270.00,115.60\n" +
            "             277.20,118.28 279.78,129.49 283.39,132.40\n" +
            "             287.17,135.45 293.31,132.76 296.57,135.02\n" +
            "             298.94,136.66 301.46,143.63 291.00,144.00\n" +
            "             293.38,147.45 295.76,150.01 297.29,154.00\n" +
            "             299.90,160.86 299.14,177.09 299.00,185.00\n" +
            "             298.96,187.14 299.04,189.77 297.40,191.40\n" +
            "             294.94,193.86 281.94,193.62 279.31,191.40\n" +
            "             276.99,189.44 277.10,186.75 277.00,184.00\n" +
            "             277.00,184.00 217.00,184.00 217.00,184.00\n" +
            "             217.00,184.00 207.00,184.59 207.00,184.59\n" +
            "             207.00,184.59 198.00,188.83 198.00,188.83\n" +
            "             198.00,188.83 183.00,177.00 183.00,177.00\n" +
            "             182.94,179.63 182.92,184.36 181.07,186.40\n" +
            "             178.68,189.03 175.11,186.97 172.58,187.32\n" +
            "             170.27,187.65 162.56,192.56 155.04,188.43\n" +
            "             148.43,184.80 148.81,180.15 147.00,174.00\n" +
            "             147.00,174.00 147.00,178.00 147.00,178.00\n" +
            "             147.00,178.00 134.00,178.00 134.00,178.00\n" +
            "             134.00,178.00 97.00,171.21 97.00,171.21\n" +
            "             97.00,171.21 68.00,165.00 68.00,165.00\n" +
            "             68.00,165.00 72.00,154.00 72.00,154.00\n" +
            "             66.14,157.67 68.05,164.51 59.00,167.35\n" +
            "             57.05,167.96 54.04,168.10 52.00,167.89\n" +
            "             33.57,166.03 37.57,136.52 56.00,139.34\n" +
            "             67.41,141.09 65.31,149.03 72.00,153.00\n" +
            "             67.19,132.54 46.27,131.38 38.45,147.00\n" +
            "             36.80,150.30 37.01,153.44 37.00,157.00\n" +
            "             30.77,156.04 20.12,152.92 17.02,146.96\n" +
            "             13.20,139.61 21.01,133.32 21.99,131.63\n" +
            "             23.52,128.98 22.59,125.82 24.15,122.02\n" +
            "             26.90,115.27 33.99,117.07 40.00,117.00\n" +
            "             46.44,116.92 51.77,115.41 58.00,114.44\n" +
            "             58.00,114.44 77.00,113.00 77.00,113.00\n" +
            "             88.51,112.98 108.99,114.20 120.00,116.66\n" +
            "             131.72,119.29 134.60,123.09 144.00,129.71\n" +
            "             146.92,131.76 153.29,136.24 156.91,136.16\n" +
            "             161.42,136.06 165.02,126.31 168.32,123.19\n" +
            "             174.78,117.07 183.13,130.18 183.98,117.00\n" +
            "             183.98,117.00 183.98,112.00 183.98,112.00\n" +
            "             183.98,112.00 187.00,112.00 187.00,112.00 Z\n" +
            "           M 86.00,132.20\n" +
            "           C 89.76,132.96 102.96,136.45 105.79,135.36\n" +
            "             109.41,133.97 113.31,121.54 110.36,119.02\n" +
            "             109.01,117.87 99.19,117.06 97.00,117.01\n" +
            "             85.83,116.76 72.98,118.49 66.00,128.00\n" +
            "             66.00,128.00 86.00,132.20 86.00,132.20 Z\n" +
            "           M 269.67,121.02\n" +
            "           C 266.13,118.82 254.43,118.95 250.00,119.00\n" +
            "             250.00,119.00 232.00,120.91 232.00,120.91\n" +
            "             228.44,121.15 223.09,120.47 220.00,122.02\n" +
            "             212.19,125.95 210.02,134.08 210.00,142.00\n" +
            "             216.75,140.18 220.58,137.52 228.00,138.09\n" +
            "             235.70,138.68 236.68,142.36 247.00,141.96\n" +
            "             247.00,141.96 264.00,141.00 264.00,141.00\n" +
            "             264.00,141.00 280.00,142.00 280.00,142.00\n" +
            "             278.42,136.72 274.31,123.90 269.67,121.02 Z\n" +
            "           M 145.00,145.57\n" +
            "           C 148.10,146.68 155.57,149.18 158.41,146.83\n" +
            "             162.78,143.21 153.15,138.81 151.00,137.57\n" +
            "             141.45,132.09 126.80,122.12 116.00,121.00\n" +
            "             116.00,121.00 113.00,139.00 113.00,139.00\n" +
            "             123.86,139.88 134.75,141.89 145.00,145.57 Z\n" +
            "           M 49.00,148.00\n" +
            "           C 49.00,148.00 53.00,146.00 53.00,146.00\n" +
            "             53.00,146.00 49.00,148.00 49.00,148.00 Z\n" +
            "           M 61.00,150.00\n" +
            "           C 61.00,150.00 59.00,147.00 59.00,147.00\n" +
            "             59.00,147.00 61.00,150.00 61.00,150.00 Z\n" +
            "           M 48.00,148.00\n" +
            "           C 48.00,148.00 49.00,149.00 49.00,149.00\n" +
            "             49.00,149.00 49.00,148.00 49.00,148.00\n" +
            "             49.00,148.00 48.00,148.00 48.00,148.00 Z\n" +
            "           M 238.00,157.00\n" +
            "           C 238.00,157.00 222.00,158.70 222.00,158.70\n" +
            "             217.50,158.37 214.05,155.11 208.00,156.53\n" +
            "             199.28,158.59 201.25,165.71 213.00,166.82\n" +
            "             219.05,167.40 219.82,165.41 224.09,164.10\n" +
            "             224.09,164.10 237.00,161.35 237.00,161.35\n" +
            "             237.00,161.35 268.00,161.35 268.00,161.35\n" +
            "             269.53,161.03 271.36,161.00 272.79,161.35\n" +
            "             274.21,162.18 283.21,172.14 289.40,163.85\n" +
            "             296.78,153.98 279.36,142.55 275.00,157.00\n" +
            "             275.00,157.00 238.00,157.00 238.00,157.00 Z\n" +
            "           M 47.00,157.00\n" +
            "           C 47.00,157.00 47.00,151.00 47.00,151.00\n" +
            "             47.00,151.00 47.00,157.00 47.00,157.00 Z\n" +
            "           M 62.00,153.00\n" +
            "           C 62.00,153.00 63.00,154.00 63.00,154.00\n" +
            "             63.00,154.00 63.00,153.00 63.00,153.00\n" +
            "             63.00,153.00 62.00,153.00 62.00,153.00 Z\n" +
            "           M 51.00,161.00\n" +
            "           C 51.00,161.00 48.00,157.00 48.00,157.00\n" +
            "             48.04,159.79 48.64,159.70 51.00,161.00 Z\n" +
            "           M 60.00,158.00\n" +
            "           C 60.00,158.00 61.00,159.00 61.00,159.00\n" +
            "             61.00,159.00 61.00,158.00 61.00,158.00\n" +
            "             61.00,158.00 60.00,158.00 60.00,158.00 Z\n" +
            "           M 59.00,159.00\n" +
            "           C 59.00,159.00 60.00,160.00 60.00,160.00\n" +
            "             60.00,160.00 60.00,159.00 60.00,159.00\n" +
            "             60.00,159.00 59.00,159.00 59.00,159.00 Z\n" +
            "           M 51.00,162.00\n" +
            "           C 51.00,162.00 57.00,161.00 57.00,161.00\n" +
            "             57.00,161.00 51.00,162.00 51.00,162.00 Z\n" +
            "           M 171.00,164.00\n" +
            "           C 171.00,164.00 172.00,165.00 172.00,165.00\n" +
            "             172.00,165.00 172.00,164.00 172.00,164.00\n" +
            "             172.00,164.00 171.00,164.00 171.00,164.00 Z\n" +
            "           M 159.00,165.00\n" +
            "           C 159.00,165.00 160.00,166.00 160.00,166.00\n" +
            "             160.00,166.00 160.00,165.00 160.00,165.00\n" +
            "             160.00,165.00 159.00,165.00 159.00,165.00 Z\n" +
            "           M 175.00,168.00\n" +
            "           C 175.00,168.00 173.00,165.00 173.00,165.00\n" +
            "             173.00,165.00 175.00,168.00 175.00,168.00 Z\n" +
            "           M 239.00,165.00\n" +
            "           C 239.20,169.46 239.02,175.34 243.00,178.00\n" +
            "             243.00,178.00 242.00,165.00 242.00,165.00\n" +
            "             242.00,165.00 239.00,165.00 239.00,165.00 Z\n" +
            "           M 243.00,165.00\n" +
            "           C 243.20,169.46 243.02,175.34 247.00,178.00\n" +
            "             247.00,178.00 246.00,165.00 246.00,165.00\n" +
            "             246.00,165.00 243.00,165.00 243.00,165.00 Z\n" +
            "           M 158.00,166.00\n" +
            "           C 158.00,166.00 159.00,167.00 159.00,167.00\n" +
            "             159.00,167.00 159.00,166.00 159.00,166.00\n" +
            "             159.00,166.00 158.00,166.00 158.00,166.00 Z\n" +
            "           M 230.00,166.00\n" +
            "           C 230.00,166.00 231.00,176.00 231.00,176.00\n" +
            "             230.06,172.08 230.00,170.43 226.00,169.00\n" +
            "             226.75,173.79 227.67,178.31 232.00,181.00\n" +
            "             232.00,181.00 232.00,177.00 232.00,177.00\n" +
            "             232.00,177.00 235.00,178.00 235.00,178.00\n" +
            "             235.00,178.00 236.00,174.00 236.00,174.00\n" +
            "             236.00,174.00 239.00,179.00 239.00,179.00\n" +
            "             239.00,179.00 237.00,167.00 237.00,167.00\n" +
            "             237.00,167.00 233.00,169.00 233.00,169.00\n" +
            "             233.00,169.00 230.00,166.00 230.00,166.00 Z\n" +
            "           M 249.00,179.00\n" +
            "           C 253.28,176.14 252.81,169.81 250.00,166.00\n" +
            "             250.00,166.00 249.00,179.00 249.00,179.00 Z\n" +
            "           M 253.00,166.00\n" +
            "           C 253.00,166.00 253.00,179.00 253.00,179.00\n" +
            "             253.00,179.00 255.00,179.00 255.00,179.00\n" +
            "             255.00,179.00 255.00,166.00 255.00,166.00\n" +
            "             255.00,166.00 253.00,166.00 253.00,166.00 Z\n" +
            "           M 257.00,166.00\n" +
            "           C 257.00,166.00 256.00,179.00 256.00,179.00\n" +
            "             256.00,179.00 259.00,179.00 259.00,179.00\n" +
            "             259.00,179.00 259.00,166.00 259.00,166.00\n" +
            "             259.00,166.00 257.00,166.00 257.00,166.00 Z\n" +
            "           M 260.00,179.00\n" +
            "           C 260.00,179.00 263.00,179.00 263.00,179.00\n" +
            "             263.00,174.32 263.86,169.88 261.00,166.00\n" +
            "             261.00,166.00 260.00,179.00 260.00,179.00 Z\n" +
            "           M 264.00,166.00\n" +
            "           C 264.00,166.00 264.00,179.00 264.00,179.00\n" +
            "             264.00,179.00 266.00,179.00 266.00,179.00\n" +
            "             266.00,179.00 266.00,166.00 266.00,166.00\n" +
            "             266.00,166.00 264.00,166.00 264.00,166.00 Z\n" +
            "           M 177.00,173.00\n" +
            "           C 177.00,173.00 176.00,168.00 176.00,168.00\n" +
            "             176.00,168.00 177.00,173.00 177.00,173.00 Z\n" +
            "           M 151.00,170.00\n" +
            "           C 151.00,170.00 152.00,171.00 152.00,171.00\n" +
            "             152.00,171.00 152.00,170.00 152.00,170.00\n" +
            "             152.00,170.00 151.00,170.00 151.00,170.00 Z\n" +
            "           M 164.00,171.00\n" +
            "           C 164.00,171.00 169.00,172.00 169.00,172.00\n" +
            "             167.11,169.89 166.61,170.04 164.00,171.00 Z\n" +
            "           M 163.00,171.00\n" +
            "           C 163.00,171.00 164.00,172.00 164.00,172.00\n" +
            "             164.00,172.00 164.00,171.00 164.00,171.00\n" +
            "             164.00,171.00 163.00,171.00 163.00,171.00 Z\n" +
            "           M 148.00,173.00\n" +
            "           C 148.00,173.00 149.00,174.00 149.00,174.00\n" +
            "             149.00,174.00 149.00,173.00 149.00,173.00\n" +
            "             149.00,173.00 148.00,173.00 148.00,173.00 Z\n" +
            "           M 155.00,179.00\n" +
            "           C 155.00,179.00 158.00,175.00 158.00,175.00\n" +
            "             155.46,176.00 154.36,176.07 155.00,179.00 Z\n" +
            "           M 159.00,183.00\n" +
            "           C 159.00,183.00 156.00,179.00 156.00,179.00\n" +
            "             156.04,181.79 156.64,181.70 159.00,183.00 Z\n" +
            "           M 168.00,180.00\n" +
            "           C 168.00,180.00 169.00,181.00 169.00,181.00\n" +
            "             169.00,181.00 169.00,180.00 169.00,180.00\n" +
            "             169.00,180.00 168.00,180.00 168.00,180.00 Z\n" +
            "           M 167.00,181.00\n" +
            "           C 167.00,181.00 168.00,182.00 168.00,182.00\n" +
            "             168.00,182.00 168.00,181.00 168.00,181.00\n" +
            "             168.00,181.00 167.00,181.00 167.00,181.00 Z\n" +
            "           M 159.00,184.00\n" +
            "           C 159.00,184.00 165.00,183.00 165.00,183.00\n" +
            "             165.00,183.00 159.00,184.00 159.00,184.00 Z\n" +
            "           M 174.00,184.00\n" +
            "           C 174.00,184.00 175.00,185.00 175.00,185.00\n" +
            "             175.00,185.00 175.00,184.00 175.00,184.00\n" +
            "             175.00,184.00 174.00,184.00 174.00,184.00 Z\n" +
            "           M 173.00,185.00\n" +
            "           C 173.00,185.00 174.00,186.00 174.00,186.00\n" +
            "             174.00,186.00 174.00,185.00 174.00,185.00\n" +
            "             174.00,185.00 173.00,185.00 173.00,185.00 Z";

    public static final String LOGO_TWO = "M 16.50,200.02\n" +
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
        configSplash.setPathSplash(LOGO_TWO); //set path String
        //configSplash.setPathSplash(SyncStateContract.Constants.DATA); //set path String
        //configSplash.setOriginalHeight(190); //in relation to your svg (path) resource--OUR_LOGO
        //configSplash.setOriginalWidth(297); //in relation to your svg (path) resource--OUR_LOGO
        configSplash.setOriginalHeight(200); //in relation to your svg (path) resource
        configSplash.setOriginalWidth(200); //in relation to your svg (path) resource
        configSplash.setAnimPathStrokeDrawingDuration(2000);
        configSplash.setPathSplashStrokeSize(3); //I advise value be <5
        configSplash.setPathSplashStrokeColor(R.color.yellow); //any color you want form colors.xml
        configSplash.setAnimPathFillingDuration(3000);
        configSplash.setPathSplashFillColor(R.color.yellowlight); //path object filling color


        //Customize Title
        configSplash.setTitleSplash("Price Crash");
        configSplash.setTitleTextColor(R.color.yellowlight);
        configSplash.setTitleTextSize(40f); //float value
        configSplash.setAnimTitleDuration(2000);
        configSplash.setAnimTitleTechnique(Techniques.FlipInX);
        //configSplash.setTitleFont("fonts/DINPro-Light_13935.ttf"); //provide string to your font located in assets/fonts/

    }

    @Override
    public void animationsFinished() {

        //transit to another activity here or do whatever you want
        Intent intent = new Intent(SplashPriceCrash.this,QuoteActivity.class);
        startActivity(intent);
    }
}
