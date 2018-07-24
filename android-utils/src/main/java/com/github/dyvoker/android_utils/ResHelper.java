package com.github.dyvoker.android_utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

/**
 * Helping class to work with {@link Resources}.
 */
@SuppressWarnings("unused")
public class ResHelper {

	@NonNull
	private final Context appContext;

	public ResHelper(@NonNull Context applicationContext) {
		appContext = applicationContext;
	}

	/**
	 * @param colorId Id of the color.
	 * @return The found color. If not found throws {@link Resources.NotFoundException}.
	 */
	@ColorInt
	public int getColor(@ColorRes int colorId) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
			return appContext.getColor(colorId);
		} else {
			//noinspection deprecation
			return appContext.getResources().getColor(colorId);
		}
	}

	/**
	 * @param stringId Id of the string.
	 * @return The found string. If not found throws {@link Resources.NotFoundException}.
	 */
	@NonNull
	public String getString(@StringRes int stringId) {
		return appContext.getResources().getString(stringId);
	}

	/**
	 * @param drawableId Id of the drawable.
	 * @return The found drawable. If not found throws {@link Resources.NotFoundException}.
	 */
	@NonNull
	public Drawable getDrawable(@DrawableRes int drawableId) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			Drawable drawable = appContext.getDrawable(drawableId);
			if (drawable == null) {
				throw new Resources.NotFoundException(
					"Drawable with resource ID #0x" + Integer.toHexString(drawableId)
				);
			}
			return drawable;
		} else {
			//noinspection deprecation
			return appContext.getResources().getDrawable(drawableId);
		}
	}

	/**
	 * @param dimensionId Id of the dimension.
	 * @return The found dimension. If not found throws {@link Resources.NotFoundException}.
	 */
	public float getDimension(@DimenRes int dimensionId) {
		return appContext.getResources().getDimension(dimensionId);
	}

}
