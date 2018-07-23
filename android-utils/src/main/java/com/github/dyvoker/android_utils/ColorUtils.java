package com.github.dyvoker.android_utils;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.ColorInt;
import android.support.annotation.WorkerThread;

/**
 * Helping class for working with colors.
 */
@SuppressWarnings({ "unused", "WeakerAccess" })
public class ColorUtils {

	public static final int DEFAULT_BLACK = 0xFF000000;
	public static final int DEFAULT_WHITE = 0xFFFFFFFF;

	/**
	 * Returns contrast color. It can be only black or white.
	 *
	 * @param color Color to get contrast.
	 * @return Black or white color.
	 */
	@ColorInt
	public static int getDiscreteContrastColor(@ColorInt int color) {
		return isBlackContrastTo(color) ? DEFAULT_BLACK : DEFAULT_WHITE;
	}

	/**
	 * Returns contrast color. It can be only black or white (custom).
	 *
	 * @param color Color to get contrast.
	 * @return Black or white color.
	 */
	@ColorInt
	public static int getDiscreteContrastColor(
		@ColorInt int color,
		@ColorInt int customBlack,
		@ColorInt int customWhite
	) {
		return isBlackContrastTo(color) ? customBlack : customWhite;
	}

	/**
	 * @param color Color to find is black contrast to.
	 * @return If true - this color is contrast to black.
	 */
	public static boolean isBlackContrastTo(@ColorInt int color) {
		int red = Color.red(color);
		int green = Color.green(color);
		int blue = Color.blue(color);
		double lum = (((0.299 * red) + ((0.587 * green) + (0.114 * blue))));
		return lum > 186;
	}

	/**
	 * Get dominant color of the bitmap.
	 *
	 * @param bitmap Bitmap.
	 * @return Dominant color.
	 */
	@ColorInt
	@WorkerThread
	public static int getDominantColor(Bitmap bitmap) {
		Bitmap newBitmap = Bitmap.createScaledBitmap(bitmap, 1, 1, true);
		final int color = newBitmap.getPixel(0, 0);
		newBitmap.recycle();
		return color;
	}
}
