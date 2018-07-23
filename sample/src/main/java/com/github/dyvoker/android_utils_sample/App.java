package com.github.dyvoker.android_utils_sample;

import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.github.dyvoker.android_utils.ResHelper;
import com.github.dyvoker.android_utils.Toaster;

/**
 * App singleton.
 */
public class App extends Application {

	private static App instance;


	@NonNull
	public static Context context() {
		return instance.getApplicationContext();
	}

	@NonNull
	public static ResHelper resHelper() {
		return instance.resHelper;
	}

	@NonNull
	public static Toaster toaster() {
		return instance.toaster;
	}


	private ResHelper resHelper;
	private Toaster toaster;

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		resHelper = new ResHelper(getApplicationContext());
		toaster = new Toaster(getApplicationContext());
	}
}