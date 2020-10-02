package com.lisamia;

import javax.swing.*;
import java.awt.*;

public class PaintI extends JPanel {

    PaintI(){
        setPreferredSize(new Dimension(600, 500));
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        paintRed(g2d);
        paintGreen(g2d);
        paintBlue(g2d);
        paintYellow(g2d);
        paintStar(g2d);

    }

    private void paintStar(Graphics2D g2) {

        int midX = getWidth() / 2;
        int midY = getHeight() / 2;

        int bigR = 220;
        int littleR = 60;
        Color[] color = {new Color(166, 84, 204), new Color(126, 24, 173),
                new Color(79, 14, 110), new Color(50, 4, 71),
                new Color(25, 3, 42), Color.black};

        for (int i = 0; i < color.length; i++) {
            int[] x = {midX - bigR, midX - littleR, midX, midX + littleR, midX + bigR, midX + littleR,
                    midX + bigR, midX + littleR, midX, midX - littleR, midX - bigR};
            int[] y = {midY, midY - littleR, midY - bigR, midY - littleR, midY, midY + littleR,
                    midY, midY + littleR, midY + bigR, midY + littleR, midY};
            g2.setColor(color[i]);
            g2.fillPolygon(x, y, y.length);
            bigR -= 45;
            littleR -= 10 + i;
        }
    }

    private void paintRed(Graphics2D g2){
       // Graphics2D g2 = (Graphics2D)g;
        Color[] colorRed = {new Color(255, 81, 51), new Color(204, 66, 41),
                new Color(153, 49, 31, 60), new Color(102, 33, 20),
                new Color(51, 16, 10), Color.black};

        int a = 0; int b =0; int step = (getWidth()/2)/5;
        int width = getWidth()/2; int height = getHeight()/2;
        for(int i =0; i < 6;i++){
            g2.setColor(colorRed[i]);
            g2.fillRect(a,b, width, height);
            a+=step;
            b+=step;
            width -=step;
            height -=step;
        }
    }

    private void paintGreen(Graphics2D g2){
       // Graphics2D g2 = (Graphics2D) g;
        Color[] colorGreen = {new Color(54, 255, 140), new Color(43, 204, 107),
                new Color(32, 153, 80), new Color(21, 102, 54),
                new Color(11, 51,27), Color.black};

        int a = getWidth()/2; int b =0; int step = (getWidth()/2)/5;
        int width = getWidth()/2; int height = getHeight()/2;
        for(int i =0; i < 6;i++){
            g2.setColor(colorGreen[i]);
            g2.fillRect(a,b, width, height);
            b+=step;
            width -=step;
            height -=step;
        }
    }

    private void paintBlue(Graphics2D g2){
      //  Graphics2D g2 = (Graphics2D)g;
        Color[] colorBlue = {new Color(92, 163, 255), new Color(73, 132, 204),
                new Color(55, 99, 153), new Color(37, 66, 102),
                new Color(18, 33, 51), Color.black};

        int a = 0; int b = getHeight()/2; int step = (getWidth()/2)/5;
        int width = getWidth()/2; int height = getHeight()/2;
        for(int i =0; i < 6;i++){
            g2.setColor(colorBlue[i]);
            g2.fillRect(a,b, width, height);
            a+=step;
            width -=step;
            height -=step;
        }
    }

    private void paintYellow(Graphics2D g2){
       // Graphics2D g2 = (Graphics2D) g;
        Color[] colorYellow = {new Color(250,191,37), new Color(204, 155, 31),
                new Color(153, 116, 23), new Color(102,77,15),
                new Color(51, 39, 8), Color.BLACK};

        int a = getWidth()/2; int b = getHeight()/2; int step = (getWidth()/2)/5;
        int width = getWidth()/2; int height = getHeight()/2;
        for(int i =0; i < 6;i++){
            g2.setColor(colorYellow[i]);
            g2.fillRect(a,b, width, height);
            width -=step;
            height -=step;
        }
    }

}
