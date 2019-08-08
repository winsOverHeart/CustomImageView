package com.example.abhishek.customimageview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class CustomImageView extends android.support.v7.widget.AppCompatImageView {
    Bitmap icon;
    Drawable mDrawable;
    Bitmap mBitmap ;



    public CustomImageView(Context context) {
        super(context);
        icon = BitmapFactory.decodeResource(context.getResources(),
                R.drawable.ic_launcher_background);
        mDrawable = context.getDrawable(R.drawable.ic_launcher);
        mBitmap = Bitmap.createScaledBitmap(((BitmapDrawable)mDrawable).getBitmap(), 120, 120, false);

    }

    public CustomImageView(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomImageView(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }



    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }



    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if(mDrawable==null)
        {
            System.out.println("I am null drawable ");
            return;
        }

        if (getWidth() == 0 || getHeight() == 0) {
            return;
        }

        Bitmap b = ((BitmapDrawable) mDrawable).getBitmap();
        Bitmap bitmap = b.copy(Bitmap.Config.ARGB_8888, true);

        int w = getWidth(), h = getHeight();

        Bitmap roundBitmap = getFinalBitmap();

        canvas.drawBitmap(roundBitmap, 0, 0, null);
        canvas.drawBitmap(mBitmap,240,240,null);
    }


    public  Bitmap getFinalBitmap()
    {
        Bitmap bitmap = Bitmap.createBitmap(
                600, // Width
                600, // Height
                Bitmap.Config.ARGB_8888 // Config
        );
        Canvas canvas = new Canvas(bitmap);
        // Draw a solid color on the canvas as background
        canvas.drawColor(Color.WHITE);
        // Initialize a new Paint instance to draw the rounded rectangle
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        int offset = 50;
        RectF rectF = new RectF(
                offset, // left
                offset, // top
                canvas.getWidth() - offset, // right
                canvas.getHeight() - offset // bottom
        );

        int cornersRadius = 25;
        // Finally, draw the rounded corners rectangle object on the canvas
        canvas.drawRoundRect(
                rectF, // rect
                cornersRadius, // rx
                cornersRadius, // ry
                paint // Paint
        );
        return bitmap;
    }


    @Override
    protected void onFocusChanged(boolean gainFocus, int direction,Rect previouslyFocusedRect) {
        super.onFocusChanged(gainFocus, direction, previouslyFocusedRect);

    }

    @Override
    public boolean callOnClick() {
        return super.callOnClick();
    }
}
