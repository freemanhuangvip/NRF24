package com.gotechcn.gallery3d;

import java.lang.reflect.Method;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.Transformation;
import android.widget.Gallery;
import android.widget.ImageView;

public class GalleryFlow extends Gallery {
	// mCamera Is used to do 3D like effect, such as the Z axis of the translation, the rotation around Y axis  
    private Camera mCamera = new Camera();  
    // mMaxRotationAngleIs the picture around the Y axis rotation angle
    private int mMaxRotationAngle = 50;  
    // mMaxZoom The picture on the Z axis shift distance
    private int mMaxZoom = -200;  
    private int mCoveflowCenter;  
    private boolean mAlphaMode = true;  
    
    private final static String TAG="GalleryFlow";
    
    public GalleryFlow(Context context) {
        super(context);
     //enable the getChildStaticTransformation function
        this.setStaticTransformationsEnabled(true);
    }
    public GalleryFlow(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setStaticTransformationsEnabled(true);
    }
    public GalleryFlow(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.setStaticTransformationsEnabled(true);
    }
    public int getMaxRotationAngle() {
        return mMaxRotationAngle;
    }
    public void setMaxRotationAngle(int maxRotationAngle) {
        mMaxRotationAngle = maxRotationAngle;
    }
   
    public int getMaxZoom() {
        return mMaxZoom;
    }
    public void setMaxZoom(int maxZoom) {
        mMaxZoom = maxZoom;
    }
    private int getCenterOfCoverflow() {
        return (getWidth() - getPaddingLeft() - getPaddingRight()) / 2
                        + getPaddingLeft();
    }
    private static int getCenterOfView(View view) {
        return view.getLeft() + view.getWidth() / 2;
    }
    
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        mCoveflowCenter = getCenterOfCoverflow();
        super.onSizeChanged(w, h, oldw, oldh);
    }
    
    @Override  
    protected boolean getChildStaticTransformation(View child, Transformation t) {  
        final int childCenter = getCenterOfView(child);  
        final int childWidth = child.getWidth();  
        int rotationAngle = 0;  
        t.clear();  
        
        t.setTransformationType(Transformation.TYPE_MATRIX);  
        if (childCenter == mCoveflowCenter) {  
            transformImageBitmap((ImageView) child, t, 0);  
        } else {  
            rotationAngle = (int) (((float) (mCoveflowCenter - childCenter) / childWidth) * mMaxRotationAngle);  
			transformImageBitmap((ImageView) child, t, rotationAngle);
        }  
        return true;  
    }  
       
	private void transformImageBitmap(View child, Transformation t,int rotationAngle) {
		mCamera.save();
		final Matrix imageMatrix = t.getMatrix();
		final int imageHeight = child.getLayoutParams().height;
		final int imageWidth = child.getLayoutParams().width;
		final int rotation = Math.abs(rotationAngle);
		
		float zoomAmount = (float) (-190 + (rotation * 2));
		if (rotationAngle == 0) {
			mCamera.translate(0f, 0f, -60 + zoomAmount);
		} 
		else {
			mCamera.translate(0f, 0f, -50 + zoomAmount);
		}
    
		mCamera.getMatrix(imageMatrix);
		imageMatrix.preTranslate(-(imageWidth / 2), -(imageHeight / 2));
		imageMatrix.postTranslate((imageWidth / 2), (imageHeight / 2));
		mCamera.restore();
	}

	@Override
	protected int getChildDrawingOrder(int childCount, int i) {

		int mFirstPosition = getFirstVisiblePosition();
		int mSelectedPosition = computeHorizontalScrollOffset();
		int selectedIndex = mSelectedPosition - mFirstPosition;

		// Just to be safe
		if (selectedIndex < 0)
			return i;

		if (i == childCount - 1) {
			// Draw the selected child last
			return selectedIndex;
		} else if (i >= selectedIndex) {
			// Move the children after the selected child from last to the
			// selected
			return (childCount - 1) - (i - selectedIndex);
		} else {
			// Keep the children before the selected child the same
			return i;
		}
	}
	
	 public void moveNext() {
	        try {
	            @SuppressWarnings("unchecked")
	            Class<Gallery> c = (Class<Gallery>) Class.forName("android.widget.Gallery");
	            Method[] flds = c.getDeclaredMethods();
	            for (Method f: flds) {
	                if ("moveNext".equals(f.getName())) {
	                    f.setAccessible(true);
	                    f.invoke(this);
	                }
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
}


