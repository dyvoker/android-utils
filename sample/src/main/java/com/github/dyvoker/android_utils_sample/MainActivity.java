package com.github.dyvoker.android_utils_sample;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.github.dyvoker.android_utils.Toaster;

public class MainActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView button1 = findViewById(R.id.textView);
		button1.setBackgroundColor(App.resHelper().getColor(R.color.buttonBackground, null));
		button1.setText(App.resHelper().getString(R.string.show_toast_dark_long));
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				App.toaster().showToast(App.resHelper().getString(R.string.toast_test_text), Toaster.LONG);
			}
		});

		TextView button2 = findViewById(R.id.textView2);
		button2.setBackgroundColor(App.resHelper().getColor(R.color.buttonBackground, null));
		button2.setText(App.resHelper().getString(R.string.show_toast_light_short));
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				App.toaster().showToast(
					App.resHelper().getString(R.string.toast_test_text),
					Toaster.SHORT,
					Toaster.LIGHT_TOAST
				);
			}
		});

		TextView button3 = findViewById(R.id.textView3);
		button3.setBackgroundColor(App.resHelper().getColor(R.color.buttonBackground, null));
		button3.setText(App.resHelper().getString(R.string.show_toast_with_drawable));
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Drawable icon = App.resHelper().getDrawable(R.drawable.ic_report, null);
				App.toaster().showToast(
					App.resHelper().getString(R.string.toast_test_text),
					Toaster.LONG,
					Toaster.DARK_TOAST,
					icon
				);
			}
		});
	}
}
