package com.example.hwandroid92;

import android.app.Activity;
import android.content.Intent;

public class Utils {

    private static int sTheme;

    public final static int THEME_MARGIN_SMALL = 0;
    public final static int THEME_MARGIN_MIDDLE = 1;
    public final static int THEME_MARGIN_BIG = 2;


    public static void changeToTheme(Activity activity, int theme) {
        sTheme = theme;
        activity.finish();

        activity.startActivity(new Intent(activity, activity.getClass()));

    }


    public static void onActivityCreateSetTheme(Activity activity) {
        switch (sTheme) {
            default:
            case THEME_MARGIN_SMALL:
                activity.setTheme(R.style.MarginSmall);
                break;
            case THEME_MARGIN_MIDDLE:
                activity.setTheme(R.style.MarginMiddle);
                break;
            case THEME_MARGIN_BIG:
                activity.setTheme(R.style.MarginBig);
                break;
        }
    }
}
