package android.heimdallr.app.heimdallr.screens.customviews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.heimdallr.app.heimdallr.R;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * Created by knightbenax on 31/10/2016.
 */

public class SkewedLinearLayout extends LinearLayout {

    Paint p;
    int height, width, half_height, third_height;
    Path bg = new Path();

    public SkewedLinearLayout(Context context) {
        super(context);
        init(context);
    }

    public SkewedLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public SkewedLinearLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context){
        p = new Paint();
        height = this.getHeight();
        width = this.getWidth();
        half_height = height / 2;
        half_height = half_height - 10;
        third_height = height - 45;
        //setOrientation(LinearLayout.HORIZONTAL);
        setGravity(Gravity.BOTTOM);
        setAlwaysDrawnWithCacheEnabled(true);
        setWillNotDraw(false);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);


        p.setAntiAlias(true);
        p.setStyle(Paint.Style.FILL);
        //p.setAlpha(0x255);
        p.setColor(getResources().getColor(R.color.colorPrimaryDark));
        //newguy = new RectF(0, 0, 100, 250);

        /*bg.moveTo(0, 0);
        bg.lineTo(0, third_height);
        bg.lineTo(width, half_height);
        bg.lineTo(width, 0);
        //bg.lineTo(0, 0);
        bg.close();*/


    }

    //@SuppressLint("DrawAllocation")
    @Override
    public void onDraw(Canvas canvas) {
        /*bg.moveTo(0, 0);
        bg.lineTo(0, 200);
        bg.lineTo(200, 200);
        bg.lineTo(250, 200);*/

        height = this.getHeight();
        width = this.getWidth();
        half_height = height - 280;
        //half_height = ;
        third_height = height;

        bg.moveTo(0, 0);
        bg.lineTo(0, third_height);
        bg.lineTo(width, half_height);
        bg.lineTo(width, 0);
        bg.close();
        canvas.drawPath(bg, p);
    }




}
