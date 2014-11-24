package com.gotechcn.yanglaolauncher;

import com.gotechcn.yanglaolauncher.view.thirdAppGridlayoutListener;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class ThirdLifeServiceActivity extends Activity {
	private Context mContext;
	private GridLayout mGridLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.layout_3_apps);

		initView();
	}

	private void initView() {
		((TextView) findViewById(R.id.layout_3_apps_title)).setText(R.string.str_life_service);
		mGridLayout = (GridLayout) findViewById(R.id.third_level_gridlayout);

		for (int i = 0; i < mGridLayout.getColumnCount() * mGridLayout.getRowCount(); ++i) {

			ViewGroup view;
			view = (ViewGroup) View.inflate(mContext, R.layout.childgrid_item, null);

			ImageView img_bg = (ImageView) view.getChildAt(0);
			// img_bg.setOnClickListener(new thirdAppGridlayoutListener(mContext, intent));

			TextView mTextView = (TextView) view.getChildAt(1);

			view.setFocusable(true);
			view.setFocusableInTouchMode(true);
			view.setDescendantFocusability(ViewGroup.FOCUS_BEFORE_DESCENDANTS);

			mGridLayout.addView(view);
		}
	}
}
