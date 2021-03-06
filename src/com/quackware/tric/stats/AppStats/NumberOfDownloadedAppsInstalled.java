package com.quackware.tric.stats.AppStats;

import java.util.List;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.quackware.tric.MyApplication;
import com.quackware.tric.stats.Stats.DataType;

public class NumberOfDownloadedAppsInstalled extends AppStats {

	private static final String mName = "NumberOfDownloadedAppsInstalled";
	private static final String mPrettyName = "Number of Downloaded Applications Installed";
	private int mDefaultCollectionInterval = 60*12;
	
	
	public NumberOfDownloadedAppsInstalled() {
		super(mName);
		// TODO Auto-generated constructor stub
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
		int count = 0;
		List<PackageInfo> packages = pm.getInstalledPackages(0);
		for(int i = 0;i<packages.size();i++)
		{
			if(isSystemPackage(packages.get(i)))
			{
				count++;
			}
		}
		mData = (Integer)count;
		return false;
	}

	private boolean isSystemPackage(PackageInfo pkgInfo) {
	    return ((pkgInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) != 0) ? true
	            : false;
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
