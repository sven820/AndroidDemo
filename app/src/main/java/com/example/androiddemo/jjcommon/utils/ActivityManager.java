package com.example.androiddemo.jjcommon.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ActivityManager {

    public static final ActivityManager shared = new ActivityManager();
    private static HashSet<Activity> activities = new HashSet<Activity>();

    ActivityManager() {

    }

    public static void registerActivity(Activity a) {
        activities.add(a);
    }
    public static void unregisterActivity(Activity a) {
        activities.remove(a);
    }

    public static void finishAll() {
        for (Activity activity : activities) {
            activity.finish();
        }
    }

    public static void finish(Activity a) {
        unregisterActivity(a);
        a.finish();
    }
}
