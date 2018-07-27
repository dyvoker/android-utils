# Android Utils
[![API](https://img.shields.io/badge/API-14%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=14)

### Usage ([samples](https://github.com/dyvoker/android-utils/tree/master/sample))
Add dependency:
```gradle
dependencies {
    implementation 'com.github.dyvoker:android-utils:0.1.0'
}
```

## App singleton
Some helpfull classes using application context.
So I recommend to use App singleton:
```java
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
```
And add in AndroidManifest.xml of your project:
```xml
<manifest>
    ...
    <application
        ...
        android:name=".App"
        >
    ...
    </application>
    ...
</manifest>
```

## Utils classes

### Toaster
Helping class to show Toasts.
Simple:
```java
App.toaster().showToast(App.resHelper().getString(R.string.toast_test_text), Toaster.LONG);
```

Max custom:
```java
Drawable icon = App.resHelper().getDrawable(R.drawable.ic_report, null);
App.toaster().showToast(
    App.resHelper().getString(R.string.toast_test_text),
    Toaster.LONG,
    Toaster.DARK_TOAST,
    icon
);
```

### DpUtils
Helping class to work with dp and px.

### ColorUtils
Helping class for working with colors.

### LayoutUtils
Helping class for work with layouts.

### ResHelper
Helping class to work with Resources.

