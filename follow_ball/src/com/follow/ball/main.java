package com.follow.ball;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.graphics.Canvas;
import android.widget.LinearLayout;
import android.graphics.Paint;
import android.graphics.Color;
import android.content.Context;
import android.view.View.OnTouchListener;
import android.view.MotionEvent;

class DrawView extends View
{
    public float currentX = 40;
    public float currentY = 50;

    public DrawView( Context context )
    {
        super(context);
    }

    public void onDraw( Canvas canvas )
    {
        super.onDraw( canvas );

        Paint p = new Paint();
        p.setColor( Color.RED );

        canvas.drawCircle( currentX, currentY, 15, p );
    }
}

public class main extends Activity
{
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        //super.setContentView( R.layout.main );
        LinearLayout root = new LinearLayout(this);
        root.setOrientation( LinearLayout.VERTICAL );
        super.setContentView( root );

        final DrawView draw = new DrawView(this);
        draw.setMinimumWidth( 300 );
        draw.setMinimumHeight( 500 );

        draw.setOnTouchListener( new OnTouchListener(){

            public boolean onTouch( View arg0, MotionEvent event )
            {
                draw.currentX = event.getX();
                draw.currentY = event.getY();
                draw.invalidate();

                return true;
            }
        } );

        root.addView( draw );
    }
}
