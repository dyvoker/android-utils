package com.github.dyvoker.android_utils.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.github.dyvoker.android_utils.DpUtils;

/**
 * Draw rectangle with rounded corners.
 */
@SuppressWarnings({ "unused", "WeakerAccess" })
public class RoundRectDrawable extends Drawable {

	@NonNull
	private final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private final float cornerRadiusPx;

	/**
 	 * @param color Color of rectangle.
	 * @param cornerRadiusDp Corner radius in dp.
	 */
	public RoundRectDrawable(@ColorInt int color, float cornerRadiusDp) {
		paint.setColor(color);
		cornerRadiusPx = DpUtils.dpToPx(cornerRadiusDp);
	}

	/**
	 * @param color Color of rectangle.
	 * @param cornerRadiusPx Corner radius in px.
	 */
	public RoundRectDrawable(@ColorInt int color, int cornerRadiusPx) {
		paint.setColor(color);
		this.cornerRadiusPx = cornerRadiusPx;
	}

	@Override
	public void draw(@NonNull Canvas canvas) {
		RectF rect = new RectF(canvas.getClipBounds());
		canvas.drawRoundRect(rect, cornerRadiusPx, cornerRadiusPx, paint);
	}

	@Override
	public void setAlpha(int alpha) {
		paint.setAlpha(alpha);
	}

	@Override
	public void setColorFilter(@Nullable ColorFilter colorFilter) {
		paint.setColorFilter(colorFilter);
	}

	@Override
	public int getOpacity() {
		return PixelFormat.OPAQUE;
	}
}
