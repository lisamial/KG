package com.lisamia;

import java.awt.*;

public class DDA {

    public static void drawDDA(Graphics g, int x0, int y0, int x1, int y1) {
        float l = Math.max(Math.abs(x1 - x0), Math.abs(y1 - y0));
        float dx = (x1-x0)/l;
        float dy = (y1- y0)/l;
        float x = x0;
        float y = y0;
        for(int i = 0; i <=l; i++){
            x+=dx;
            y+=dy;
            g.fillRect((int)x, (int)y, 2, 2);
        }
    }
}
