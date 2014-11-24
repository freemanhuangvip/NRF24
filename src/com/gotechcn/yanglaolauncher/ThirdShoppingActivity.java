package com.gotechcn.yanglaolauncher;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class ThirdShoppingActivity extends Activity{
	private Context mContext;
	
	private RelativeLayout ShoppingRela[] = new RelativeLayout[11];
	private ImageView[] ShoppingImageView = new ImageView[11];

	private static final int L_TAOBAO = 0;
	private static final int L_FOOD = 1;
	private static final int L_CLOTHES = 2;
	private static final int L_FRESH = 3;
	private static final int L_WINE = 4;
	private static final int L_RECHARGE = 5;
	private static final int L_PAYMENT = 6;
	private static final int L_JD_SHOP = 7;
	private static final int L_SUNING = 8;
	private static final int L_DANG_DANG = 9;
	private static final int L_NUOMI = 10;
	
	private static final float SCALE_MID = 1.24F;
	private static final float SCALE_NONE = 1.0F;
	
	private View ThirdLevelShopping;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		mContext = this;
		setContentView(R.layout.layout_3_shopping);
		initView();
	}
	
	private void initView() {
		
		Integer[] images = { R.drawable.taobao, R.drawable.taobao,
				R.drawable.taobao, R.drawable.taobao, R.drawable.taobao,
				R.drawable.dangdang, R.drawable.dangdang, R.drawable.dangdang,
				R.drawable.dangdang, R.drawable.dangdang, R.drawable.dangdang, };
		
		ThirdLevelShopping = findViewById(R.id.layout_third_shopping);
		
		ShoppingRela[L_TAOBAO] = (RelativeLayout) findViewById(R.id.layout_taobao);
		ShoppingRela[L_RECHARGE] = (RelativeLayout) findViewById(R.id.layout_recharge);
		ShoppingRela[L_PAYMENT] = (RelativeLayout) findViewById(R.id.layout_payment);
		ShoppingRela[L_DANG_DANG] = (RelativeLayout) findViewById(R.id.layout_dangdang);
		ShoppingRela[L_JD_SHOP] = (RelativeLayout) findViewById(R.id.layout_jd);
		ShoppingRela[L_SUNING] = (RelativeLayout) findViewById(R.id.layout_suning);
		ShoppingRela[L_NUOMI] = (RelativeLayout) findViewById(R.id.layout_nuomi);
		
		ShoppingRela[L_FOOD] = (RelativeLayout) findViewById(R.id.layout_food);
		ShoppingRela[L_CLOTHES] = (RelativeLayout) findViewById(R.id.layout_clothes);
		ShoppingRela[L_FRESH] = (RelativeLayout) findViewById(R.id.layout_fresh);
		ShoppingRela[L_WINE] = (RelativeLayout) findViewById(R.id.layout_wine);

		ShoppingImageView[L_TAOBAO] = (ImageView) findViewById(R.id.image_taobao);
		ShoppingImageView[L_RECHARGE] = (ImageView) findViewById(R.id.image_recharge);
		ShoppingImageView[L_PAYMENT] = (ImageView) findViewById(R.id.img_payment);
		ShoppingImageView[L_DANG_DANG] = (ImageView) findViewById(R.id.img_dangdang);
		ShoppingImageView[L_JD_SHOP] = (ImageView) findViewById(R.id.img_jd);
		ShoppingImageView[L_SUNING] = (ImageView) findViewById(R.id.img_suning);
		ShoppingImageView[L_NUOMI] = (ImageView) findViewById(R.id.img_nuomi);
		
		ShoppingImageView[L_FOOD] = (ImageView) findViewById(R.id.img_food);
		ShoppingImageView[L_CLOTHES] = (ImageView) findViewById(R.id.img_clothes);
		ShoppingImageView[L_FRESH] = (ImageView) findViewById(R.id.img_fresh);
		ShoppingImageView[L_WINE] = (ImageView) findViewById(R.id.img_wine);
		
		  
		for (int j = 0; j < 11; j++) {
			Bitmap photo = BitmapFactory.decodeResource(getResources(), images[j]);
			ShoppingImageView[j].setImageBitmap(getRoundedCornerBitmap(photo)); 
			
			ShoppingImageView[j].setOnFocusChangeListener(shoppingOnFocusChangeListener);
			ShoppingImageView[j].setOnClickListener(shoppingOnClickListener);
		}
	}
	
	public static Bitmap getRoundedCornerBitmap(Bitmap bitmap) {
	     
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), 
            bitmap.getHeight(), Config.ARGB_8888);
        //得到画布
        Canvas canvas = new Canvas(output);
    
       //将画布的四角圆化
        final int color = Color.RED; 
        final Paint paint = new Paint(); 
        //得到与图像相同大小的区域  由构造的四个值决定区域的位置以及大小
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight()); 
        final RectF rectF = new RectF(rect); 
        //值越大角度越明显
        final float roundPx = 20; 
      
        paint.setAntiAlias(true); 
        canvas.drawARGB(0, 0, 0, 0); 
        paint.setColor(color); 
        //drawRoundRect的第2,3个参数一样则画的是正圆的一角，如果数值不同则是椭圆的一角
        canvas.drawRoundRect(rectF, roundPx,roundPx, paint); 
      
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN)); 
        canvas.drawBitmap(bitmap, rect, rect, paint); 
      
        return output; 
      } 
	
	OnFocusChangeListener shoppingOnFocusChangeListener = new OnFocusChangeListener() {

		@Override
		public void onFocusChange(View v, boolean hasFocus) {
			// TODO Auto-generated method stub
			int iSelect = 0;

			switch (v.getId()) {
				case R.id.image_taobao:
					iSelect = L_TAOBAO;
					break;
				case R.id.image_recharge:
					iSelect = L_RECHARGE;
					break;
				case R.id.img_payment:
					iSelect = L_PAYMENT;
					break;
				case R.id.img_dangdang:
					iSelect = L_DANG_DANG;
					break;
				case R.id.img_jd:
					iSelect = L_JD_SHOP;
					break;
				case R.id.img_suning:
					iSelect = L_SUNING;
					break;
				case R.id.img_nuomi:
					iSelect = L_NUOMI;
					break;
				case R.id.img_food:
					iSelect = L_FOOD;
					break;
				case R.id.img_clothes:
					iSelect = L_CLOTHES;
					break;
				case R.id.img_fresh:
					iSelect = L_FRESH;
					break;
				case R.id.img_wine:
					iSelect = L_WINE;
					break;
			}

			if (hasFocus) {
				ShoppingRela[iSelect].setScaleX(SCALE_MID);
				ShoppingRela[iSelect].setScaleY(SCALE_MID);
				v.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.civil_for_aged_anim_in));
				ShoppingRela[iSelect].bringToFront();
			}else {
				ShoppingRela[iSelect].setScaleX(SCALE_NONE);
				ShoppingRela[iSelect].setScaleY(SCALE_NONE);
				v.startAnimation(AnimationUtils.loadAnimation(mContext, R.anim.civil_for_aged_anim_out));
			}
			ThirdLevelShopping.invalidate();
		}
	};
	
	OnClickListener shoppingOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

		}
	};

}
