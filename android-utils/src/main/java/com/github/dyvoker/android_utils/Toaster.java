package com.github.dyvoker.android_utils;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.github.dyvoker.android_utils.drawable.RoundRectDrawable;

/**
 * Helping class to show {@link Toast}.
 */
@SuppressWarnings({ "WeakerAccess", "unused" })
public class Toaster {

	@ColorInt
	public static final int LIGHT_TOAST = 0xE6EEEEEE;
	@ColorInt
	public static final int DARK_TOAST = 0xCC181818;

	public static int SHORT = Toast.LENGTH_SHORT;
	public static int LONG = Toast.LENGTH_LONG;


	@NonNull
	private final Context appContext;


	public Toaster(@NonNull Context applicationContext) {
		appContext = applicationContext;
	}

	/**
	 * Show {@link Toast} with dark theme.
	 *
	 * @param text Text in the Toast.
	 * @param duration Duration of the Toast.
	 */
	public void showToast(
		@NonNull CharSequence text,
		int duration
	) {
		showToast(text, duration, DARK_TOAST);
	}

	/**
	 * Show {@link Toast} with dark theme.
	 *
	 * @param stringId Id of the string resource.
	 * @param duration Duration of the Toast.
	 */
	public void showToast(
		@StringRes int stringId,
		int duration
	) {
		showToast(stringId, duration, DARK_TOAST);
	}

	/**
	 * Show {@link Toast}. Color of text will be black or white,
	 * it depends on brightness of the backgroundColor.
	 *
	 * @param text Text in the Toast.
	 * @param duration Duration of the Toast.
	 * @param backgroundColor Color of the background.
	 */
	public void showToast(
		@NonNull CharSequence text,
		int duration,
		@ColorInt int backgroundColor
	) {
		int textColor = ColorUtils.getDiscreteContrastColor(backgroundColor);
		showCustomToast(text, duration, backgroundColor, textColor, null);
	}

	/**
	 * Show {@link Toast}. Color of text will be black or white,
	 * it depends on brightness of the backgroundColor.
	 *
	 * @param stringId Id of the string resource.
	 * @param duration Duration of the Toast.
	 * @param backgroundColor Color of the background.
	 */
	public void showToast(
		@StringRes int stringId,
		int duration,
		@ColorInt int backgroundColor
	) {
		String text = appContext.getString(stringId);
		int textColor = ColorUtils.getDiscreteContrastColor(backgroundColor);
		showCustomToast(text, duration, backgroundColor, textColor, null);
	}

	/**
	 * Show {@link Toast}  with icon.
	 *
	 * @param text Text in the Toast.
	 * @param duration Duration of the Toast.
	 * @param backgroundColor Color of the background.
	 * @param icon Optional drawable to show to the left of text.
	 */
	public void showToast(
		@NonNull CharSequence text,
		int duration,
		@ColorInt int backgroundColor,
		@NonNull Drawable icon
	) {
		int textColor = ColorUtils.getDiscreteContrastColor(backgroundColor);
		showCustomToast(text, duration, backgroundColor, textColor, icon);
	}

	/**
	 * Show custom {@link Toast}.
	 *
	 * @param text Text in the Toast.
	 * @param duration Duration of the Toast.
	 * @param backgroundColor Color of the background.
	 * @param textColor Color of the text.
	 * @param icon Optional drawable to show to the left of text.
	 */
	public void showCustomToast(
		@NonNull CharSequence text,
		int duration,
		@ColorInt int backgroundColor,
		@ColorInt int textColor,
		@Nullable Drawable icon
	) {
		LayoutInflater inflater = LayoutInflater.from(appContext);
		View layout = inflater.inflate(R.layout.andr_ut_custom_toast, null);

		// Set rounded rectangle background.
		LinearLayout container = layout.findViewById(R.id.toast_container);
		Drawable background = new RoundRectDrawable(backgroundColor, 18.0f);
		container.setBackgroundDrawable(background);

		// Set text.
		TextView textView = layout.findViewById(R.id.toast_caption);
		textView.setText(text);
		textView.setTextColor(textColor);

		// Set icon if needed.
		if (icon != null) {
			FrameLayout iconContainer = layout.findViewById(R.id.toast_icon);
			iconContainer.setBackgroundDrawable(icon);
			iconContainer.setVisibility(View.VISIBLE);
		}

		// Create and show toast.
		Toast toast = new Toast(appContext);
		toast.setDuration(duration);
		toast.setView(layout);
		toast.show();
	}


}
