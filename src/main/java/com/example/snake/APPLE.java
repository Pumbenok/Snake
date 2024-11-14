package com.example.snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import java.util.Random;

public class APPLE {
    private int radious = 25;
    private Random random = new Random();

    private int x;
    private int y;
    public APPLE(){
        x = random.nextInt(1000) + 1;
        y = random.nextInt(1000) + 1;

    }
    void SetX(int x_){
        x = x_;
    }
    void SetY(int y_){
        y = y_;
    }
    int getX(){
        return x;
    }
    int getY(){
        return y;
    }

    public void draw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.argb(255, 0, 255, 0));
            canvas.drawCircle(x,y, this.radious, p);
    }
}
