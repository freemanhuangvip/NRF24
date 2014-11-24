package com.gotechcn.wasulauncher.view;

import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.format.DateFormat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.TextView;

public class DateView extends TextView{
    private static final String TAG = "DateView";

    private boolean mAttachedToWindow;
    private boolean mWindowVisible;
    private boolean mUpdating;
    private Context mContext;

    private BroadcastReceiver mIntentReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String action = intent.getAction();
            if (Intent.ACTION_TIME_TICK.equals(action)
                    || Intent.ACTION_TIME_CHANGED.equals(action)
                    || Intent.ACTION_TIMEZONE_CHANGED.equals(action)) {
                updateClock();
            }
        }
    };

    public DateView(Context context, AttributeSet attrs) {
        super(context, attrs);
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

    private final void updateClock() {
        final Context context = getContext();
        Date now = new Date();
        CharSequence dow = DateFormat.format("E", now);
        CharSequence date = DateFormat.getMediumDateFormat(context).format(now);
        setText(date+"  "+dow);
    }

    private boolean isVisible() {
        View v = this;
        while (true) {
            if (v.getVisibility() != VISIBLE) {
                return false;
            }
            final ViewParent parent = v.getParent();
            if (parent instanceof View) {
                v = (View)parent;
            } else {
                return true;
            }
        }
    }

    private void setUpdates() {
        boolean update = mAttachedToWindow && mWindowVisible && isVisible();
        if (update != mUpdating) {
            mUpdating = update;
            if (update) {
                // Register for Intent broadcasts for the clock and battery
                IntentFilter filter = new IntentFilter();
                filter.addAction(Intent.ACTION_TIME_TICK);
                filter.addAction(Intent.ACTION_TIME_CHANGED);
                filter.addAction(Intent.ACTION_TIMEZONE_CHANGED);
                mContext.registerReceiver(mIntentReceiver, filter, null, null);
                updateClock();
            } else {
                mContext.unregisterReceiver(mIntentReceiver);
            }
        }
    }
}
