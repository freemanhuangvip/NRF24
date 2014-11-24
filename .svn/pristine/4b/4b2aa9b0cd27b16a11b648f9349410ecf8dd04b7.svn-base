package com.gotechcn.yanglaolauncher;

import java.util.List;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;

public class thirdLevelApp {
	private Context mContext;
	private List<ResolveInfo> appList;
	private PackageManager mManager;

	public thirdLevelApp(Context context) {
		// TODO Auto-generated constructor stub
		mContext = context;
		mManager = mContext.getPackageManager();
		getAllApp();
	}

	private void getAllApp() {
		Intent mainIntent = new Intent(Intent.ACTION_MAIN, null);
		mainIntent.addCategory(Intent.CATEGORY_LAUNCHER);

		appList = mManager.queryIntentActivities(mainIntent, 0);
	}

	public ResolveInfo getAppResolveInfo(String packageName) {
		for (int i = 0; i < appList.size(); ++i) {
			String packageNametemp = appList.get(i).activityInfo.packageName;
			if (packageName.equals(packageNametemp)) {
				return appList.get(i);
			}
		}
		return null;
	}

	public String getAppTitle(ResolveInfo reso) {
		return reso.loadLabel(mManager).toString();
	}

	public Drawable getAppIcon(ResolveInfo reso) {
		return reso.loadIcon(mManager);
	}

	public Intent getAppIntent(ResolveInfo reso) {
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		intent.setComponent(new ComponentName(reso.activityInfo.packageName, reso.activityInfo.name));
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);

		return intent;
	}
}
