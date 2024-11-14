package com.example.snake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.Log;
import java.util.Random;
import android.view.View;

import androidx.annotation.Nullable;

public class Game extends View {
    int kol = 0;


    private Random random = new Random();
    private Snake snake;
    private APPLE apple;
    private CountDownTimer timer = new CountDownTimer(Integer.MAX_VALUE, 1000) {
        @Override
        public void onTick(long l) {
            if(snake.append(apple.getX(), apple.getY())){
                apple.SetX(random.nextInt(1000) + 1);
                apple.SetY(random.nextInt(1000) + 1);
            }

            else
                snake.move();
            invalidate();
        }

        @Override
        public void onFinish() {

        }
    };

    public Game(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        snake = new Snake();
        apple = new APPLE();
        timer.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        snake.draw(canvas);
        apple.draw(canvas);
    }


    public void onClick(View view) {
        //Log.i("Nikita", "" + view.getId());
        if (view.getId() == R.id.btnLeft) {
            snake.left();
        }
        if (view.getId() == R.id.btnRight) {
            snake.right();
        }
        if (view.getId() == R.id.btnUp) {
            snake.up();
        }
        if (view.getId() == R.id.btnDown) {
            snake.down();
        }
    }
}