package com.gotechcn.gallery3d;

import com.gotechcn.yanglaolauncher.MainActivity;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuffXfermode;
import android.graphics.Bitmap.Config;
import android.graphics.Shader.TileMode;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

public class ImageGalleryAdapter extends BaseAdapter {
	int mGalleryItemBackground;
	private Context mContext;
	private Integer[] mImageIds;
	private ImageView[] mImages;
	
	private final static String TAG="ImageGalleryAdapter";

	public ImageGalleryAdapter(Context c, Integer[] ImageIds) {
		mContext = c;
		mImageIds = ImageIds;
		mImages = new ImageView[mImageIds.length];
	}

	// Create reflection effect
	public boolean createReflectedImages() {
		// Reflection map and the distance between the original
		final int reflectionGap = 4;
		int index = 0;
		for (int imageId : mImageIds) {
			// After returning to the original decoding bitmap object
	
			//get the original image and reset the height and width
			Bitmap originalImage = Bitmap.createScaledBitmap(BitmapFactory.decodeResource(
					mContext.getResources(), imageId), 631, 331, true);    
			
			int width = originalImage.getWidth();
			int height = originalImage.getHeight();

			// Create a matrix object
			Matrix matrix = new Matrix();

			// The specified matrix (x axis invariant, Y axis instead)
			matrix.preScale(1, -1);

			/*The matrix is applied to the original image, returns a constant width,
			height of the original bitmap 1/3 reflection*/
			Bitmap reflectionImage = Bitmap.createBitmap(originalImage, 0,
					height / 3*2, width, height / 3, matrix, false);

			// To create a constant width, height of the original + reflection height map bitmap
			Bitmap bitmapWithReflection = Bitmap.createBitmap(width,
					(height + height / 3), Config.ARGB_8888);

			// Initializes the bitmap created above to the canvas
			Canvas canvas = new Canvas(bitmapWithReflection);
			canvas.drawBitmap(originalImage, 0, 0, null);

			Paint deafaultPaint = new Paint();
			deafaultPaint.setAntiAlias(false);
			// canvas.drawRect(0, height, width, height +
			// reflectionGap,deafaultPaint);
			canvas.drawBitmap(reflectionImage, 0, height + reflectionGap, null);
			Paint paint = new Paint();
			paint.setAntiAlias(false);

			/**
			 * Set here to mirror the Gradient is based on the Shader class, 
			 * so we through the setShader method of the Paint to set the gradient
			 */
			LinearGradient shader = new LinearGradient(0,
					originalImage.getHeight(), 0,
					bitmapWithReflection.getHeight() + reflectionGap,
					0x70ffffff, 0x00ffffff, TileMode.MIRROR);
			// Set the shadow
			paint.setShader(shader);
			paint.setXfermode(new PorterDuffXfermode(
					android.graphics.PorterDuff.Mode.DST_IN));
			// The construction of a rectangular shadow effect
			canvas.drawRect(0, height, width, bitmapWithReflection.getHeight()
					+ reflectionGap, paint);

			// Create a ImageView to display the painted bitmapWithReflection
			ImageView imageView = new ImageView(mContext);
			imageView.setImageBitmap(bitmapWithReflection);
			// Set the imageView size, also is the final display image size
			imageView.setLayoutParams(new GalleryFlow.LayoutParams(300, 400));
			// imageView.setScaleType(ScaleType.MATRIX);
			mImages[index++] = imageView;
		}
		return true;
	}

	@SuppressWarnings("unused")
	private Resources getResources() {
		return null;
	}

	public int getCount() {
		return Integer.MAX_VALUE;
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}	
	
	public View getView(int position, View convertView, ViewGroup parent) {
		return mImages[position % mImages.length];  
	}

	public float getScale(boolean focused, int offset) {
		return Math.max(0, 1.0f / (float) Math.pow(2, Math.abs(offset)));
	}
}








