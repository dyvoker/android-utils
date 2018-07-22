package com.github.dyvoker.android_utils;

import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

/**
 * Helping class for work with layouts.
 */
@SuppressWarnings({ "WeakerAccess", "unused" })
public class LayoutUtils {

	public static int MATCH_PARENT = ViewGroup.LayoutParams.MATCH_PARENT;
	public static int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;

	/**
	 * Sets {@link ViewGroup.LayoutParams#width} and {@link ViewGroup.LayoutParams#height}
	 * with {@link ViewGroup.LayoutParams#MATCH_PARENT} value.
	 *
	 * @param view View to set layout params.
	 */
	public static void setMatchParent(@NonNull View view) {
		setLayoutSize(view, MATCH_PARENT, MATCH_PARENT);
	}

	/**
	 * Sets {@link ViewGroup.LayoutParams#width} and {@link ViewGroup.LayoutParams#height}
	 * with {@link ViewGroup.LayoutParams#WRAP_CONTENT} value.
	 *
	 * @param view View to set layout params.
	 */
	public static void setWrapContent(@NonNull View view) {
		setLayoutSize(view, WRAP_CONTENT, WRAP_CONTENT);
	}

	/**
	 * Sets {@link ViewGroup.LayoutParams#width} and {@link ViewGroup.LayoutParams#height}
	 * with specified width and height.
	 *
	 * @param view View to set layout params.
	 * @param width Width of layout.
	 * @param height Height of layout.
	 */
	public static void setLayoutSize(@NonNull View view, int width, int height) {
		ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
		if (layoutParams == null) {
			layoutParams = new ViewGroup.LayoutParams(width, height);
		} else {
			layoutParams.width = width;
			layoutParams.height = height;
		}
		view.setLayoutParams(layoutParams);
	}
}
