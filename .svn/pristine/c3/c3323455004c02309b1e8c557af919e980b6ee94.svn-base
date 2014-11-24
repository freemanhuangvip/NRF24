package com.gotechcn.yanglaolauncher;

import com.gotechcn.yanglaolauncher.view.thirdAppGridlayoutListener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdGridAppsActivity extends Activity {
	private Context mContext;
	private GridLayout mGridLayout;
	private Intent mIntent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.layout_3_apps);

		mIntent = getIntent();

		initView();
	}

	private void initView() {
		String title = mIntent.getStringExtra("title");
		String[] packageName = mIntent.getStringArrayExtra("packageName");
		thirdLevelApp mApps = new thirdLevelApp(mContext);

		if (title != null) {
			((TextView) findViewById(R.id.layout_3_apps_title)).setText(title);
		}

		mGridLayout = (GridLayout) findViewById(R.id.third_level_gridlayout);

		try {

			for (int i = 0; i < packageName.length; ++i) {
				ResolveInfo appsInfo = mApps.getAppResolveInfo(packageName[i]);

				if (appsInfo != null) {

					ViewGroup view;
					view = (ViewGroup) View.inflate(mContext, R.layout.childgrid_item, null);

					ImageView img_bg = (ImageView) view.getChildAt(0);

					img_bg.setImageDrawable(mApps.getAppIcon(appsInfo));
					thirdAppGridlayoutListener listener = new thirdAppGridlayoutListener(mContext,
							mApps.getAppIntent(appsInfo));
					img_bg.setOnClickListener(listener);
					img_bg.setOnFocusChangeListener(listener);

					TextView mTextView = (TextView) view.getChildAt(1);
					mTextView.setText(mApps.getAppTitle(appsInfo));

					mGridLayout.addView(view);
				}
			}

		}catch (NullPointerException e) {
			e.printStackTrace();
		}
	}
}
