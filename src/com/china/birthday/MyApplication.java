package com.china.birthday;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class MyApplication extends Application {

	/** 保存Activity的集合 */
	private List<Activity> activityList = new ArrayList<Activity>();

	/** 单例 */
	private static MyApplication instance;

	private MyApplication() {
	}

	public static MyApplication getInstance() {
		if (instance == null) {
			instance = new MyApplication();
		}
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
	}

	/** 在Activity的OnCreate方法中调用 */
	public void addActivity(Activity activity) {
		activityList.add(activity);
	}

	/** 在Activity的OnDestroy中调用 */
	public void removeActivity(Activity activity) {
		for (int i = 0; i < activityList.size(); i++) {
			if (activityList.get(i) == activity) {
				activityList.remove(i);
			}
		}
	}

	/** 在退出程序时调用 */
	public void exit() {
		for (Activity activity : activityList) {
			activity.finish();
		}
		System.exit(0);
	}

	public List<Activity> getActivityList() {
		return activityList;
	}

	public void removeAll() {
		for (int i = 0; i < activityList.size(); i++) {
			activityList.remove(i);
		}
	}
}
