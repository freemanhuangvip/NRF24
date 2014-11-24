package com.gotechcn.yanglaolauncher;

import java.util.Timer;
import java.util.TimerTask;

import com.gotechcn.gallery3d.GalleryFlow;
import com.gotechcn.gallery3d.ImageGalleryAdapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

@SuppressLint("ClickableViewAccessibility")
public class MainActivity extends Activity {
	private Context mContext;
	
	private static final String TAG = "MainActivity";

	private ImageView firstLevelImg[] = new ImageView[5];

	private TextView firstLevelText[] = new TextView[5];

	private View firstLevelRelativeL[] = new View[5];

	private static final int L_WONDERFUL = 0;
	private static final int L_VIDEO_ON_DEMAND = 1;
	private static final int L_CIVIL_FOR_AGED = 2;
	private static final int L_SECOND_SETTING = 3;
	private static final int L_APP_SHOP = 4;

	private ImageView civilForAgedImg[] = new ImageView[8];
	private RelativeLayout civilForAgedRela[] = new RelativeLayout[8];
	private View layoutCivilForAgedLine;

	private static final int L_ROOM_SERVICE = 0;
	private static final int L_HEALTH_CARE = 1;
	private static final int L_SURROUNDING_SHOPPING = 2;
	private static final int L_ENTERTAINMENT = 3;
	private static final int L_CIVIL_WINDOW = 4;              
	private static final int L_VISUAL_COMMUNICATION = 5;
	private static final int L_TRAVEL = 6;
	private static final int L_LIFE_SERVICE = 7;

	private static final float SCALE_MAX = 1.30F;
	private static final float SCALE_MID = 1.24F;
	private static final float SCALE_MIN = 1.18F;
	private static final float SCALE_NONE = 1.0F;

	private RelativeLayout videoOndemandRela[] = new RelativeLayout[7];
	private ImageView[] videoOndemandImageView = new ImageView[7];

	private static final int L_VOD_MOVIE = 0;
	private static final int L_VOD_INFOMATION = 1;
	private static final int L_VOD_SPORT = 2;
	private static final int L_VOD_TELEPLAY = 3;
	private static final int L_VOD_COLUMN = 4;
	private static final int L_VOD_ENTERTAINMENT = 5;
	private static final int L_VOD_CHILDREN = 6;

	private RelativeLayout appshopRela[] = new RelativeLayout[7];
	private ImageView[] appshopImageView = new ImageView[7];

	private static final int L_APPSHOP_MEDIA = 0;
	private static final int L_APPSHOP_SHOPPING = 1;
	private static final int L_APPSHOP_MUSIC = 2;
	private static final int L_APPSHOP_LIFE = 3;
	private static final int L_APPSHOP_EDUCATION = 4;
	private static final int L_APPSHOP_ENTERTAINMENT = 5;
	private static final int L_APPSHOP_MORE = 6;

	private ImageView mLayerTopBg;
	private GalleryFlow recommendGalleryFlow;
    private boolean mRecommendFocus = false;
    private int mCurrentRecommend;
    
    public static final int MIN_CYCLE_NUMS = 5;
    private Timer mTimer;
    private TimerTask mAutoScrollTask;
    private boolean isActivityShown = true;
    private ImageGalleryAdapter recommendAdapter;
    private static final int RECOMMEND_SCROLL_INTERVAL = 5000;
	
	private RelativeLayout secondSettingRela[] = new RelativeLayout[10];
	private ImageView[] secondSettingImg = new ImageView[10];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView() {
		firstLevelRelativeL[L_WONDERFUL] = findViewById(R.id.layout_second_wonderful);
		firstLevelRelativeL[L_VIDEO_ON_DEMAND] = findViewById(R.id.layout_video_ondemand);
		firstLevelRelativeL[L_CIVIL_FOR_AGED] = findViewById(R.id.layout_civil_for_aged_rela);
		firstLevelRelativeL[L_SECOND_SETTING] = findViewById(R.id.layout_second_setting);
		firstLevelRelativeL[L_APP_SHOP] = findViewById(R.id.layout_app_shop);

		firstLevelImg[L_WONDERFUL] = (ImageView) findViewById(R.id.wonderful_img);
		firstLevelImg[L_VIDEO_ON_DEMAND] = (ImageView) findViewById(R.id.video_on_demand_img);
		firstLevelImg[L_CIVIL_FOR_AGED] = (ImageView) findViewById(R.id.civil_for_aged_img);
		firstLevelImg[L_SECOND_SETTING] = (ImageView) findViewById(R.id.second_setting_img);
		firstLevelImg[L_APP_SHOP] = (ImageView) findViewById(R.id.app_shop_img);

		firstLevelText[L_WONDERFUL] = (TextView) findViewById(R.id.wonderful_text);
		firstLevelText[L_VIDEO_ON_DEMAND] = (TextView) findViewById(R.id.video_on_demand_text);
		firstLevelText[L_CIVIL_FOR_AGED] = (TextView) findViewById(R.id.civil_for_aged_text);
		firstLevelText[L_SECOND_SETTING] = (TextView) findViewById(R.id.second_setting_text);
		firstLevelText[L_APP_SHOP] = (TextView) findViewById(R.id.app_shop_text);

		for (int i = 0; i <= L_APP_SHOP; ++i) {
			firstLevelText[i].setShadowLayer(10f, 5f, 4f, R.color.white);
			firstLevelText[i].setOnFocusChangeListener(firstLevelTextFocusChangeListener);
			firstLevelText[i].setOnClickListener(firstLevelTextOnClickListener);
		}

		layoutCivilForAgedLine = findViewById(R.id.layout_civil_for_aged_line);

		civilForAgedImg[L_ROOM_SERVICE] = (ImageView) findViewById(R.id.room_service_img);
		civilForAgedImg[L_HEALTH_CARE] = (ImageView) findViewById(R.id.health_care_img);
		civilForAgedImg[L_SURROUNDING_SHOPPING] = (ImageView) findViewById(R.id.surrounding_shopping_img);
		civilForAgedImg[L_ENTERTAINMENT] = (ImageView) findViewById(R.id.entertainment_img);
		civilForAgedImg[L_CIVIL_WINDOW] = (ImageView) findViewById(R.id.civil_window_img);
		civilForAgedImg[L_VISUAL_COMMUNICATION] = (ImageView) findViewById(R.id.visual_communication_img);
		civilForAgedImg[L_TRAVEL] = (ImageView) findViewById(R.id.travel_img);
		civilForAgedImg[L_LIFE_SERVICE] = (ImageView) findViewById(R.id.life_service_img);

		for (int i = 0; i <= L_LIFE_SERVICE; ++i) {
			civilForAgedImg[i].setOnFocusChangeListener(civilForAgedImgonFocusChangeListener);
			civilForAgedImg[i].setOnClickListener(civilForAgedImgOnClickListener);
		}

		civilForAgedRela[L_ROOM_SERVICE] = (RelativeLayout) findViewById(R.id.room_service_rela);
		civilForAgedRela[L_HEALTH_CARE] = (RelativeLayout) findViewById(R.id.health_care_rela);
		civilForAgedRela[L_SURROUNDING_SHOPPING] = (RelativeLayout) findViewById(R.id.surrounding_shopping_rela);
		civilForAgedRela[L_ENTERTAINMENT] = (RelativeLayout) findViewById(R.id.entertainment_rela);
		civilForAgedRela[L_CIVIL_WINDOW] = (RelativeLayout) findViewById(R.id.civil_window_rela);
		civilForAgedRela[L_VISUAL_COMMUNICATION] = (RelativeLayout) findViewById(R.id.visual_communication_rela);
		civilForAgedRela[L_TRAVEL] = (RelativeLayout) findViewById(R.id.travel_rela);
		civilForAgedRela[L_LIFE_SERVICE] = (RelativeLayout) findViewById(R.id.life_service_rela);
		
		wonderfulRecommendInit();
		
		videoOndemandRela[L_VOD_MOVIE] = (RelativeLayout) findViewById(R.id.layout_vod_movie);
		videoOndemandRela[L_VOD_INFOMATION] = (RelativeLayout) findViewById(R.id.layout_vod_infomation);
		videoOndemandRela[L_VOD_SPORT] = (RelativeLayout) findViewById(R.id.layout_vod_sport);
		videoOndemandRela[L_VOD_TELEPLAY] = (RelativeLayout) findViewById(R.id.layout_vod_teleplay);
		videoOndemandRela[L_VOD_COLUMN] = (RelativeLayout) findViewById(R.id.layout_vod_column);
		videoOndemandRela[L_VOD_ENTERTAINMENT] = (RelativeLayout) findViewById(R.id.layout_vod_entertainment);
		videoOndemandRela[L_VOD_CHILDREN] = (RelativeLayout) findViewById(R.id.layout_vod_children);

		videoOndemandImageView[L_VOD_MOVIE] = (ImageView) findViewById(R.id.vod_movie);
		videoOndemandImageView[L_VOD_INFOMATION] = (ImageView) findViewById(R.id.vod_infomation);
		videoOndemandImageView[L_VOD_SPORT] = (ImageView) findViewById(R.id.vod_sport);
		videoOndemandImageView[L_VOD_TELEPLAY] = (ImageView) findViewById(R.id.vod_teleplay);
		videoOndemandImageView[L_VOD_COLUMN] = (ImageView) findViewById(R.id.vod_column);
		videoOndemandImageView[L_VOD_ENTERTAINMENT] = (ImageView) findViewById(R.id.vod_entertainment);
		videoOndemandImageView[L_VOD_CHILDREN] = (ImageView) findViewById(R.id.vod_children);

		for (int j = 0; j < 7; j++) {
			videoOndemandImageView[j].setOnFocusChangeListener(videoOndemandOnFocusChangeListener);
			videoOndemandImageView[j].setOnClickListener(videoOndemandOnClickListener);
		}

		appshopRela[L_APPSHOP_MEDIA] = (RelativeLayout) findViewById(R.id.layout_appshop_media);
		appshopRela[L_APPSHOP_SHOPPING] = (RelativeLayout) findViewById(R.id.layout_appshop_shopping);
		appshopRela[L_APPSHOP_MUSIC] = (RelativeLayout) findViewById(R.id.layout_appshop_music);
		appshopRela[L_APPSHOP_LIFE] = (RelativeLayout) findViewById(R.id.layout_appshop_life);
		appshopRela[L_APPSHOP_EDUCATION] = (RelativeLayout) findViewById(R.id.layout_appshop_education);
		appshopRela[L_APPSHOP_ENTERTAINMENT] = (RelativeLayout) findViewById(R.id.layout_appshop_entertainment);
		appshopRela[L_APPSHOP_MORE] = (RelativeLayout) findViewById(R.id.layout_appshop_more);

		appshopImageView[L_APPSHOP_MEDIA] = (ImageView) findViewById(R.id.appshop_media_img);
		appshopImageView[L_APPSHOP_SHOPPING] = (ImageView) findViewById(R.id.appshop_shopping_img);
		appshopImageView[L_APPSHOP_MUSIC] = (ImageView) findViewById(R.id.appshop_music_img);
		appshopImageView[L_APPSHOP_LIFE] = (ImageView) findViewById(R.id.appshop_life_img);
		appshopImageView[L_APPSHOP_EDUCATION] = (ImageView) findViewById(R.id.appshop_education_img);
		appshopImageView[L_APPSHOP_ENTERTAINMENT] = (ImageView) findViewById(R.id.appshop_entertainment_img);
		appshopImageView[L_APPSHOP_MORE] = (ImageView) findViewById(R.id.appshop_more_img);

		for (int j = 0; j < 7; j++) {
			appshopImageView[j].setOnFocusChangeListener(appshopOnFocusChangeListener);
			appshopImageView[j].setOnClickListener(appshopOnClickListener);
		}

		secondSettingRela[0] = (RelativeLayout) findViewById(R.id.setting_system_setting_rela);
		secondSettingRela[1] = (RelativeLayout) findViewById(R.id.setting_display_rela);
		secondSettingRela[2] = (RelativeLayout) findViewById(R.id.setting_download_rela);
		secondSettingRela[3] = (RelativeLayout) findViewById(R.id.setting_network_rela);
		secondSettingRela[4] = (RelativeLayout) findViewById(R.id.setting_install_rela);
		secondSettingRela[5] = (RelativeLayout) findViewById(R.id.setting_about_us_rela);

		secondSettingImg[0] = (ImageView) findViewById(R.id.setting_system_setting_img);
		secondSettingImg[1] = (ImageView) findViewById(R.id.setting_display_img);
		secondSettingImg[2] = (ImageView) findViewById(R.id.setting_download_img);
		secondSettingImg[3] = (ImageView) findViewById(R.id.setting_network_img);
		secondSettingImg[4] = (ImageView) findViewById(R.id.setting_install_img);
		secondSettingImg[5] = (ImageView) findViewById(R.id.setting_about_us_img);

		for (int j = 0; j < 6; j++) {
			secondSettingImg[j].setOnFocusChangeListener(secondSettingOnFocusChangeListener);
			secondSettingImg[j].setOnClickListener(secondSettingOnClickListener);
		}
	}
	
	private void wonderfulRecommendInit() {
		
		int iImagesLength = 0;
	    mLayerTopBg = (ImageView) findViewById(R.id.layer_top_bg);
		// set wonderful recommend
		final Integer[] images = { R.drawable.goodvoice, R.drawable.plantapes,
				R.drawable.ganshidui, R.drawable.lihunlvshi,
				R.drawable.dangdang, R.drawable.jd, };
		
		recommendAdapter = new ImageGalleryAdapter(this, images);
		recommendAdapter.createReflectedImages();// Create reflection effect

		recommendGalleryFlow = (GalleryFlow) this.findViewById(R.id.Gallery01);
		recommendGalleryFlow.setAdapter(recommendAdapter);
		// set long number for start from left
		recommendGalleryFlow.setSelection(2147483646 / 2);
		
		recommendGalleryFlow.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				int iSelect = 0;
				iSelect = position % images.length;
				Log.d(TAG, "recommendItemClickListener: " + iSelect);
			}
		});
	   
		recommendGalleryFlow.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
				view.setNextFocusDownId(R.id.wonderful_text);
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub

			}
		});
		
		recommendGalleryFlow.setOnFocusChangeListener(new OnFocusChangeListener() {

			@Override
			public void onFocusChange(View v, boolean hasFocus) {
				// TODO Auto-generated method stub

				if (hasFocus) {
					mLayerTopBg.setImageResource(R.drawable.layer_top_bg_sel);
					mRecommendFocus = true;
				}
			}
		});
		
		//auto scroll five second at a time 
		recommendAutoScroll();
	}
	
	 private void recommendAutoScroll() {
	        mTimer = new Timer();
	        mAutoScrollTask = new TimerTask() {

	            @Override
	            public void run() {
	                if (isActivityShown) {
	                    runOnUiThread(new Runnable() {

	                        @Override
	                        public void run() {
	                            if (!mRecommendFocus) {
	                                mCurrentRecommend++;
	                                if (mCurrentRecommend >= recommendAdapter.getCount()) {
	                                    mCurrentRecommend = 2147483646 / 2;
	                                    recommendGalleryFlow.setSelection(mCurrentRecommend);
	                                } else {
	                                	recommendGalleryFlow.moveNext();
	                                }
	                            }
	                        }
	                    });
	                }
	            }
	        };
	        mTimer.schedule(mAutoScrollTask, RECOMMEND_SCROLL_INTERVAL, RECOMMEND_SCROLL_INTERVAL);
	    }
	
	
	OnFocusChangeListener firstLevelTextFocusChangeListener = new OnFocusChangeListener() {

		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub
			int iSelect = 0;
			switch (v.getId()) {
				case R.id.wonderful_text:
					iSelect = L_WONDERFUL;
					break;
				case R.id.video_on_demand_text:
					iSelect = L_VIDEO_ON_DEMAND;
					break;
				case R.id.civil_for_aged_text:
					iSelect = L_CIVIL_FOR_AGED;
					break;
				case R.id.second_setting_text:
					iSelect = L_SECOND_SETTING;
					break;
				case R.id.app_shop_text:
					iSelect = L_APP_SHOP;
					break;
			}

			if (hasFocus) {
				for (int i = 0; i < 5; ++i) {
					firstLevelRelativeL[i].setVisibility(View.GONE);
					firstLevelImg[i].setVisibility(View.GONE);
				}
				firstLevelRelativeL[iSelect].setVisibility(View.VISIBLE);
				if(L_WONDERFUL == iSelect)
				{
					mLayerTopBg.setImageResource(R.drawable.layer_top_bg_nor);
					mRecommendFocus = false;
				}

				firstLevelImg[iSelect].setVisibility(View.VISIBLE);
			}else {

			}
		}
	};

	OnClickListener firstLevelTextOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

		}
	};
	OnFocusChangeListener civilForAgedImgonFocusChangeListener = new OnFocusChangeListener() {

		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub
			int iSelect = 0;

			switch (v.getId()) {
				case R.id.room_service_img:
					iSelect = L_ROOM_SERVICE;
					break;
				case R.id.health_care_img:
					iSelect = L_HEALTH_CARE;
					break;
				case R.id.surrounding_shopping_img:
					iSelect = L_SURROUNDING_SHOPPING;
					break;
				case R.id.entertainment_img:
					iSelect = L_ENTERTAINMENT;
					break;
				case R.id.civil_window_img:
					iSelect = L_CIVIL_WINDOW;
					break;
				case R.id.visual_communication_img:
					iSelect = L_VISUAL_COMMUNICATION;
					break;
				case R.id.travel_img:
					iSelect = L_TRAVEL;
					break;
				case R.id.life_service_img:
					iSelect = L_LIFE_SERVICE;
					break;
			}

			if (hasFocus) {
				civilForAgedRela[iSelect].setScaleX(SCALE_MAX);
				civilForAgedRela[iSelect].setScaleY(SCALE_MID);
				v.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.civil_for_aged_anim_in));
				civilForAgedRela[iSelect].bringToFront();
			}else {
				v.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.civil_for_aged_anim_out));
				civilForAgedRela[iSelect].setScaleX(SCALE_NONE);
				civilForAgedRela[iSelect].setScaleY(SCALE_NONE);
			}
			layoutCivilForAgedLine.invalidate();
		}
	};

	OnClickListener civilForAgedImgOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			String[] packageName;
			Intent intent = new Intent();
			intent.setComponent(new ComponentName(MainActivity.this, ThirdGridAppsActivity.class));

			switch (v.getId()) {
				case R.id.room_service_img:
					break;
				case R.id.health_care_img:
					packageName = new String[] { "com.douguo.recipetv", "com.lovesport.dama", "tv.huan.health",
							"com.ts.tv.zys4xiaomi", "com.nudms.app.hsp.mini", "com.broadin.taijiquanpu",
							"com.lovesport.taiji", "me.chunyu.tvdoctor", "com.broadin.wuqinxi",
							"com.manle.phone.android.yaodian.hd"

					};
					intent.putExtra("packageName", packageName);
					intent.putExtra("title", getResources().getString(R.string.str_health_care));
					startActivity(intent);

					break;
				case R.id.surrounding_shopping_img:		
					Intent intentShopping = new Intent();
					intentShopping.setClass(MainActivity.this, ThirdShoppingActivity.class);
					startActivity(intentShopping);
					
					break;
				case R.id.entertainment_img:
					packageName = new String[] { "air.TimerMan", "com.trans.othello", "com.hichang.activity",
							"cn.jj.lordhl", "com.lrgame", "com.kuangshi.shitougame", "air.Swing", "com.wk.game.tv",
							"com.bf.WuZiQi_TV", "com.loki.xiangqi1"

					};
					intent.putExtra("packageName", packageName);
					intent.putExtra("title", getResources().getString(R.string.str_game_entertainment));
					startActivity(intent);

					break;
				case R.id.civil_window_img:
	
					break;
				case R.id.visual_communication_img:

					break;
				case R.id.travel_img:
					packageName = new String[] { "com.podinns.android.tv", "com.broadin.hangbandongtai",
							"com.flightmanager.tv", "com.mfw.roadbook.tv", "com.qunar.travelplan.tv",
							"com.coocaa.ahzk.sjly"

					};
					intent.putExtra("packageName", packageName);
					intent.putExtra("title", getResources().getString(R.string.str_travel));
					startActivity(intent);
					break;
				case R.id.life_service_img:
					packageName = new String[] { "com.broadin.caipiaochaxun", "com.broadin.changyonghaoma",
							"com.smarter.fabaov2", "com.dt.news.tv.mobile", "com.broadin.kuaidichaxun",
							"com.xmobo.phonexm", "com.broadin.quhaochaxun", "com.youloft.calendar.tv",
							"com.broadin.youbianchaxun", "com.zdworks.android.pad.zdclock", "cn.etouch.ecalendarTv" };
					intent.putExtra("packageName", packageName);
					intent.putExtra("title", getResources().getString(R.string.str_life_service));
					startActivity(intent);
					break;
			}
		}
	};

	OnFocusChangeListener videoOndemandOnFocusChangeListener = new OnFocusChangeListener() {

		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub
			int iSelect = 0;

			switch (v.getId()) {
				case R.id.vod_movie:
					iSelect = L_VOD_MOVIE;
					break;
				case R.id.vod_infomation:
					iSelect = L_VOD_INFOMATION;
					break;
				case R.id.vod_sport:
					iSelect = L_VOD_SPORT;
					break;
				case R.id.vod_teleplay:
					iSelect = L_VOD_TELEPLAY;
					break;
				case R.id.vod_column:
					iSelect = L_VOD_COLUMN;
					break;
				case R.id.vod_entertainment:
					iSelect = L_VOD_ENTERTAINMENT;
					break;
				case R.id.vod_children:
					iSelect = L_VOD_CHILDREN;
					break;
			}

			if (hasFocus) {
				videoOndemandRela[iSelect].setScaleX(SCALE_MID);
				videoOndemandRela[iSelect].setScaleY(SCALE_MID);
				v.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.civil_for_aged_anim_in));
				videoOndemandRela[iSelect].bringToFront();
			}else {
				videoOndemandRela[iSelect].setScaleX(SCALE_NONE);
				videoOndemandRela[iSelect].setScaleY(SCALE_NONE);
				v.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.civil_for_aged_anim_out));
			}
			firstLevelRelativeL[L_VIDEO_ON_DEMAND].invalidate();
		}
	};

	OnClickListener videoOndemandOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

		}
	};

	OnFocusChangeListener appshopOnFocusChangeListener = new OnFocusChangeListener() {

		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub
			int iSelect = 0;

			switch (v.getId()) {
				case R.id.appshop_media_img:
					iSelect = L_APPSHOP_MEDIA;
					break;
				case R.id.appshop_shopping_img:
					iSelect = L_APPSHOP_SHOPPING;
					break;
				case R.id.appshop_music_img:
					iSelect = L_APPSHOP_MUSIC;
					break;
				case R.id.appshop_life_img:
					iSelect = L_APPSHOP_LIFE;
					break;
				case R.id.appshop_education_img:
					iSelect = L_APPSHOP_EDUCATION;
					break;
				case R.id.appshop_entertainment_img:
					iSelect = L_APPSHOP_ENTERTAINMENT;
					break;
				case R.id.appshop_more_img:
					iSelect = L_APPSHOP_MORE;
					break;
			}

			if (hasFocus) {
				appshopRela[iSelect].setScaleX(SCALE_MID);
				appshopRela[iSelect].setScaleY(SCALE_MID);
				v.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.civil_for_aged_anim_in));
				appshopRela[iSelect].bringToFront();
			}else {
				appshopRela[iSelect].setScaleX(SCALE_NONE);
				appshopRela[iSelect].setScaleY(SCALE_NONE);
				v.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.civil_for_aged_anim_out));
			}
			firstLevelRelativeL[L_APP_SHOP].invalidate();
		}
	};

	OnClickListener appshopOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

		}
	};

	OnFocusChangeListener secondSettingOnFocusChangeListener = new OnFocusChangeListener() {

		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub
			int iSelect = 0;
			float fScaleX = SCALE_MID;
			float fScaleY = SCALE_MID;

			switch (v.getId()) {
				case R.id.setting_system_setting_img:
					fScaleX = SCALE_MIN;
					fScaleY = SCALE_MIN;
					iSelect = 0;
					break;
				case R.id.setting_display_img:
					iSelect = 1;
					break;
				case R.id.setting_download_img:
					iSelect = 2;
					break;
				case R.id.setting_network_img:
					iSelect = 3;
					break;
				case R.id.setting_install_img:
					iSelect = 4;
					break;
				case R.id.setting_about_us_img:
					iSelect = 5;
					break;
			}

			if (hasFocus) {
				secondSettingRela[iSelect].setScaleX(fScaleX);
				secondSettingRela[iSelect].setScaleY(fScaleY);
				v.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.civil_for_aged_anim_in));
				secondSettingRela[iSelect].bringToFront();
			}else {
				secondSettingRela[iSelect].setScaleX(SCALE_NONE);
				secondSettingRela[iSelect].setScaleY(SCALE_NONE);
				v.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.civil_for_aged_anim_out));
			}
			firstLevelRelativeL[L_SECOND_SETTING].invalidate();
		}
	};

	OnClickListener secondSettingOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

		}
	};
	
	
}
