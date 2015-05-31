package villes.com.shapequiz;

import android.content.Context;
import android.graphics.Canvas;

import android.support.annotation.NonNull;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;


/**
 * Created by Ville on 30.5.2015.
 */
public class GameArea extends View
{
    private GestureDetector gestures;
    private Shape image;
    private String LOG_TAG = "GameAreaGesture";
    private boolean firstDraw;
    private float initX;
    private float initY;
    private FrameLayout parent;

    public GameArea(Context context, float x, float y, FrameLayout parent)
    {
        super(context);
        gestures = new GestureDetector(context, new GestureListener(this));

        initX = x;
        initY = y;
        this.parent = parent;

        firstDraw = true;

        image = new Shape(getResources(), R.drawable.rounded_rect_test,
                R.drawable.rounded_rect_test, initX, initY);
    }

    @Override
    public boolean onTouchEvent(@NonNull MotionEvent event)
    {
        return gestures.onTouchEvent(event);
    }

    protected void onDraw(Canvas canvas)
    {
        if(firstDraw)
        {
            canvas.drawBitmap(image.getBlankImage(), initX, initY, null);
            firstDraw = false;
        }
        else
        {System.out.println("DRAW:");
            canvas.drawBitmap(image.getBlankImage(), image.getX(), image.getY(), null);
        }

    }

    private void onMove(float v, float v1)
    {
        image.move(v, 0, parent.getWidth());
        invalidate();
    }


    private class GestureListener implements GestureDetector.OnGestureListener,
            GestureDetector.OnDoubleTapListener
    {
        private GameArea view;

        public GestureListener(GameArea view)
        {
            this.view = view;
        }

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e)
        {
            Log.v(LOG_TAG, "onSingleTapConfirmed");
            return false;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e)
        {
            Log.v(LOG_TAG, "onMotionEvent");
            return false;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e)
        {
            Log.v(LOG_TAG, "onDoubleTapEvent");
            return false;
        }

        @Override
        public boolean onDown(MotionEvent e)
        {
            Log.v(LOG_TAG, "onDown");
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e)
        {
            Log.v(LOG_TAG, "onShowPress");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e)
        {
            Log.v(LOG_TAG, "onSingleTapUp");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
        {
            Log.v(LOG_TAG, "onScroll");
            view.onMove(-distanceX, -distanceY);


            return true;
        }

        @Override
        public void onLongPress(MotionEvent e)
        {
            Log.v(LOG_TAG, "longPress");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
        {
            Log.v(LOG_TAG, "onFling");
            return false;
        }
    }


}
