package com.gotechcn.yanglaolauncher.view;

import com.gotechcn.yanglaolauncher.R;

import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnKeyListener;

public class thirdAppGridlayoutListener implements OnClickListener, OnKeyListener, OnFocusChangeListener {

	private Context mContext;
	private Intent mIntent = null;

	public thirdAppGridlayoutListener(Context context, Intent intent) {
		// TODO Auto-generated constructor stub
		mContext = context;
		mIntent = intent;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		System.out.println("-------------" + Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ "  ----------  " + Thread.currentThread().getStackTrace()[2].getFileName());
		if (mIntent != null) {
			mContext.startActivity(mIntent);
		}
	}

	@Override
	public boolean onKey(View v, int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		System.out.println("-------------" + Thread.currentThread().getStackTrace()[2].getLineNumber()
				+ "  ----------  " + Thread.currentThread().getStackTrace()[2].getFileName());
		if (hasFocus) {
			v.setBackgroundColor(0xff2c95de);
		}else {
			v.setBackgroundColor(0x00000000);
		}
	}
}