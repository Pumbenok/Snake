package com.example.snake;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;


import java.util.LinkedList;

public class Snake extends LinkedList<Rect> {


    private boolean left = false, right = false, up = false, down = false;
    private int h = 50;
    public Snake() {
        for (int i = 0; i < 3; i++) {
            add(new Rect(h * (i + 1), 100, h * (i + 2), 150));
        }
    }

    public void draw(Canvas canvas) {
        Paint p = new Paint();
        p.setColor(Color.argb(150, 180, 150, 100));
        for (Rect r : this) {
            canvas.drawRect(r, p);
        }
    }

    public void left() {
        left = true;
        right = false;
        up = false;
        down = false;
    }

    public void right() {
        left = false;
        right = true;
        up = false;
        down = false;
    }

    public void up() {
        left = false;
        right = false;
        up = true;
        down = false;
    }

    public void down() {
        left = false;
        right = false;
        up = false;
        down = true;
    }

    public boolean append(int x, int y){
        Rect tp = getFirst();
        if ((tp.left - 10 <= x && x <= tp.right + 10 || tp.left + 10 >= x && x >= tp.right - 10) && (tp.top - 10 <= y && y <= tp.bottom + 10 || tp.top + 10 >= y && y >= tp.bottom - 10)){
            move_app();
            return true;
        }
        return false;
    }

    public void move() {

        Rect r = removeLast();
        r.set(getFirst());

        if (left) {
            r.left -= h;
            r.right -= h;
        }
        if (right) {
            r.left += h;
            r.right += h;
        }
        if (up) {
            r.top -= h;
            r.bottom -= h;
        }
        if (down) {
            r.top += h;
            r.bottom += h;
        }
        addFirst(r);
    }

    public void move_app() {

        Rect r = new Rect();
        r.set(getFirst());


        if (left) {
            r.left -= h;
            r.right -= h;
        }
        if (right) {
            r.left += h;
            r.right += h;
        }
        if (up) {
            r.top -= h;
            r.bottom -= h;
        }
        if (down) {
            r.top += h;
            r.bottom += h;
        }
        addFirst(r);
    }


}