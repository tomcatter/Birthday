package com.china.birthday;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TabHost;

public class LoadActivity extends Activity implements Runnable {

	/** 选项卡对象 */
	private TabHost tabHost;

	/** 选项卡按钮 */
	private RadioButton radioButton[] = new RadioButton[4];

	/** 选项卡按钮id数组 */
	private int radioButtonId[] = { R.id.tab_item_1, R.id.tab_item_2,
			R.id.tab_item_3, R.id.tab_item_4 };

	/** 是否今日主界面 */
	private int isEnter;

	private ImageView img_appLoad;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.load);
		this.tabHost = (TabHost) findViewById(android.R.id.tabhost);
		tabHost.setup();
		tabHostInit();
		this.img_appLoad = (ImageView) findViewById(R.id.applaoding);

	}

	// 选项的初始化
	private void tabHostInit() {
		tabHost.addTab(tabHost.newTabSpec("birth").setIndicator("11")
				.setContent(new Intent(this, BirthdayActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("bless").setIndicator("22")
				.setContent(new Intent(this, BlessActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("center").setIndicator("33")
				.setContent(new Intent(this, CenterActivity.class)));
		tabHost.addTab(tabHost.newTabSpec("more").setIndicator("44")
				.setContent(new Intent(this, MoreActivity.class)));
		for (int i = 0; i < radioButton.length; i++) {
			radioButton[i] = (RadioButton) findViewById(radioButtonId[i]);
			radioButton[i].setOnClickListener(onClickListener);
		}
		tabHost.setCurrentTabByTag("birth");
		radioButton[0].setChecked(true);
		
		new Thread(this).start();
	}

	/** 单击监听 */
	OnClickListener onClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			switch (id) {
			case R.id.tab_item_1:
				tabHost.setCurrentTabByTag("birth");
				break;
			case R.id.tab_item_2:
				tabHost.setCurrentTabByTag("bless");
				break;
			case R.id.tab_item_3:
				tabHost.setCurrentTabByTag("center");
				break;
			case R.id.tab_item_4:
				tabHost.setCurrentTabByTag("more");
				break;
			default:
				break;
			}

		}
	};

	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		handler.sendEmptyMessage(0);
	}

	
	Handler handler = new Handler() {
   
		public void handleMessage(android.os.Message msg) {
			img_appLoad.setVisibility(View.GONE);
		};
	};
}
