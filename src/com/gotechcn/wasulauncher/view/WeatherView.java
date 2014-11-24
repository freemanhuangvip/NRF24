package com.gotechcn.wasulauncher.view;

import com.dvb.spring.weather.IRemoteService;
import com.dvb.spring.weather.WeatherCondition;
import com.excellence.weather.model.WeatherInfo;
import com.gotechcn.yanglaolauncher.R;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherView extends TextView implements WeatherCondition {
	private static final String TAG = "WeatherView";

	private Context mContext;
	public static final String GET_WEATHER_FINISH_RECEIVE = "android.intent.action.GET_WEATHER_FINISH";
	public static final String GET_WEATHER_FINISH_EXTRA = "weather";

	private String sWeatherInfo = null;
	private int iWeatherImgId = R.drawable.weather;

	private static final int MSG_GET_WEATHER = 0;
	private boolean mAttachedToWindow;
	private boolean mWindowVisible;
	private boolean mUpdating;
	WeatherFinishReiciver mWeatherReiciver;

	public WeatherView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		mContext = context;
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
		mAttachedToWindow = true;
		setUpdates();
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		mAttachedToWindow = false;
		setUpdates();
	}

	@Override
	protected void onWindowVisibilityChanged(int visibility) {
		super.onWindowVisibilityChanged(visibility);
		mWindowVisible = visibility == VISIBLE;
		setUpdates();
	}

	@Override
	protected void onVisibilityChanged(View changedView, int visibility) {
		super.onVisibilityChanged(changedView, visibility);
		setUpdates();
	}

	@Override
	protected int getSuggestedMinimumWidth() {
		// makes the large background bitmap not force us to full width
		return 0;
	}

	private boolean isVisible() {
		View v = this;
		while (true) {
			if (v.getVisibility() != VISIBLE) {
				return false;
			}
			final ViewParent parent = v.getParent();
			if (parent instanceof View) {
				v = (View) parent;
			}else {
				return true;
			}
		}
	}

	private void setUpdates() {
		boolean update = mAttachedToWindow && mWindowVisible && isVisible();
		if (update != mUpdating) {
			mUpdating = update;
			if (update) {
				mContext.bindService(new Intent("com.dvb.spring.weather.IRemoteService"), getWeatherInfoConnect,
						Context.BIND_AUTO_CREATE);
				registWeatherReceiver();
			}else {
				mContext.unbindService(getWeatherInfoConnect);
				mContext.unregisterReceiver(mWeatherReiciver);
			}
		}
	}

	private ServiceConnection getWeatherInfoConnect = new ServiceConnection() {

		@Override
		public void onServiceDisconnected(ComponentName name) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onServiceConnected(ComponentName name, IBinder service) {
			// TODO Auto-generated method stub
			IRemoteService mIRemoteService = IRemoteService.Stub.asInterface(service);

			try {
				mIRemoteService.startGetWeatherInfoTask();
			}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	};

	private void registWeatherReceiver() {
		IntentFilter intentFilter = new IntentFilter(GET_WEATHER_FINISH_RECEIVE);
		mWeatherReiciver = new WeatherFinishReiciver();
		mContext.registerReceiver(mWeatherReiciver, intentFilter);
	}

	private class WeatherFinishReiciver extends BroadcastReceiver {
		@Override
		public void onReceive(Context context, Intent intent) {
			Bundle bundle = intent.getExtras();
			if (bundle != null) {
				try {
					WeatherInfo weatherInfo = (WeatherInfo) bundle.getSerializable(GET_WEATHER_FINISH_EXTRA);
					if (weatherInfo != null) {
						String sCity = weatherInfo.getCity();
						if (sCity.length() > 8) {
							sCity = weatherInfo.getCity().substring(0, 8);
						}

						sWeatherInfo = sCity + " "
								+ changeTemperatureF2C(Integer.parseInt(weatherInfo.get_Low_Temperature())) + "~"
								+ changeTemperatureF2C(Integer.parseInt(weatherInfo.get_High_Temperature())) + "°C";

						iWeatherImgId = WeatherImg[weatherInfo.getWeatherCode()];
					}else {
						sWeatherInfo = "Have a nice day !";
						iWeatherImgId = R.drawable.weather;
					}
					mHandler.sendEmptyMessage(MSG_GET_WEATHER);
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	private Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
				case MSG_GET_WEATHER:
					setText(sWeatherInfo);
					((ImageView) ((Activity) mContext).findViewById(R.id.weatherimage)).setImageResource(iWeatherImgId);
					break;
			}
		};
	};

	public static int changeTemperatureF2C(int in) {
		float out = 0;
		out = (in - 32) * 5.0f / 9.0f;
		return (int) out;
	}
}
