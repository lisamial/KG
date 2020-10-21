package com.lisamia;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Form {
    private JPanel contentPane;
    private JPanel panelDraw;
    private draw draw;


    public Form(){
        panelDraw.setLayout(new BorderLayout());;
        draw = new draw();
        panelDraw.add(draw);
    }

    private class draw extends JPanel {
        public void paintComponent(Graphics g){
            g.setColor(Color.gray);
            g.fillRect(0, 0, getWidth(), getHeight());
            g.setColor(Color.black);
            Point[] startPoints ={new Point(500, 600), new Point(1000, 300),
                                    new Point(370, 80), new Point(750, 650)};
            /*{new Point(150, 50), new Point(450, 95),
                    new Point(250, 500), new Point(700, 250),
                    new Point(600, 400), new Point(1100, 120),
                    new Point(1300, 600)};*/
            /*{new Point(150, 30),new Point(500, 300),
                    new Point(300, 700), new Point(200, 600), new Point(800, 400)};*/
            for (int i = 0; i < startPoints.length -1 ;  i++){
                g.drawOval(startPoints[i].x-2, startPoints[i].y-2, 4, 4);
                g.drawLine(startPoints[i].x, startPoints[i].y, startPoints[i+1].x, startPoints[i+1].y);
            }
            g.drawOval(startPoints[startPoints.length-1].x -2,
                    startPoints[startPoints.length-1].y -2, 4, 4);

            ArrayList<Point> list = Bezier.pointsBezier(startPoints);
            g.setColor(new Color(170, 6, 6));
            for(int i = 0; i < list.size()-1; i++){
                g.drawLine(list.get(i).x, list.get(i).y, list.get(i+1).x, list.get(i+1).y);
            }
            g.drawLine(list.get(list.size()-1).x, list.get(list.size()-1).y,
                    startPoints[startPoints.length-1].x, startPoints[startPoints.length -1].y);
        }
    }

    public static void main(String[] args){
        JFrame f = new JFrame("-Wow, what is it?  -Nonsense =)");
        f.setContentPane(new Form().contentPane);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        f.pack();

        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
