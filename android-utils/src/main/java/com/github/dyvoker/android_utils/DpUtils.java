package com.github.dyvoker.android_utils;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * Helping class to work with dp and px.
 */
@SuppressWarnings("unused")
public class DpUtils {

	/**
	 * Convert dp to px.
	 *
	 * @param dp Size in dp.
	 * @return Size in px.
	 */
	public static float dpToPx(float dp) {
		return TypedValue.applyDimension(
			TypedValue.COMPLEX_UNIT_DIP,
			dp,
			Resources.getSystem().getDisplayMetrics()
		);
	}

	/**
	 * Convert px to dp.
	 *
	 * @param px Size in px.
	 * @return Size in dp.
	 */
	public static float pxToDp(float px) {
		DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
		return px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
	}

	/**
	 * Convert dp to px. Use context.
	 *
	 * @param context Context for getting display metrics.
	 * @param dp Size in dp.
	 * @return Size in px.
	 */
	public static float dpToPx(@NonNull Context context, float dp) {
		return TypedValue.applyDimension(
			TypedValue.COMPLEX_UNIT_DIP,
			dp,
			context.getResources().getDisplayMetrics()
		);
	}

	/**
	 * Convert px to dp. Use context.
	 *
	 * @param context Context for getting display metrics.
	 * @param px Size in px.
	 * @return Size in dp.
	 */
	public static float pxToDp(@NonNull Context context, float px) {
		DisplayMetrics metrics = context.getResources().getDisplayMetrics();
		return px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
	}
}
