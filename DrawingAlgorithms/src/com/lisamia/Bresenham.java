package com.lisamia;

import java.awt.*;

public class Bresenham {

    public static void Bresenham(Graphics g, int x0, int y0, int x1, int y1){
        int x = x0; int y = y0;
        int dx = x1 - x0; int dy = y1-y0;
        int e = 2 * dy - dx;
        for(int i = 1; i <= dx; i++){
            g.fillRect(x, y, 2, 2);
            if(e >= 0){
                y++;
                e += -2 * dx + 2 * dy;
            } else {
                e += 2 * dy;
            }
            x++;
        }
    }

}
