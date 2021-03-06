package com.quackware.tric.stats.AppStats;

import android.content.pm.PackageManager;

import com.quackware.tric.MyApplication;
import com.quackware.tric.stats.Stats.DataType;

public class NumberOfTotalAppsUninstalled extends AppStats {
	
	private static String mName = "NumberOfTotalAppsUninstalled";
	private static final String mPrettyName = "Number of Total Applications Uninstalled";
	
	private int mDefaultCollectionInterval = 60*24;

	public NumberOfTotalAppsUninstalled() {
		super(mName);
	}
	
	@Override
	public String getName()
	{
		return mName;
	}
	
	@Override
	public int getDefaultCollectionInterval()
	{
		return mDefaultCollectionInterval;
	}

	@Override
	public boolean refreshStats() {
		final PackageManager pm = MyApplication.getInstance().getPackageManager();
		mData = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES).size() - pm.getInstalledPackages(0).size();
		return false;
	}
	
	@Override
	public DataType getDataType() {
		return DataType.NUMBER;
	}
	
	@Override
	public String getPrettyName() {
		return mPrettyName;
	}

}
