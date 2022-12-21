package com.example.contactsapp.bl;

import android.view.GestureDetector;
import android.view.MotionEvent;

public class MyGestureListener extends GestureDetector.SimpleOnGestureListener {

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        double xInc = e2.getX() - e1.getX();
        double yInc = e2.getY() - e1.getY();
        return xInc > 100;
    }
}
