package villes.com.shapequiz;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * Created by Ville on 30.5.2015.
 */
public class Shape
{
    private Bitmap blankImage;
    private Bitmap filledImage;
    private float x;
    private float y;
    private float height;
    private float width;

    public Shape(Resources resources, int blankImageId, int filledImageId, float initX, float initY)
    {
        blankImage = BitmapFactory.decodeResource(resources, blankImageId);
        filledImage = BitmapFactory.decodeResource(resources, filledImageId);
        this.x = initX;
        this.y = initY;
        width = blankImage.getWidth();
    }

    public void move(float xChange, float yChange, float gameAreaWidth)
    {System.out.println("WIDTH:" + gameAreaWidth);
        if((x + xChange) > 0 && (x + width + xChange) < gameAreaWidth){
            x += xChange; System.out.println("X:" +x);}
        y += yChange;  //TODO: is y really necessary?
    }

    public float getX()
    {
        return x;
    }

    public float getY()
    {
        return y;
    }

    public Bitmap getBlankImage()
    {
        return blankImage;
    }

}
