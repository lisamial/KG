package com.lisamia;

import java.awt.*;
import java.util.ArrayList;

public class Bezier {

    public static ArrayList<Point> pointsBezier(Point[] startPoint){
        ArrayList<Point> points = new ArrayList<>();
        double t = 0;
        while(t <= 1){
            points.add(pointsBezierRecur(t, startPoint)[0]);
            t += 0.05;
        }
        return points;
    }

    private static Point[] pointsBezierRecur(double t, Point[] array){
        int x;
        int y;
        if (array.length == 1) {
            return array;
        }
        Point[] newArray = new Point[array.length - 1];
        for (int i = 0; i < array.length - 1; i++) {
            x = (int) ((1 - t) * array[i].x + t * array[i + 1].x);
            y =(int) ((1 - t) * array[i].y + t * array[i + 1].y);
            newArray[i] = new Point(x, y);
        }
        return pointsBezierRecur(t, newArray);
    }
}
